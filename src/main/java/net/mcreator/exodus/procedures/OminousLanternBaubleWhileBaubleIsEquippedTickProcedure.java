package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.exodus.network.ExodusModVariables;

public class OminousLanternBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double range = 0;
		range = entity.getData(ExodusModVariables.PLAYER_VARIABLES).latest_trial_level * 8;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.TRIAL_OMEN)) == true) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands()
							.performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER,
											_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
									("team join TrialMobs @e[type=#the_better_server:trial_mobs,distance=.." + new java.text.DecimalFormat("#").format(range) + "]"));
				}
			}
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