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
				tooltip.add(Component.literal("\u00A77Keeps Creepers at bay"));
			}
			if (itemstack.getItem() == ExodusModItems.GREED_RELIC.get()) {
				tooltip.add(Component.literal("\u00A77Wearing Golden Armor grants effects against Piglin Brutes"));
			}
			if (itemstack.getItem() == ExodusModItems.HERMES_WINGS.get()) {
				tooltip.add(Component.literal("\u00A77Slows your fall when sneaking mid-air"));
			}
			if (itemstack.getItem() == ExodusModItems.OMINOUS_LANTERN.get()) {
				tooltip.add(Component.literal("\u00A77Highlights mobs during ominous trials"));
			}
			if (itemstack.getItem() == ExodusModItems.WATER_STONE.get()) {
				tooltip.add(Component.literal("\u00A77Extinguishes fire when you sneak"));
			}
			if (itemstack.getItem() == ExodusModItems.DEATH_CONTRACT.get()) {
				tooltip.add(Component.literal("\u00A77Reverses death for hearts"));
			}
			if (itemstack.getItem() == ExodusModItems.FLUORITE_NECKLACE.get()) {
				tooltip.add(Component.literal("\u00A77Cures negative potion effects"));
			}
			if (itemstack.getItem() == ExodusModItems.CHARM_OF_EXPERIENCE.get()) {
				tooltip.add(Component.literal("\u00A77Shares XP with players in a 16-block radius"));
			}
			if (itemstack.getItem() == ExodusModItems.CHARM_OF_FALL_CANCELLATION.get()) {
				tooltip.add(Component.literal("\u00A77- Single Use"));
				tooltip.add(Component.literal("\u00A77Reverses a death by fall damage"));
			}
			if (itemstack.getItem() == ExodusModItems.CHARM_OF_FIRE_RESISTANCE.get()) {
				tooltip.add(Component.literal("\u00A77- Single Use"));
				tooltip.add(Component.literal("\u00A77Grants \u00A79Fire Resistance (00:30)"));
			}
		}
	}
}