package dev.felnull.smlexample;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomModelData;

import java.util.function.Function;

public class SMLExampleItems {
    public static final Item OBJ_MODEL_ITEM = register("obj_model_item", Item::new, new Item.Properties());
    public static final Item OBJ_MODEL_ITEM2 = register("obj_model_item2", Item::new, new Item.Properties());
    public static final Item NEO_FORGE_COMPAT_MODEL_ITEM = register("neo_forge_compat_model_item", Item::new, new Item.Properties());

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(ct -> {
            ct.accept(OBJ_MODEL_ITEM);
            ct.accept(OBJ_MODEL_ITEM2);

            ct.accept(NEO_FORGE_COMPAT_MODEL_ITEM);
        });
    }

    public static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        ResourceKey<Item> resKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SMLExample.MODID, name));
        return Items.registerItem(resKey, factory, properties);
    }
}
