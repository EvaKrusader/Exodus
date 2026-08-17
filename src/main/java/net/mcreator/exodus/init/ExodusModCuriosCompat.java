package net.mcreator.exodus.init;

import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.CuriosCapability;

import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

import net.minecraft.world.item.ItemStack;

import net.mcreator.exodus.procedures.*;

public class ExodusModCuriosCompat {
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public boolean makesPiglinsNeutral(SlotContext slotContext) {
				return true;
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				GreedRelicBaubleWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity(), stack);
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				GreedRelicBaubleBaubleIsEquippedProcedure.execute(slotContext.entity().level(), slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				GreedRelicBaubleBaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, ExodusModItems.GREED_RELIC.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				HermesWingsProcProcedure.execute(slotContext.entity().level(), slotContext.entity(), stack);
			}
		}, ExodusModItems.HERMES_WINGS.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				WaterStoneBaubleWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ(), slotContext.entity(), stack);
			}
		}, ExodusModItems.WATER_STONE.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public boolean canUnequip(SlotContext slotContext) {
				return DeathContractBaubleCanUnequipBaubleProcedure.execute(slotContext.entity());
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				DeathContractBaubleWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				DeathContractBaubleBaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				DeathContractBaubleBaubleIsUnequippedProcedure.execute(slotContext.entity(), stack);
			}
		}, ExodusModItems.DEATH_CONTRACT.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				OminousLanternBaubleWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity());
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				OminousLanternBaubleBaubleIsEquippedProcedure.execute(slotContext.entity());
			}
		}, ExodusModItems.OMINOUS_LANTERN.get());
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				CreeperRepellentProcProcedure.execute(slotContext.entity().level(), slotContext.entity(), stack);
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				TestBaubleIsEquippedProcedure.execute(slotContext.entity());
			}
		}, ExodusModItems.ONYX_NECKLACE.get());
	}
}