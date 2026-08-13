/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thebetterserver.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thebetterserver.client.model.Modellustar_halo;

@EventBusSubscriber(Dist.CLIENT)
public class TheBetterServerModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modellustar_halo.LAYER_LOCATION, Modellustar_halo::createBodyLayer);
	}
}