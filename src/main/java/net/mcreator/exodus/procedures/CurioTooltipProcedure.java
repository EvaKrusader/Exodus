package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.exodus.init.ExodusModMobEffects;
import net.mcreator.exodus.init.ExodusModItems;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = Dist.CLIENT)
public class CurioTooltipProcedure {
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ExodusModMobEffects.KNOWLEDGE)) == true) {
			if (itemstack.getItem() == ExodusModItems.ONYX_NECKLACE.get()) {
				tooltip.add(Component.literal("\u00A77Protects from Creepers"));
			}
			if (itemstack.getItem() == ExodusModItems.GREED_RELIC.get()) {
				tooltip.add(Component.literal("\u00A77Your greed protects you"));
			}
			if (itemstack.getItem() == ExodusModItems.HERMES_WINGS.get()) {
				tooltip.add(Component.literal("\u00A77Slows your fall when sneaking"));
			}
			if (itemstack.getItem() == ExodusModItems.OMINOUS_LANTERN.get()) {
				tooltip.add(Component.literal("\u00A77Highlights mobs during ominous trials"));
			}
			if (itemstack.getItem() == ExodusModItems.WATER_STONE.get()) {
				tooltip.add(Component.literal("\u00A77Extinguishes fire when you sneak"));
			}
			if (itemstack.getItem() == ExodusModItems.DEATH_CONTRACT.get()) {
				tooltip.add(Component.literal("\u00A77Reverses death for a price"));
			}
		}
	}
}