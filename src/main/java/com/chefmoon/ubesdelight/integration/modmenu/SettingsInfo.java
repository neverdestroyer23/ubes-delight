package com.chefmoon.ubesdelight.integration.modmenu;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(value= EnvType.CLIENT)
public enum SettingsInfo {

    SETTINGS("Game settings", false,
            Entry.bool("enableUDCropCrates", () -> UbesDelightMod.CONFIG.isEnableUDCropCrates(),
                    newValue -> UbesDelightMod.CONFIG.setEnableUDCropCrates(newValue), true,
                    "Ube's Delight adds crates (3x3) for vanilla crops, similar to",
                    "Farmer's Delight. Should they be craftable? Requires Restart."),
            Entry.bool("farmersBuyUDCrops", () -> UbesDelightMod.CONFIG.isFarmersBuyUDCrops(),
                    newValue -> UbesDelightMod.CONFIG.setFarmersBuyUDCrops(newValue), true,
                    "Should Novice and Apprentice Farmers buy this mod's crops? (May",
                    "reduce chances of other trades appearing)"),
            Entry.bool("wanderingTraderSellsFDItems", () -> UbesDelightMod.CONFIG.isWanderingTraderSellsUDItems(),
                    newValue -> UbesDelightMod.CONFIG.setWanderingTraderSellsUDItems(newValue), true,
                    "Should the Wandering Trader sell some of this mod's items? (Currently",
                    "includes crop seeds)")),

    WILD_UBE("Wild Ube Generation", true,
            Entry.bool("generateWildUbe", () -> UbesDelightMod.CONFIG.isGenerateWildUbe(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildUbe(newValue), true,
                    "Generate wild ube in jungles")
            //TODO: add chance modifier
            ),
    WILD_GARLIC("Wild Garlic Generation", true,
            Entry.bool("generateWildGarlic", () -> UbesDelightMod.CONFIG.isGenerateWildGarlic(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildGarlic(newValue), true,
                    "Generate wild garlic in plains")
            //TODO: add chance modifier
            ),
    WILD_GINGER("Wild Ginger Generation", true,
            Entry.bool("generateWildGinger", () -> UbesDelightMod.CONFIG.isGenerateWildGinger(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildGinger(newValue), true,
                    "Generate wild ginger in plains")
            //TODO: add chance modifier
            ),
    WILD_LEMONGRASS("Wild Lemongrass Generation", true,
            Entry.bool("generateWildLemongrass", () -> UbesDelightMod.CONFIG.isGenerateWildLemongrass(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildLemongrass(newValue), true,
                    "Generate wild lemongrass in jungles")
            //TODO: add chance modifier
            ),

    WORLD("World generation", false, new SettingsInfo[]{ WILD_UBE, WILD_GARLIC, WILD_GINGER, WILD_LEMONGRASS },
            Entry.bool("generateUDChestLoot", () -> UbesDelightMod.CONFIG.isGenerateUDChestLoot(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateUDChestLoot(newValue), true,
                    "Should this mod add its seeds",
                    "as extra chest loot across Minecraft?")),

    CLIENT("Client Settings", false,
            Entry.bool("foodEffectTooltip", () -> UbesDelightMod.CONFIG.isFoodEffectTooltip(),
                    newValue -> UbesDelightMod.CONFIG.setFoodEffectTooltip(newValue), true,
                    "Should meal and drink tooltips display which effects they provide?")),

    INTEGRATION("Integration", false,
            Entry.bool("enableGarlicCompat", () -> UbesDelightMod.CONFIG.isEnableGarlicCompat(),
                    newValue -> UbesDelightMod.CONFIG.setEnableGarlicCompat(newValue), true,
                    "This allows all c:crops/garlic to be chopped into Chopped Garlic?"),
            Entry.bool("enableGingerCompat", () -> UbesDelightMod.CONFIG.isEnableGingerCompat(),
                    newValue -> UbesDelightMod.CONFIG.setEnableGingerCompat(newValue), true,
                    "This allows all c:crops/ginger to be chopped into Chopped Ginger?"));

    private final String text;
    private final Entry<?>[] entries;
    private final SettingsInfo[] children;
    private final boolean isChild;

    SettingsInfo(String text, boolean isChild, Entry<?>... entries) {
        this.text = text;
        this.entries = entries;
        this.children = new SettingsInfo[0];
        this.isChild = isChild;
    }

    SettingsInfo(String text, boolean isChild, SettingsInfo[] children, Entry<?>... entries) {
        this.text = text;
        this.entries = entries;
        this.children = children;
        this.isChild = isChild;
    }

    public String text() {
        return text;
    }

    public Entry<?>[] entries() {
        return entries;
    }

    public SettingsInfo[] children() {
        return children;
    }

    public boolean isChild() {
        return isChild;
    }
}
