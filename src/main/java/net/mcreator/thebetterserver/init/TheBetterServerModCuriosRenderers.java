package net.mcreator.thebetterserver.init;

import top.theillusivec4.curios.api.client.ICurioRenderer;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import net.mcreator.thebetterserver.client.renderer.TestRenderer;
import net.mcreator.thebetterserver.client.renderer.GreedRelicBaubleRenderer;

public class TheBetterServerModCuriosRenderers {
	public static void registerRenderers(FMLClientSetupEvent event) {
		ICurioRenderer.register(TheBetterServerModItems.CREEPER_REPELLENT.get(), TestRenderer::new);
		ICurioRenderer.register(TheBetterServerModItems.GREED_RELIC.get(), GreedRelicBaubleRenderer::new);
	}
}