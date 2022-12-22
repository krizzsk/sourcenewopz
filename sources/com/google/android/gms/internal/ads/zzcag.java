package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcag implements zzesa<zzcaa> {
    private final zzesn<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> zzfxl;

    private zzcag(zzesn<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzcag zzv(zzesn<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> zzesn) {
        return new zzcag(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzcaa(this.zzfxl.get());
    }
}
