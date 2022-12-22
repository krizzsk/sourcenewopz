package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfv implements Callable {
    private final zzcf.zza.zzb zzabg;
    private final zzfc zzwh;

    public zzfv(zzfc zzfc, zzcf.zza.zzb zzb) {
        this.zzwh = zzfc;
        this.zzabg = zzb;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcz */
    public final Void call() throws Exception {
        if (this.zzwh.zzcq() != null) {
            this.zzwh.zzcq().get();
        }
        zzcf.zza zzcp = this.zzwh.zzcp();
        if (zzcp != null) {
            try {
                synchronized (this.zzabg) {
                    zzcf.zza.zzb zzb = this.zzabg;
                    byte[] byteArray = zzcp.toByteArray();
                    zzb.zza(byteArray, 0, byteArray.length, zzemn.zzbiv());
                }
            } catch (zzenn | NullPointerException unused) {
            }
        }
        return null;
    }
}
