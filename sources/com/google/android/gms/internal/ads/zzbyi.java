package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyi implements zzesa<Set<zzbzl<AppEventListener>>> {
    private final zzbxr zzgdc;

    private zzbyi(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyi zzw(zzbxr zzbxr) {
        return new zzbyi(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamx());
    }
}
