package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public enum ConfiguredFeaturesRegistry {
    PATCH_WILD_UBE("patch_wild_ube"),
    PATCH_WILD_GARLIC("patch_wild_garlic"),
    PATCH_WILD_GINGER("patch_wild_ginger"),
    PATCH_WILD_LEMONGRASS("patch_wild_lemongrass");
    private final Identifier featureIdentifier;
    private RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureRegistryKey;
    private RegistryKey<PlacedFeature> featureRegistryKey;
    ConfiguredFeaturesRegistry(String featurePathName) {
        this.featureIdentifier = new Identifier(UbesDelightMod.MOD_ID, featurePathName);
    }
    public static void registerAll() {
        for (ConfiguredFeaturesRegistry value : values()) {
            value.configuredFeatureRegistryKey = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, value.featureIdentifier);
            value.featureRegistryKey = RegistryKey.of(Registry.PLACED_FEATURE_KEY, value.featureIdentifier);
        }
    }
    public RegistryKey<ConfiguredFeature<? extends FeatureConfig, ?>> configKey() {
        return configuredFeatureRegistryKey;
    }
    public RegistryKey<PlacedFeature> key() {
        return featureRegistryKey;
    }
    public Identifier identifier() {
        return featureIdentifier;
    }
}