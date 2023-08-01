package com.chefmoon.ubesdelight.registry;

import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;


public class TagsRegistry {
    public static final TagKey<Item> KNIVES = TagRegistration.ITEM_TAG_REGISTRATION.registerCommon("tools/knives");
    public static final TagKey<Item> FOOD_WRAPPER = TagRegistration.ITEM_TAG_REGISTRATION.registerCommon("food_wrappers/lumpia_wrapper");

    private TagsRegistry() throws InstantiationException {
        throw new InstantiationException("Constant class cannot be instantiate");
    }
}
