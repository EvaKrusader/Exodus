package net.mcreator.exodus.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TungstenOreBlock extends Block {
	public TungstenOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(3f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}