package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class DevOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SPECTATOR);
		} else {
			if (entity instanceof Player _plr2 && _plr2.gameMode() == GameType.SURVIVAL) {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.CREATIVE);
			} else if (entity instanceof Player _plr4 && _plr4.gameMode() == GameType.CREATIVE) {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SURVIVAL);
			}
			if (entity instanceof Player _plr6 && _plr6.gameMode() == GameType.SPECTATOR) {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.CREATIVE);
			}
		}
	}
}