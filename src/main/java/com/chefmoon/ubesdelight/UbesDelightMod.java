package com.chefmoon.ubesdelight;

import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.FeaturesRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.world.gen.FeatureGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.util.Identifier;

import java.util.Set;

public class UbesDelightMod implements ModInitializer {

    public static final String MOD_ID = "ubesdelight";
    public static Configuration CONFIG = new Configuration();
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"),
            () -> new ItemStack(ItemsRegistry.UBE.get()));

    @Override
    public void onInitialize() {

        initConfiguration();

        ItemsRegistry.registerAll();
        BlocksRegistry.registerAll();
        FeaturesRegistry.registerAll();
        FeatureGeneration.generateAll();

        registerCompostables();
        registerLootTable();
        //registerVillagerTradeOffer()



    }

    private void initConfiguration() {
        CONFIG = Configuration.load();
    }

    private void registerCompostables() {

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LEMONGRASS_SEEDS.get(), .3f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GARLIC_CLOVES.get(), .4f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_UBE.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_GARLIC.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_GINGER.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_LEMONGRASS.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.UBE.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GARLIC.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GINGER.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LEMONGRASS.get(), .65f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.COOKIE_UBE.get(), .85f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.COOKIE_GINGER.get(), .85f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LECHE_FLAN.get(), 1.f);

    }

    private void registerVillagerTradeOffer() {
        if (UbesDelightMod.CONFIG.isFarmersBuyUDCrops()) {
            //TODO: register trade offers
        }
    }

    private void registerLootTable() {
        Set<Identifier> chestsId = Set.of(
                LootTables.VILLAGE_PLAINS_CHEST
        );

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            Identifier injectId = new Identifier(UbesDelightMod.MOD_ID, "inject/" + id.getPath());

            if (chestsId.contains(id) && UbesDelightMod.CONFIG.isGenerateUDChestLoot()) {
                tableBuilder.pool(LootPool.builder().with(LootTableEntry.builder(injectId).weight(1).quality(0)).build());
            }
        });
    }


}
