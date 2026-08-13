package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CreeperRepellentProcProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double range = 0;
		if ((itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:mystical_conductivity")))) != 0) == true) {
			if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:mystical_conductivity")))) == 1) {
				range = 8;
			} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:mystical_conductivity")))) == 2) {
				range = 11;
			} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:mystical_conductivity")))) == 3) {
				range = 15;
			}
		} else {
			range = 5;
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
				_ent.level().getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level().getServer(), _ent),
						("execute if entity @e[type=creeper,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run team join Creepers @e[type=creeper,distance=.." + new java.text.DecimalFormat("#").format(range) + "]"));
			}
		}
		if ((itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("the_better_server:extra_bioluminescence")))) != 0) == true) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							("execute if entity @e[type=creeper,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[type=creeper,distance=.." + new java.text.DecimalFormat("#").format(range)
									+ "] minecraft:glowing 1 0 true"));
				}
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
				_ent.level().getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level().getServer(), _ent),
						("execute if entity @e[type=creeper,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[type=creeper,distance=.." + new java.text.DecimalFormat("#").format(range)
								+ "] minecraft:slowness 1 255 true"));
			}
		}
	}
}