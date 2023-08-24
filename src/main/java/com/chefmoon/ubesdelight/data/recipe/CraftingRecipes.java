package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.tag.CompatibilityTags;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class CraftingRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {
        // Crate to Vegetable
        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.UBE_CRATE, 1,
                ItemsRegistry.UBE, 9);
        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.GARLIC_CRATE, 1,
                ItemsRegistry.GARLIC, 9);
        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.GINGER_CRATE, 1,
                ItemsRegistry.GINGER, 9);
        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.LEMONGRASS_CRATE, 1,
                ItemsRegistry.LEMONGRASS, 9);

        /* //Release: TBD
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                ItemsRegistry.UBE_JUNGLE_LOG_CRATE, 1,
                ItemsRegistry.UBE, 8);

        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                ItemsRegistry.UBE_JUNGLE_CRATE, 1,
                ItemsRegistry.UBE, 8);
         */

        /*
        // Vegetable Crate Variants: Log
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemsRegistry.UBE_JUNGLE_LOG_CRATE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .input('A', ItemsRegistry.UBE.get())
                .input('B', Items.JUNGLE_LOG)
                .criterion(RecipeProvider.hasItem(Items.JUNGLE_LOG), RecipeProvider.conditionsFromItem(Items.JUNGLE_LOG))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.UBE.get()))
                .showNotification(false)
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.UBE_JUNGLE_LOG_CRATE.get())));

        // Vegetable Crate Variants: Plank
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemsRegistry.UBE_JUNGLE_CRATE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .input('A', ItemsRegistry.UBE.get())
                .input('B', Items.JUNGLE_PLANKS)
                .criterion(RecipeProvider.hasItem(Items.JUNGLE_PLANKS), RecipeProvider.conditionsFromItem(Items.JUNGLE_PLANKS))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.UBE.get()))
                .showNotification(false)
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.UBE_JUNGLE_CRATE.get())));
         */

        // Seed from crop
        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.LEMONGRASS, 1,
                ItemsRegistry.LEMONGRASS_SEEDS, 1);

        // Partial to full Vegetables
        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.GARLIC_CHOP, 2,
                ItemsRegistry.GARLIC, 1);

        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.GINGER_CHOP, 2,
                ItemsRegistry.GINGER, 1);

        // Cake Slices to Cake
        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.UBE_CAKE_SLICE, 7,
                ItemsRegistry.UBE_CAKE, 1);

        RecipeUtil.simpleRecipeBuilder(exporter,
                ItemsRegistry.LECHE_FLAN, 5,
                ItemsRegistry.LECHE_FLAN_FEAST, 1);

        ShapelessRecipeJsonBuilder.create(ItemsRegistry.COOKIE_GINGER.get(), 8)
                .input(CommonTags.C_VEGETABLES_GINGER)
                .input(Items.WHEAT, 2)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GINGER.get()), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GINGER))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.COOKIE_GINGER.get())));

        ShapelessRecipeJsonBuilder.create(ItemsRegistry.COOKIE_UBE.get(), 8)
                .input(CommonTags.C_VEGETABLES_UBE)
                .input(Items.WHEAT, 2)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE.get()), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_UBE))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.COOKIE_UBE.get())));

        ShapelessRecipeJsonBuilder.create(ItemsRegistry.KINILAW.get())
                .input(CommonTags.C_RAW_FISHES)
                .input(CommonTags.C_CROPS_ONION)
                .input(CommonTags.C_VEGETABLES_GARLIC)
                .input(CommonTags.C_VEGETABLES_GINGER)
                .input(CommonTags.C_CROPS_LEMONGRASS)
                .input(Items.BOWL)
                .criterion(RecipeProvider.hasItem(Items.BOWL), RecipeProvider.conditionsFromItem(Items.BOWL))
                //TODO: add criterion
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.KINILAW.get())));

        ShapelessRecipeJsonBuilder.create(ItemsRegistry.LUMPIA_WRAPPER.get(), 32)
                .input(CommonTags.C_GRAIN)
                .input(CommonTags.C_EGGS)
                .input(Items.WATER_BUCKET)
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromTag(CommonTags.C_GRAIN))
                .criterion(RecipeProvider.hasItem(Items.EGG), RecipeProvider.conditionsFromTag(CommonTags.C_EGGS))
                .criterion(RecipeProvider.hasItem(Items.WATER_BUCKET), RecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.LUMPIA_WRAPPER.get())
                        + "_from_" + RecipeProvider.getRecipeName(Items.WATER_BUCKET)));

        ShapedRecipeJsonBuilder.create(ItemsRegistry.HALO_HALO_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .input('A', ItemsRegistry.HALO_HALO.get())
                .input('B', CommonTags.C_MILK)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.HALO_HALO.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.HALO_HALO.get()))
                //.showNotification(false) TODO: verify this works + others below
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.HALO_HALO_FEAST.get())));

        ShapedRecipeJsonBuilder.create(ItemsRegistry.MILK_TEA_UBE_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .input('A', ItemsRegistry.MILK_TEA_UBE.get())
                .input('B', CommonTags.C_MILK)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.MILK_TEA_UBE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.MILK_TEA_UBE.get()))
                //.showNotification(false)
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.MILK_TEA_UBE_FEAST.get())));

        ShapedRecipeJsonBuilder.create(ItemsRegistry.LUMPIA_FEAST.get())
                .pattern("   ")
                .pattern("AAA")
                .pattern("BBB")
                .input('A', ItemsRegistry.LUMPIA.get())
                .input('B', CompatibilityTags.MINECRAFT_LEAVES)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LUMPIA.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.LUMPIA.get()))
                //.showNotification(false)
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.LUMPIA_FEAST.get())));

        ShapedRecipeJsonBuilder.create(ItemsRegistry.UBE_CAKE.get())
                .pattern("AAA")
                .pattern("BEB")
                .pattern("CFC")
                .input('A', CommonTags.C_MILK)
                .input('B', CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .input('C', Items.WHEAT)
                .input('E', CommonTags.C_EGGS)
                .input('F', CommonTags.C_CROPS_UBE)
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(Items.WHEAT))
                //.showNotification(false)
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.UBE_CAKE.get())));

        ShapedRecipeJsonBuilder.create(ItemsRegistry.KALAN.get())
                .pattern("AAA")
                .pattern("ACA")
                .pattern("ABA")
                .input('A', CompatibilityTags.MINECRAFT_TERRACOTTA)
                .input('B', Items.CAMPFIRE)
                .input('C', CommonTags.C_IRON_INGOTS)
                .criterion(RecipeProvider.hasItem(Items.CAMPFIRE), RecipeProvider.conditionsFromItem(Items.CAMPFIRE))
                //.showNotification(false)
                .offerTo(exporter, new Identifier("minecraft/crafting/"
                        + RecipeProvider.getRecipeName(ItemsRegistry.KALAN.get())));
    }
}
