package net.mcreator.exodus.init;

import top.theillusivec4.curios.api.client.ICurioRenderer;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import net.mcreator.exodus.client.renderer.GreedRelicBaubleRenderer;

public class ExodusModCuriosRenderers {
	public static void registerRenderers(FMLClientSetupEvent event) {
		ICurioRenderer.register(ExodusModItems.GREED_RELIC.get(), GreedRelicBaubleRenderer::new);
	}
}