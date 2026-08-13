/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thebetterserver.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.thebetterserver.TheBetterServerMod;

@EventBusSubscriber
public class TheBetterServerModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheBetterServerMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BAUBLES = REGISTRY.register("baubles",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.the_better_server.baubles")).icon(() -> new ItemStack(TheBetterServerModItems.CREEPER_REPELLENT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TheBetterServerModItems.CREEPER_REPELLENT.get());
				tabData.accept(TheBetterServerModItems.GREED_RELIC.get());
				tabData.accept(TheBetterServerModItems.HERMES_WINGS.get());
				tabData.accept(TheBetterServerModItems.WATER_STONE.get());
				tabData.accept(TheBetterServerModItems.DEATH_CONTRACT.get());
				tabData.accept(TheBetterServerModItems.OMINOUS_LANTERN.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TheBetterServerModItems.CREEPER_REPELLENT.get());
			tabData.accept(TheBetterServerModItems.ONYX_PICKAXE.get());
			tabData.accept(TheBetterServerModItems.ONYX_AXE.get());
			tabData.accept(TheBetterServerModItems.ONYX_SHOVEL.get());
			tabData.accept(TheBetterServerModItems.ONYX_HOE.get());
			tabData.accept(TheBetterServerModItems.RUBY_PICKAXE.get());
			tabData.accept(TheBetterServerModItems.RUBY_AXE.get());
			tabData.accept(TheBetterServerModItems.RUBY_SHOVEL.get());
			tabData.accept(TheBetterServerModItems.RUBY_HOE.get());
			tabData.accept(TheBetterServerModItems.BONE_PICKAXE.get());
			tabData.accept(TheBetterServerModItems.BONE_AXE.get());
			tabData.accept(TheBetterServerModItems.BONE_SHOVEL.get());
			tabData.accept(TheBetterServerModItems.BONE_HOE.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_PICKAXE.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_AXE.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_SHOVEL.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_HOE.get());
			tabData.accept(TheBetterServerModItems.GREED_RELIC.get());
			tabData.accept(TheBetterServerModItems.WATER_STONE.get());
			tabData.accept(TheBetterServerModItems.DEATH_CONTRACT.get());
			tabData.accept(TheBetterServerModItems.OMINOUS_LANTERN.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(TheBetterServerModBlocks.CREEPER_PATCHER.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(TheBetterServerModItems.ONYX.get());
			tabData.accept(TheBetterServerModItems.RUBY.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(TheBetterServerModBlocks.ONYX_ORE.get().asItem());
			tabData.accept(TheBetterServerModBlocks.ONYX_BLOCK.get().asItem());
			tabData.accept(TheBetterServerModBlocks.RUBY_ORE.get().asItem());
			tabData.accept(TheBetterServerModBlocks.RUBY_BLOCK.get().asItem());
			tabData.accept(TheBetterServerModBlocks.CALIDIUM_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(TheBetterServerModItems.ONYX_SWORD.get());
			tabData.accept(TheBetterServerModItems.ONYX_ARMOR_HELMET.get());
			tabData.accept(TheBetterServerModItems.ONYX_ARMOR_CHESTPLATE.get());
			tabData.accept(TheBetterServerModItems.ONYX_ARMOR_LEGGINGS.get());
			tabData.accept(TheBetterServerModItems.ONYX_ARMOR_BOOTS.get());
			tabData.accept(TheBetterServerModItems.RUBY_SWORD.get());
			tabData.accept(TheBetterServerModItems.RUBY_ARMOR_HELMET.get());
			tabData.accept(TheBetterServerModItems.RUBY_ARMOR_CHESTPLATE.get());
			tabData.accept(TheBetterServerModItems.RUBY_ARMOR_LEGGINGS.get());
			tabData.accept(TheBetterServerModItems.RUBY_ARMOR_BOOTS.get());
			tabData.accept(TheBetterServerModItems.BONE_SWORD.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_SWORD.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_ARMOR_HELMET.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_ARMOR_CHESTPLATE.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_ARMOR_LEGGINGS.get());
			tabData.accept(TheBetterServerModItems.CALIDIUM_ARMOR_BOOTS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(TheBetterServerModItems.EXPERIENCE_GUMMY.get());
			tabData.accept(TheBetterServerModItems.CHEWING_GUM.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(TheBetterServerModBlocks.CALIDIUM_ORE.get().asItem());
			tabData.accept(TheBetterServerModBlocks.BASALT_CALIDIUM_ORE.get().asItem());
		}
	}
}