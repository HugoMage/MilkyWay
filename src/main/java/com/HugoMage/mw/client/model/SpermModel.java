package com.HugoMage.mw.client.model;

import com.HugoMage.mw.entities.SpermEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SpermModel<T extends SpermEntity> extends EntityModel<T>{
    private final ModelRenderer Head;
    private final ModelRenderer Tail;

    public SpermModel() {
        textureWidth = 64;
        textureHeight = 64;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 21.0F, 0.0F);
        Head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 7.0F, 12.0F, 0.0F, false);

        Tail = new ModelRenderer(this);
        Tail.setRotationPoint(0.0F, 1.0F, 6.0F);
        Head.addChild(Tail);
        Tail.setTextureOffset(0, 19).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 5.0F, 13.0F, 0.0F, false);
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.Tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}