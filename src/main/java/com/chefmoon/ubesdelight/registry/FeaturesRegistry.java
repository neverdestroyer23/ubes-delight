package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.world.feature.FeatureList;
import net.minecraft.block.Block;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class FeaturesRegistry {

    public static void registerAll() {
        FeatureList.PATCH_WILD_UBE = featurePatch("wild_ube_feature", BlocksRegistry.WILD_UBE.get());
        FeatureList.PATCH_WILD_GARLIC = featurePatch("wild_garlic_feature", BlocksRegistry.WILD_GARLIC.get());
        FeatureList.PATCH_WILD_GINGER = featurePatch("wild_ginger_feature", BlocksRegistry.WILD_GINGER.get());
        FeatureList.PATCH_WILD_LEMONGRASS = featurePatch("wild_lemongrass_feature", BlocksRegistry.WILD_LEMONGRASS.get());

        if (UbesDelightMod.CONFIG.isGenerateWildUbe()) {
            FeatureList.WILD_UBE_PLACED = placedPatch("wild_ube_placed", FeatureList.PATCH_WILD_UBE, UbesDelightMod.CONFIG.getChanceWildUbe());
        }
        if (UbesDelightMod.CONFIG.isGenerateWildGarlic()) {
            FeatureList.WILD_GARLIC_PLACED = placedPatch("wild_garlic_placed", FeatureList.PATCH_WILD_GARLIC, UbesDelightMod.CONFIG.getChanceWildGarlic());
        }
        if (UbesDelightMod.CONFIG.isGenerateWildGinger()) {
            FeatureList.WILD_GINGER_PLACED = placedPatch("wild_ginger_placed", FeatureList.PATCH_WILD_GINGER, UbesDelightMod.CONFIG.getChanceWildGinger());
        }
        if (UbesDelightMod.CONFIG.isGenerateWildLemongrass()) {
            FeatureList.WILD_LEMONGRASS_PLACED = placedPatch("wild_lemongrass_placed", FeatureList.PATCH_WILD_LEMONGRASS, UbesDelightMod.CONFIG.getChanceWildLemongrass());
        }
    }

    private static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> featurePatch(String name, Block block) {
        return ConfiguredFeatures.register(name, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(64, 2, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(block)))));
    }

    private static RegistryEntry<PlacedFeature> placedPatch(String name, RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> configuredFeature, int chanceWild) {
        return PlacedFeatures.register(name, configuredFeature, RarityFilterPlacementModifier.of(chanceWild), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }
}
