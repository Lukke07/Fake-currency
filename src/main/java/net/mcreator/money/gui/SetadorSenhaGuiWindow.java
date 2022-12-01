
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

import net.mcreator.money.procedures.UnoProcedure;
import net.mcreator.money.procedures.TriProcedure;
import net.mcreator.money.procedures.QuadProcedure;
import net.mcreator.money.procedures.DuoProcedure;
import net.mcreator.money.MoneyMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SetadorSenhaGuiWindow extends ContainerScreen<SetadorSenhaGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = SetadorSenhaGui.guistate;

	public SetadorSenhaGuiWindow(SetadorSenhaGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 200;
		this.ySize = 83;
	}

	private static final ResourceLocation texture = new ResourceLocation("money:textures/screens/setador_senha.png");

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
		if (UnoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "1", 27, 19, -12829636);
		this.font.drawString(ms, "Senha", 68, 1, -12829636);
		if (DuoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "2", 27, 28, -12829636);
		if (TriProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "3", 27, 37, -12829636);
		if (QuadProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "4", 27, 46, -12829636);
		this.font.drawString(ms, "Ns:", 18, 10, -12829636);
		if (QuadProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "OK", 22, 55, -12829636);
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
		this.addButton(new Button(this.guiLeft + 36, this.guiTop + 10, 30, 20, new StringTextComponent("1"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(0, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 66, this.guiTop + 10, 30, 20, new StringTextComponent("2"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(1, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 10, 30, 20, new StringTextComponent("3"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(2, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 36, this.guiTop + 30, 30, 20, new StringTextComponent("4"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(3, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 66, this.guiTop + 30, 30, 20, new StringTextComponent("5"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(4, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 30, 30, 20, new StringTextComponent("6"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(5, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 36, this.guiTop + 50, 30, 20, new StringTextComponent("7"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(6, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 66, this.guiTop + 50, 30, 20, new StringTextComponent("8"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(7, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 50, 30, 20, new StringTextComponent("9"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(8, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 126, this.guiTop + 30, 30, 20, new StringTextComponent("0"), e -> {
			if (true) {
				MoneyMod.PACKET_HANDLER.sendToServer(new SetadorSenhaGui.ButtonPressedMessage(9, x, y, z));
				SetadorSenhaGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
	}
}
