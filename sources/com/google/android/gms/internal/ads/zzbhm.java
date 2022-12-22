package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbhm implements zzesa<WeakReference<Context>> {
    private final zzbhg zzeyi;

    public zzbhm(zzbhg zzbhg) {
        this.zzeyi = zzbhg;
    }

    public final /* synthetic */ Object get() {
        return (WeakReference) zzesg.zzbd(this.zzeyi.zzafq());
    }
}
