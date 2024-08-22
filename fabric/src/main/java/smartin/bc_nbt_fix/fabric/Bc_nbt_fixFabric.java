package smartin.bc_nbt_fix.fabric;

import smartin.bc_nbt_fix.Bc_nbt_fix;
import net.fabricmc.api.ModInitializer;

public class Bc_nbt_fixFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Bc_nbt_fix.init();
    }
}