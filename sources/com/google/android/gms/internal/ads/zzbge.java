package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbge implements Runnable {
    private final int zzehh;
    private final int zzehi;
    private final boolean zzeua;
    private final boolean zzeub;
    private final zzbgc zzewe;

    zzbge(zzbgc zzbgc, int i, int i2, boolean z, boolean z2) {
        this.zzewe = zzbgc;
        this.zzehh = i;
        this.zzehi = i2;
        this.zzeua = z;
        this.zzeub = z2;
    }

    public final void run() {
        this.zzewe.zzb(this.zzehh, this.zzehi, this.zzeua, this.zzeub);
    }
}
