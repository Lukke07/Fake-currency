
package net.mcreator.money.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MoneyConversionGuiWindow extends ContainerScreen<MoneyConversionGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MoneyConversionGui.guistate;

	public MoneyConversionGuiWindow(MoneyConversionGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/faketemplate144.png"));
		this.blit(ms, this.guiLeft + 15, this.guiTop + 12, 0, 0, 144, 144, 144, 144);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/megaslot.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 70, 0, 0, 27, 27, 27, 27);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 83, this.guiTop + 48, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 83, this.guiTop + 75, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 83, this.guiTop + 102, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 83, this.guiTop + 129, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 83, this.guiTop + 21, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/umfake.png"));
		this.blit(ms, this.guiLeft + 65, this.guiTop + 21, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/doisfake.png"));
		this.blit(ms, this.guiLeft + 65, this.guiTop + 48, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/cinco_fake.png"));
		this.blit(ms, this.guiLeft + 65, this.guiTop + 75, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/10fake.png"));
		this.blit(ms, this.guiLeft + 65, this.guiTop + 102, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/20_fake.png"));
		this.blit(ms, this.guiLeft + 65, this.guiTop + 129, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 123, this.guiTop + 21, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/50fake.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 21, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("money:textures/screens/moedinha.png"));
		this.blit(ms, this.guiLeft + 33, this.guiTop + 48, 0, 0, 16, 16, 16, 16);

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
	}
}
