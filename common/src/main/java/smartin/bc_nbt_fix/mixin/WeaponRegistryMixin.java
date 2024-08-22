package smartin.bc_nbt_fix.mixin;

import net.bettercombat.logic.WeaponRegistry;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import smartin.bc_nbt_fix.SyncPacket;

@Mixin(WeaponRegistry.class)
public abstract class WeaponRegistryMixin {

    @Inject(method = "encodeRegistry", at = @At(value = "TAIL"), remap = false)
    private static void bc$add_packet_data_encode(CallbackInfo ci) {
        SyncPacket.appendBufferData(WeaponRegistryAccessor.getEncodedRegistrations());
    }

    @Inject(method = "decodeRegistry", at = @At(value = "TAIL"), remap = false)
    private static void bc$add_packet_data_decode(FriendlyByteBuf buf,CallbackInfo ci) {
        SyncPacket.decodeRegistry(buf);
    }}
