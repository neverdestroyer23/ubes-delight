package com.chefmoon.ubesdelight;

import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;

public final class Configuration {

    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "ubesdelight.json");

    //Basic Config
    private boolean enableUDCropCrates = true;
    private boolean farmersBuyUDCrops = true;
    private boolean wanderingTraderSellsUDItems = true;
    private boolean isFoodEffectTooltip = true;

    //World Generation
    private boolean generateUDChestLoot = true;
    private boolean generateWildUbe = true;
    private int chanceWildUbe = 50;
    private boolean generateWildGarlic = true;
    private int chanceWildGarlic = 80;
    private boolean generateWildGinger = true;
    private int chanceWildGinger = 80;
    private boolean generateWildLemongrass = true;
    private int chanceWildLemongrass = 80;

    public Configuration() {
    }

    public static Configuration load() {
        Configuration configuration = new Configuration();
        if (!CONFIG_FILE.exists()) {
            save(configuration);
        }

        Reader reader;
        try {
            reader = Files.newBufferedReader(CONFIG_FILE.toPath());
            configuration = (new GsonBuilder().setPrettyPrinting().create()).fromJson(reader, Configuration.class);
            reader.close();
        } catch (IOException e) {
            UbesDelightMod.LOGGER.error("Error while trying to load configuration file. Default configuration used.", e);
            System.out.println("Error while trying to load configuration file. Default configuration used."+e);
        }

        return configuration;
    }

    public static void save(Configuration config) {
        try {
            Writer writer = Files.newBufferedWriter(CONFIG_FILE.toPath());
            (new GsonBuilder().setPrettyPrinting().create()).toJson(config, writer);

            writer.close();
        } catch (IOException e) {
            UbesDelightMod.LOGGER.error("Error while trying to save configuration file.", e);
            System.out.println("Error while trying to save configuration file."+e);
        }
    }

    public boolean isEnableUDCropCrates() {
        return enableUDCropCrates;
    }

    public void setEnableUDCropCrates(boolean enableUDCropCrates) {
        this.enableUDCropCrates = enableUDCropCrates;
    }
    public boolean isFarmersBuyUDCrops() {
        return farmersBuyUDCrops;
    }

    public void setFarmersBuyUDCrops(boolean farmersBuyUDCrops) {
        this.farmersBuyUDCrops = farmersBuyUDCrops;
    }

    public boolean isWanderingTraderSellsUDItems() {
        return wanderingTraderSellsUDItems;
    }

    public void setWanderingTraderSellsUDItems(boolean wanderingTraderSellsUDItems) {
        this.wanderingTraderSellsUDItems = wanderingTraderSellsUDItems;
    }

    public boolean isFoodEffectTooltip() {
        return isFoodEffectTooltip;
    }

    public void setFoodEffectTooltip(boolean foodEffectTooltip) {
        isFoodEffectTooltip = foodEffectTooltip;
    }

    public boolean isGenerateUDChestLoot() {
        return generateUDChestLoot;
    }

    public void setGenerateUDChestLoot(boolean generateUDChestLoot) {
        this.generateUDChestLoot = generateUDChestLoot;
    }

    public boolean isGenerateWildUbe() {
        return generateWildUbe;
    }

    public void setGenerateWildUbe(boolean generateWildUbe) {
        this.generateWildUbe = generateWildUbe;
    }

    public int getChanceWildUbe() {
        return chanceWildUbe;
    }

    public void setChanceWildUbe(int chanceWildUbe) {
        this.chanceWildUbe = chanceWildUbe;
    }

    public boolean isGenerateWildGarlic() {
        return generateWildGarlic;
    }

    public void setGenerateWildGarlic(boolean generateWildGarlic) {
        this.generateWildGarlic = generateWildGarlic;
    }

    public int getChanceWildGarlic() {
        return chanceWildGarlic;
    }

    public void setChanceWildGarlic(int chanceWildGarlic) {
        this.chanceWildGarlic = chanceWildGarlic;
    }

    public boolean isGenerateWildGinger() {
        return generateWildGinger;
    }

    public void setGenerateWildGinger(boolean generateWildGinger) {
        this.generateWildGinger = generateWildGinger;
    }

    public int getChanceWildGinger() {
        return chanceWildGinger;
    }

    public void setChanceWildGinger(int chanceWildGinger) {
        this.chanceWildGinger = chanceWildGinger;
    }

    public boolean isGenerateWildLemongrass() {
        return generateWildLemongrass;
    }

    public void setGenerateWildLemongrass(boolean generateWildLemongrass) {
        this.generateWildLemongrass = generateWildLemongrass;
    }

    public int getChanceWildLemongrass() {
        return chanceWildLemongrass;
    }

    public void setChanceWildLemongrass(int chanceWildLemongrass) {
        this.chanceWildLemongrass = chanceWildLemongrass;
    }

}
