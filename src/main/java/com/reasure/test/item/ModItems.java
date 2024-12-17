package com.reasure.test.item;

import com.reasure.test.Test;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item SUSPICIOUS_SUBSTANCE = registerSimpleItem("suspicious_substance", new Item.Settings());

    public static <T extends Item> T register(String name, Item.Settings settings, Function<Item.Settings, T> item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Test.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, item.apply(settings.registryKey(key)));
    }

    public static Item registerSimpleItem(String name, Item.Settings settings) {
        return register(name, settings, Item::new);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(itemGroup ->
                        itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE)
                );
    }
}