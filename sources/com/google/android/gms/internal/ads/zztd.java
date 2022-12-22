package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zztd implements Runnable {
    private final /* synthetic */ zzta zzbvr;

    zztd(zzta zzta) {
        this.zzbvr = zzta;
    }

    public final void run() {
        this.zzbvr.disconnect();
    }
}
