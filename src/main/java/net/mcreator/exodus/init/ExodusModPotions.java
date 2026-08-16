/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exodus.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.ExodusMod;

public class ExodusModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, ExodusMod.MODID);
	public static final DeferredHolder<Potion, Potion> PHASING_POTION = REGISTRY.register("phasing_potion", () -> new Potion("phasing_potion", new MobEffectInstance(ExodusModMobEffects.PHASING, 60, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> GOLD_RUSH_POTION = REGISTRY.register("gold_rush_potion", () -> new Potion("gold_rush_potion", new MobEffectInstance(ExodusModMobEffects.GOLD_RUSH, 800, 0, false, false)));
}