package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcmi implements Runnable {
    private final String zzdkl;
    private final zzcmj zzgop;

    zzcmi(zzcmj zzcmj, String str) {
        this.zzgop = zzcmj;
        this.zzdkl = str;
    }

    public final void run() {
        zzcmj zzcmj = this.zzgop;
        zzcmj.zzeiw.zzen(this.zzdkl);
    }
}
