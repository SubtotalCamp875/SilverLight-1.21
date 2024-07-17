package net.subtotalcamp875.silverlight.block.entity;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record DragonProcessingStationData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, DragonProcessingStationData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, DragonProcessingStationData::pos, DragonProcessingStationData::new);
}
