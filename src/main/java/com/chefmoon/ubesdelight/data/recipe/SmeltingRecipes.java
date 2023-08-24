package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class SmeltingRecipes {
    public static void register(Consumer<RecipeJsonProvider> exporter) {
        RecipeUtil.offerSmeltCampSmokeRecipe(Items.SUGAR, ItemsRegistry.SUGAR_BROWN.get(), .5f, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeFromTag(CommonTags.C_MILK_MILK_BOTTLE, ItemsRegistry.MILK_POWDER.get(), .2f, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.RAW_POLVORONE.get(), ItemsRegistry.POLVORONE.get(), .3F, 100, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), ItemsRegistry.POLVORONE_PINIPIG.get(), .3F, 100, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.RAW_POLVORONE_UBE.get(), ItemsRegistry.POLVORONE_UBE.get(), .3F, 100, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.RAW_POLVORONE_CC.get(), ItemsRegistry.POLVORONE_CC.get(), .3F, 100, exporter);
    }
}
