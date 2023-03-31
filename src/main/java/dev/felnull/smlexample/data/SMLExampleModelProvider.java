package dev.felnull.smlexample.data;

import dev.felnull.smlexample.SMLExample;
import dev.felnull.smlexample.SMLExampleItems;
import dev.felnull.smlexample.block.SMLExampleBlocks;
import dev.felnull.specialmodelloader.api.data.SpecialModelDataGenHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;

public class SMLExampleModelProvider extends FabricModelProvider {
    public SMLExampleModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        SpecialModelDataGenHelper.generateObjModel(SMLExampleBlocks.OBJ_MODEL_BLOCK,
                new ResourceLocation(SMLExample.MODID, "models/block/block_obj.obj"),
                true,
                false,
                null,
                blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(blockStateModelGenerator.createSimpleBlock(SMLExampleBlocks.OBJ_MODEL_BLOCK, ModelLocationUtils.getModelLocation(SMLExampleBlocks.OBJ_MODEL_BLOCK)));


        SpecialModelDataGenHelper.generateObjModel(SMLExampleBlocks.FACING_OBJ_MODEL_BLOCK,
                new ResourceLocation(SMLExample.MODID, "models/block/facing_block_obj.obj"),
                true,
                false,
                null,
                blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(SMLExampleBlocks.FACING_OBJ_MODEL_BLOCK, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(SMLExampleBlocks.FACING_OBJ_MODEL_BLOCK)))
                .with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        SpecialModelDataGenHelper.generateObjModel(SMLExampleItems.OBJ_MODEL_ITEM2,
                new ResourceLocation(SMLExample.MODID, "models/item/obj2.obj"),
                true,
                false,
                null,
                itemModelGenerator.output);
    }
}
