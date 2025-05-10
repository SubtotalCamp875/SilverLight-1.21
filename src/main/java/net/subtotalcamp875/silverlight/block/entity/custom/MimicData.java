package net.subtotalcamp875.silverlight.block.entity.custom;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record MimicData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, MimicData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, MimicData::pos, MimicData::new);
}
