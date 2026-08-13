package net.mcreator.thebetterserver.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BasaltCalidiumOreBlock extends Block {
	public BasaltCalidiumOreBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.BASALT).strength(3f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}