package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdbg implements Callable {
    private final Uri zzgws;
    private final zzdbf zzhch;
    private final IObjectWrapper zzhcj;

    zzdbg(zzdbf zzdbf, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zzhch = zzdbf;
        this.zzgws = uri;
        this.zzhcj = iObjectWrapper;
    }

    public final Object call() {
        return this.zzhch.zzb(this.zzgws, this.zzhcj);
    }
}
