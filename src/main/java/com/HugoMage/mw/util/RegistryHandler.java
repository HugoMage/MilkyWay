package com.HugoMage.mw.util;

import com.HugoMage.mw.MilkyWay;
import com.HugoMage.mw.blocks.*;
import com.HugoMage.mw.init.ModEntityTypes;
import com.HugoMage.mw.items.CumPotionBase;
import com.HugoMage.mw.items.ItemBase;
import com.HugoMage.mw.items.ModSpawnEggItem;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MilkyWay.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MilkyWay.MOD_ID);


    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    // Items
    public static final RegistryObject<Item> CUM = ITEMS.register("cum", ItemBase::new);
    public static final RegistryObject<CumPotionBase> CUM_BOTTLE = ITEMS.register("cum_bottle", CumPotionBase::new);

    // Spawn Egg
    public static final RegistryObject<ModSpawnEggItem> SPERM_SPAWN_EGG = ITEMS.register("sperm_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.SPERM, 0xd1cdcd, 0xebccca, new Item.Properties().group(ItemGroup.MISC)));

    // Music Disc

    // Block
    public static final RegistryObject<SemenBlock> SEMEN_BLOCK = BLOCKS.register("semen_block", SemenBlock::new);
    public static final RegistryObject<FleshBlock> FLESH_BLOCK = BLOCKS.register("flesh_block", FleshBlock::new);
    public static final RegistryObject<PubesBlock> PUBES = BLOCKS.register("pubes",() -> new PubesBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.BROWN).sound(SoundType.PLANT).doesNotBlockMovement().zeroHardnessAndResistance()));
    public static final RegistryObject<PubesBlock> SHORT_PUBES = BLOCKS.register("short_pubes", () -> new PubesBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.BROWN).sound(SoundType.PLANT).doesNotBlockMovement().zeroHardnessAndResistance()));
    public static final RegistryObject<FleshBlock> PP_BLOCK = BLOCKS.register("penis_block", FleshBlock::new);
    public static final RegistryObject<PoopBlock> POOP_BLOCK = BLOCKS.register("poop_block", PoopBlock::new);
    public static final RegistryObject<OreBlock> CUM_ORE = BLOCKS.register("cum_ore", CumOre::new);
    public static final RegistryObject<BallsBlock> BALLS = BLOCKS.register("balls", () -> new BallsBlock(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BROWN).sound(SoundType.SLIME).doesNotBlockMovement().zeroHardnessAndResistance()));

    // Block Item
    public static final RegistryObject<Item> CUM_ORE_ITEM = ITEMS.register("cum_ore", () -> new BlockItem(CUM_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> SEMEN_BLOCK_ITEM = ITEMS.register("semen_block", () -> new BlockItem(SEMEN_BLOCK.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> FLESH_BLOCK_ITEM = ITEMS.register("flesh_block", () -> new BlockItem(FLESH_BLOCK.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> PUBES_ITEM = ITEMS.register("pubes", () -> new BlockItem(PUBES.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> SHORT_PUBES_ITEM = ITEMS.register("short_pubes", () -> new BlockItem(SHORT_PUBES.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> PP_BLOCK_ITEM = ITEMS.register("penis_block", () -> new BlockItem(PP_BLOCK.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> POOP_BLOCK_ITEM = ITEMS.register("poop_block", () -> new BlockItem(POOP_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> BALLS_ITEM = ITEMS.register("balls", () -> new BlockItem(BALLS.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));


    // Tools









}
