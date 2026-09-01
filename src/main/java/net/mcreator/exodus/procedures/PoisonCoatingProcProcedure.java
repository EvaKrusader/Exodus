package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.network.ExodusModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PoisonCoatingProcProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double local_chance = 0;
		double local_length = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:poison_coating")))) == 1) {
			local_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_chance_1;
			local_length = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_length_1;
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:poison_coating")))) == 2) {
			local_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_chance_2;
			local_length = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_length_2;
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:poison_coating")))) == 3) {
			local_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_chance_3;
			local_length = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_length_3;
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:poison_coating")))) == 4) {
			local_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_chance_4;
			local_length = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_length_4;
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:poison_coating")))) == 5) {
			local_chance = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_chance_5;
			local_length = ExodusModVariables.WorldVariables.get(world).EnchVal_poison_coating_length_5;
		}
		if (Math.random() <= local_chance) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, (int) (local_length * 20), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:poison_coating")))) - 1, false, true));
			if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
				if (entity instanceof ServerPlayer _player)
					_player.sendSystemMessage(Component.literal(("You have been poisoned by " + sourceentity.getDisplayName().getString())), false);
			}
		}
	}
}