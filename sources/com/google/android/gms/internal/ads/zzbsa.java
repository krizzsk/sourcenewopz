package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbsa implements zzbtp, zzbuj {
    private final Context context;
    private final zzaso zzboy;
    private final zzdot zzeux;

    public zzbsa(Context context2, zzdot zzdot, zzaso zzaso) {
        this.context = context2;
        this.zzeux = zzdot;
        this.zzboy = zzaso;
    }

    public final void zzce(Context context2) {
    }

    public final void zzcf(Context context2) {
    }

    public final void onAdLoaded() {
        if (this.zzeux.zzhmv != null && this.zzeux.zzhmv.zzduu) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzeux.zzhmv.zzduv.isEmpty()) {
                arrayList.add(this.zzeux.zzhmv.zzduv);
            }
            this.zzboy.zza(this.context, arrayList);
        }
    }

    public final void zzcg(Context context2) {
        this.zzboy.detach();
    }
}
