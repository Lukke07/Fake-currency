
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

import net.mcreator.money.procedures.UmProcedure;
import net.mcreator.money.procedures.TresProcedure;
import net.mcreator.money.procedures.QuatroProcedure;
import net.mcreator.money.procedures.DoisProcedure;
import net.mcreator.money.MoneyMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GuiSenhaGuiWindow extends ContainerScreen<GuiSenhaGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GuiSenhaGui.guistate;

	public GuiSenhaGuiWindow(GuiSenhaGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/gui_senha.png");

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
		this.font.drawString(ms, "Senha", 24, 3, -12829636);
		if (UmProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "*", 26, 13, -12829636);
		if (DoisProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "*", 32, 13, -12829636);
		if (TresProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "*", 38, 13, -12829636);
		if (QuatroProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "*", 44, 13, -12829636);
		this.font.drawString(ms, "|", 18, 3, -12829636);
		this.font.drawString(ms, "Cart\u00E3o", 2, 31, -12829636);
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
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 3, 30, 20, new StringTextComponent("1"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(0, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 90, this.guiTop + 3, 30, 20, new StringTextComponent("2"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(1, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + 3, 30, 20, new StringTextComponent("3"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(2, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 23, 30, 20, new StringTextComponent("4"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(3, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 90, this.guiTop + 23, 30, 20, new StringTextComponent("5"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(4, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + 23, 30, 20, new StringTextComponent("6"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(5, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 43, 30, 20, new StringTextComponent("7"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(6, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 90, this.guiTop + 43, 30, 20, new StringTextComponent("8"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(7, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + 43, 30, 20, new StringTextComponent("9"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(8, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 90, this.guiTop + 63, 30, 20, new StringTextComponent("0"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(9, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + 63, 35, 20, new StringTextComponent("OK"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new GuiSenhaGui.ButtonPressedMessage(10, x, y, z));
				GuiSenhaGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
	}
}
