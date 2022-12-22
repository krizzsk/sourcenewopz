package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdbe implements Callable {
    private final zzdbf zzhch;
    private final List zzhci;
    private final IObjectWrapper zzhcj;

    zzdbe(zzdbf zzdbf, List list, IObjectWrapper iObjectWrapper) {
        this.zzhch = zzdbf;
        this.zzhci = list;
        this.zzhcj = iObjectWrapper;
    }

    public final Object call() {
        return this.zzhch.zza(this.zzhci, this.zzhcj);
    }
}
