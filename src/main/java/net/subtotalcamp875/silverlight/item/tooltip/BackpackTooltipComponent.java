package net.subtotalcamp875.silverlight.item.tooltip;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.component.type.BackpackContentsComponent;

@Environment(EnvType.CLIENT)
public class BackpackTooltipComponent implements TooltipComponent {
    private static final Identifier BACKGROUND_TEXTURE = Identifier.of(SilverLight.MOD_ID, "textures/gui/tooltip_background.png");
    private static final Identifier SLOT_TEXTURE = Identifier.ofVanilla("container/slot");
    private static final int WIDTH_PER_COLUMN = 18;
    private static final int HEIGHT_PER_ROW = 18;
    private final BackpackContentsComponent backpackContents;
    private static final int BACKGROUND_WIDTH = 176;
    private static final int BACKGROUND_HEIGHT = 68;

    public BackpackTooltipComponent(BackpackContentsComponent backpackContents) {
        this.backpackContents = backpackContents;
    }

    @Override
    public int getHeight() {
        return BACKGROUND_HEIGHT + 4;
    }

    @Override
    public int getWidth(TextRenderer textRenderer) {
        return BACKGROUND_WIDTH;
    }

    @Override
    public void drawItems(TextRenderer textRenderer, int x, int y, DrawContext context) {
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        // context.drawGuiTexture(BACKGROUND_TEXTURE, x, y, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        int slotIndex = 0;

        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                int slotX = x + columnIndex * WIDTH_PER_COLUMN + 7;
                int slotY = y + rowIndex * HEIGHT_PER_ROW + 7;
                this.drawSlot(slotX, slotY, slotIndex++, context, textRenderer);
            }
        }
    }

    private void drawSlot(int x, int y, int index, DrawContext context, TextRenderer textRenderer) {
        ItemStack itemStack = this.backpackContents.stacks.get(index);
        context.drawGuiTexture(SLOT_TEXTURE, x, y, 0, 18, 18);
        context.drawItem(itemStack, x + 1, y + 1, index);
        context.drawItemInSlot(textRenderer, itemStack, x + 1, y + 1);
    }
}
