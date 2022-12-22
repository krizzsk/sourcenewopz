package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcxo implements zzbzy {
    private final /* synthetic */ zzdot zzgyd;
    private final /* synthetic */ zzdpi zzgyq;
    private final /* synthetic */ zzctb zzgyr;
    final /* synthetic */ zzcxm zzgys;

    zzcxo(zzcxm zzcxm, zzdpi zzdpi, zzdot zzdot, zzctb zzctb) {
        this.zzgys = zzcxm;
        this.zzgyq = zzdpi;
        this.zzgyd = zzdot;
        this.zzgyr = zzctb;
    }

    public final void onInitializationSucceeded() {
        this.zzgys.zzfur.execute(new zzcxr(this, this.zzgyq, this.zzgyd, this.zzgyr));
    }

    public final void zzeg(int i) {
        String valueOf = String.valueOf(this.zzgyr.zzcja);
        zzd.zzez(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
