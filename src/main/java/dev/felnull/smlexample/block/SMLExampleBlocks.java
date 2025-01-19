package dev.felnull.smlexample.block;

import dev.felnull.smlexample.SMLExample;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class SMLExampleBlocks {
    public static final Block OBJ_MODEL_BLOCK = register("obj_model_block", OBJBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL));
    public static final Block FACING_OBJ_MODEL_BLOCK = register("facing_obj_model_block", FacingOBJBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL));

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(ct -> {
            ct.accept(OBJ_MODEL_BLOCK);
            ct.accept(FACING_OBJ_MODEL_BLOCK);
        });
    }

    public static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> resKey = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, name));
        Block block = Blocks.register(resKey, factory, properties);
        Items.registerBlock(block);
        return block;
    }
}
