package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbm implements zzaz {
    private final /* synthetic */ Context val$appContext;
    private File zzdb = null;

    zzbm(Context context) {
        this.val$appContext = context;
    }

    public final File zzo() {
        if (this.zzdb == null) {
            this.zzdb = new File(this.val$appContext.getCacheDir(), "volley");
        }
        return this.zzdb;
    }
}
