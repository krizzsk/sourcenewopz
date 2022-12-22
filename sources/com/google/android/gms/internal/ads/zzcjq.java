package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcjq {
    private Context context;
    private PopupWindow zzgmr;

    public final void zzc(Context context2, View view) {
        if (PlatformVersion.isAtLeastKitKat() && !PlatformVersion.isAtLeastLollipop()) {
            PopupWindow zzd = zzd(context2, view);
            this.zzgmr = zzd;
            if (zzd == null) {
                context2 = null;
            }
            this.context = context2;
        }
    }

    public final void zzaql() {
        Context context2 = this.context;
        if (context2 != null && this.zzgmr != null) {
            if (!(context2 instanceof Activity) || !((Activity) context2).isDestroyed()) {
                if (this.zzgmr.isShowing()) {
                    this.zzgmr.dismiss();
                }
                this.context = null;
                this.zzgmr = null;
                return;
            }
            this.context = null;
            this.zzgmr = null;
        }
    }

    private static PopupWindow zzd(Context context2, View view) {
        Window window = context2 instanceof Activity ? ((Activity) context2).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context2).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context2);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow(frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzd.zzdz("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }
}
