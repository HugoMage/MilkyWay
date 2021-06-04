package com.HugoMage.mw.util;

import com.HugoMage.mw.MilkyWay;
import com.HugoMage.mw.client.render.SpermRenderer;
import com.HugoMage.mw.entities.SpermEntity;
import com.HugoMage.mw.init.ModEntityTypes;
import com.HugoMage.mw.items.ModSpawnEggItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MilkyWay.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.PUBES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.SHORT_PUBES.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SPERM.get(), SpermRenderer::new);
        RenderTypeLookup.setRenderLayer(RegistryHandler.BALLS.get(), RenderType.getCutout());
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

}
