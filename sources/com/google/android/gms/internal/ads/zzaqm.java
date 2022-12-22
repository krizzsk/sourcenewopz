package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaqm implements SignalCallbacks {
    private final /* synthetic */ zzaqf zzdqe;

    zzaqm(zzaqj zzaqj, zzaqf zzaqf) {
        this.zzdqe = zzaqf;
    }

    public final void onSuccess(String str) {
        try {
            this.zzdqe.zzdo(str);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdqe.onFailure(str);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.zzdqe.zzh(adError.zzdr());
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
