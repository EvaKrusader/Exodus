package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.network.ExodusModVariables;

import javax.annotation.Nullable;

import java.io.File;

@EventBusSubscriber
public class VampirismProcProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity, double amount) {
		execute(null, world, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		String fileName = "";
		String url = "";
		File file = new File("");
		com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
		double localVampirismChance = 0;
		double localVampirismPercentage = 0;
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) != 0) == true) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 1) {
				localVampirismChance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_1;
				localVampirismPercentage = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_1;
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 2) {
				localVampirismChance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_2;
				localVampirismPercentage = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_2;
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 3) {
				localVampirismChance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_3;
				localVampirismPercentage = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_3;
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 4) {
				localVampirismChance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_4;
				localVampirismPercentage = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_4;
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:vampirism")))) == 5) {
				localVampirismChance = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_chance_5;
				localVampirismPercentage = ExodusModVariables.WorldVariables.get(world).EnchVal_vampirism_percentage_5;
			}
			if (Math.random() <= localVampirismChance) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount * localVampirismPercentage));
			}
		}
	}
}