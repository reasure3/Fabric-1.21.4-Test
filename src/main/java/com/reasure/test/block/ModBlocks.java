package com.reasure.test.block;

import com.reasure.test.Test;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block CONDENSED_DIRT = registerSimpleBlock("condensed_dirt", AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS));

    public static <T extends Block> T register(String name, boolean shouldRegisterItem, Block.Settings settings, Function<Block.Settings, T> block) {
        Identifier id = Identifier.of(Test.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        T registerBlock = block.apply(settings.registryKey(key));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
            BlockItem blockItem = new BlockItem(registerBlock, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, key, registerBlock);
    }

    public static Block registerSimpleBlock(String name, Block.Settings settings) {
        return register(name, true, settings, Block::new);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(itemGroup ->
                        itemGroup.add(ModBlocks.CONDENSED_DIRT)
                );
    }
}