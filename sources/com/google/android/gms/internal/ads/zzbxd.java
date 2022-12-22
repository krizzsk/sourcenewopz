package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbxd implements zzbxs {
    private final String zzdkl;
    private final String zzdmo;

    zzbxd(String str, String str2) {
        this.zzdmo = str;
        this.zzdkl = str2;
    }

    public final void zzo(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zzdmo, this.zzdkl);
    }
}
