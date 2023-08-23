package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.data.recipe.CraftingRecipes;
import com.chefmoon.ubesdelight.data.recipe.SmeltingRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //CookingRecipes.register(exporter);
        //CuttingRecipes.register(exporter);
        CraftingRecipes.register(exporter);
        SmeltingRecipes.register(exporter);
    }




}
