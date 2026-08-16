package net.mcreator.exodus.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.exodus.procedures.*;

@EventBusSubscriber(Dist.CLIENT)
public class DevOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGreedLevelProcedure.execute(entity), 3, 2, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGoldValueProcedure.execute(entity), w / 2 + -85, h / 2 + -116, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGoldGoalProcedure.execute(entity), w / 2 + -85, h / 2 + -103, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnStepHeightBaseProcedure.execute(entity), w / 2 + 39, h / 2 + -117, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnStepHeightModProcedure.execute(entity), w / 2 + 39, h / 2 + -105, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnOminousLevelProcedure.execute(entity), w / 2 + -206, h / 2 + -72, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnAdrenalineDamageProcedure.execute(entity), w / 2 + 92, h / 2 + -76, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnChewingGumGlobalProcedure.execute(entity), w / 2 + -208, h / 2 + -38, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnChewingGumCounterProcedure.execute(entity), w / 2 + -209, h / 2 + -24, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnChewingGumLevelProcedure.execute(entity), w / 2 + -207, h / 2 + -9, -1, false);
		}
	}
}