package com.chefmoon.ubesdelight.integration.modmenu;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;

@Environment(value= EnvType.CLIENT)
public enum SettingsInfo {

    SETTINGS(Text.translatable("ubesdelight.modmenu.title.gamesettings").getString(), false,
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.enableudcropcrates").getString(),
                    () -> UbesDelightMod.CONFIG.isEnableUDCropCrates(),
    newValue -> UbesDelightMod.CONFIG.setEnableUDCropCrates(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.enableudcropcrates").getString()),
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.farmersbuyudcrops").getString(),
                    () -> UbesDelightMod.CONFIG.isFarmersBuyUDCrops(),
                    newValue -> UbesDelightMod.CONFIG.setFarmersBuyUDCrops(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.farmersbuyudcrops").getString()),
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.wanderingtradersellsuditems").getString(),
                    () -> UbesDelightMod.CONFIG.isWanderingTraderSellsUDItems(),
                    newValue -> UbesDelightMod.CONFIG.setWanderingTraderSellsUDItems(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.wanderingtradersellsuditems").getString())),

    WILD_UBE(Text.translatable("ubesdelight.modmenu.category.wildubegen").getString(), true,
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.wildgen").getString(),
                    () -> UbesDelightMod.CONFIG.isGenerateWildUbe(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildUbe(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.wildubegen").getString())
            //TODO: add chance modifier
            ),
    WILD_GARLIC(Text.translatable("ubesdelight.modmenu.category.wildgarlicgen").getString(), true,
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.wildgen").getString(),
                    () -> UbesDelightMod.CONFIG.isGenerateWildGarlic(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildGarlic(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.wildgarlicgen").getString())
            //TODO: add chance modifier
            ),
    WILD_GINGER(Text.translatable("ubesdelight.modmenu.category.wildgingergen").getString(), true,
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.wildgen").getString(),
                    () -> UbesDelightMod.CONFIG.isGenerateWildGinger(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildGinger(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.wildgingergen").getString())
            //TODO: add chance modifier
            ),
    WILD_LEMONGRASS(Text.translatable("ubesdelight.modmenu.category.wildlemongrassgen").getString(), true,
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.wildgen").getString(),
                    () -> UbesDelightMod.CONFIG.isGenerateWildLemongrass(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateWildLemongrass(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.wildlemongrassgen").getString())
            //TODO: add chance modifier
            ),

    WORLD(Text.translatable("ubesdelight.modmenu.title.worldgeneration").getString(), false, new SettingsInfo[]{ WILD_UBE, WILD_GARLIC, WILD_GINGER, WILD_LEMONGRASS },
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.generateUDChestLoot").getString(),
                    () -> UbesDelightMod.CONFIG.isGenerateUDChestLoot(),
                    newValue -> UbesDelightMod.CONFIG.setGenerateUDChestLoot(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.generateUDChestLoot").getString())),

    CLIENT(Text.translatable("ubesdelight.modmenu.title.clientsettings").getString(), false,
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.foodEffectTooltip").getString(),
                    () -> UbesDelightMod.CONFIG.isFoodEffectTooltip(),
                    newValue -> UbesDelightMod.CONFIG.setFoodEffectTooltip(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.foodEffectTooltip").getString())),

    INTEGRATION(Text.translatable("ubesdelight.modmenu.title.integration").getString(), false,
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.enableGarlicCompat").getString(),
                    () -> UbesDelightMod.CONFIG.isEnableGarlicCompat(),
                    newValue -> UbesDelightMod.CONFIG.setEnableGarlicCompat(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.enableGarlicCompat").getString()),
            Entry.bool(Text.translatable("ubesdelight.modmenu.option.enableGingerCompat").getString(),
                    () -> UbesDelightMod.CONFIG.isEnableGingerCompat(),
                        newValue -> UbesDelightMod.CONFIG.setEnableGingerCompat(newValue), true,
                    Text.translatable("ubesdelight.modmenu.tooltip.enableGingerCompat").getString()));

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
