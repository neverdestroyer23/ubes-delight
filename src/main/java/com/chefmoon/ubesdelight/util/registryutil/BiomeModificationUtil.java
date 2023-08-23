package com.chefmoon.ubesdelight.util.registryutil;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ConfiguredFeaturesRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("unchecked")
public class BiomeModificationUtil {

    public static Collection<RegistryKey<Biome>> JUNGLE_BIOMES = List.of(new RegistryKey[]{BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE});

    public static void register() {
        registerBiomeModifications();
    }

    private static void registerBiomeModifications() {
        if (UbesDelightMod.CONFIG.isGenerateWildUbe()) {
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(JUNGLE_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_UBE.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildGarlic()) {
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(JUNGLE_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_GARLIC.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildGinger()) {
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(JUNGLE_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_GINGER.key());
        }

        if (UbesDelightMod.CONFIG.isGenerateWildLemongrass()) {
            BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(JUNGLE_BIOMES).test(context),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ConfiguredFeaturesRegistry.PATCH_WILD_LEMONGRASS.key());
        }
    }
}
