package net.mcreator.exodus.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class MetalGrateSlabBlock extends SlabBlock {
	public MetalGrateSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.CHAIN).strength(4f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public int getLightDampening(BlockState state) {
		return 0;
	}
}