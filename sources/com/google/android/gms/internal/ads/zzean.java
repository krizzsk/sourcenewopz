package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzean implements Runnable {
    private final /* synthetic */ zzdyv zzicw;
    private final /* synthetic */ zzeal zzicx;

    zzean(zzeal zzeal, zzdyv zzdyv) {
        this.zzicx = zzeal;
        this.zzicw = zzdyv;
    }

    public final void run() {
        this.zzicx.zza(this.zzicw);
    }
}
