package io.github.coolcrabs.augmentedautojump.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import io.github.coolcrabs.augmentedautojump.AugmentedAutojump;
import net.minecraft.client.player.LocalPlayer;

@Mixin(LocalPlayer.class)
public abstract class ClientPlayerEntityMixin {
    @Shadow
    private int autoJumpTime;

    @Shadow
    protected abstract boolean canAutoJump();

    @Overwrite
    public void updateAutoJump(float dx, float dz) {
        if (canAutoJump()) autoJumpTime = AugmentedAutojump.autojumpPlayer((LocalPlayer)(Object)this, dx, dz) ? 1 : 0;
    }
}
