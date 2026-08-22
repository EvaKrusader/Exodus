package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.exodus.network.ExodusModVariables;

public class OminousLanternBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double range = 0;
		range = entity.getData(ExodusModVariables.PLAYER_VARIABLES).latest_trial_level * 8;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.TRIAL_OMEN)) == true) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
							LevelBasedPermissionSet.OWNER, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
							("team join TrialMobs @e[type=#exodus:trial_mobs,distance=.." + new java.text.DecimalFormat("#").format(range) + "]"));
				}
			}
			if ((itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:nether_coal")))) != 0) == true) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
						_ent.level().getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER,
												_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute at @e[team=TrialMobs,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[team=TrialMobs,distance=.." + new java.text.DecimalFormat("#").format(range)
												+ ("] minecraft:glowing "
														+ (new java.text.DecimalFormat("#")
																.format(Math.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.TRIAL_OMEN) ? _livEnt.getEffect(MobEffects.TRIAL_OMEN).getDuration() : 0) / 20d)))
														+ " 0 true")));
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
						_ent.level().getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
										_ent.getDisplayName(), _ent.level().getServer(), _ent),
								("execute at @e[team=TrialMobs,distance=.." + new java.text.DecimalFormat("#").format(range) + "] run effect give @e[team=TrialMobs,distance=.." + new java.text.DecimalFormat("#").format(range)
										+ "] minecraft:glowing 1 0 true"));
					}
				}
			}
		}
	}
}