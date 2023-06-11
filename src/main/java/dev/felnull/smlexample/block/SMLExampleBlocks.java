package dev.felnull.smlexample.block;

import dev.felnull.smlexample.SMLExample;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

public class SMLExampleBlocks {
    public static final Block OBJ_MODEL_BLOCK = new OBJBlock(FabricBlockSettings.copyOf(Blocks.ANVIL));
    public static final Block FACING_OBJ_MODEL_BLOCK = new FacingOBJBlock(FabricBlockSettings.copyOf(Blocks.ANVIL));

    public static void init() {
        register("obj_model_block", OBJ_MODEL_BLOCK);
        register("facing_obj_model_block", FACING_OBJ_MODEL_BLOCK);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(ct -> {
            ct.accept(OBJ_MODEL_BLOCK);
            ct.accept(FACING_OBJ_MODEL_BLOCK);
        });
    }

    public static void register(String name, Block block) {
        Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(SMLExample.MODID, name), block);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SMLExample.MODID, name), new BlockItem(block, new FabricItemSettings()));
    }
}
