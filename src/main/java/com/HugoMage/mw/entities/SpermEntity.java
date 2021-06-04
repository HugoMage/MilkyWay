package com.HugoMage.mw.entities;


import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class SpermEntity extends MonsterEntity {
    private int attackTimer;


    public SpermEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }
    private static final DataParameter<Float> GIANT_SIZE = EntityDataManager.createKey(SpermEntity.class, DataSerializers.FLOAT);
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 6D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 4D);
    }
    public boolean isPushedByWater() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0D, 1));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(0, new SwimGoal(this));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1+ this.world.rand.nextInt(5);
    }

    @Override
    protected void playStepSound( BlockPos pos, BlockState blockIn )
    {
        if ( !blockIn.getMaterial().isLiquid() )
        {
            this.playSound( SoundEvents.ENTITY_COW_STEP, this.getSoundVolume() * 0.3F, this.getSoundPitch() );
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(GIANT_SIZE, 1.0F);
    }

    public void setGiantSize(float size) {
        getDataManager().set(GIANT_SIZE, size);
        recenterBoundingBox();
        recalculateSize();
    }


    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putFloat("Size", getGiantSize());
    }

    public void readAdditional(CompoundNBT compound) {
        setGiantSize(compound.getFloat("Size"));
        super.readAdditional(compound);
    }

    @Override
    public void recalculateSize() {
        super.recalculateSize();
        setPosition(getPosX(), getPosY(), getPosZ());
    }

    @Override
    public EntitySize getSize(Pose poseIn) {
        return super.getSize(poseIn).scale(getGiantSize());
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        if (GIANT_SIZE.equals(key)) {
            recalculateSize();
        }

        super.notifyDataManagerChange(key);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTimer = 10;
        } else {
            super.handleStatusUpdate(id);
        }

    }



    @OnlyIn(Dist.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }


    private float func_226511_et_() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }



    private void func_241821_eG() {
        this.livingSoundTime = -this.getTalkInterval();
    }

    public int livingSoundTime() {
        return 0;
    }

    public static boolean canSpawn(EntityType<SpermEntity> type, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return (pos.getY() > 50);
    }

    public float getGiantSize() {
        return this.dataManager.get(GIANT_SIZE);
    }

}


