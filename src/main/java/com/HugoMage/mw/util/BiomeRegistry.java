package com.HugoMage.mw.util;

import com.HugoMage.mw.MilkyWay;
import com.HugoMage.mw.world.biomes.SurfaceBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MilkyWay.MOD_ID);

    public static final RegistryObject<Biome> CUM_LAND = BIOMES.register("cum_land", SurfaceBuilder::CumLand);
    public static final RegistryKey<Biome> CUM_LAND_BUILDER_KEY =
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, MilkyWay.id("cum_land"));

    public static void biomeLoading(FMLCommonSetupEvent event) {
        BiomeDictionary.addTypes(CUM_LAND_BUILDER_KEY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.DEAD);
    }

}
