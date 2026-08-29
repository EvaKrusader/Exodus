package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.init.ExodusModMobEffects;
import net.mcreator.exodus.init.ExodusModItems;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = Dist.CLIENT)
public class CurioTooltipProcedure {
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, Minecraft.getInstance().level, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, world, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ExodusModMobEffects.KNOWLEDGE)) == true) {
			if (itemstack.getItem() == ExodusModItems.ONYX_NECKLACE.get()) {
				tooltip.add(Component.literal("\u00A77- Keeps Creepers at bay"));
			}
			if (itemstack.getItem() == ExodusModItems.GREED_RELIC.get()) {
				tooltip.add(Component.literal("\u00A77- Wearing Golden Armor grants effects against Piglin Brutes"));
			}
			if (itemstack.getItem() == ExodusModItems.HERMES_WINGS.get()) {
				tooltip.add(Component.literal("\u00A77- Slows your fall when sneaking mid-air"));
			}
			if (itemstack.getItem() == ExodusModItems.OMINOUS_LANTERN.get()) {
				tooltip.add(Component.literal("\u00A77- Highlights mobs during ominous trials"));
			}
			if (itemstack.getItem() == ExodusModItems.WATER_STONE.get()) {
				tooltip.add(Component.literal("\u00A77- Extinguishes fire when you sneak"));
			}
			if (itemstack.getItem() == ExodusModItems.DEATH_CONTRACT.get()) {
				tooltip.add(Component.literal("\u00A77- Reverses death for hearts"));
			}
			if (itemstack.getItem() == ExodusModItems.FLUORITE_NECKLACE.get()) {
				tooltip.add(Component.literal("\u00A77- Cures negative potion effects"));
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
					tooltip.add(Component.literal(("\u00A77* Has a " + new java.text.DecimalFormat("##.##").format((ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_cooldown * 20
							- itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:mystical_conductivity"))))
									* ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_reduction * 20)
							/ 20) + " second cooldown")));
				}
			}
			if (itemstack.getItem() == ExodusModItems.CHARM_OF_EXPERIENCE.get()) {
				tooltip.add(Component.literal("\u00A77- Shares XP with players in a 16-block radius"));
			}
			if (itemstack.getItem() == ExodusModItems.CHARM_OF_FALL_CANCELLATION.get()) {
				tooltip.add(Component.literal("\u00A77~ Single Use"));
				tooltip.add(Component.literal("\u00A77Reverses a death by fall damage"));
			}
			if (itemstack.getItem() == ExodusModItems.CHARM_OF_FIRE_RESISTANCE.get()) {
				tooltip.add(Component.literal("\u00A77~ Single Use"));
				tooltip.add(Component.literal("\u00A77~ Stackable"));
				tooltip.add(Component.literal("\u00A77Grants \u00A79Fire Resistance (00:30)"));
			}
			if (itemstack.getItem() == ExodusModItems.EXPERIENCE_CRYSTAL.get()) {
				tooltip.add(Component.literal("\u00A77- Stores experience on death"));
			}
			if (itemstack.getItem() == ExodusModItems.TOME_OF_KNOWLEDGE.get()) {
				tooltip.add(Component.literal("\u00A77- Grants more specific info about items"));
				tooltip.add(Component.literal("\u00A77- Enhances the knowledge effect"));
			}
		}
	}
}