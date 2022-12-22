package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbw implements zzesa<zzcbx> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<Context> zzeyq;
    private final zzesn<View> zzfub;
    private final zzesn<zzuh.zza.C22026zza> zzfvk;
    private final zzesn<zzaya> zzfyk;

    private zzcbw(zzesn<zzaya> zzesn, zzesn<Context> zzesn2, zzesn<zzayd> zzesn3, zzesn<View> zzesn4, zzesn<zzuh.zza.C22026zza> zzesn5) {
        this.zzfyk = zzesn;
        this.zzeyq = zzesn2;
        this.zzecg = zzesn3;
        this.zzfub = zzesn4;
        this.zzfvk = zzesn5;
    }

    public static zzcbw zzd(zzesn<zzaya> zzesn, zzesn<Context> zzesn2, zzesn<zzayd> zzesn3, zzesn<View> zzesn4, zzesn<zzuh.zza.C22026zza> zzesn5) {
        return new zzcbw(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        return new zzcbx(this.zzfyk.get(), this.zzeyq.get(), this.zzecg.get(), this.zzfub.get(), this.zzfvk.get());
    }
}
