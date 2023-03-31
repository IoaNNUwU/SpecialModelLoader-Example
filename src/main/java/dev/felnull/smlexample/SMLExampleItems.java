package dev.felnull.smlexample;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class SMLExampleItems {
    public static final Item OBJ_MODEL_ITEM = new Item(new FabricItemSettings());
    public static final Item OBJ_MODEL_ITEM2 = new Item(new FabricItemSettings());

    public static void init() {
        register("obj_model_item", OBJ_MODEL_ITEM);
        register("obj_model_item2", OBJ_MODEL_ITEM2);

        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, entries) -> {
            if (group == CreativeModeTabs.BUILDING_BLOCKS) {
                entries.accept(OBJ_MODEL_ITEM);
                entries.accept(OBJ_MODEL_ITEM2);
            }
        });
    }

    private static void register(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SMLExample.MODID, name), item);
    }
}
