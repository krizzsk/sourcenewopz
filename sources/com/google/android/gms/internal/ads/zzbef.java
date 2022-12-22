package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbef extends zza {
    final zzbcs zzekz;
    private final String zzemj;
    private final String[] zzemk;
    final zzbek zzerp;

    zzbef(zzbcs zzbcs, zzbek zzbek, String str, String[] strArr) {
        this.zzekz = zzbcs;
        this.zzerp = zzbek;
        this.zzemj = str;
        this.zzemk = strArr;
        zzr.zzlr().zza(this);
    }

    public final void zzwp() {
        try {
            this.zzerp.zze(this.zzemj, this.zzemk);
        } finally {
            zzj.zzegq.post(new zzbei(this));
        }
    }
}
