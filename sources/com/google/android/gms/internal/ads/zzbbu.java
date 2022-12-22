package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbu implements Runnable {
    private final /* synthetic */ zzbbq zzelq;
    private final /* synthetic */ String zzels;
    private final /* synthetic */ String zzelt;

    zzbbu(zzbbq zzbbq, String str, String str2) {
        this.zzelq = zzbbq;
        this.zzels = str;
        this.zzelt = str2;
    }

    public final void run() {
        if (this.zzelq.zzelo != null) {
            this.zzelq.zzelo.zzl(this.zzels, this.zzelt);
        }
    }
}
