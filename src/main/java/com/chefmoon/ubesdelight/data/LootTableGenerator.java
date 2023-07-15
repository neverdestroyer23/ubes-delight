package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class LootTableGenerator extends SimpleFabricLootTableProvider {
    public LootTableGenerator(FabricDataGenerator dataGenerator, LootContextType lootContextType) {
        super(dataGenerator, lootContextType);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {

        identifierBuilderBiConsumer.accept(new Identifier(UbesDelightMod.MOD_ID, "blocks/ube_crate"),
                BlockLootTableGenerator.drops(BlocksRegistry.UBE_CRATE.get()));
        identifierBuilderBiConsumer.accept(new Identifier(UbesDelightMod.MOD_ID, "blocks/garlic_crate"),
                BlockLootTableGenerator.drops(BlocksRegistry.GARLIC_CRATE.get()));
        identifierBuilderBiConsumer.accept(new Identifier(UbesDelightMod.MOD_ID, "blocks/ginger_crate"),
                BlockLootTableGenerator.drops(BlocksRegistry.GINGER_CRATE.get()));
        identifierBuilderBiConsumer.accept(new Identifier(UbesDelightMod.MOD_ID, "blocks/lemongrass_crate"),
                BlockLootTableGenerator.drops(BlocksRegistry.LEMONGRASS_CRATE.get()));


        //identifierBuilderBiConsumer.accept(new Identifier(UbesDelightMod.MOD_ID, UbesDelightMod.ITEM_GROUP.toString()),
        //        BlockLootTableGenerator.cropDrops(BlocksRegistry.UBE_CROP.get(), ItemsRegistry.UBE.get(), ));
        //LootTable.Builder builder = LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))).build();
        //identifierBuilderBiConsumer.accept(new Identifier(UbesDelightMod.MOD_ID, UbesDelightMod.ITEM_GROUP.toString()),
        //        BlockLootTableGenerator.cropDrops(BlocksRegistry.UBE_CROP.get(), ItemsRegistry.UBE.get(), ItemsRegistry.UBE.get(), builder));
    }
}
