package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbye implements zzesa<Set<zzbzl<AdMetadataListener>>> {
    private final zzbxr zzgdc;

    private zzbye(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbye zzr(zzbxr zzbxr) {
        return new zzbye(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamw());
    }
}
