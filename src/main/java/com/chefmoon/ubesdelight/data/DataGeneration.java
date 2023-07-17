package com.chefmoon.ubesdelight.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.loot.context.LootContextTypes;

public class DataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TranslationGenerator::new);
        pack.addProvider(RecipeGenerator::new);
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(LootTableGenerator::new);

        //pack.addProvider(new LootTableGenerator(fabricDataGenerator, LootContextTypes.BLOCK));



    }
}
