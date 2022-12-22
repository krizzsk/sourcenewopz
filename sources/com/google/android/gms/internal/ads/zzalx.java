package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzalx implements zzbbi<zzamc> {
    private final /* synthetic */ zzalv zzdlm;

    zzalx(zzalv zzalv) {
        this.zzdlm = zzalv;
    }

    public final /* synthetic */ void zzg(Object obj) {
        zzamc zzamc = (zzamc) obj;
        zzd.zzed("Releasing engine reference.");
        this.zzdlm.zzdlk.zzux();
    }
}
