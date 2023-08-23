package com.chefmoon.ubesdelight.util;

import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagUtil {

    public static TagKey<Item> getItemTagKey(String namespace, String path) {
        return new TagKey<Item>(RegistryKeys.ITEM, new Identifier(namespace, path));
    }
    public static TagKey<Block> getBlockTagKey(String namespace, String path) {
        return new TagKey<Block>(RegistryKeys.BLOCK, new Identifier(namespace, path));
    }

    public static TagKey<Item> registerCommonItem(String tagId) {
        return TagRegistration.ITEM_TAG_REGISTRATION.registerCommon(tagId);
    }
    public static TagKey<Block> registerCommonBlock(String tagId) {
        return TagRegistration.BLOCK_TAG_REGISTRATION.registerCommon(tagId);
    }
}
