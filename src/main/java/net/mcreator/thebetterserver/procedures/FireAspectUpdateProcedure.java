package net.mcreator.thebetterserver.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FireAspectUpdateProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState fireType = Blocks.AIR.defaultBlockState();
		if ((entity.level()
				.clip(new ClipContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity0.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
						ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
				.getType() == HitResult.Type.BLOCK) == true) {
			if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) != 0) == true) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) == 1) {
					fireType = Blocks.FIRE.defaultBlockState();
				} else {
					fireType = Blocks.SOUL_FIRE.defaultBlockState();
				}
				if ((entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity6.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.UP) {
					world.setBlock(BlockPos.containing(x, y + 1, z), fireType, 3);
				}
				if ((entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity10.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.DOWN) {
					world.setBlock(BlockPos.containing(x, y - 1, z), fireType, 3);
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("up") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if ((entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity15.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					world.setBlock(BlockPos.containing(x, y, z + 1), fireType, 3);
					{
						BlockPos _pos = BlockPos.containing(x, y, z + 1);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("north") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if ((entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity20.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.NORTH) {
					world.setBlock(BlockPos.containing(x, y, z - 1), fireType, 3);
					{
						BlockPos _pos = BlockPos.containing(x, y, z - 1);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("south") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if ((entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity25.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					world.setBlock(BlockPos.containing(x - 1, y, z), fireType, 3);
					{
						BlockPos _pos = BlockPos.containing(x - 1, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("east") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if ((entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity30.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.EAST) {
					world.setBlock(BlockPos.containing(x + 1, y, z), fireType, 3);
					{
						BlockPos _pos = BlockPos.containing(x + 1, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("west") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.blaze.shoot")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.blaze.shoot")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			}
		}
	}
}