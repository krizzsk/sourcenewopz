package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzduo implements Runnable {
    private final String zzdkl;
    private final zzdup zzhol;

    zzduo(zzdup zzdup, String str) {
        this.zzhol = zzdup;
        this.zzdkl = str;
    }

    public final void run() {
        this.zzhol.zzhd(this.zzdkl);
    }
}
