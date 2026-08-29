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
		if (DevOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGreedLevelProcedure.execute(entity), w / 2 + 128, h / 2 + -45, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGoldValueProcedure.execute(entity), w / 2 + 129, h / 2 + 1, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGoldGoalProcedure.execute(entity), w / 2 + 130, h / 2 + -14, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnStepHeightBaseProcedure.execute(entity), w - 175, 3, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnStepHeightModProcedure.execute(entity), w - 175, 15, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnOminousLevelProcedure.execute(entity), 1, h / 2 + -73, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnAdrenalineDamageProcedure.execute(entity), w / 2 + 92, h / 2 + -76, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnChewingGumCounterProcedure.execute(entity), w / 2 + -209, h / 2 + -24, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGreedyProcedure.execute(entity), w / 2 + 128, h / 2 + -31, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnGithubGoldValuesProcedure.execute(world), w / 2 + -62, h / 2 + 37, -1, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnXPVALUEProcedure.execute(entity), 14, h / 2 + 2, -1, false);
		}
	}
}