package com.chefmoon.ubesdelight;

import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(value= EnvType.CLIENT)
public class UbesDelightModClient  implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlocksRegistry.registerRenderLayer();
    }
}
