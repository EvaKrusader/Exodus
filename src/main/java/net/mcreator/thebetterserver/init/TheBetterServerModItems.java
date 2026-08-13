/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thebetterserver.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.Identifier;

import net.mcreator.thebetterserver.item.*;
import net.mcreator.thebetterserver.TheBetterServerMod;

import java.util.function.Function;

public class TheBetterServerModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TheBetterServerMod.MODID);
	public static final DeferredItem<Item> CREEPER_REPELLENT;
	public static final DeferredItem<Item> CREEPER_PATCHER;
	public static final DeferredItem<Item> ONYX;
	public static final DeferredItem<Item> ONYX_ORE;
	public static final DeferredItem<Item> ONYX_BLOCK;
	public static final DeferredItem<Item> ONYX_PICKAXE;
	public static final DeferredItem<Item> ONYX_AXE;
	public static final DeferredItem<Item> ONYX_SWORD;
	public static final DeferredItem<Item> ONYX_SHOVEL;
	public static final DeferredItem<Item> ONYX_HOE;
	public static final DeferredItem<Item> ONYX_ARMOR_HELMET;
	public static final DeferredItem<Item> ONYX_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> ONYX_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> ONYX_ARMOR_BOOTS;
	public static final DeferredItem<Item> RUBY;
	public static final DeferredItem<Item> RUBY_ORE;
	public static final DeferredItem<Item> RUBY_BLOCK;
	public static final DeferredItem<Item> RUBY_PICKAXE;
	public static final DeferredItem<Item> RUBY_AXE;
	public static final DeferredItem<Item> RUBY_SWORD;
	public static final DeferredItem<Item> RUBY_SHOVEL;
	public static final DeferredItem<Item> RUBY_HOE;
	public static final DeferredItem<Item> RUBY_ARMOR_HELMET;
	public static final DeferredItem<Item> RUBY_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> RUBY_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> RUBY_ARMOR_BOOTS;
	public static final DeferredItem<Item> BONE_PICKAXE;
	public static final DeferredItem<Item> BONE_AXE;
	public static final DeferredItem<Item> BONE_SWORD;
	public static final DeferredItem<Item> BONE_SHOVEL;
	public static final DeferredItem<Item> BONE_HOE;
	public static final DeferredItem<Item> EXPERIENCE_GUMMY;
	public static final DeferredItem<Item> CALIDIUM;
	public static final DeferredItem<Item> CALIDIUM_ORE;
	public static final DeferredItem<Item> CALIDIUM_BLOCK;
	public static final DeferredItem<Item> CALIDIUM_PICKAXE;
	public static final DeferredItem<Item> CALIDIUM_AXE;
	public static final DeferredItem<Item> CALIDIUM_SWORD;
	public static final DeferredItem<Item> CALIDIUM_SHOVEL;
	public static final DeferredItem<Item> CALIDIUM_HOE;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_HELMET;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> CALIDIUM_ARMOR_BOOTS;
	public static final DeferredItem<Item> SCALDING_CALIDIUM;
	public static final DeferredItem<Item> BASALT_CALIDIUM_ORE;
	public static final DeferredItem<Item> GREED_RELIC;
	public static final DeferredItem<Item> HERMES_WINGS;
	public static final DeferredItem<Item> WATER_STONE;
	public static final DeferredItem<Item> DEATH_CONTRACT;
	public static final DeferredItem<Item> OMINOUS_LANTERN;
	public static final DeferredItem<Item> CHEWING_GUM;
	static {
		CREEPER_REPELLENT = register("creeper_repellent", CreeperRepellentItem::new);
		CREEPER_PATCHER = block(TheBetterServerModBlocks.CREEPER_PATCHER);
		ONYX = register("onyx", OnyxItem::new);
		ONYX_ORE = block(TheBetterServerModBlocks.ONYX_ORE);
		ONYX_BLOCK = block(TheBetterServerModBlocks.ONYX_BLOCK);
		ONYX_PICKAXE = register("onyx_pickaxe", OnyxPickaxeItem::new);
		ONYX_AXE = register("onyx_axe", OnyxAxeItem::new);
		ONYX_SWORD = register("onyx_sword", OnyxSwordItem::new);
		ONYX_SHOVEL = register("onyx_shovel", OnyxShovelItem::new);
		ONYX_HOE = register("onyx_hoe", OnyxHoeItem::new);
		ONYX_ARMOR_HELMET = register("onyx_armor_helmet", OnyxArmorItem.Helmet::new);
		ONYX_ARMOR_CHESTPLATE = register("onyx_armor_chestplate", OnyxArmorItem.Chestplate::new);
		ONYX_ARMOR_LEGGINGS = register("onyx_armor_leggings", OnyxArmorItem.Leggings::new);
		ONYX_ARMOR_BOOTS = register("onyx_armor_boots", OnyxArmorItem.Boots::new);
		RUBY = register("ruby", RubyItem::new);
		RUBY_ORE = block(TheBetterServerModBlocks.RUBY_ORE);
		RUBY_BLOCK = block(TheBetterServerModBlocks.RUBY_BLOCK);
		RUBY_PICKAXE = register("ruby_pickaxe", RubyPickaxeItem::new);
		RUBY_AXE = register("ruby_axe", RubyAxeItem::new);
		RUBY_SWORD = register("ruby_sword", RubySwordItem::new);
		RUBY_SHOVEL = register("ruby_shovel", RubyShovelItem::new);
		RUBY_HOE = register("ruby_hoe", RubyHoeItem::new);
		RUBY_ARMOR_HELMET = register("ruby_armor_helmet", RubyArmorItem.Helmet::new);
		RUBY_ARMOR_CHESTPLATE = register("ruby_armor_chestplate", RubyArmorItem.Chestplate::new);
		RUBY_ARMOR_LEGGINGS = register("ruby_armor_leggings", RubyArmorItem.Leggings::new);
		RUBY_ARMOR_BOOTS = register("ruby_armor_boots", RubyArmorItem.Boots::new);
		BONE_PICKAXE = register("bone_pickaxe", BonePickaxeItem::new);
		BONE_AXE = register("bone_axe", BoneAxeItem::new);
		BONE_SWORD = register("bone_sword", BoneSwordItem::new);
		BONE_SHOVEL = register("bone_shovel", BoneShovelItem::new);
		BONE_HOE = register("bone_hoe", BoneHoeItem::new);
		EXPERIENCE_GUMMY = register("experience_gummy", ExperienceGummyItem::new);
		CALIDIUM = register("calidium", CalidiumItem::new);
		CALIDIUM_ORE = block(TheBetterServerModBlocks.CALIDIUM_ORE);
		CALIDIUM_BLOCK = block(TheBetterServerModBlocks.CALIDIUM_BLOCK);
		CALIDIUM_PICKAXE = register("calidium_pickaxe", CalidiumPickaxeItem::new);
		CALIDIUM_AXE = register("calidium_axe", CalidiumAxeItem::new);
		CALIDIUM_SWORD = register("calidium_sword", CalidiumSwordItem::new);
		CALIDIUM_SHOVEL = register("calidium_shovel", CalidiumShovelItem::new);
		CALIDIUM_HOE = register("calidium_hoe", CalidiumHoeItem::new);
		CALIDIUM_ARMOR_HELMET = register("calidium_armor_helmet", CalidiumArmorItem.Helmet::new);
		CALIDIUM_ARMOR_CHESTPLATE = register("calidium_armor_chestplate", CalidiumArmorItem.Chestplate::new);
		CALIDIUM_ARMOR_LEGGINGS = register("calidium_armor_leggings", CalidiumArmorItem.Leggings::new);
		CALIDIUM_ARMOR_BOOTS = register("calidium_armor_boots", CalidiumArmorItem.Boots::new);
		SCALDING_CALIDIUM = register("scalding_calidium", ScaldingCalidiumItem::new);
		BASALT_CALIDIUM_ORE = block(TheBetterServerModBlocks.BASALT_CALIDIUM_ORE);
		GREED_RELIC = register("greed_relic", GreedRelicItem::new);
		HERMES_WINGS = register("hermes_wings", HermesWingsItem::new);
		WATER_STONE = register("water_stone", WaterStoneItem::new);
		DEATH_CONTRACT = register("death_contract", DeathContractItem::new);
		OMINOUS_LANTERN = register("ominous_lantern", OminousLanternItem::new);
		CHEWING_GUM = register("chewing_gum", ChewingGumItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), () -> properties);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		public static void registerItemModelProperties(RegisterRangeSelectItemModelPropertyEvent event) {
			event.register(Identifier.parse("the_better_server:creeper_repellent/has_biolum"), CreeperRepellentItem.HasBiolumProperty.MAP_CODEC);
			event.register(Identifier.parse("the_better_server:creeper_repellent/range_level"), CreeperRepellentItem.RangeLevelProperty.MAP_CODEC);
			event.register(Identifier.parse("the_better_server:greed_relic/greed_level"), GreedRelicItem.GreedLevelProperty.MAP_CODEC);
			event.register(Identifier.parse("the_better_server:death_contract/is_signed"), DeathContractItem.IsSignedProperty.MAP_CODEC);
			event.register(Identifier.parse("the_better_server:ominous_lantern/ominous_level"), OminousLanternItem.OminousLevelProperty.MAP_CODEC);
		}
	}
}