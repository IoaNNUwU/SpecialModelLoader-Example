package dev.felnull.smlexample.block;

import dev.felnull.smlexample.SMLExample;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SMLExampleBlocks {
    public static final Block OBJ_MODEL_BLOCK = new OBJBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL));
    public static final Block FACING_OBJ_MODEL_BLOCK = new FacingOBJBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL));

    public static void init() {
        register("obj_model_block", OBJ_MODEL_BLOCK);
        register("facing_obj_model_block", FACING_OBJ_MODEL_BLOCK);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(ct -> {
            ct.accept(OBJ_MODEL_BLOCK);
            ct.accept(FACING_OBJ_MODEL_BLOCK);
        });
    }

    public static void register(String name, Block block) {
        Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, name), block);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, name), new BlockItem(block, new Item.Properties()));
    }
}
