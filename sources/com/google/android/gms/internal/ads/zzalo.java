package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzalo implements Runnable {
    private final zzakv zzdlb;

    private zzalo(zzakv zzakv) {
        this.zzdlb = zzakv;
    }

    static Runnable zzb(zzakv zzakv) {
        return new zzalo(zzakv);
    }

    public final void run() {
        this.zzdlb.destroy();
    }
}
