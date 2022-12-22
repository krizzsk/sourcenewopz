package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaaq extends zzza {
    private final OnPaidEventListener zzcmc;

    public zzaaq(OnPaidEventListener onPaidEventListener) {
        this.zzcmc = onPaidEventListener;
    }

    public final void zza(zzvv zzvv) {
        if (this.zzcmc != null) {
            this.zzcmc.onPaidEvent(AdValue.zza(zzvv.zzadj, zzvv.zzadk, zzvv.zzadl));
        }
    }
}
