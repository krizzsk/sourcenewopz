package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzamd implements Runnable {
    private final zzama zzdlr;
    private final zzakv zzdls;

    zzamd(zzama zzama, zzakv zzakv) {
        this.zzdlr = zzama;
        this.zzdls = zzakv;
    }

    public final void run() {
        zzama zzama = this.zzdlr;
        zzakv zzakv = this.zzdls;
        zzama.zzdlq.zzdkt.zzg(zzakv);
        zzakv.destroy();
    }
}
