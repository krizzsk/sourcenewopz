package com.didi.payment.wallet_ui.keyboard.system;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/keyboard/system/SystemKeyboardUtils;", "", "()V", "Companion", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SystemKeyboardUtils.kt */
public final class SystemKeyboardUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/keyboard/system/SystemKeyboardUtils$Companion;", "", "()V", "setSystemKeyboardListener", "", "decorView", "Landroid/view/View;", "keyBoardListener", "Lcom/didi/payment/wallet_ui/keyboard/system/SystemKeyboardListener;", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SystemKeyboardUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setSystemKeyboardListener(View view, SystemKeyboardListener systemKeyboardListener) {
            if (view != null && systemKeyboardListener != null) {
                ViewCompat.setWindowInsetsAnimationCallback(view, new RootViewDeferringInsetsCallback(1, systemKeyboardListener));
            }
        }
    }
}
