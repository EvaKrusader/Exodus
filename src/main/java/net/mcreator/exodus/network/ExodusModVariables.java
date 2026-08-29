package net.mcreator.exodus.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.ProblemReporter;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.exodus.ExodusMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class ExodusModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ExodusMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ExodusMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		ExodusMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.howLongChewingGum = original.howLongChewingGum;
		clone.chewingGumLevel = original.chewingGumLevel;
		clone.showDevUI = original.showDevUI;
		clone.playerXPbeforeDeath = original.playerXPbeforeDeath;
		if (!event.isWasDeath()) {
			clone.phasing_overlay = original.phasing_overlay;
			clone.isGreedy = original.isGreedy;
			clone.greedLevel = original.greedLevel;
			clone.greedLeveler = original.greedLeveler;
			clone.goldAmount = original.goldAmount;
			clone.goldGoal = original.goldGoal;
			clone.fakeGoldLevel = original.fakeGoldLevel;
			clone.hasDeathContract = original.hasDeathContract;
			clone.playContractSound = original.playContractSound;
			clone.deathContractDied = original.deathContractDied;
			clone.latest_trial_level = original.latest_trial_level;
			clone.adrenalineDamage = original.adrenalineDamage;
			clone.healthBeforeAdrenaline = original.healthBeforeAdrenaline;
			clone.isChewingGum = original.isChewingGum;
			clone.chewingGumCounter = original.chewingGumCounter;
			clone.hasNetherCoalEnchant = original.hasNetherCoalEnchant;
			clone.lastFireDamage = original.lastFireDamage;
			clone.hasFireResCharm = original.hasFireResCharm;
			clone.hasFallDamageCharm = original.hasFallDamageCharm;
			clone.cancelFallDamageCharm = original.cancelFallDamageCharm;
			clone.hasXPCharm = original.hasXPCharm;
			clone.playerKnowledge = original.playerKnowledge;
			clone.crescent_chance = original.crescent_chance;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData mapdata = MapVariables.get(event.getEntity().level());
			SavedData worlddata = WorldVariables.get(event.getEntity().level());
			if (mapdata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData worlddata = WorldVariables.get(event.getEntity().level());
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final SavedDataType<WorldVariables> TYPE = new SavedDataType<>(Identifier.parse("exodus:worldvars"), level -> new WorldVariables(), level -> CompoundTag.CODEC.xmap(tag -> {
			WorldVariables instance = new WorldVariables();
			instance.read(tag, level.registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), level.registryAccess())));
		boolean _syncDirty = false;
		public double goldVal_gold_block = 0;
		public double goldVal_raw_gold_block = 0;
		public double goldVal_gold_ore = 0;
		public double goldVal_deepslate_gold_ore = 0;
		public double goldVal_nether_gold_ore = 0;
		public double goldVal_gilded_blackstone = 0;
		public double goldVal_golden_helmet = 0;
		public double goldVal_golden_chestplate = 0;
		public double goldVal_golden_leggings = 0;
		public double goldVal_golden_boots = 0;
		public double goldVal_golden_pickaxe = 0;
		public double goldVal_gold_rush_mult = 0;
		public double goldVal_gold_rush_add = 0;
		public double goldVal_greed_lvl_1 = 0;
		public double goldVal_greed_lvl_2 = 0;
		public double goldVal_greed_lvl_3 = 0;
		public double goldVal_greed_lvl_4 = 0;
		public double goldVal_greed_lvl_5 = 0;
		public double EnchVal_trial_breaker_damage = 0;
		public double EnchVal_vampirism_chance_1 = 0;
		public double EnchVal_vampirism_chance_2 = 0;
		public double EnchVal_vampirism_chance_3 = 0;
		public double EnchVal_vampirism_chance_4 = 0;
		public double EnchVal_vampirism_chance_5 = 0;
		public double EnchVal_vampirism_percentage_1 = 0.0;
		public double EnchVal_vampirism_percentage_2 = 0;
		public double EnchVal_vampirism_percentage_3 = 0;
		public double EnchVal_vampirism_percentage_4 = 0;
		public double EnchVal_vampirism_percentage_5 = 0;
		public double EnchVal_fluorite_necklace_cooldown = 0;
		public double EnchVal_fluorite_necklace_reduction = 0;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			goldVal_gold_block = nbt.getDoubleOr("goldVal_gold_block", 0);
			goldVal_raw_gold_block = nbt.getDoubleOr("goldVal_raw_gold_block", 0);
			goldVal_gold_ore = nbt.getDoubleOr("goldVal_gold_ore", 0);
			goldVal_deepslate_gold_ore = nbt.getDoubleOr("goldVal_deepslate_gold_ore", 0);
			goldVal_nether_gold_ore = nbt.getDoubleOr("goldVal_nether_gold_ore", 0);
			goldVal_gilded_blackstone = nbt.getDoubleOr("goldVal_gilded_blackstone", 0);
			goldVal_golden_helmet = nbt.getDoubleOr("goldVal_golden_helmet", 0);
			goldVal_golden_chestplate = nbt.getDoubleOr("goldVal_golden_chestplate", 0);
			goldVal_golden_leggings = nbt.getDoubleOr("goldVal_golden_leggings", 0);
			goldVal_golden_boots = nbt.getDoubleOr("goldVal_golden_boots", 0);
			goldVal_golden_pickaxe = nbt.getDoubleOr("goldVal_golden_pickaxe", 0);
			goldVal_gold_rush_mult = nbt.getDoubleOr("goldVal_gold_rush_mult", 0);
			goldVal_gold_rush_add = nbt.getDoubleOr("goldVal_gold_rush_add", 0);
			goldVal_greed_lvl_1 = nbt.getDoubleOr("goldVal_greed_lvl_1", 0);
			goldVal_greed_lvl_2 = nbt.getDoubleOr("goldVal_greed_lvl_2", 0);
			goldVal_greed_lvl_3 = nbt.getDoubleOr("goldVal_greed_lvl_3", 0);
			goldVal_greed_lvl_4 = nbt.getDoubleOr("goldVal_greed_lvl_4", 0);
			goldVal_greed_lvl_5 = nbt.getDoubleOr("goldVal_greed_lvl_5", 0);
			EnchVal_trial_breaker_damage = nbt.getDoubleOr("EnchVal_trial_breaker_damage", 0);
			EnchVal_vampirism_chance_1 = nbt.getDoubleOr("EnchVal_vampirism_chance_1", 0);
			EnchVal_vampirism_chance_2 = nbt.getDoubleOr("EnchVal_vampirism_chance_2", 0);
			EnchVal_vampirism_chance_3 = nbt.getDoubleOr("EnchVal_vampirism_chance_3", 0);
			EnchVal_vampirism_chance_4 = nbt.getDoubleOr("EnchVal_vampirism_chance_4", 0);
			EnchVal_vampirism_chance_5 = nbt.getDoubleOr("EnchVal_vampirism_chance_5", 0);
			EnchVal_vampirism_percentage_1 = nbt.getDoubleOr("EnchVal_vampirism_percentage_1", 0);
			EnchVal_vampirism_percentage_2 = nbt.getDoubleOr("EnchVal_vampirism_percentage_2", 0);
			EnchVal_vampirism_percentage_3 = nbt.getDoubleOr("EnchVal_vampirism_percentage_3", 0);
			EnchVal_vampirism_percentage_4 = nbt.getDoubleOr("EnchVal_vampirism_percentage_4", 0);
			EnchVal_vampirism_percentage_5 = nbt.getDoubleOr("EnchVal_vampirism_percentage_5", 0);
			EnchVal_fluorite_necklace_cooldown = nbt.getDoubleOr("EnchVal_fluorite_necklace_cooldown", 0);
			EnchVal_fluorite_necklace_reduction = nbt.getDoubleOr("EnchVal_fluorite_necklace_reduction", 0);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("goldVal_gold_block", goldVal_gold_block);
			nbt.putDouble("goldVal_raw_gold_block", goldVal_raw_gold_block);
			nbt.putDouble("goldVal_gold_ore", goldVal_gold_ore);
			nbt.putDouble("goldVal_deepslate_gold_ore", goldVal_deepslate_gold_ore);
			nbt.putDouble("goldVal_nether_gold_ore", goldVal_nether_gold_ore);
			nbt.putDouble("goldVal_gilded_blackstone", goldVal_gilded_blackstone);
			nbt.putDouble("goldVal_golden_helmet", goldVal_golden_helmet);
			nbt.putDouble("goldVal_golden_chestplate", goldVal_golden_chestplate);
			nbt.putDouble("goldVal_golden_leggings", goldVal_golden_leggings);
			nbt.putDouble("goldVal_golden_boots", goldVal_golden_boots);
			nbt.putDouble("goldVal_golden_pickaxe", goldVal_golden_pickaxe);
			nbt.putDouble("goldVal_gold_rush_mult", goldVal_gold_rush_mult);
			nbt.putDouble("goldVal_gold_rush_add", goldVal_gold_rush_add);
			nbt.putDouble("goldVal_greed_lvl_1", goldVal_greed_lvl_1);
			nbt.putDouble("goldVal_greed_lvl_2", goldVal_greed_lvl_2);
			nbt.putDouble("goldVal_greed_lvl_3", goldVal_greed_lvl_3);
			nbt.putDouble("goldVal_greed_lvl_4", goldVal_greed_lvl_4);
			nbt.putDouble("goldVal_greed_lvl_5", goldVal_greed_lvl_5);
			nbt.putDouble("EnchVal_trial_breaker_damage", EnchVal_trial_breaker_damage);
			nbt.putDouble("EnchVal_vampirism_chance_1", EnchVal_vampirism_chance_1);
			nbt.putDouble("EnchVal_vampirism_chance_2", EnchVal_vampirism_chance_2);
			nbt.putDouble("EnchVal_vampirism_chance_3", EnchVal_vampirism_chance_3);
			nbt.putDouble("EnchVal_vampirism_chance_4", EnchVal_vampirism_chance_4);
			nbt.putDouble("EnchVal_vampirism_chance_5", EnchVal_vampirism_chance_5);
			nbt.putDouble("EnchVal_vampirism_percentage_1", EnchVal_vampirism_percentage_1);
			nbt.putDouble("EnchVal_vampirism_percentage_2", EnchVal_vampirism_percentage_2);
			nbt.putDouble("EnchVal_vampirism_percentage_3", EnchVal_vampirism_percentage_3);
			nbt.putDouble("EnchVal_vampirism_percentage_4", EnchVal_vampirism_percentage_4);
			nbt.putDouble("EnchVal_vampirism_percentage_5", EnchVal_vampirism_percentage_5);
			nbt.putDouble("EnchVal_fluorite_necklace_cooldown", EnchVal_fluorite_necklace_cooldown);
			nbt.putDouble("EnchVal_fluorite_necklace_reduction", EnchVal_fluorite_necklace_reduction);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(WorldVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final SavedDataType<MapVariables> TYPE = new SavedDataType<>(Identifier.parse("exodus:mapvars"), level -> new MapVariables(), level -> CompoundTag.CODEC.xmap(tag -> {
			MapVariables instance = new MapVariables();
			instance.read(tag, level.registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), level.registryAccess())));
		boolean _syncDirty = false;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAccessor) {
				return serverLevelAccessor.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(MapVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(ExodusMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data instanceof MapVariables mapVariables)
				buffer.writeNbt(mapVariables.save(new CompoundTag(), buffer.registryAccess()));
			else if (message.data instanceof WorldVariables worldVariables)
				buffer.writeNbt(worldVariables.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(((MapVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(((WorldVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements ValueIOSerializable {
		boolean _syncDirty = false;
		public double phasing_overlay = 0;
		public boolean isGreedy = false;
		public double greedLevel = 0;
		public double greedLeveler = 0;
		public double goldAmount = 0;
		public double goldGoal = 20.0;
		public double fakeGoldLevel = 0;
		public boolean hasDeathContract = false;
		public boolean playContractSound = false;
		public boolean deathContractDied = false;
		public double latest_trial_level = 0;
		public double adrenalineDamage = 0;
		public double healthBeforeAdrenaline = 20.0;
		public boolean isChewingGum = false;
		public double howLongChewingGum = 0;
		public double chewingGumCounter = 0;
		public double chewingGumLevel = 0;
		public boolean hasNetherCoalEnchant = false;
		public double lastFireDamage = 0;
		public boolean hasFireResCharm = false;
		public boolean hasFallDamageCharm = false;
		public boolean cancelFallDamageCharm = false;
		public boolean hasXPCharm = false;
		public boolean showDevUI = true;
		public boolean playerKnowledge = false;
		public double playerXPbeforeDeath = 0;
		public double crescent_chance = 0;

		@Override
		public void serialize(ValueOutput output) {
			output.putDouble("phasing_overlay", phasing_overlay);
			output.putBoolean("isGreedy", isGreedy);
			output.putDouble("greedLevel", greedLevel);
			output.putDouble("greedLeveler", greedLeveler);
			output.putDouble("goldAmount", goldAmount);
			output.putDouble("goldGoal", goldGoal);
			output.putDouble("fakeGoldLevel", fakeGoldLevel);
			output.putBoolean("hasDeathContract", hasDeathContract);
			output.putBoolean("playContractSound", playContractSound);
			output.putBoolean("deathContractDied", deathContractDied);
			output.putDouble("latest_trial_level", latest_trial_level);
			output.putDouble("adrenalineDamage", adrenalineDamage);
			output.putDouble("healthBeforeAdrenaline", healthBeforeAdrenaline);
			output.putBoolean("isChewingGum", isChewingGum);
			output.putDouble("howLongChewingGum", howLongChewingGum);
			output.putDouble("chewingGumCounter", chewingGumCounter);
			output.putDouble("chewingGumLevel", chewingGumLevel);
			output.putBoolean("hasNetherCoalEnchant", hasNetherCoalEnchant);
			output.putDouble("lastFireDamage", lastFireDamage);
			output.putBoolean("hasFireResCharm", hasFireResCharm);
			output.putBoolean("hasFallDamageCharm", hasFallDamageCharm);
			output.putBoolean("cancelFallDamageCharm", cancelFallDamageCharm);
			output.putBoolean("hasXPCharm", hasXPCharm);
			output.putBoolean("showDevUI", showDevUI);
			output.putBoolean("playerKnowledge", playerKnowledge);
			output.putDouble("playerXPbeforeDeath", playerXPbeforeDeath);
			output.putDouble("crescent_chance", crescent_chance);
		}

		@Override
		public void deserialize(ValueInput input) {
			phasing_overlay = input.getDoubleOr("phasing_overlay", 0);
			isGreedy = input.getBooleanOr("isGreedy", false);
			greedLevel = input.getDoubleOr("greedLevel", 0);
			greedLeveler = input.getDoubleOr("greedLeveler", 0);
			goldAmount = input.getDoubleOr("goldAmount", 0);
			goldGoal = input.getDoubleOr("goldGoal", 0);
			fakeGoldLevel = input.getDoubleOr("fakeGoldLevel", 0);
			hasDeathContract = input.getBooleanOr("hasDeathContract", false);
			playContractSound = input.getBooleanOr("playContractSound", false);
			deathContractDied = input.getBooleanOr("deathContractDied", false);
			latest_trial_level = input.getDoubleOr("latest_trial_level", 0);
			adrenalineDamage = input.getDoubleOr("adrenalineDamage", 0);
			healthBeforeAdrenaline = input.getDoubleOr("healthBeforeAdrenaline", 0);
			isChewingGum = input.getBooleanOr("isChewingGum", false);
			howLongChewingGum = input.getDoubleOr("howLongChewingGum", 0);
			chewingGumCounter = input.getDoubleOr("chewingGumCounter", 0);
			chewingGumLevel = input.getDoubleOr("chewingGumLevel", 0);
			hasNetherCoalEnchant = input.getBooleanOr("hasNetherCoalEnchant", false);
			lastFireDamage = input.getDoubleOr("lastFireDamage", 0);
			hasFireResCharm = input.getBooleanOr("hasFireResCharm", false);
			hasFallDamageCharm = input.getBooleanOr("hasFallDamageCharm", false);
			cancelFallDamageCharm = input.getBooleanOr("cancelFallDamageCharm", false);
			hasXPCharm = input.getBooleanOr("hasXPCharm", false);
			showDevUI = input.getBooleanOr("showDevUI", false);
			playerKnowledge = input.getBooleanOr("playerKnowledge", false);
			playerXPbeforeDeath = input.getDoubleOr("playerXPbeforeDeath", 0);
			crescent_chance = input.getDoubleOr("crescent_chance", 0);
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int player) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(ExodusMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, buffer.registryAccess());
			message.data.serialize(output);
			buffer.writeInt(message.player());
			buffer.writeNbt(output.buildResult());
		}, (RegistryFriendlyByteBuf buffer) -> {
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserialize(TagValueInput.create(ProblemReporter.DISCARDING, buffer.registryAccess(), buffer.readNbt()));
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					Entity player = context.player().level().getEntity(message.player);
					if (player == null)
						return;
					TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, context.player().registryAccess());
					message.data.serialize(output);
					player.getData(PLAYER_VARIABLES).deserialize(TagValueInput.create(ProblemReporter.DISCARDING, context.player().registryAccess(), output.buildResult()));
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}