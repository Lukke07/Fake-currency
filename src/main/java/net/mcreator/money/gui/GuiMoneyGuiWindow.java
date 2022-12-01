
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
public class GuiMoneyGuiWindow extends ContainerScreen<GuiMoneyGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GuiMoneyGui.guistate;

	public GuiMoneyGuiWindow(GuiMoneyGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/gui_money.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/seta.png"));
		this.blit(ms, this.guiLeft + 15, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/seta.png"));
		this.blit(ms, this.guiLeft + 51, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/seta.png"));
		this.blit(ms, this.guiLeft + 112, this.guiTop + 3, 0, 0, 8, 8, 8, 8);

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
		this.font.drawString(ms, "Entrada", 6, 21, -12829636);
		this.font.drawString(ms, "Sa\u00EDda", 47, 21, -12829636);
		this.font.drawString(ms, "Moedas", 82, 2, -12829636);
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
		this.addButton(new Button(this.guiLeft + 86, this.guiTop + 12, 30, 20, new StringTextComponent("1"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiMoneyGui.ButtonPressedMessage(0, x, y, z));
				GuiMoneyGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 86, this.guiTop + 32, 30, 20, new StringTextComponent("2"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiMoneyGui.ButtonPressedMessage(1, x, y, z));
				GuiMoneyGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 86, this.guiTop + 52, 30, 20, new StringTextComponent("5"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiMoneyGui.ButtonPressedMessage(2, x, y, z));
				GuiMoneyGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 116, this.guiTop + 12, 35, 20, new StringTextComponent("10"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiMoneyGui.ButtonPressedMessage(3, x, y, z));
				GuiMoneyGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 116, this.guiTop + 32, 35, 20, new StringTextComponent("20"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiMoneyGui.ButtonPressedMessage(4, x, y, z));
				GuiMoneyGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 116, this.guiTop + 52, 35, 20, new StringTextComponent("50"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiMoneyGui.ButtonPressedMessage(5, x, y, z));
				GuiMoneyGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
