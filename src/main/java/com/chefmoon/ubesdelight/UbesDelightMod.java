package com.chefmoon.ubesdelight;

import com.chefmoon.ubesdelight.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;

import java.util.Set;

public class UbesDelightMod implements ModInitializer {

    public static final String MOD_ID = "ubesdelight";
    public static Configuration CONFIG = new Configuration();
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"),
            () -> new ItemStack(ItemsRegistry.UBE.get()));

    @Override
    public void onInitialize() {

        initConfiguration();

        ItemsRegistry.registerAll();
        BlocksRegistry.registerAll();
        ConfiguredFeaturesRegistry.registerAll();
        PlacementModifiersRegistry.registerAll();
        BiomeFeaturesRegistry.registerAll();

        registerCompostables();
        registerLootTable();

        registerBiomeModifications();

        //registerVillagerTradeOffer()
    }

    private void initConfiguration() {
        CONFIG = Configuration.load();
    }

    private void registerCompostables() {

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LEMONGRASS_SEEDS.get(), .3f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GARLIC_CLOVES.get(), .4f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_UBE.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_GARLIC.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_GINGER.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_LEMONGRASS.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.UBE.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GARLIC.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GINGER.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LEMONGRASS.get(), .65f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.COOKIE_UBE.get(), .85f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.COOKIE_GINGER.get(), .85f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LECHE_FLAN.get(), 1.f);

    }
    private void registerLootTable() {
        Set<Identifier> chestsId = Set.of(
                LootTables.VILLAGE_PLAINS_CHEST
        );

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            Identifier injectId = new Identifier(UbesDelightMod.MOD_ID, "inject/" + id.getPath());

            if (chestsId.contains(id) && UbesDelightMod.CONFIG.isGenerateUDChestLoot()) {
                tableBuilder.pool(LootPool.builder().with(LootTableEntry.builder(injectId).weight(1).quality(0)).build());
            }
        });
    }

    private void registerBiomeModifications() {
        if (UbesDelightMod.CONFIG.isGenerateWildUbe()) {
            BiomeModifications.addFeature(context -> context.getBiome().getTemperature() > .3f && context.getBiome().getTemperature() < 1.f,
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_UBE.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildGarlic()) {
            BiomeModifications.addFeature(context -> context.getBiome().getTemperature() > .3f && context.getBiome().getTemperature() < 1.f,
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_GARLIC.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildGinger()) {
            BiomeModifications.addFeature(context -> context.getBiome().getTemperature() > .3f && context.getBiome().getTemperature() < 1.f,
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_GINGER.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildLemongrass()) {
            BiomeModifications.addFeature(context -> context.getBiome().getTemperature() > .3f && context.getBiome().getTemperature() < 1.f,
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_LEMONGRASS.key());
        }
    }
    private void registerVillagerTradeOffer() {
        if (UbesDelightMod.CONFIG.isFarmersBuyUDCrops()) {
            //TODO: register trade offers
        }
    }
}
