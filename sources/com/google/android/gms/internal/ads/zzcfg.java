package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcfg implements ViewTreeObserver.OnScrollChangedListener {
    private final String zzdmx;
    private final View zzgjh;
    private final zzbfi zzgji;
    private final WindowManager.LayoutParams zzgjj;
    private final int zzgjk;
    private final WindowManager zzgjl;

    zzcfg(View view, zzbfi zzbfi, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.zzgjh = view;
        this.zzgji = zzbfi;
        this.zzdmx = str;
        this.zzgjj = layoutParams;
        this.zzgjk = i;
        this.zzgjl = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zzgjh;
        zzbfi zzbfi = this.zzgji;
        String str = this.zzdmx;
        WindowManager.LayoutParams layoutParams = this.zzgjj;
        int i = this.zzgjk;
        WindowManager windowManager = this.zzgjl;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzbfi.getView().getWindowToken() != null) {
            if ("1".equals(str) || "2".equals(str)) {
                layoutParams.y = rect.bottom - i;
            } else {
                layoutParams.y = rect.top - i;
            }
            windowManager.updateViewLayout(zzbfi.getView(), layoutParams);
        }
    }
}
