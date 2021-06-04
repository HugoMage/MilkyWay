package com.HugoMage.mw.init;

import com.HugoMage.mw.MilkyWay;
import com.HugoMage.mw.entities.SpermEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MilkyWay.MOD_ID);

    //Void Mobs
    public static final RegistryObject<EntityType<SpermEntity>> SPERM = ENTITY_TYPES.register("sperm", ()->
            EntityType.Builder.create(SpermEntity::new, EntityClassification.MONSTER)
                    .size(1.0f,1.3f)
                    .build(new ResourceLocation(MilkyWay.MOD_ID, "sperm").toString()));
}
