package com.chefmoon.ubesdelight.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.loot.context.LootContextTypes;

public class DataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        fabricDataGenerator.addProvider(RecipeGenerator::new);
        fabricDataGenerator.addProvider(ModelGenerator::new);
        fabricDataGenerator.addProvider(TranslationGenerator::new);
        fabricDataGenerator.addProvider(new LootTableGenerator(fabricDataGenerator, LootContextTypes.BLOCK));
        //fabricDataGenerator.addProvider(LootTableGenerator::new);
    }
}
