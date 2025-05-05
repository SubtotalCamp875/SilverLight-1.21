package net.subtotalcamp875.silverlight.block.entity.custom;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record FermentingStationData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, FermentingStationData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, FermentingStationData::pos, FermentingStationData::new);
}
