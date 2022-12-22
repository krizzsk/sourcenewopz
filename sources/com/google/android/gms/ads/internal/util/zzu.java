package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzu implements Callable {
    private final Context zzdbt;
    private final WebSettings zzegz;

    zzu(Context context, WebSettings webSettings) {
        this.zzdbt = context;
        this.zzegz = webSettings;
    }

    public final Object call() {
        Context context = this.zzdbt;
        WebSettings webSettings = this.zzegz;
        if (context.getCacheDir() != null) {
            webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowContentAccess(false);
        return true;
    }
}
