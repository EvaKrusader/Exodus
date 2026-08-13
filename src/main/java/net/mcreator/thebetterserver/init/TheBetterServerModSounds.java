/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thebetterserver.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.thebetterserver.TheBetterServerMod;

public class TheBetterServerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, TheBetterServerMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> GOLD_RUSH_START = REGISTRY.register("gold_rush_start", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("the_better_server", "gold_rush_start")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GOLD_RUSH_KACHING = REGISTRY.register("gold_rush_kaching", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("the_better_server", "gold_rush_kaching")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GREED_UPGRADE = REGISTRY.register("greed_upgrade", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("the_better_server", "greed_upgrade")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHOKE_COUGH = REGISTRY.register("choke_cough", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("the_better_server", "choke_cough")));
}