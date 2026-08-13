package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class GreedRelicBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double range = 0;
		double slowness = 0;
		double power = 0;
		itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:authority"))),
				(int) entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).greedLevel);
		range = Math.ceil(itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:authority")))) * 2.2 + 3);
		power = Math.ceil(itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:authority")))) * 0.45 + 0);
		slowness = Math.ceil(itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:authority")))) * 0.5 + 0.65);
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
				_ent.level().getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level().getServer(), _ent),
						("execute if entity @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run team join Brutes @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range) + "]"));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.GOLDEN_HELMET) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							("execute if entity @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range)
									+ "] minecraft:glowing 1 0 true"));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.GOLDEN_CHESTPLATE) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							("execute if entity @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range)
									+ ("] minecraft:weakness 1 " + new java.text.DecimalFormat("#").format(power) + " true")));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.GOLDEN_LEGGINGS) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							("execute if entity @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range)
									+ ("] minecraft:slowness 1 " + new java.text.DecimalFormat("#").format(power) + " true")));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.GOLDEN_BOOTS) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							("execute if entity @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range)
									+ ("] minecraft:slowness 1 " + new java.text.DecimalFormat("#").format(power) + " true")));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.GOLDEN_LEGGINGS
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.GOLDEN_BOOTS) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							("execute if entity @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[type=piglin_brute,distance=.." + new java.text.DecimalFormat("#").format(range)
									+ ("] minecraft:slowness 1 " + new java.text.DecimalFormat("#").format(slowness) + " true")));
				}
			}
		}
	}
}