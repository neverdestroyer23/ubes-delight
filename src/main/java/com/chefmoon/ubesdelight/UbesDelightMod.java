package com.chefmoon.ubesdelight;


import com.chefmoon.ubesdelight.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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

    public static final Logger LOGGER = LoggerFactory.getLogger("Ube's Delight");
    public static final String MOD_ID = "ubesdelight";
    public static Configuration CONFIG = new Configuration();
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "group"));
    public static Collection<RegistryKey<Biome>> PLAINS_BIOMES = List.of(new RegistryKey[]{BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS});
    public static Collection<RegistryKey<Biome>> JUNGLE_BIOMES = List.of(new RegistryKey[]{BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE});

    public static MutableText tooltip(String key, Object... args) {
        return Text.translatable(MOD_ID + "." + key, args);
    }

    @Override
    public void onInitialize() {

        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.ubesdelight.group"))
                .icon(() -> new ItemStack(ItemsRegistry.UBE.get()))
                .build());
        initConfiguration();

        ItemsRegistry.registerAll();
        BlocksRegistry.registerAll();

        ConfiguredFeaturesRegistry.registerAll();
        PlacementModifiersRegistry.registerAll();
        BiomeFeaturesRegistry.registerAll();

        registerCompostables();
        registerLootTable();
        registerBiomeModifications();
        registerVillagerTradeOffer();
    }

    private void initConfiguration() {
        CONFIG = Configuration.load();

        //TODO: Fix JSONDataLoader?
        ResourceConditions.register(new Identifier(MOD_ID, "ud_crates_enabled"),
                jsonObject -> UbesDelightMod.CONFIG.isEnableUDCropCrates());
    }

    private void registerCompostables() {

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LEMONGRASS_SEEDS.get(), .3f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GARLIC_CLOVES.get(), .4f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LUMPIA_WRAPPER.get(), .4f);

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
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(JUNGLE_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_UBE.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildGarlic()) {
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(PLAINS_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_GARLIC.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildGinger()) {
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(PLAINS_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_GINGER.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildLemongrass()) {
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(JUNGLE_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_LEMONGRASS.key());
        }
    }

    private void registerVillagerTradeOffer() {
        //Farmer Villagers
        if (UbesDelightMod.CONFIG.isFarmersBuyUDCrops()) {
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.UBE.get(), 26),
                                16, 2, 0.05f
                        )));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GARLIC.get(), 26),
                                16, 2, 0.05f
                        )));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GINGER.get(), 26),
                                16, 2, 0.05f
                        )));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,2,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.LEMONGRASS.get(), 20),
                                16, 5, 0.05f
                        )));
                    });
        }

        //Wandering Traders
        if (UbesDelightMod.CONFIG.isWanderingTraderSellsUDItems()) {
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.UBE.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GARLIC.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GINGER.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.LEMONGRASS_SEEDS.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
        }
    }
}
