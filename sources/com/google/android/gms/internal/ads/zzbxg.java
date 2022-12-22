package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxg implements zzesa<zzbxe> {
    private final zzesn<Set<zzbzl<AppEventListener>>> zzfxl;

    private zzbxg(zzesn<Set<zzbzl<AppEventListener>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbxg zzr(zzesn<Set<zzbzl<AppEventListener>>> zzesn) {
        return new zzbxg(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbxe(this.zzfxl.get());
    }
}
