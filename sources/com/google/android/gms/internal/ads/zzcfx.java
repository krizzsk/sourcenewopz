package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcfx implements zzesa<zzbzl<VideoController.VideoLifecycleCallbacks>> {
    private final zzesn<zzcil> zzeyk;
    private final zzesn<Executor> zzfxf;
    private final zzcfo zzgjs;

    public zzcfx(zzcfo zzcfo, zzesn<zzcil> zzesn, zzesn<Executor> zzesn2) {
        this.zzgjs = zzcfo;
        this.zzeyk = zzesn;
        this.zzfxf = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzfxf.get()));
    }
}
