package dev.felnull.smlexample.data;

import com.google.common.collect.ImmutableMap;
import dev.felnull.smlexample.SMLExample;
import dev.felnull.smlexample.SMLExampleItems;
import dev.felnull.smlexample.block.SMLExampleBlocks;
import dev.felnull.specialmodelloader.api.data.SpecialModelDataGenHelper;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;

public class SMLExampleModelProvider extends FabricModelProvider {
    public SMLExampleModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        SpecialModelDataGenHelper.generateObjModel(SMLExampleBlocks.OBJ_MODEL_BLOCK,
                ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, "models/block/block_obj.obj"),
                true,
                false,
                null,
                ImmutableMap.of(),
                null,
                blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(SMLExampleBlocks.OBJ_MODEL_BLOCK, ModelLocationUtils.getModelLocation(SMLExampleBlocks.OBJ_MODEL_BLOCK)));


        SpecialModelDataGenHelper.generateObjModel(SMLExampleBlocks.FACING_OBJ_MODEL_BLOCK,
                ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, "models/block/facing_block_obj.obj"),
                true,
                false,
                null,
                ImmutableMap.of(),
                null,
                blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(SMLExampleBlocks.FACING_OBJ_MODEL_BLOCK, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(SMLExampleBlocks.FACING_OBJ_MODEL_BLOCK)))
                .with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        SpecialModelDataGenHelper.generateObjModel(SMLExampleItems.OBJ_MODEL_ITEM2,
                ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, "models/item/obj2.obj"),
                true,
                false,
                null,
                ImmutableMap.of(),
                null,
                itemModelGenerator.modelOutput);
        itemModelGenerator.itemModelOutput.accept(SMLExampleItems.OBJ_MODEL_ITEM2,
                ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(SMLExampleItems.OBJ_MODEL_ITEM2)));
    }
}
