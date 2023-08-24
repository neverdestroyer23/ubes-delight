package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.data.recipe.CraftingRecipes;
import com.chefmoon.ubesdelight.data.recipe.SmeltingRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        CraftingRecipes.register(exporter);
        SmeltingRecipes.register(exporter);
    }
}
