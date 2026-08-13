package net.mcreator.thebetterserver.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class OnyxBlockBlock extends Block {
	public OnyxBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(5f, 6f).requiresCorrectToolForDrops());
	}
}