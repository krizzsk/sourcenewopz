package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdtv implements Runnable {
    private final String zzdkl;
    private final zzdts zzhuk;

    zzdtv(zzdts zzdts, String str) {
        this.zzhuk = zzdts;
        this.zzdkl = str;
    }

    public final void run() {
        this.zzhuk.zzgx(this.zzdkl);
    }
}
