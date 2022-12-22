package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcvl extends zzaps {
    private zzctb<zzaqa, zzcuv> zzgwo;

    private zzcvl(zzcvj zzcvj, zzctb<zzaqa, zzcuv> zzctb) {
        this.zzgwo = zzctb;
    }

    public final void zzvy() throws RemoteException {
        ((zzcuv) this.zzgwo.zzgvk).onAdLoaded();
    }

    public final void zzdm(String str) throws RemoteException {
        ((zzcuv) this.zzgwo.zzgvk).zzc(0, str);
    }

    public final void zzg(zzvh zzvh) throws RemoteException {
        ((zzcuv) this.zzgwo.zzgvk).zzc(zzvh);
    }
}
