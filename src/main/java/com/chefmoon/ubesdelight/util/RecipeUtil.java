package com.chefmoon.ubesdelight.util;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RecipeUtil {

    private static final Identifier MINECRAFT = new Identifier("minecraft");

    //TODO: utilize RecipeProvider.convertBetween for _from_
    public static void simpleRecipeBuilder(Consumer<RecipeJsonProvider> exporter, ItemsRegistry input, Integer inputCount, ItemsRegistry output, Integer outputCount) {
        ShapelessRecipeJsonBuilder.create(output.get(), outputCount)
                .input(input.get(), inputCount)
                .criterion(RecipeProvider.hasItem(output.get()), RecipeProvider.conditionsFromItem(output.get()))
                .criterion(RecipeProvider.hasItem(input.get()), RecipeProvider.conditionsFromItem(input.get()))
                .group(UbesDelightMod.ITEM_GROUP.getName())
                .offerTo(exporter, new Identifier(MINECRAFT.getNamespace() + "/crafting/" + RecipeProvider.getRecipeName(output.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(input.get()));
    }
    public static void offerSmeltCampSmokeRecipe(Item input, ItemConvertible output, float experience, int cookingTime, Consumer<RecipeJsonProvider> exporter) {
        int smeltingTime = cookingTime;
        int campfireTime = cookingTime * 3;
        int smokingTime = cookingTime/2;

        // Smelting
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input), output, experience, smeltingTime)
                .criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(output), RecipeProvider.conditionsFromItem(output))
                .offerTo(exporter, new Identifier(MINECRAFT.getNamespace() + "/smelting/" + RecipeProvider.getRecipeName(output)
                        + "_from_" + RecipeProvider.getRecipeName(input) + "_from_smelting"));

        // Campfire
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), output, experience, campfireTime)
                .criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(output), RecipeProvider.conditionsFromItem(output))
                .offerTo(exporter, new Identifier(MINECRAFT.getNamespace() + "/smelting/campfire_cooking/" + RecipeProvider.getRecipeName(output)
                        + "_from_" + RecipeProvider.getRecipeName(input) + "_from_campfire_cooking"));

        // Smoking
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(input), output, experience, smokingTime)
                .criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input))
                .criterion(RecipeProvider.hasItem(output), RecipeProvider.conditionsFromItem(output))
                .offerTo(exporter, new Identifier(MINECRAFT.getNamespace() + "/smelting/smoking/" + RecipeProvider.getRecipeName(output)
                        + "_from_" + RecipeProvider.getRecipeName(input) + "_from_smoking"));
    }

    //TODO: Solve category: "misc"
    public static void offerSmeltCampSmokeFromTag(TagKey<Item> input, ItemConvertible output, float experience, int cookingTime, Consumer<RecipeJsonProvider> exporter) {
        int smeltingTime = cookingTime;
        int campfireTime = cookingTime * 3;
        int smokingTime = cookingTime/2;

        CookingRecipeJsonBuilder.create(Ingredient.fromTag(input), output, experience, smeltingTime, RecipeSerializer.SMELTING)
                .criterion(input.id().toUnderscoreSeparatedString(), RecipeProvider.conditionsFromTag(input))
                .offerTo(exporter, new Identifier(MINECRAFT.getNamespace() + "/smelting/" + RecipeProvider.getRecipeName(output)
                        + "_from_" + input.id().toUnderscoreSeparatedString() + "_from_smelting"));

        CookingRecipeJsonBuilder.create(Ingredient.fromTag(input), output, experience, campfireTime, RecipeSerializer.CAMPFIRE_COOKING)
                .criterion(input.id().toUnderscoreSeparatedString(), RecipeProvider.conditionsFromTag(input))
                .offerTo(exporter, new Identifier(MINECRAFT.getNamespace() + "/smelting/campfire_cooking/" + RecipeProvider.getRecipeName(output)
                        + "_from_" + input.id().toUnderscoreSeparatedString() + "_from_campfire_cooking"));

        CookingRecipeJsonBuilder.create(Ingredient.fromTag(input), output, experience, smokingTime, RecipeSerializer.SMOKING)
                .criterion(input.id().toUnderscoreSeparatedString(), RecipeProvider.conditionsFromTag(input))
                .offerTo(exporter, new Identifier(MINECRAFT.getNamespace() + "/smelting/smoking/" + RecipeProvider.getRecipeName(output)
                        + "_from_" + input.id().toUnderscoreSeparatedString() + "_from_smoking"));
    }
}
