package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpu {
    private final zzcsh zzdji;
    private final zzdot zzeux;
    private final zzdoy zzeuy;
    private final zzdup zzftn;

    public zzdpu(zzcsh zzcsh, zzdup zzdup, zzdot zzdot, zzdoy zzdoy) {
        this.zzeux = zzdot;
        this.zzeuy = zzdoy;
        this.zzdji = zzcsh;
        this.zzftn = zzdup;
    }

    public final void zzj(List<String> list) {
        for (String zzb : list) {
            zzb(zzb, zzcse.zzgui);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.util.List<java.lang.String> r2, java.lang.Integer r3) {
        /*
            r1 = this;
            java.util.Iterator r2 = r2.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r2.next()
            java.lang.String r0 = (java.lang.String) r0
            r1.zzb(r0, r3)
            goto L_0x0004
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpu.zza(java.util.List, int):void");
    }

    private final void zzb(String str, int i) {
        if (!this.zzeux.zzhmz) {
            this.zzftn.zzen(str);
            return;
        }
        this.zzdji.zza(new zzcso(zzr.zzlc().currentTimeMillis(), this.zzeuy.zzbwe, str, i));
    }
}
