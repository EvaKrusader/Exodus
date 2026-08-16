/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exodus.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.ExodusMod;

public class ExodusModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ExodusMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> GOLD_RUSH_START = REGISTRY.register("gold_rush_start", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("exodus", "gold_rush_start")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GOLD_RUSH_KACHING = REGISTRY.register("gold_rush_kaching", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("exodus", "gold_rush_kaching")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GREED_UPGRADE = REGISTRY.register("greed_upgrade", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("exodus", "greed_upgrade")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHOKE_COUGH = REGISTRY.register("choke_cough", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("exodus", "choke_cough")));
}