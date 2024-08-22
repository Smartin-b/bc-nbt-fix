package smartin.bc_nbt_fix.forge;

import smartin.bc_nbt_fix.Bc_nbt_fix;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Bc_nbt_fix.MOD_ID)
public class Bc_nbt_fixForge {
    public Bc_nbt_fixForge() {
        Bc_nbt_fix.init();
    }
}