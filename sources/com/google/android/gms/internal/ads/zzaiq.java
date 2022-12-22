package com.google.android.gms.internal.ads;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.android.gms.ads.internal.overlay.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaiq implements zzv {
    private boolean zzdjm = false;
    private final /* synthetic */ Map zzdjn;
    private final /* synthetic */ Map zzdjo;
    private final /* synthetic */ zzve zzdjp;

    zzaiq(zzaio zzaio, Map map, Map map2, zzve zzve) {
        this.zzdjn = map;
        this.zzdjo = map2;
        this.zzdjp = zzve;
    }

    public final void zzb(zzacs zzacs) {
    }

    public final void zzaf(boolean z) {
        if (!this.zzdjm) {
            this.zzdjm = true;
            this.zzdjn.put((String) this.zzdjo.get(ParamKeys.PARAM_EVENT_ID), Boolean.valueOf(z));
            ((zzakr) this.zzdjp).zza("openIntentAsync", (Map<String, ?>) this.zzdjn);
        }
    }
}
