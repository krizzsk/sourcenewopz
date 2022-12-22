package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaqv implements Runnable {
    private final /* synthetic */ zzaqt zzdqi;
    private final /* synthetic */ AdOverlayInfoParcel zzdqq;

    zzaqv(zzaqt zzaqt, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdqi = zzaqt;
        this.zzdqq = adOverlayInfoParcel;
    }

    public final void run() {
        zzr.zzku();
        zzo.zza(this.zzdqi.zzdqj, this.zzdqq, true);
    }
}
