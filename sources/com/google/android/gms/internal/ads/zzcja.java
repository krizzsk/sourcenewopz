package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcja {
    private final Context context;
    private final zzbar zzbpx;
    private final zzbfq zzbqk;
    private final zztz zzesy;
    private final zzei zzeus;
    private final zzacv zzeut;
    private final zzb zzeuv;
    /* access modifiers changed from: private */
    public final zzbve zzgmh;

    public zzcja(zzbfq zzbfq, Context context2, zzei zzei, zzacv zzacv, zzbar zzbar, zzb zzb, zztz zztz, zzbve zzbve) {
        this.zzbqk = zzbfq;
        this.context = context2;
        this.zzeus = zzei;
        this.zzeut = zzacv;
        this.zzbpx = zzbar;
        this.zzeuv = zzb;
        this.zzesy = zztz;
        this.zzgmh = zzbve;
    }

    public final zzbfi zze(zzvt zzvt) throws zzbfu {
        return zza(zzvt, (zzdot) null, (zzdoy) null);
    }

    public final zzbfi zza(zzvt zzvt, zzdot zzdot, zzdoy zzdoy) throws zzbfu {
        return zzbfq.zza(this.context, zzbgx.zzb(zzvt), zzvt.zzadd, false, false, this.zzeus, this.zzeut, this.zzbpx, (zzach) null, new zzcjd(this), this.zzeuv, this.zzesy, zzdot, zzdoy);
    }
}
