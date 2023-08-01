package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.minecraft.entity.damage.DamageSource;

public class DamageSourcesRegistry extends DamageSource {

    public static final DamageSource KALAN_BLOCK = (new DamageSourcesRegistry("kalan")).setFire();
    public DamageSourcesRegistry(String name) {
        super(UbesDelightMod.MOD_ID + "." + name);
    }
}
