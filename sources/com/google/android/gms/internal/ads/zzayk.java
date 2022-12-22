package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzayd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzayk implements zzayd.zzb {
    static final zzayd.zzb zzedi = new zzayk();

    private zzayk() {
    }

    public final Object zzb(zzbha zzbha) {
        String currentScreenName = zzbha.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbha.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
