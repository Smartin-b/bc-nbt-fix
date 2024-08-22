package smartin.bc_nbt_fix;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.bettercombat.api.AttributesContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import smartin.bc_nbt_fix.mixin.WeaponRegistryAccessor;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncPacket {
    public static void decodeRegistry(FriendlyByteBuf buffer) {

        var totalChunkCount = buffer.readInt();

        StringBuilder jsonBuilder = new StringBuilder();

        for (int i = 0; i < totalChunkCount; ++i) {
            jsonBuilder.append(buffer.readUtf());
        }
        var gson = new Gson();
        Type attributeContainerType = new TypeToken<Map<String, AttributesContainer>>() {
        }.getType();

        Map<String, AttributesContainer> readAttributes = gson.fromJson(jsonBuilder.toString(), attributeContainerType);
        Map<ResourceLocation, AttributesContainer> newAttributes = new HashMap();
        readAttributes.forEach((key, value) -> {
            newAttributes.put(new ResourceLocation(key), value);
        });
        WeaponRegistryAccessor.setContainers(newAttributes);
    }

    public static void appendBufferData(FriendlyByteBuf buffer) {
        var gson = new Gson();

        var json = gson.toJson(WeaponRegistryAccessor.getContainers());

        List<String> chunks = new ArrayList<>();
        var chunkSize = 10000;
        for (int i = 0; i < json.length(); i += chunkSize) {
            chunks.add(json.substring(i, Math.min(json.length(), i + chunkSize)));
        }

        buffer.writeInt(chunks.size());
        for (var chunk : chunks) {
            buffer.writeUtf(chunk);
        }
    }
}
