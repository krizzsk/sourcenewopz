package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzaky implements Runnable {
    private final zzakx zzdkk;
    private final String zzdkl;

    zzaky(zzakx zzakx, String str) {
        this.zzdkk = zzakx;
        this.zzdkl = str;
    }

    public final void run() {
        this.zzdkk.zzda(this.zzdkl);
    }
}
