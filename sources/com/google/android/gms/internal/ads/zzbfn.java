package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfn implements zzp {
    private zzp zzduf;
    private zzbfi zzets;

    public zzbfn(zzbfi zzbfi, zzp zzp) {
        this.zzets = zzbfi;
        this.zzduf = zzp;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zzvz() {
        zzp zzp = this.zzduf;
        if (zzp != null) {
            zzp.zzvz();
        }
        this.zzets.zzwm();
    }

    public final void zza(zzl zzl) {
        zzp zzp = this.zzduf;
        if (zzp != null) {
            zzp.zza(zzl);
        }
        this.zzets.zzady();
    }

    public final void onUserLeaveHint() {
        zzp zzp = this.zzduf;
        if (zzp != null) {
            zzp.onUserLeaveHint();
        }
    }
}
