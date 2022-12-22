package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdaq implements zzbsz {
    private final zzczm zzhbu;
    private final zzakg zzhbv;

    zzdaq(zzczm zzczm, zzakg zzakg) {
        this.zzhbu = zzczm;
        this.zzhbv = zzakg;
    }

    public final void zzd(zzvh zzvh) {
        zzczm zzczm = this.zzhbu;
        zzakg zzakg = this.zzhbv;
        zzczm.zzd(zzvh);
        if (zzakg != null) {
            try {
                zzakg.zze(zzvh);
            } catch (RemoteException e) {
                zzbao.zze("#007 Could not call remote method.", e);
            }
        }
        if (zzakg != null) {
            try {
                zzakg.onInstreamAdFailedToLoad(zzvh.errorCode);
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
