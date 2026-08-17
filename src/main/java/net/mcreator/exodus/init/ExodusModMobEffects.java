/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exodus.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.procedures.PhasingEffectExpiresProcedure;
import net.mcreator.exodus.procedures.AdrenalineEffectExpiresProcedure;
import net.mcreator.exodus.potion.PhasingMobEffect;
import net.mcreator.exodus.potion.KnowledgeMobEffect;
import net.mcreator.exodus.potion.GoldRushMobEffect;
import net.mcreator.exodus.potion.AdrenalineMobEffect;
import net.mcreator.exodus.ExodusMod;

@EventBusSubscriber
public class ExodusModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, ExodusMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> PHASING = REGISTRY.register("phasing", PhasingMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> GOLD_RUSH = REGISTRY.register("gold_rush", GoldRushMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> ADRENALINE = REGISTRY.register("adrenaline", AdrenalineMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> KNOWLEDGE = REGISTRY.register("knowledge", KnowledgeMobEffect::new);

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