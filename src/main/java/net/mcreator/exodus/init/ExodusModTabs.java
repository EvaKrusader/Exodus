/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exodus.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.ExodusMod;

@EventBusSubscriber
public class ExodusModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExodusMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BAUBLES = REGISTRY.register("baubles",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.exodus.baubles")).icon(() -> new ItemStack(ExodusModItems.ONYX_NECKLACE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ExodusModItems.GREED_RELIC.get());
				tabData.accept(ExodusModItems.HERMES_WINGS.get());
				tabData.accept(ExodusModItems.WATER_STONE.get());
				tabData.accept(ExodusModItems.DEATH_CONTRACT.get());
				tabData.accept(ExodusModItems.OMINOUS_LANTERN.get());
				tabData.accept(ExodusModItems.ONYX_NECKLACE.get());
				tabData.accept(ExodusModItems.FLUORITE_NECKLACE.get());
				tabData.accept(ExodusModItems.CHARM_OF_FIRE_RESISTANCE.get());
				tabData.accept(ExodusModItems.CHARM_OF_FALL_CANCELLATION.get());
				tabData.accept(ExodusModItems.CHARM_OF_EXPERIENCE.get());
				tabData.accept(ExodusModItems.TOME_OF_KNOWLEDGE.get());
				tabData.accept(ExodusModItems.EXPERIENCE_CRYSTAL.get());
				tabData.accept(ExodusModItems.CRESCENT_NECKLACE.get());
			}).withSearchBar().build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_GRIDWORLD = REGISTRY.register("tab_gridworld",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.exodus.tab_gridworld")).icon(() -> new ItemStack(ExodusModBlocks.GRID_PORTAL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ExodusModBlocks.GRID_PORTAL.get().asItem());
			}).withTabsBefore(BAUBLES.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MUSIC_DISCS = REGISTRY.register("music_discs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.exodus.music_discs")).icon(() -> new ItemStack(Items.MUSIC_DISC_PIGSTEP)).displayItems((parameters, tabData) -> {
				tabData.accept(ExodusModItems.RECORD_2000.get());
				tabData.accept(ExodusModItems.RECORD_GLACEIR.get());
			}).withSearchBar().withTabsBefore(TAB_GRIDWORLD.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(ExodusModBlocks.CREEPER_PATCHER.get().asItem());
			tabData.accept(ExodusModBlocks.EASY_BAKE_OVEN.get().asItem());
			tabData.accept(ExodusModBlocks.CREEPER_PATCHER_2.get().asItem());
			tabData.accept(ExodusModItems.CREEPER_ZERO.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(ExodusModItems.ONYX.get());
			tabData.accept(ExodusModItems.RUBY.get());
			tabData.accept(ExodusModItems.CALIDIUM.get());
			tabData.accept(ExodusModItems.TUNGSTEN_INGOT.get());
			tabData.accept(ExodusModItems.TUNGSTEN.get());
			tabData.accept(ExodusModItems.SQUALINE.get());
			tabData.accept(ExodusModItems.FLUORITE.get());
			tabData.accept(ExodusModItems.CAELITE_CLEAR.get());
			tabData.accept(ExodusModItems.CAELITE_RAIN.get());
			tabData.accept(ExodusModItems.CAELITE_THUNDER.get());
			tabData.accept(ExodusModItems.DAELITE.get());
			tabData.accept(ExodusModItems.MONLITE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(ExodusModBlocks.ONYX_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.RUBY_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.CALIDIUM_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.BASALT_CALIDIUM_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.TUNGSTEN_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.SQUALINE_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.STONE_ONYX_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.CAELITE_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.PHASEM_ORE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(ExodusModBlocks.ONYX_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.RUBY_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.CALIDIUM_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.METAL_GRATE_STAIRS.get().asItem());
			tabData.accept(ExodusModBlocks.METAL_GRATE_SLAB.get().asItem());
			tabData.accept(ExodusModBlocks.TUNGSTEN_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.RAW_TUNGSTEN_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.SQUALINE_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.EXPERIENCE_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.FLUORITE_ORE.get().asItem());
			tabData.accept(ExodusModBlocks.FLUORITE_BLOCK.get().asItem());
			tabData.accept(ExodusModBlocks.CAELITE_BLOCK_CLEAR.get().asItem());
			tabData.accept(ExodusModBlocks.CAELITE_BLOCK_RAIN.get().asItem());
			tabData.accept(ExodusModBlocks.CAELITE_BLOCK_THUNDER.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(ExodusModItems.ONYX_PICKAXE.get());
			tabData.accept(ExodusModItems.ONYX_AXE.get());
			tabData.accept(ExodusModItems.ONYX_SHOVEL.get());
			tabData.accept(ExodusModItems.ONYX_HOE.get());
			tabData.accept(ExodusModItems.RUBY_PICKAXE.get());
			tabData.accept(ExodusModItems.RUBY_AXE.get());
			tabData.accept(ExodusModItems.RUBY_SHOVEL.get());
			tabData.accept(ExodusModItems.RUBY_HOE.get());
			tabData.accept(ExodusModItems.CALIDIUM_PICKAXE.get());
			tabData.accept(ExodusModItems.CALIDIUM_AXE.get());
			tabData.accept(ExodusModItems.CALIDIUM_SHOVEL.get());
			tabData.accept(ExodusModItems.CALIDIUM_HOE.get());
			tabData.accept(ExodusModItems.RAZOR_EDGE.get());
			tabData.accept(ExodusModItems.CREEPER_ZERO.get());
			tabData.accept(ExodusModItems.BLACK_KNIFE.get());
			tabData.accept(ExodusModItems.ESCAPE_ROPE.get());
			tabData.accept(ExodusModItems.UPGRADED_ESCAPE_ROPE.get());
			tabData.accept(ExodusModItems.RECORD_2000.get());
			tabData.accept(ExodusModItems.RECORD_GLACEIR.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(ExodusModItems.ONYX_SWORD.get());
			tabData.accept(ExodusModItems.ONYX_ARMOR_HELMET.get());
			tabData.accept(ExodusModItems.ONYX_ARMOR_CHESTPLATE.get());
			tabData.accept(ExodusModItems.ONYX_ARMOR_LEGGINGS.get());
			tabData.accept(ExodusModItems.ONYX_ARMOR_BOOTS.get());
			tabData.accept(ExodusModItems.RUBY_SWORD.get());
			tabData.accept(ExodusModItems.RUBY_ARMOR_HELMET.get());
			tabData.accept(ExodusModItems.RUBY_ARMOR_CHESTPLATE.get());
			tabData.accept(ExodusModItems.RUBY_ARMOR_LEGGINGS.get());
			tabData.accept(ExodusModItems.RUBY_ARMOR_BOOTS.get());
			tabData.accept(ExodusModItems.CALIDIUM_SWORD.get());
			tabData.accept(ExodusModItems.CALIDIUM_ARMOR_HELMET.get());
			tabData.accept(ExodusModItems.CALIDIUM_ARMOR_CHESTPLATE.get());
			tabData.accept(ExodusModItems.CALIDIUM_ARMOR_LEGGINGS.get());
			tabData.accept(ExodusModItems.CALIDIUM_ARMOR_BOOTS.get());
			tabData.accept(ExodusModItems.SQUALINE_ARMOR_HELMET.get());
			tabData.accept(ExodusModItems.SQUALINE_ARMOR_CHESTPLATE.get());
			tabData.accept(ExodusModItems.SQUALINE_ARMOR_LEGGINGS.get());
			tabData.accept(ExodusModItems.SQUALINE_ARMOR_BOOTS.get());
			tabData.accept(ExodusModItems.NETHERITE_FULL_SET.get());
			tabData.accept(ExodusModItems.LONG_FALL_BOOTS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(ExodusModItems.EXPERIENCE_GUMMY.get());
			tabData.accept(ExodusModItems.CHEWING_GUM.get());
		}
	}
}