package com.didi.payment.wallet_ui;

import android.view.animation.Animation;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/wallet_ui/WalletToast$Companion$getEnterAnim$1$5", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletToast.kt */
public final class WalletToast$Companion$getEnterAnim$1$5 implements Animation.AnimationListener {
    final /* synthetic */ WeakReference<Toast> $toastRef;

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    WalletToast$Companion$getEnterAnim$1$5(WeakReference<Toast> weakReference) {
        this.$toastRef = weakReference;
    }

    public void onAnimationEnd(Animation animation) {
        Toast toast = (Toast) this.$toastRef.get();
        if (toast != null) {
            toast.cancel();
        }
    }
}
