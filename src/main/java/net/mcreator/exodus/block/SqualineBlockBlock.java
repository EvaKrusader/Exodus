package net.mcreator.exodus.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class SqualineBlockBlock extends Block {
	public SqualineBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(5f, 6f).requiresCorrectToolForDrops());
	}
}