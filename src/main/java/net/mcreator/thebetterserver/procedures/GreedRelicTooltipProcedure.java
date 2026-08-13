package net.mcreator.thebetterserver.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;
import net.mcreator.thebetterserver.init.TheBetterServerModItems;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = Dist.CLIENT)
public class GreedRelicTooltipProcedure {
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
		if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).isGreedy == true) {
			if (itemstack.getItem() == Items.GOLDEN_HELMET) {
				tooltip.remove(1);
				tooltip.add(1, Component.literal("\u00A76The Mind"));
			}
			if (itemstack.getItem() == Items.GOLDEN_CHESTPLATE) {
				tooltip.remove(1);
				tooltip.add(1, Component.literal("\u00A76The Body"));
			}
			if (itemstack.getItem() == Items.GOLDEN_LEGGINGS) {
				tooltip.add(Component.literal("\u00A76The Mind"));
			}
			if (itemstack.getItem() == Items.GOLDEN_BOOTS) {
				tooltip.add(Component.literal("\u00A76The Mind"));
			}
			if (itemstack.getItem() == TheBetterServerModItems.GREED_RELIC.get()) {
				tooltip.add(Component.literal(("\u00A76" + new java.text.DecimalFormat("#").format(Math.floor(entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).goldAmount)) + "/"
						+ new java.text.DecimalFormat("#").format(Math.floor(entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).goldGoal)))));
			}
		}
	}
}