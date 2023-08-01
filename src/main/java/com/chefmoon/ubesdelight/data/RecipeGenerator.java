package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
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

        offerSmelting(exporter, List.of(Items.SUGAR), RecipeCategory.MISC ,ItemsRegistry.SUGAR_BROWN.get(), .5f,100,UbesDelightMod.ITEM_GROUP.getValue().toString());

        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE.get()), RecipeCategory.FOOD, ItemsRegistry.POLVORONE.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getValue().toString());
        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE_PINIPIG.get()), RecipeCategory.FOOD, ItemsRegistry.POLVORONE_PINIPIG.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getValue().toString());
        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE_UBE.get()), RecipeCategory.FOOD, ItemsRegistry.POLVORONE_UBE.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getValue().toString());
        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE_CC.get()), RecipeCategory.FOOD, ItemsRegistry.POLVORONE_CC.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getValue().toString());

        offerShapelessRecipe(exporter, ItemsRegistry.LEMONGRASS_SEEDS.get(), ItemsRegistry.LEMONGRASS.get(), UbesDelightMod.ITEM_GROUP.getValue().toString(), 1);

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
        //Partial to full Vegetables
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.GARLIC.get(), 1)
                .input(ItemsRegistry.GARLIC_CLOVES.get(), 2)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC_CLOVES.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC_CLOVES.get()))
                .group(UbesDelightMod.ITEM_GROUP.getValue().toString())
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GARLIC.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.GARLIC_CLOVES.get()));

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


    }
}
