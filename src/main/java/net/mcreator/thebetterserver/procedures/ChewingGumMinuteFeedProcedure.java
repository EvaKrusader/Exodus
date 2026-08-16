package net.mcreator.thebetterserver.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ChewingGumMinuteFeedProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).isChewingGum == true) {
			if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumCounter > 600) {
				{
					TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
					_vars.chewingGumCounter = 0;
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("the_better_server:greed_upgrade")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("the_better_server:greed_upgrade")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				{
					TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
					_vars.chewingGumCounter = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).chewingGumCounter + 1;
					_vars.markSyncDirty();
				}
			}
			{
				TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
				_vars.howLongChewingGum = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).howLongChewingGum + 1;
				_vars.markSyncDirty();
			}
			if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).howLongChewingGum > 7000) {
				{
					TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
					_vars.chewingGumLevel = 2;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).howLongChewingGum > 6000) {
				{
					TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
					_vars.chewingGumLevel = 1;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).howLongChewingGum == 2) {
				{
					TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
					_vars.chewingGumLevel = 3;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).howLongChewingGum == 3) {
				{
					TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
					_vars.chewingGumLevel = 4;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).howLongChewingGum == 4) {
				{
					TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
					_vars.chewingGumLevel = 5;
					_vars.markSyncDirty();
				}
			}
		}
	}
}