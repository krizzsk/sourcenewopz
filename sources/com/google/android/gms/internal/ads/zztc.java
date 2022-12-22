package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zztc implements zzrr {
    private final /* synthetic */ zzta zzbvr;

    zztc(zzta zzta) {
        this.zzbvr = zzta;
    }

    public final void zzq(boolean z) {
        if (z) {
            this.zzbvr.connect();
        } else {
            this.zzbvr.disconnect();
        }
    }
}
