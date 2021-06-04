package com.HugoMage.mw.util;


import com.HugoMage.mw.MilkyWay;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKeyCodec;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import java.awt.*;

public class DimensionRegistry {
    public static final RegistryKey<DimensionType> CUM_DIMENSION = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, name("cum_dimension"));
    public static final RegistryKey<Dimension> CUM_WORLD = RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, name("cum_dimension"));

    private static ResourceLocation name(String name) {
        return new ResourceLocation(MilkyWay.MOD_ID, name);
    }
}
