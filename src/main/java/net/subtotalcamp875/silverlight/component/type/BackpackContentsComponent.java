package net.subtotalcamp875.silverlight.component.type;

import com.mojang.serialization.Codec;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.collection.DefaultedList;

import java.util.List;

public final class BackpackContentsComponent implements TooltipData {
	public static final Codec<BackpackContentsComponent> CODEC = ItemStack.OPTIONAL_CODEC.listOf(27, 27).xmap(BackpackContentsComponent::new, component -> component.stacks);
	public static final PacketCodec<RegistryByteBuf, BackpackContentsComponent> PACKET_CODEC = ItemStack.OPTIONAL_PACKET_CODEC
		.collect(PacketCodecs.toList(27))
		.xmap(BackpackContentsComponent::new, component -> component.stacks);
	public final List<ItemStack> stacks;

	public BackpackContentsComponent(List<ItemStack> stacks) {
		this.stacks = stacks;
	}

	public BackpackContentsComponent() {
		this(List.copyOf(DefaultedList.ofSize(27, ItemStack.EMPTY)));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
//		return o instanceof BackpackContentsComponent backpackContentsComponent && collectionsEqual(this.stacks, backpackContentsComponent.stacks, ItemStack::areEqual);
        return o instanceof BackpackContentsComponent backpackContentsComponent && ItemStack.stacksEqual(this.stacks, backpackContentsComponent.stacks);
    }

//	private static <T, U> boolean collectionsEqual(SequencedCollection<T> collection1, SequencedCollection<U> collection2, BiFunction<T, U, Boolean> areEqualFunction) {
//		if (collection1.size() != collection2.size()) return false;
//		Iterator<U> iterator = collection2.iterator();
//		return collection1.stream().allMatch(t -> areEqualFunction.apply(t, iterator.next()));
//	}

	@Override
	public int hashCode() {
		return ItemStack.listHashCode(this.stacks);
	}

	@Override
	public String toString() {
		return "BackpackContents" + this.stacks;
	}

}
