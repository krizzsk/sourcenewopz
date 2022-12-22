package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxw implements zzesa<Set<zzbzl<zzp>>> {
    private final zzbxr zzgdc;

    private zzbxw(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbxw zzi(zzbxr zzbxr) {
        return new zzbxw(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzand());
    }
}
