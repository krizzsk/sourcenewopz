package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzrl extends zzxx {
    private final AppEventListener zzbtf;

    public zzrl(AppEventListener appEventListener) {
        this.zzbtf = appEventListener;
    }

    public final void onAppEvent(String str, String str2) {
        this.zzbtf.onAppEvent(str, str2);
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbtf;
    }
}
