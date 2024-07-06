package net.subtotalcamp875.silverlight.item.tooltip;

import net.minecraft.item.tooltip.TooltipData;
import net.subtotalcamp875.silverlight.component.type.BackpackContentsComponent;

public record BackpackTooltipData(BackpackContentsComponent contents) implements TooltipData {
}
