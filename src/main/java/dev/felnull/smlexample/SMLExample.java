package dev.felnull.smlexample;

import dev.felnull.smlexample.block.SMLExampleBlocks;
import net.fabricmc.api.ModInitializer;

public class SMLExample implements ModInitializer {
    public static final String MODID = "smlexample";

    @Override
    public void onInitialize() {
        SMLExampleItems.init();
        SMLExampleBlocks.init();
    }
}
