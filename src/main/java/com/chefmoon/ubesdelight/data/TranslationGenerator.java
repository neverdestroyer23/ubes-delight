package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class TranslationGenerator extends FabricLanguageProvider {
    protected TranslationGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        translationBuilder.add(UbesDelightMod.ITEM_GROUP, "Ube's Delight");

        translationBuilder.add("ubesdelight.container."+ItemsRegistry.HALO_HALO_FEAST.get(), "Glass Bottle Required.");

        translationBuilder.add("ubesdelight.tooltip."+ItemsRegistry.KALAN.get(), "Traditional Filipino Clay Oven.");
        translationBuilder.add("ubesdelight.tooltip.knife", "Knife Required.");

        translationBuilder.add(ItemsRegistry.KALAN.get(), "Kalan");

        translationBuilder.add(ItemsRegistry.UBE_CRATE.get(), "Ube Crate");
        translationBuilder.add(ItemsRegistry.GARLIC_CRATE.get(), "Garlic Crate");
        translationBuilder.add(ItemsRegistry.GINGER_CRATE.get(), "Ginger Crate");
        translationBuilder.add(ItemsRegistry.LEMONGRASS_CRATE.get(), "Lemongrass Crate");

        translationBuilder.add(ItemsRegistry.WILD_UBE.get(), "Wild Ube");
        translationBuilder.add(ItemsRegistry.WILD_GARLIC.get(), "Wild Garlic");
        translationBuilder.add(ItemsRegistry.WILD_GINGER.get(), "Wild Ginger");
        translationBuilder.add(ItemsRegistry.WILD_LEMONGRASS.get(), "Wild Lemongrass");

        translationBuilder.add(ItemsRegistry.SINANGAG.get(), "Sinangag");
        translationBuilder.add(ItemsRegistry.KINILAW.get(), "Kinilaw");
        translationBuilder.add(ItemsRegistry.LUMPIA.get(), "Lumpia");
        translationBuilder.add(ItemsRegistry.TOCINO.get(), "Tocino");
        translationBuilder.add(ItemsRegistry.CHICKEN_INASAL.get(), "Chicken Inasal");

        translationBuilder.add(ItemsRegistry.CHICKEN_INASAL_RICE.get(), "Chicken Inasal Plate");
        translationBuilder.add(ItemsRegistry.TOSILOG.get(), "Tosilog");
        translationBuilder.add(ItemsRegistry.BANGSILOG.get(), "Bangsilog");
        translationBuilder.add(ItemsRegistry.SISIG.get(), "Sisig");
        translationBuilder.add(ItemsRegistry.BULALO.get(), "Bulalo");
        translationBuilder.add(ItemsRegistry.ARROZ_CALDO.get(), "Arroz Caldo");
        translationBuilder.add(ItemsRegistry.MECHADO.get(), "Mechado");

        translationBuilder.add(ItemsRegistry.POISONOUS_UBE.get(), "Poisonous Ube");
        translationBuilder.add(ItemsRegistry.UBE.get(), "Ube");
        translationBuilder.add(ItemsRegistry.GARLIC.get(), "Garlic");
        translationBuilder.add(ItemsRegistry.GINGER.get(), "Ginger");
        translationBuilder.add(ItemsRegistry.LEMONGRASS.get(), "Lemongrass");
        translationBuilder.add(ItemsRegistry.LEMONGRASS_SEEDS.get(), "Lemongrass Seeds");

        translationBuilder.add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), "Condensed Milk Bottle");
        translationBuilder.add(ItemsRegistry.FISH_SAUCE_BOTTLE.get(), "Fish Sauce Bottle");
        translationBuilder.add(ItemsRegistry.MILK_POWDER.get(), "Milk Powder");
        translationBuilder.add(ItemsRegistry.SUGAR_BROWN.get(), "Brown Sugar");
        translationBuilder.add(ItemsRegistry.LUMPIA_WRAPPER.get(), "Lumpia Wrapper");

        translationBuilder.add(ItemsRegistry.MILK_TEA_UBE.get(), "Ube Milk Tea");
        translationBuilder.add(ItemsRegistry.HALO_HALO.get(), "Halo Halo");

        translationBuilder.add(ItemsRegistry.GARLIC_CHOP.get(), "Chopped Garlic");
        translationBuilder.add(ItemsRegistry.GINGER_CHOP.get(), "Chopped Ginger");

        translationBuilder.add(ItemsRegistry.LECHE_FLAN.get(), "Leche Flan Slice");
        translationBuilder.add(ItemsRegistry.COOKIE_UBE.get(), "Ube Cookie");
        translationBuilder.add(ItemsRegistry.COOKIE_GINGER.get(), "Ginger Cookie");

        translationBuilder.add(ItemsRegistry.POLVORONE.get(), "Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_PINIPIG.get(), "Pinipig Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_UBE.get(), "Ube Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_CC.get(), "Cookies and Cream Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE.get(), "Raw Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), "Raw Pinipig Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_UBE.get(), "Raw Ube Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_CC.get(), "Raw Cookies and Cream Polvorone");

        translationBuilder.add(ItemsRegistry.LECHE_FLAN_FEAST.get(), "Leche Flan");
        translationBuilder.add(ItemsRegistry.HALO_HALO_FEAST.get(), "Bowl of Halo Halo");
        translationBuilder.add(ItemsRegistry.MILK_TEA_UBE_FEAST.get(), "Bowl of Ube Milk Tea");
        translationBuilder.add(ItemsRegistry.LUMPIA_FEAST.get(), "Lumpia Platter");

        translationBuilder.add(ItemsRegistry.UBE_CAKE.get(), "Ube Cake");
        translationBuilder.add(ItemsRegistry.UBE_CAKE_SLICE.get(), "Ube Cake Slice");

        translationBuilder.add(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "Lemongrass Stalk");
        translationBuilder.add(BlocksRegistry.LEMONGRASS_LEAF_CROP.get(), "Lemongrass Leaves");

        translationBuilder.add("ubesdelight.modmenu.title", "Ube's Delight Config");
        translationBuilder.add("ubesdelight.modmenu.title.gamesettings", "Game settings");


        translationBuilder.add("ubesdelight.modmenu.option.enableudcropcrates", "Enable UD Crop Crates");
        translationBuilder.add("ubesdelight.modmenu.option.farmersbuyudcrops", "Farmers Buy UD Crops");
        translationBuilder.add("ubesdelight.modmenu.option.wanderingtradersellsuditems", "Wandering Trader Sells UD Items");

        translationBuilder.add("ubesdelight.modmenu.tooltip.enableudcropcrates", "Ube's Delight adds crates (3x3) for vanilla crops, similar to Farmer's Delight. Should they be craftable? Requires Reload.");
        translationBuilder.add("ubesdelight.modmenu.tooltip.farmersbuyudcrops", "Should Novice and Apprentice Farmers buy this mod's crops? (May reduce chances of other trades appearing)");
        translationBuilder.add("ubesdelight.modmenu.tooltip.wanderingtradersellsuditems", "Should the Wandering Trader sell some of this mod's items? (Crop Seeds Only)");

        translationBuilder.add("ubesdelight.modmenu.title.worldgeneration", "World generation");

        translationBuilder.add("ubesdelight.modmenu.category.wildubegen", "Wild Ube Generation");
        translationBuilder.add("ubesdelight.modmenu.category.wildgarlicgen", "Wild Garlic Generation");
        translationBuilder.add("ubesdelight.modmenu.category.wildgingergen", "Wild Ginger Generation");
        translationBuilder.add("ubesdelight.modmenu.category.wildlemongrassgen", "Wild Lemongrass Generation");

        translationBuilder.add("ubesdelight.modmenu.option.wildgen", "Generation");
        translationBuilder.add("ubesdelight.modmenu.option.generateUDChestLoot", "Generate UD Chest Loot");

        translationBuilder.add("ubesdelight.modmenu.tooltip.wildubegen", "Generate wild ube in jungles?");
        translationBuilder.add("ubesdelight.modmenu.tooltip.wildgarlicgen", "Generate wild garlic in jungles?");
        translationBuilder.add("ubesdelight.modmenu.tooltip.wildgingergen", "Generate wild ginger in jungles?");
        translationBuilder.add("ubesdelight.modmenu.tooltip.wildlemongrassgen", "Generate wild lemongrass in jungles?");
        translationBuilder.add("ubesdelight.modmenu.tooltip.generateUDChestLoot", "Should this mod add its seeds as extra chest loot across Minecraft?");

        translationBuilder.add("ubesdelight.modmenu.title.clientsettings", "Client Settings");

        translationBuilder.add("ubesdelight.modmenu.option.foodEffectTooltip", "Food Effect Tooltip");
        translationBuilder.add("ubesdelight.modmenu.tooltip.foodEffectTooltip", "Should meal and drink tooltips display which effects they provide?");

        translationBuilder.add("ubesdelight.modmenu.title.integration", "Integration");

        translationBuilder.add("ubesdelight.modmenu.option.enableGarlicCompat", "Garlic Extra Compatibility");
        translationBuilder.add("ubesdelight.modmenu.option.enableGingerCompat", "Ginger Extra Compatibility");

        translationBuilder.add("ubesdelight.modmenu.tooltip.enableGarlicCompat", "This allows all c:crops/garlic to be chopped into Chopped Garlic?");
        translationBuilder.add("ubesdelight.modmenu.tooltip.enableGingerCompat", "This allows all c:crops/ginger to be chopped into Chopped Ginger?");
    }
}
