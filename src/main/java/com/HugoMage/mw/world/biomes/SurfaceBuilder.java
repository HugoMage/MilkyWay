package com.HugoMage.mw.world.biomes;

import com.HugoMage.mw.init.ModEntityTypes;
import com.HugoMage.mw.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import static com.HugoMage.mw.world.biomes.BiomeHelper.*;

public class SurfaceBuilder {
    public static final SurfaceBuilderConfig THE_CUM_BUILDER_CONFIG = new SurfaceBuilderConfig(
            RegistryHandler.FLESH_BLOCK.get().getDefaultState(),
            RegistryHandler.POOP_BLOCK.get().getDefaultState(),
            RegistryHandler.POOP_BLOCK.get().getDefaultState()
    );
    public static final Biome CumLand() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(net.minecraft.world.gen.surfacebuilders.SurfaceBuilder.DEFAULT,THE_CUM_BUILDER_CONFIG);

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.MONSTER,
                ModEntityTypes.SPERM.get(), 4, 1, 4);


        final BiomeAmbience.Builder effects = effects(0x8F877B,
                0xA28565,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR
        );

        return biome(
                Biome.RainType.NONE,
                Biome.Category.DESERT,
                0.125F,
                0.07F,
                0F,
                0.0001F,
                effects,
                genSettings,
                MobSpawnInfo.EMPTY
        );
    }

}


