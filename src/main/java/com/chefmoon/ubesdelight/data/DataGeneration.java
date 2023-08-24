package com.chefmoon.ubesdelight.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        fabricDataGenerator.addProvider(RecipeGenerator::new);
        fabricDataGenerator.addProvider(ModelGenerator::new);
        fabricDataGenerator.addProvider(TranslationGenerator::new);
        fabricDataGenerator.addProvider(LootTableGenerator::new);
        fabricDataGenerator.addProvider(BlockTagGenerator::new);
        fabricDataGenerator.addProvider(ItemTagGenerator::new);
    }
}
