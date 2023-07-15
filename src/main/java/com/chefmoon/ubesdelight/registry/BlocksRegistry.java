package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.block.UbeCropBlock;
import com.chefmoon.ubesdelight.block.GarlicCropBlock;
import com.chefmoon.ubesdelight.block.GingerCropBlock;
import com.chefmoon.ubesdelight.block.WildCropBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;

import java.util.function.Supplier;

import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum BlocksRegistry {

    UBE_CRATE("ube_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    GARLIC_CRATE("garlic_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    GINGER_CRATE("ginger_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    LEMONGRASS_CRATE("lemongrass_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),

    //TODO: Add wild variations of each crop
    WILD_UBE("wild_ube", WildCropBlock::new, true, flammable(100,60)),
    WILD_GARLIC("wild_garlic", WildCropBlock::new, true, flammable(100,60)),
    WILD_GINGER("wild_ginger", WildCropBlock::new, true, flammable(100,60)),
    WILD_LEMONGRASS("wild_lemongrass", WildCropBlock::new, true, flammable(100,60)),


    UBE_CROP("ube_crop", UbeCropBlock::new, true),
    GARLIC_CROP("garlic_crop", GarlicCropBlock::new, true),
    GINGER_CROP("ginger_crop", GingerCropBlock::new, true),
    LEMONGRASS_CROP("lemongrass_crop", GingerCropBlock::new, true);



    private static FlammableBlockRegistry.Entry flammable(int burnChance, @SuppressWarnings("SameParameterValue") int spreadChance) {
        return new FlammableBlockRegistry.Entry(burnChance, spreadChance);
    }

    private static boolean isValidFlammableEntry(FlammableBlockRegistry.Entry flammableRate) {
        return flammableRate != null && flammableRate.getBurnChance() > 0 && flammableRate.getSpreadChance() > 0;
    }

    private final String pathName;
    private final Supplier<Block> blockSupplier;
    private final FlammableBlockRegistry.Entry flammableRate;
    private final boolean isCutout;
    private Block block;

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier) {
        this(pathName, blockSupplier, false, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout) {
        this(pathName, blockSupplier, isCutout, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout, FlammableBlockRegistry.Entry flammableRate) {
        this.pathName = pathName;
        this.blockSupplier = blockSupplier;
        this.flammableRate = flammableRate;
        this.isCutout = isCutout;
    }
    public static void registerAll() {
        for (BlocksRegistry value : values()) {
            Block block = value.get();
            Registry.register(Registry.BLOCK, new Identifier(UbesDelightMod.MOD_ID, value.pathName), block);
            if (isValidFlammableEntry(value.flammableRate)) {
                FlammableBlockRegistry.getDefaultInstance().add(block, value.flammableRate);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayer() {
        for (BlocksRegistry value : values()) {
            if (value.isCutout) {
                BlockRenderLayerMap.INSTANCE.putBlock(value.get(), RenderLayer.getCutout());
            }
        }
    }

    public Block get() {
        if (block == null) {
            block = blockSupplier.get();
        }

        return block;
    }

    public String getId() {
        return Registry.BLOCK.getId(get()).toString();
    }
}
