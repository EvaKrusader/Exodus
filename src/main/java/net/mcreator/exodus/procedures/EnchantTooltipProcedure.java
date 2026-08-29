package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.init.ExodusModMobEffects;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = Dist.CLIENT)
public class EnchantTooltipProcedure {
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
			vampirism_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_1;
			vampirism_heal = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_1;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 2) {
			vampirism_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_2;
			vampirism_heal = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_2;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 3) {
			vampirism_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_3;
			vampirism_heal = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_3;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 4) {
			vampirism_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_4;
			vampirism_heal = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_4;
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 5) {
			vampirism_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_5;
			vampirism_heal = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_5;
		}
		if ((entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(ExodusModMobEffects.KNOWLEDGE)) == true) {
			if (itemstack.getItem() == Items.ENCHANTED_BOOK) {
				if ((tooltip.get(1).getString()).contains("Mystical Conductivity")) {
					tooltip.add(Component.literal("\u00A77- Upgrades the range of baubles or reduces their cooldown"));
				} else if ((tooltip.get(1).getString()).contains("Bioluminescence")) {
					tooltip.add(Component.literal("\u00A77- Makes affected Creepers glow"));
				} else if ((tooltip.get(1).getString()).contains("Platform Soles")) {
					tooltip.add(Component.literal("\u00A77- Gives a higher step height"));
					if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
						if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) == 1) {
							tooltip.add(Component.literal("\u00A77* Allows to step up a whole block"));
						} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) == 2) {
							tooltip.add(Component.literal("\u00A77* Allows to step up a block and a half"));
						} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) == 3) {
							tooltip.add(Component.literal(("\u00A77* Sets step height to " + (new java.text.DecimalFormat("##.##")
									.format((entity instanceof LivingEntity _livingEntity27 && _livingEntity27.getAttributes().hasAttribute(Attributes.STEP_HEIGHT) ? _livingEntity27.getAttribute(Attributes.STEP_HEIGHT).getBaseValue() : 0)
											+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:platform_soles")))) / 3.5))
									+ " blocks")));
						}
					}
				} else if ((tooltip.get(1).getString()).contains("Spiky Cleats")) {
					tooltip.add(Component.literal("\u00A77- Breaks cobwebs when sneaking"));
				} else if ((tooltip.get(1).getString()).contains("Trial Breaker")) {
					tooltip.add(Component.literal("\u00A77- Deals extra damage to mobs that spawn in Trial Chambers"));
					if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
						tooltip.add(Component.literal(("\u00A77* Deals "
								+ new java.text.DecimalFormat("##.##").format(ExodusModVariables.WorldVariables.get(world).EnchVal_trial_breaker_damage
										* itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:trial_breaker")))))
								+ " extra damage")));
					}
				} else if ((tooltip.get(1).getString()).contains("Vampirism")) {
					tooltip.add(Component.literal("\u00A77- Gives back health based on dealt damage"));
					if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
						tooltip.add(Component.literal(("\u00A77* Has a " + new java.text.DecimalFormat("##.##").format(vampirism_chance * 100) + "% chance of triggering")));
						tooltip.add(Component.literal(("\u00A77* Heals back " + new java.text.DecimalFormat("##.##").format(vampirism_heal * 100) + "% of the damage dealt")));
					}
				}
			}
		}
	}
}