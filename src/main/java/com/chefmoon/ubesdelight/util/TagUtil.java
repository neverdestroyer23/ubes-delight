package com.chefmoon.ubesdelight.util;

import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class TagUtil {

    public static TagKey<Item> getItemTagKey(String namespace, String path) {
        return new TagKey<Item>(Registry.ITEM_KEY, new Identifier(namespace, path));
    }
    public static TagKey<Block> getBlockTagKey(String namespace, String path) {
        return new TagKey<Block>(Registry.BLOCK_KEY, new Identifier(namespace, path));
    }

    public static TagKey<Item> registerCommonItem(String tagId) {
        return TagRegistration.ITEM_TAG_REGISTRATION.registerCommon(tagId);
    }
    public static TagKey<Block> registerCommonBlock(String tagId) {
        return TagRegistration.BLOCK_TAG_REGISTRATION.registerCommon(tagId);
    }
}
