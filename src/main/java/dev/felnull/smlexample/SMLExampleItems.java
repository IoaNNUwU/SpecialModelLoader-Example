package dev.felnull.smlexample;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class SMLExampleItems {
    public static final Item OBJ_MODEL_ITEM = new Item(new Item.Properties());
    public static final Item OBJ_MODEL_ITEM2 = new Item(new Item.Properties());
    public static final Item CUSTOM_MODEL_DATA_OBJ_MODEL_ITEM = new Item(new Item.Properties());
    public static final Item NEO_FORGE_COMPAT_MODEL_ITEM = new Item(new Item.Properties());

    public static void init() {
        register("obj_model_item", OBJ_MODEL_ITEM);
        register("obj_model_item2", OBJ_MODEL_ITEM2);
        register("custom_model_data_obj_model_item", CUSTOM_MODEL_DATA_OBJ_MODEL_ITEM);
        register("neo_forge_compat_model_item", NEO_FORGE_COMPAT_MODEL_ITEM);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(ct -> {
            ct.accept(OBJ_MODEL_ITEM);
            ct.accept(OBJ_MODEL_ITEM2);

            ct.accept(CUSTOM_MODEL_DATA_OBJ_MODEL_ITEM);

            ItemStack customModelDataItem = new ItemStack(CUSTOM_MODEL_DATA_OBJ_MODEL_ITEM);
            customModelDataItem.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(1));
            ct.accept(customModelDataItem);

            ct.accept(NEO_FORGE_COMPAT_MODEL_ITEM);
        });
    }

    private static void register(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, name), item);
    }
}
