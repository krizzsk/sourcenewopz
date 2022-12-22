package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbda implements Runnable {
    private final String zzdkl;
    private final zzbcv zzepq;

    zzbda(zzbcv zzbcv, String str) {
        this.zzepq = zzbcv;
        this.zzdkl = str;
    }

    public final void run() {
        this.zzepq.zzff(this.zzdkl);
    }
}
