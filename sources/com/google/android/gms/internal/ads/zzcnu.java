package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnu implements Callable {
    private final CookieManager zzgqk;

    zzcnu(CookieManager cookieManager) {
        this.zzgqk = cookieManager;
    }

    public final Object call() {
        CookieManager cookieManager = this.zzgqk;
        if (cookieManager == null) {
            return "";
        }
        return cookieManager.getCookie((String) zzww.zzra().zzd(zzabq.zzcpu));
    }
}
