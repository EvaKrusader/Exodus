/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thebetterserver.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.thebetterserver.block.*;
import net.mcreator.thebetterserver.TheBetterServerMod;

import java.util.function.Function;

public class TheBetterServerModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TheBetterServerMod.MODID);
	public static final DeferredBlock<Block> CREEPER_PATCHER;
	public static final DeferredBlock<Block> ONYX_ORE;
	public static final DeferredBlock<Block> ONYX_BLOCK;
	public static final DeferredBlock<Block> RUBY_ORE;
	public static final DeferredBlock<Block> RUBY_BLOCK;
	public static final DeferredBlock<Block> CALIDIUM_ORE;
	public static final DeferredBlock<Block> CALIDIUM_BLOCK;
	public static final DeferredBlock<Block> BASALT_CALIDIUM_ORE;
	public static final DeferredBlock<Block> DS;
	public static final DeferredBlock<Block> EASY_BAKE_OVEN;
	static {
		CREEPER_PATCHER = register("creeper_patcher", CreeperPatcherBlock::new);
		ONYX_ORE = register("onyx_ore", OnyxOreBlock::new);
		ONYX_BLOCK = register("onyx_block", OnyxBlockBlock::new);
		RUBY_ORE = register("ruby_ore", RubyOreBlock::new);
		RUBY_BLOCK = register("ruby_block", RubyBlockBlock::new);
		CALIDIUM_ORE = register("calidium_ore", CalidiumOreBlock::new);
		CALIDIUM_BLOCK = register("calidium_block", CalidiumBlockBlock::new);
		BASALT_CALIDIUM_ORE = register("basalt_calidium_ore", BasaltCalidiumOreBlock::new);
		DS = register("ds", DsBlock::new);
		EASY_BAKE_OVEN = register("easy_bake_oven", EasyBakeOvenBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.BlockTintSources event) {
			DsBlock.blockColorLoad(event);
		}
	}
}