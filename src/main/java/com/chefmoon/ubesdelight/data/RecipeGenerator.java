package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;


import java.util.List;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerSmeltCampSmokeRecipe(ItemsRegistry.SUGAR_BROWN.getId(), Items.SUGAR, RecipeCategory.FOOD, ItemsRegistry.SUGAR_BROWN.get(), .5f, 200, exporter);

        offerSmeltCampSmokeRecipe(ItemsRegistry.POLVORONE.getId(), ItemsRegistry.RAW_POLVORONE.get(), RecipeCategory.FOOD, ItemsRegistry.POLVORONE.get(), .3F, 100, exporter);
        offerSmeltCampSmokeRecipe(ItemsRegistry.POLVORONE_PINIPIG.getId(), ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), RecipeCategory.FOOD, ItemsRegistry.POLVORONE_PINIPIG.get(), .3F, 100, exporter);
        offerSmeltCampSmokeRecipe(ItemsRegistry.POLVORONE_UBE.getId(), ItemsRegistry.RAW_POLVORONE_UBE.get(), RecipeCategory.FOOD, ItemsRegistry.POLVORONE_UBE.get(), .3F, 100, exporter);
        offerSmeltCampSmokeRecipe(ItemsRegistry.POLVORONE_CC.getId(), ItemsRegistry.RAW_POLVORONE_CC.get(), RecipeCategory.FOOD, ItemsRegistry.POLVORONE_CC.get(), .3F, 100, exporter);

        //Crate to Vegetable
        offerShapelessRecipe(exporter, ItemsRegistry.UBE.get(), ItemsRegistry.UBE_CRATE.get(), UbesDelightMod.ITEM_GROUP.getValue().toString(), 9);
        offerShapelessRecipe(exporter, ItemsRegistry.GARLIC.get(), ItemsRegistry.GARLIC_CRATE.get(), UbesDelightMod.ITEM_GROUP.getValue().toString(), 9);
        offerShapelessRecipe(exporter, ItemsRegistry.GINGER.get(), ItemsRegistry.GINGER_CRATE.get(), UbesDelightMod.ITEM_GROUP.getValue().toString(), 9);
        offerShapelessRecipe(exporter, ItemsRegistry.LEMONGRASS.get(), ItemsRegistry.LEMONGRASS_CRATE.get(), UbesDelightMod.ITEM_GROUP.getValue().toString(), 9);

        //Vegetable to Crate
        /* Moved to Manual *//*
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemsRegistry.UBE_CRATE.get(), 1)
                .input(ItemsRegistry.UBE.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.UBE_CRATE.get())));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemsRegistry.GARLIC_CRATE.get(), 1)
                .input(ItemsRegistry.GARLIC.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GARLIC_CRATE.get())));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemsRegistry.GINGER_CRATE.get(), 1)
                .input(ItemsRegistry.GINGER.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GINGER.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GINGER.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GINGER_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GINGER_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GINGER_CRATE.get())));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemsRegistry.LEMONGRASS_CRATE.get(), 1)
                .input(ItemsRegistry.LEMONGRASS.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LEMONGRASS.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LEMONGRASS.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LEMONGRASS_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LEMONGRASS_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.LEMONGRASS_CRATE.get())));
        */

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.LEMONGRASS_SEEDS.get(), 1)
                .input(ItemsRegistry.LEMONGRASS.get())
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LEMONGRASS_SEEDS.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LEMONGRASS_SEEDS.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LEMONGRASS.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LEMONGRASS.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.LEMONGRASS_SEEDS.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.LEMONGRASS.get()));

        //Partial to full Vegetables
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.GARLIC.get(), 1)
                .input(ItemsRegistry.GARLIC_CHOP.get(), 2)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC_CHOP.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC_CHOP.get()))
                .group(UbesDelightMod.ITEM_GROUP.getValue().toString())
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GARLIC.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.GARLIC_CHOP.get()));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.GINGER.get(), 1)
                .input(ItemsRegistry.GINGER_CHOP.get(), 2)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GINGER.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GINGER.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GINGER_CHOP.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GINGER_CHOP.get()))
                .group(UbesDelightMod.ITEM_GROUP.getValue().toString())
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GINGER.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.GINGER_CHOP.get()));

        //Cake Slices to Cake
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.UBE_CAKE.get(), 1)
                .input(ItemsRegistry.UBE_CAKE_SLICE.get(), 7)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE_CAKE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE_CAKE.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE_CAKE_SLICE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE_CAKE_SLICE.get()))
                .group(UbesDelightMod.ITEM_GROUP.getValue().toString())
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.UBE_CAKE.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.UBE_CAKE_SLICE.get()));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.LECHE_FLAN_FEAST.get(), 1)
                .input(ItemsRegistry.LECHE_FLAN.get(), 5)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LECHE_FLAN_FEAST.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LECHE_FLAN_FEAST.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LECHE_FLAN.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LECHE_FLAN.get()))
                .group(UbesDelightMod.MOD_ID)
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.LECHE_FLAN_FEAST.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.LECHE_FLAN.get()));
    }

    private static void offerSmeltCampSmokeRecipe(String name, Item input, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, Consumer<RecipeJsonProvider> exporter) {

        int smeltingTime = cookingTime;
        int campfireTime = cookingTime * 3;
        int smokingTime = cookingTime/2;

        // Smelting
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input), category, output, experience, smeltingTime)
                .criterion(RecipeProvider.hasItem(input),
                        RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(output),
                        RecipeProvider.conditionsFromItem(output))
                .offerTo(exporter, name + "_from_" + input);

        // Campfire
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(input), category, output, experience, campfireTime)
                .criterion(RecipeProvider.hasItem(input),
                        RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(output),
                        RecipeProvider.conditionsFromItem(output))
                .offerTo(exporter, name + "_from_" + input + "_from_campfire_cooking");

        // Smoking
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(input), category, output, experience, smokingTime)
                .criterion(RecipeProvider.hasItem(input),
                        RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(output),
                        RecipeProvider.conditionsFromItem(output))
                .offerTo(exporter, name + "_from_" + input + "_from_smoking");
    }
}
