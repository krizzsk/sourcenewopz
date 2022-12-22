package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaae implements Runnable {
    private final /* synthetic */ zzaaf zzclu;

    zzaae(zzaaf zzaaf) {
        this.zzclu = zzaaf;
    }

    public final void run() {
        if (this.zzclu.zzclv.zzbqc != null) {
            try {
                this.zzclu.zzclv.zzbqc.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbao.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
