package net.subtotalcamp875.silverlight.block.entity.custom;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record SievingStationData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, SievingStationData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, SievingStationData::pos, SievingStationData::new);
}
