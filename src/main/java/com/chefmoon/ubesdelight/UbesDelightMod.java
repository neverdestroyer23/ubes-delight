package com.chefmoon.ubesdelight;

import com.chefmoon.ubesdelight.registry.*;
import com.chefmoon.ubesdelight.util.GeneralRegistryUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UbesDelightMod implements ModInitializer {
    public static final String MOD_ID = "ubesdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Configuration CONFIG = new Configuration();
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID),
            () -> new ItemStack(ItemsRegistry.UBE.get()));

    public static Collection<RegistryKey<Biome>> PLAINS_BIOMES = List.of(new RegistryKey[]{BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS});
    public static Collection<RegistryKey<Biome>> JUNGLE_BIOMES = List.of(new RegistryKey[]{BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE});

    public static MutableText tooltip(String key, Object... args) {
        return Text.translatable(MOD_ID + "." + key, args);
    }

    @Override
    public void onInitialize() {
        initConfiguration();

        ItemsRegistry.registerAll();
        BlocksRegistry.registerAll();
        ConfiguredFeaturesRegistry.registerAll();
        PlacementModifiersRegistry.registerAll();
        BiomeFeaturesRegistry.registerAll();
        GeneralRegistryUtil.register();
    }

    private void initConfiguration() {
        CONFIG = Configuration.load();

        ResourceConditions.register(new Identifier(MOD_ID, "ud_crates_enabled"),
                jsonObject -> UbesDelightMod.CONFIG.isEnableUDCropCrates());

        ResourceConditions.register(new Identifier(MOD_ID, "garlic_compat"),
                jsonObject -> UbesDelightMod.CONFIG.isEnableGarlicCompat());

        ResourceConditions.register(new Identifier(MOD_ID, "ginger_compat"),
                jsonObject -> UbesDelightMod.CONFIG.isEnableGingerCompat());
    }
}