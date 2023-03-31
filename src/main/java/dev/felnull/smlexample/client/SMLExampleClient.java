package dev.felnull.smlexample.client;

import dev.felnull.smlexample.SMLExample;
import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.fabricmc.api.ClientModInitializer;

public class SMLExampleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //Without this code, special models will not be loaded!
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> SMLExample.MODID.equals(location.getNamespace()));
    }
}
