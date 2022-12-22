package com.didi.payment.wallet_ui.keyboard.system;

import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/keyboard/system/RootViewDeferringInsetsCallback;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "dispatchMode", "", "keyboardListener", "Lcom/didi/payment/wallet_ui/keyboard/system/SystemKeyboardListener;", "(ILcom/didi/payment/wallet_ui/keyboard/system/SystemKeyboardListener;)V", "deferredInsets", "", "onEnd", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onPrepare", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RootViewDeferringInsetsCallback.kt */
public final class RootViewDeferringInsetsCallback extends WindowInsetsAnimationCompat.Callback {

    /* renamed from: a */
    private final SystemKeyboardListener f33008a;

    /* renamed from: b */
    private boolean f33009b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RootViewDeferringInsetsCallback(int i, SystemKeyboardListener systemKeyboardListener) {
        super(i);
        Intrinsics.checkNotNullParameter(systemKeyboardListener, "keyboardListener");
        this.f33008a = systemKeyboardListener;
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationCompat, "animation");
        if ((windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
            this.f33009b = true;
            this.f33008a.onKeyBoardAnimStart();
        }
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Intrinsics.checkNotNullParameter(list, "runningAnimations");
        if (this.f33009b) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
            Intrinsics.checkNotNullExpressionValue(insets, "insets.getInsets(WindowInsetsCompat.Type.ime())");
            Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(WindowI…Compat.Type.systemBars())");
            Insets subtract = Insets.subtract(insets, insets2);
            Intrinsics.checkNotNullExpressionValue(subtract, "subtract(typesInset, otherInset)");
            Insets max = Insets.max(subtract, Insets.NONE);
            Intrinsics.checkNotNullExpressionValue(max, "max(subtract, Insets.NONE)");
            this.f33008a.onKeyBoardHeightChange(max.bottom);
        }
        return windowInsetsCompat;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationCompat, "animation");
        if (this.f33009b && (windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
            this.f33009b = false;
            this.f33008a.onKeyBoardAnimEnd();
        }
    }
}
