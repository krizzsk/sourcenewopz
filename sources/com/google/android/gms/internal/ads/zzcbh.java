package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbh implements zzp {
    private final zzbur zzgds;
    private final zzbzh zzgdt;

    public zzcbh(zzbur zzbur, zzbzh zzbzh) {
        this.zzgds = zzbur;
        this.zzgdt = zzbzh;
    }

    public final void zza(zzl zzl) {
        this.zzgds.zza(zzl);
        this.zzgdt.onHide();
    }

    public final void onPause() {
        this.zzgds.onPause();
    }

    public final void onResume() {
        this.zzgds.onResume();
    }

    public final void zzvz() {
        this.zzgds.zzvz();
        this.zzgdt.zzanj();
    }

    public final void onUserLeaveHint() {
        this.zzgds.onUserLeaveHint();
    }
}
