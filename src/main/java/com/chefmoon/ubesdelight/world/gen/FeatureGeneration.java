package com.chefmoon.ubesdelight.world.gen;

import com.chefmoon.ubesdelight.world.feature.FeatureList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import java.util.Collection;
import java.util.List;

public class FeatureGeneration {

    public static Collection<RegistryKey<Biome>> BIOMES = List.of(new RegistryKey[]{BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.SNOWY_PLAINS});

    public static void generateAll() {
        generatePlantCategory(BIOMES, FeatureList.WILD_UBE_PLACED.getKey().get());
        generatePlantCategory(BIOMES, FeatureList.WILD_GARLIC_PLACED.getKey().get());
        generatePlantCategory(BIOMES, FeatureList.WILD_GINGER_PLACED.getKey().get());
        generatePlantCategory(BIOMES, FeatureList.WILD_LEMONGRASS_PLACED.getKey().get());
    }

    private static void generatePlantCategory(Collection<RegistryKey<Biome>> biome, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature((context) ->
                        BiomeSelectors.includeByKey(biome).test(context),
                GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }
}
