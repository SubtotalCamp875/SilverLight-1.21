package net.subtotalcamp875.silverlight.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;

public class EnergyGeneratorScreen extends HandledScreen<EnergyGeneratorScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(SilverLight.MOD_ID, "textures/gui/energy_generator_gui.png");

    public EnergyGeneratorScreen(EnergyGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
        renderCharge(context, x, y);
    }


    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 22, y + 38, 176, 0, 8,
                    handler.getScaledProgress());
        }
    }

    private void renderCharge(DrawContext context, int x, int y) {
        context.drawTexture(TEXTURE, x + 60, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge1());
        context.drawTexture(TEXTURE, x + 72, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge2());
        context.drawTexture(TEXTURE, x + 84, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge3());
        context.drawTexture(TEXTURE, x + 96, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge4());
        context.drawTexture(TEXTURE, x + 108, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge5());
        context.drawTexture(TEXTURE, x + 120, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge6());
        context.drawTexture(TEXTURE, x + 132, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge7());
        context.drawTexture(TEXTURE, x + 144, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge8());
        context.drawTexture(TEXTURE, x + 156, y + 9, 176, 20, 12,
                68 - handler.getScaledCharge9());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
