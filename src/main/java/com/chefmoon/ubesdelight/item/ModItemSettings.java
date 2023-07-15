package com.chefmoon.ubesdelight.item;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.item.enumeration.FoodItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ModItemSettings extends FabricItemSettings {

    public static FabricItemSettings base() {
        return new ModItemSettings();
    }
    public static FabricItemSettings noStack() {
        return new ModItemSettings().maxCount(1);
    }

    public static FabricItemSettings food(FoodItem food) {
        return new ModItemSettings().food(food.get());
    }

    public static FabricItemSettings food(FoodItem food, Item remainder, int maxCount) {
        return new ModItemSettings().food(food.get()).recipeRemainder(remainder).maxCount(maxCount);
    }

    public ModItemSettings() {
        super();
        group(UbesDelightMod.ITEM_GROUP);
    }
}
