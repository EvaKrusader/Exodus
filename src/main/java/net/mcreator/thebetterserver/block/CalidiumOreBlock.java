package net.mcreator.thebetterserver.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CalidiumOreBlock extends Block {
	public CalidiumOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(3f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}