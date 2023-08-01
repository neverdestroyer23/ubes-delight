package com.chefmoon.ubesdelight.util.registryutil;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.util.Identifier;

import java.util.Set;

public class LootTableUtil {
    public static void register() {
        registerLootTable();
    }

    private static void registerLootTable() {
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
