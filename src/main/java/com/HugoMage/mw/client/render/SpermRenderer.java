package com.HugoMage.mw.client.render;

import com.HugoMage.mw.MilkyWay;
import com.HugoMage.mw.client.model.SpermModel;
import com.HugoMage.mw.entities.SpermEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpermRenderer extends MobRenderer<SpermEntity, SpermModel<SpermEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(MilkyWay.MOD_ID, "textures/entity/sperm.png");


    public SpermRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SpermModel<>(), 0.8F);
    }


    @Override
    public ResourceLocation getEntityTexture(SpermEntity entity) {
        return TEXTURE;
    }
}
