package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.exodus.network.ExodusModVariables;

public class FluoriteNecklaceBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double cooldown = 0;
		if ((itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:mystical_conductivity")))) != 0) == true) {
			cooldown = ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_cooldown * 20
					- itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("exodus:mystical_conductivity"))))
							* ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_reduction * 20;
		} else {
			cooldown = ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_cooldown * 20 - ExodusModVariables.WorldVariables.get(world).EnchVal_fluorite_necklace_reduction * 20;
		}
		if ((entity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.WITHER)) == true || (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.POISON)) == true) {
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
					if ((entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.WITHER)) == true && (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MobEffects.POISON)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Wither & Poison" + " effects")), true);
					} else if ((entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.WITHER)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Wither" + " effect")), true);
					} else if ((entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MobEffects.POISON)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Poison" + " effect")), true);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WITHER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, (int) cooldown);
			}
		}
		if ((entity instanceof Player _plrCldCheck27 && _plrCldCheck27.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(MobEffects.SLOWNESS)) == true || (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(MobEffects.MINING_FATIGUE)) == true) {
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
					if ((entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(MobEffects.SLOWNESS)) == true && (entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MobEffects.MINING_FATIGUE)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Slowness & Mining Fatigue" + " effects")), true);
					} else if ((entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(MobEffects.MINING_FATIGUE)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Mining Fatigue" + " effect")), true);
					} else if ((entity instanceof LivingEntity _livEnt39 && _livEnt39.hasEffect(MobEffects.SLOWNESS)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Slowness" + " effect")), true);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SLOWNESS);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MINING_FATIGUE);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, (int) cooldown);
			}
		}
		if ((entity instanceof Player _plrCldCheck49 && _plrCldCheck49.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(MobEffects.HUNGER)) == true || (entity instanceof LivingEntity _livEnt51 && _livEnt51.hasEffect(MobEffects.WEAKNESS)) == true) {
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
					if ((entity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect(MobEffects.HUNGER)) == true && (entity instanceof LivingEntity _livEnt53 && _livEnt53.hasEffect(MobEffects.WEAKNESS)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Hunger & Weakness" + " effects")), true);
					} else if ((entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(MobEffects.WEAKNESS)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Weakness" + " effect")), true);
					} else if ((entity instanceof LivingEntity _livEnt61 && _livEnt61.hasEffect(MobEffects.HUNGER)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Hunger" + " effect")), true);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HUNGER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAKNESS);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, (int) cooldown);
			}
		}
		if ((entity instanceof Player _plrCldCheck71 && _plrCldCheck71.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt72 && _livEnt72.hasEffect(MobEffects.BLINDNESS)) == true || (entity instanceof LivingEntity _livEnt73 && _livEnt73.hasEffect(MobEffects.DARKNESS)) == true) {
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
					if ((entity instanceof LivingEntity _livEnt74 && _livEnt74.hasEffect(MobEffects.BLINDNESS)) == true && (entity instanceof LivingEntity _livEnt75 && _livEnt75.hasEffect(MobEffects.DARKNESS)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Blindness & Darkness" + " effects")), true);
					} else if ((entity instanceof LivingEntity _livEnt79 && _livEnt79.hasEffect(MobEffects.BLINDNESS)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Blindness" + " effect")), true);
					} else if ((entity instanceof LivingEntity _livEnt83 && _livEnt83.hasEffect(MobEffects.DARKNESS)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Darkness" + " effect")), true);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BLINDNESS);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DARKNESS);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, (int) cooldown);
			}
		}
		if ((entity instanceof Player _plrCldCheck93 && _plrCldCheck93.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt94 && _livEnt94.hasEffect(MobEffects.INFESTED)) == true || (entity instanceof LivingEntity _livEnt95 && _livEnt95.hasEffect(MobEffects.OOZING)) == true
					|| (entity instanceof LivingEntity _livEnt96 && _livEnt96.hasEffect(MobEffects.WEAVING)) == true || (entity instanceof LivingEntity _livEnt97 && _livEnt97.hasEffect(MobEffects.WIND_CHARGED)) == true) {
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).playerKnowledge == true) {
					if ((entity instanceof LivingEntity _livEnt98 && _livEnt98.hasEffect(MobEffects.INFESTED)) == true && (entity instanceof LivingEntity _livEnt99 && _livEnt99.hasEffect(MobEffects.OOZING)) == true
							&& (entity instanceof LivingEntity _livEnt100 && _livEnt100.hasEffect(MobEffects.WEAVING)) == true && (entity instanceof LivingEntity _livEnt101 && _livEnt101.hasEffect(MobEffects.WIND_CHARGED)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Oozing, Weaving, Infested & Wind Charged" + " effects")), true);
					} else if ((entity instanceof LivingEntity _livEnt105 && _livEnt105.hasEffect(MobEffects.OOZING)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Oozing" + " effect")), true);
					} else if ((entity instanceof LivingEntity _livEnt109 && _livEnt109.hasEffect(MobEffects.WEAVING)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Weaving" + " effect")), true);
					} else if ((entity instanceof LivingEntity _livEnt113 && _livEnt113.hasEffect(MobEffects.WIND_CHARGED)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Wind Charged" + " effect")), true);
					} else if ((entity instanceof LivingEntity _livEnt117 && _livEnt117.hasEffect(MobEffects.INFESTED)) == true) {
						if (entity instanceof ServerPlayer _player)
							_player.sendSystemMessage(Component.literal(("Your " + ((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", "") + " cured your " + "Infested" + " effect")), true);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.OOZING);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAVING);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WIND_CHARGED);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.INFESTED);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.amethyst_block.resonate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, (int) cooldown);
			}
		}
	}
}