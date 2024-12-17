package com.reasure.test;

import com.reasure.test.block.ModBlocks;
import com.reasure.test.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test implements ModInitializer {

    public static final String MOD_ID = "test";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
    }
}
