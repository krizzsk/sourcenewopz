package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzczv implements zzdma {
    private final String zzdkl;
    private final String zzdmo;

    zzczv(String str, String str2) {
        this.zzdmo = str;
        this.zzdkl = str2;
    }

    public final void zzp(Object obj) {
        ((zzxy) obj).onAppEvent(this.zzdmo, this.zzdkl);
    }
}
