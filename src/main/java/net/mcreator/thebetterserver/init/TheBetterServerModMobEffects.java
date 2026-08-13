/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thebetterserver.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.thebetterserver.procedures.PhasingEffectExpiresProcedure;
import net.mcreator.thebetterserver.procedures.AdrenalineEffectExpiresProcedure;
import net.mcreator.thebetterserver.potion.PhasingMobEffect;
import net.mcreator.thebetterserver.potion.GoldRushMobEffect;
import net.mcreator.thebetterserver.potion.AdrenalineMobEffect;
import net.mcreator.thebetterserver.TheBetterServerMod;

@EventBusSubscriber
public class TheBetterServerModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, TheBetterServerMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> PHASING = REGISTRY.register("phasing", PhasingMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> GOLD_RUSH = REGISTRY.register("gold_rush", GoldRushMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> ADRENALINE = REGISTRY.register("adrenaline", AdrenalineMobEffect::new);

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.is(PHASING)) {
			PhasingEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.is(ADRENALINE)) {
			AdrenalineEffectExpiresProcedure.execute(entity.level(), entity);
		}
	}
}