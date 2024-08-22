package smartin.bc_nbt_fix.mixin;

import net.bettercombat.api.AttributesContainer;
import net.bettercombat.logic.WeaponRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(WeaponRegistry.class)
public interface WeaponRegistryAccessor {
    @Accessor
    static Map<ResourceLocation, AttributesContainer> getContainers() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static void setContainers(Map<ResourceLocation, AttributesContainer> containers) {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static FriendlyByteBuf getEncodedRegistrations() {
        throw new UnsupportedOperationException();
    }
}
