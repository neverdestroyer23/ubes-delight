package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.world.configuration.WildCropConfiguration;
import com.chefmoon.ubesdelight.world.feature.WildCropFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import java.util.function.Supplier;

public enum BiomeFeaturesRegistry {
    WILD_CROP("wild_crop", () -> new WildCropFeature(WildCropConfiguration.CODEC));
    private final String pathName;
    private final Supplier<Feature<? extends FeatureConfig>> featureSupplier;
    private Feature<? extends FeatureConfig> feature;
    BiomeFeaturesRegistry(String pathName, Supplier<Feature<? extends FeatureConfig>> featureSupplier) {
        this.pathName = pathName;
        this.featureSupplier = featureSupplier;
    }
    public static void registerAll() {
        for (BiomeFeaturesRegistry value : values()) {
            Registry.register(Registry.FEATURE, new Identifier(UbesDelightMod.MOD_ID, value.pathName), value.featureSupplier.get());
        }
    }
    public Feature<? extends FeatureConfig> get() {
        if (feature == null) {
            feature = featureSupplier.get();
        }
        return feature;
    }
}