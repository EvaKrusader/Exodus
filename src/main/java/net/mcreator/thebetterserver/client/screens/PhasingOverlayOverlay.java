package net.mcreator.thebetterserver.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.Minecraft;

import net.mcreator.thebetterserver.procedures.PhasingOverlayDisplayOverlayIngameProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class PhasingOverlayOverlay {
	private static final Identifier BACKGROUND = Identifier.parse("the_better_server:textures/screens/phasing_overlay.png");

	@SubscribeEvent(priority = EventPriority.HIGHEST)
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
		if (PhasingOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, 0, 0, 0, 0, w, h, w, h);
		}
	}
}