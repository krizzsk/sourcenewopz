package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbfp implements zzear {
    private final Context zzdbt;
    private final zzei zzdkw;
    private final zzbar zzetv;
    private final zzb zzetw;
    private final String zzetx;

    zzbfp(Context context, zzei zzei, zzbar zzbar, zzb zzb, String str) {
        this.zzdbt = context;
        this.zzdkw = zzei;
        this.zzetv = zzbar;
        this.zzetw = zzb;
        this.zzetx = str;
    }

    public final zzebt zzf(Object obj) {
        Context context = this.zzdbt;
        zzei zzei = this.zzdkw;
        zzbar zzbar = this.zzetv;
        zzb zzb = this.zzetw;
        String str = this.zzetx;
        zzr.zzkw();
        zzbfi zza = zzbfq.zza(context, zzbgx.zzafg(), "", false, false, zzei, (zzacv) null, zzbar, (zzach) null, (zzm) null, zzb, zztz.zznl(), (zzdot) null, (zzdoy) null);
        zzbbb zzk = zzbbb.zzk(zza);
        zza.zzaef().zza((zzbgt) new zzbfr(zzk));
        zza.loadUrl(str);
        return zzk;
    }
}
