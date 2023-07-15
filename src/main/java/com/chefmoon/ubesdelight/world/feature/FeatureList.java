package com.chefmoon.ubesdelight.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;

public class FeatureList {

    //Configured features
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WILD_UBE;
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WILD_GARLIC;
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WILD_GINGER;
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WILD_LEMONGRASS;

    //Placed features
    public static RegistryEntry<PlacedFeature> WILD_UBE_PLACED;
    public static RegistryEntry<PlacedFeature> WILD_GARLIC_PLACED;
    public static RegistryEntry<PlacedFeature> WILD_GINGER_PLACED;
    public static RegistryEntry<PlacedFeature> WILD_LEMONGRASS_PLACED;
}
