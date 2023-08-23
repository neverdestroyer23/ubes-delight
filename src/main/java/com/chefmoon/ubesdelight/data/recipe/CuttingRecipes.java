package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class CuttingRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {
        RecipeUtil.offerCuttingRecipe(ItemsRegistry.WILD_GARLIC, ItemsRegistry.GARLIC, 1, null, exporter);
        RecipeUtil.offerCuttingRecipe(ItemsRegistry.WILD_GINGER, ItemsRegistry.GINGER, 1, null, exporter);
        RecipeUtil.offerCuttingRecipe(ItemsRegistry.WILD_LEMONGRASS, ItemsRegistry.LEMONGRASS, 1, null, exporter);
        RecipeUtil.offerCuttingRecipe(ItemsRegistry.WILD_UBE, ItemsRegistry.UBE, 1, null, exporter);

        RecipeUtil.offerCuttingRecipe(ItemsRegistry.HALO_HALO, ItemsRegistry.HALO_HALO_FEAST, 4, null, exporter);
        RecipeUtil.offerCuttingRecipe(ItemsRegistry.LECHE_FLAN, ItemsRegistry.LECHE_FLAN_FEAST, 5, null, exporter);
        RecipeUtil.offerCuttingRecipe(ItemsRegistry.UBE_CAKE_SLICE, ItemsRegistry.UBE_CAKE, 7, null, exporter);
    }
}
