package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaag implements Runnable {
    private final /* synthetic */ zzaah zzclw;

    zzaag(zzaah zzaah) {
        this.zzclw = zzaah;
    }

    public final void run() {
        if (this.zzclw.zzbqc != null) {
            try {
                this.zzclw.zzbqc.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbao.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
