package net.mcreator.exodus.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import net.mcreator.exodus.world.inventory.DevMenuMenu;
import net.mcreator.exodus.network.DevMenuButtonMessage;
import net.mcreator.exodus.init.ExodusModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class DevMenuScreen extends AbstractContainerScreen<DevMenuMenu> implements ExodusModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_nether;
	private Button button_overworld;
	private Button button_end;
	private Button button_night_vision;
	private static final Identifier BACKGROUND = Identifier.parse("exodus:textures/screens/dev_menu.png");

	public DevMenuScreen(DevMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractBackground(guiGraphics, mouseX, mouseY, partialTicks);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_nether = Button.builder(Component.translatable("gui.exodus.dev_menu.button_nether"), e -> {
			int x = DevMenuScreen.this.x;
			int y = DevMenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DevMenuButtonMessage(0, x, y, z));
				DevMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 79, 55, 20).build();
		this.addRenderableWidget(button_nether);
		button_overworld = Button.builder(Component.translatable("gui.exodus.dev_menu.button_overworld"), e -> {
			int x = DevMenuScreen.this.x;
			int y = DevMenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DevMenuButtonMessage(1, x, y, z));
				DevMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 57, 70, 20).build();
		this.addRenderableWidget(button_overworld);
		button_end = Button.builder(Component.translatable("gui.exodus.dev_menu.button_end"), e -> {
			int x = DevMenuScreen.this.x;
			int y = DevMenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DevMenuButtonMessage(2, x, y, z));
				DevMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 103, 40, 20).build();
		this.addRenderableWidget(button_end);
		button_night_vision = Button.builder(Component.translatable("gui.exodus.dev_menu.button_night_vision"), e -> {
			int x = DevMenuScreen.this.x;
			int y = DevMenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DevMenuButtonMessage(3, x, y, z));
				DevMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 82, this.topPos + 8, 85, 20).build();
		this.addRenderableWidget(button_night_vision);
	}
}