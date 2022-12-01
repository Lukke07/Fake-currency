
package net.mcreator.money.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.money.MoneyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SetadorGuiWindow extends ContainerScreen<SetadorGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = SetadorGui.guistate;

	public SetadorGuiWindow(SetadorGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 200;
		this.ySize = 83;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/setador.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/carta_de_credito_bungas.png"));
		this.blit(ms, this.guiLeft + 18, this.guiTop + 10, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/carta_de_credito_bungas_fafas.png"));
		this.blit(ms, this.guiLeft + 108, this.guiTop + 10, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("money:textures/screens/carta_de_credito_bungas_fafas_lalau.png"));
		this.blit(ms, this.guiLeft + 18, this.guiTop + 42, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "Selecione o seu cart\u00E3o", 45, 1, -12829636);
		this.font.drawString(ms, "BfCard", 108, 51, -12829636);
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
		this.addButton(new Button(this.guiLeft + 54, this.guiTop + 15, 40, 20, new StringTextComponent("Red"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorGui.ButtonPressedMessage(0, x, y, z));
				SetadorGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 54, this.guiTop + 46, 51, 20, new StringTextComponent("Black"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorGui.ButtonPressedMessage(1, x, y, z));
				SetadorGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 144, this.guiTop + 15, 46, 20, new StringTextComponent("Pink"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorGui.ButtonPressedMessage(2, x, y, z));
				SetadorGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 144, this.guiTop + 46, 35, 20, new StringTextComponent("BF"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorGui.ButtonPressedMessage(3, x, y, z));
				SetadorGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 144, this.guiTop + -18, 51, 20, new StringTextComponent("Pular"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorGui.ButtonPressedMessage(4, x, y, z));
				SetadorGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
