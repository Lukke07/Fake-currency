
package net.mcreator.money.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.money.procedures.UserMoneyDisplayOverlayIngameProcedure;
import net.mcreator.money.MoneyMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NewAtmGuiGuiWindow extends ContainerScreen<NewAtmGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = NewAtmGuiGui.guistate;
	CheckboxButton Comprovante;

	public NewAtmGuiGuiWindow(NewAtmGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/new_atm_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/megaslot.png"));
		this.blit(ms, this.guiLeft + 46, this.guiTop + 35, 0, 0, 27, 27, 27, 27);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/seta.png"));
		this.blit(ms, this.guiLeft + 52, this.guiTop + 19, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/seta.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 30, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/seta.png"));
		this.blit(ms, this.guiLeft + 86, this.guiTop + 31, 0, 0, 8, 8, 8, 8);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "ATM", 2, 3, -12829636);
		this.font.drawString(ms, "Cart\u00E3o", 46, 15, -12829636);
		this.font.drawString(ms, "Entrada", 11, 24, -12829636);
		this.font.drawString(ms, "Sa\u00EDda", 77, 25, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		Comprovante = new CheckboxButton(this.guiLeft + 50, this.guiTop + 61, 20, 20, new StringTextComponent(""),

				UserMoneyDisplayOverlayIngameProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		NewAtmGuiGui.guistate.put("checkbox:Comprovante", Comprovante);
		this.addButton(Comprovante);
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + 3, 30, 20, new StringTextComponent("1"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new NewAtmGuiGui.ButtonPressedMessage(0, x, y, z));
				NewAtmGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + 23, 30, 20, new StringTextComponent("2"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new NewAtmGuiGui.ButtonPressedMessage(1, x, y, z));
				NewAtmGuiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + 43, 30, 20, new StringTextComponent("5"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new NewAtmGuiGui.ButtonPressedMessage(2, x, y, z));
				NewAtmGuiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 134, this.guiTop + 3, 35, 20, new StringTextComponent("10"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new NewAtmGuiGui.ButtonPressedMessage(3, x, y, z));
				NewAtmGuiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 134, this.guiTop + 23, 35, 20, new StringTextComponent("20"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new NewAtmGuiGui.ButtonPressedMessage(4, x, y, z));
				NewAtmGuiGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 134, this.guiTop + 43, 35, 20, new StringTextComponent("50"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new NewAtmGuiGui.ButtonPressedMessage(5, x, y, z));
				NewAtmGuiGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
