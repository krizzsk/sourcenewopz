package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzact;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzo implements zzact {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Uri val$uri;
    private final /* synthetic */ zzacq zzegx;

    zzo(zzj zzj, zzacq zzacq, Context context, Uri uri) {
        this.zzegx = zzacq;
        this.val$context = context;
        this.val$uri = uri;
    }

    public final void zztc() {
    }

    public final void zztb() {
        new CustomTabsIntent.Builder(this.zzegx.zzsz()).build().launchUrl(this.val$context, this.val$uri);
        this.zzegx.zzc((Activity) this.val$context);
    }
}
