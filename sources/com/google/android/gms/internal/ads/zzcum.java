package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcum implements zzcbr {
    private final zzbbe zzbwk;

    zzcum(zzbbe zzbbe) {
        this.zzbwk = zzbbe;
    }

    public final void zza(boolean z, Context context) {
        zzbbe zzbbe = this.zzbwk;
        try {
            zzr.zzku();
            zzo.zza(context, (AdOverlayInfoParcel) zzbbe.get(), true);
        } catch (Exception unused) {
        }
    }
}
