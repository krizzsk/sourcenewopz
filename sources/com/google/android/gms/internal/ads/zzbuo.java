package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbuo implements zzesa<zzbum> {
    private final zzesn<Set<zzbzl<AdMetadataListener>>> zzfxl;

    private zzbuo(zzesn<Set<zzbzl<AdMetadataListener>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbuo zzm(zzesn<Set<zzbzl<AdMetadataListener>>> zzesn) {
        return new zzbuo(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbum(this.zzfxl.get());
    }
}
