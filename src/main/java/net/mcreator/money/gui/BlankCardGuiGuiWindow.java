
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
public class BlankCardGuiGuiWindow extends ContainerScreen<BlankCardGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = BlankCardGuiGui.guistate;

	public BlankCardGuiGuiWindow(BlankCardGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/blank_card_gui.png");

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
		this.blit(ms, this.guiLeft + 69, this.guiTop + -2, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/carta_de_credito_bungas_fafas.png"));
		this.blit(ms, this.guiLeft + 69, this.guiTop + 34, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("money:textures/screens/carta_de_credito_bungas_fafas_lalau.png"));
		this.blit(ms, this.guiLeft + 69, this.guiTop + 16, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/megaslot.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 39, 0, 0, 27, 27, 27, 27);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/blankcard.png"));
		this.blit(ms, this.guiLeft + 8, this.guiTop + 1, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/seta.png"));
		this.blit(ms, this.guiLeft + 15, this.guiTop + 21, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Escolha", 4, 69, -12829636);
		this.font.drawString(ms, "1", 60, 7, -12829636);
		this.font.drawString(ms, "2", 60, 25, -12829636);
		this.font.drawString(ms, "3", 60, 43, -12829636);
		this.font.drawString(ms, "4", 60, 61, -12829636);
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
		this.addButton(new Button(this.guiLeft + 105, this.guiTop + 3, 35, 20, new StringTextComponent("TX Red"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new BlankCardGuiGui.ButtonPressedMessage(0, x, y, z));
				BlankCardGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 105, this.guiTop + 21, 40, 20, new StringTextComponent("TX Black"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new BlankCardGuiGui.ButtonPressedMessage(1, x, y, z));
				BlankCardGuiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 105, this.guiTop + 39, 40, 20, new StringTextComponent("TX Pink"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new BlankCardGuiGui.ButtonPressedMessage(2, x, y, z));
				BlankCardGuiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 105, this.guiTop + 57, 40, 20, new StringTextComponent("BF Card"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new BlankCardGuiGui.ButtonPressedMessage(3, x, y, z));
				BlankCardGuiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
