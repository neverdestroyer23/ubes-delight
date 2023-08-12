package com.chefmoon.ubesdelight.integration.modmenu;

import com.chefmoon.ubesdelight.Configuration;
import com.chefmoon.ubesdelight.UbesDelightMod;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.SubCategoryListEntry;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.Arrays;

public class UbesDelightModMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::buildConfigScreen;
    }

    private Screen buildConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setSavingRunnable(() -> Configuration.save(UbesDelightMod.CONFIG))
                .setTitle(Text.literal("Ube's Delight Config")); //TODO: make translatable
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        Arrays.stream(SettingsInfo.values()).filter(category -> !category.isChild()).forEach(category -> buildCategory(builder, entryBuilder, category));

        return builder.build();
    }

    private void buildCategory(ConfigBuilder builder, ConfigEntryBuilder entryBuilder, SettingsInfo category) {
        ConfigCategory configCategory = builder.getOrCreateCategory(Text.literal(category.text()));
        Arrays.stream(category.entries()).forEach(entry -> configCategory.addEntry(entry.build(entryBuilder)));
        Arrays.stream(category.children()).forEach(entry -> configCategory.addEntry(buildSubCategory(entryBuilder.startSubCategory(Text.literal(entry.text())), entryBuilder, entry)));
    }

    private SubCategoryListEntry buildSubCategory(SubCategoryBuilder subCategoryBuilder, ConfigEntryBuilder entryBuilder, SettingsInfo category) {
        Arrays.stream(category.entries()).forEach(entry -> subCategoryBuilder.add(entry.build(entryBuilder)));
        Arrays.stream(category.children()).forEach(entry -> subCategoryBuilder.add(buildSubCategory(entryBuilder.startSubCategory(Text.literal(entry.text())), entryBuilder, entry)));

        return subCategoryBuilder.build();
    }
}
