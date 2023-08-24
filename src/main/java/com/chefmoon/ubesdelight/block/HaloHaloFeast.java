package com.chefmoon.ubesdelight.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;

public class HaloHaloFeast extends DrinkableFeastBlock {
    //TODO: idea, make luminance decrease with servings left
    public HaloHaloFeast(Item servingItem) {
        super(servingItem, FabricBlockSettings.copyOf(Blocks.GLASS).luminance(10));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

}