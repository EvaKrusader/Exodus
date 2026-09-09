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
public class WeaponTooltipProcedure {
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
		double vampirism_chance = 0;
		double vampirism_heal = 0;
		if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 1) {
			vampirism_chance = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_chance_1;
			vampirism_heal = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_percentage_1;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 2) {
			vampirism_chance = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_chance_2;
			vampirism_heal = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_percentage_2;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 3) {
			vampirism_chance = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_chance_3;
			vampirism_heal = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_chance_3;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 4) {
			vampirism_chance = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_chance_4;
			vampirism_heal = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_percentage_4;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 5) {
			vampirism_chance = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_chance_5;
			vampirism_heal = ExodusModVariables.MapVariables.get(world).EnchVal_vampirism_percentage_5;
		}
		if ((entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(ExodusModMobEffects.KNOWLEDGE)) == true) {
			if (itemstack.getItem() == ExodusModItems.RAZOR_EDGE.get()) {
				tooltip.add(Component.literal("\u00A77- Deals half of the target's max health if it has over half of it's max health"));
			}
		}
	}
}