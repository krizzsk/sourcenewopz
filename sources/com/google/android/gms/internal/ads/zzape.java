package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzape implements Runnable {
    private final /* synthetic */ zzapb zzdpu;
    private final /* synthetic */ AdRequest.ErrorCode zzdpv;

    zzape(zzapb zzapb, AdRequest.ErrorCode errorCode) {
        this.zzdpu = zzapb;
        this.zzdpv = errorCode;
    }

    public final void run() {
        try {
            this.zzdpu.zzdpk.onAdFailedToLoad(zzapn.zza(this.zzdpv));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}
