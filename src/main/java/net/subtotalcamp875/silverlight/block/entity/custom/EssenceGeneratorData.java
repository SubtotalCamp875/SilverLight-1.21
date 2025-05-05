package net.subtotalcamp875.silverlight.block.entity.custom;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record EssenceGeneratorData(BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, EssenceGeneratorData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, EssenceGeneratorData::pos, EssenceGeneratorData::new);
}
