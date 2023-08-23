package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.data.builder.CookingPotRecipeJsonBuilder;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class CookingRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {
        //TODO: V0.1.5
        CookingPotRecipeJsonBuilder.create(RecipeCategory.MISC,
                CookingRecipeCategory.MISC,
                ItemsRegistry.SUGAR_BROWN.get(),
                List.of(Ingredient.ofItems(Items.SUGAR)),
                0.3F, 200)
                .offerTo(exporter, "brown_sugar_test");
    }
}
