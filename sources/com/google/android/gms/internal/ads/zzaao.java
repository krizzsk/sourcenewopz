package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaao implements Runnable {
    private final /* synthetic */ zzaap zzcma;

    zzaao(zzaap zzaap) {
        this.zzcma = zzaap;
    }

    public final void run() {
        if (this.zzcma.zzcmb != null) {
            try {
                this.zzcma.zzcmb.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbao.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
