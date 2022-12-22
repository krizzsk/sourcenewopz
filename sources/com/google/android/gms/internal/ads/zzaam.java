package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzaam implements Runnable {
    private final zzawn zzclz;

    zzaam(zzawn zzawn) {
        this.zzclz = zzawn;
    }

    public final void run() {
        zzawn zzawn = this.zzclz;
        if (zzawn != null) {
            try {
                zzawn.onRewardedAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbao.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
