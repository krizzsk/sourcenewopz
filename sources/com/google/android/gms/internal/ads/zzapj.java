package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzapj implements Runnable {
    private final /* synthetic */ zzapb zzdpu;

    zzapj(zzapb zzapb) {
        this.zzdpu = zzapb;
    }

    public final void run() {
        try {
            this.zzdpu.zzdpk.onAdLoaded();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}
