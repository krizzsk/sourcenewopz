package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzauq {
    /* access modifiers changed from: private */
    public WeakHashMap<Context, zzaus> zzeaf = new WeakHashMap<>();

    public final Future<zzauo> zzr(Context context) {
        return zzbat.zzeke.zze(new zzaut(this, context));
    }
}
