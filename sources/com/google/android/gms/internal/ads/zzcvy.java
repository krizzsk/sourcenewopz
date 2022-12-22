package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcvy extends zzapx {
    private zzctb<zzaqa, zzcuv> zzgwo;
    private final /* synthetic */ zzcvw zzgxt;

    private zzcvy(zzcvw zzcvw, zzctb<zzaqa, zzcuv> zzctb) {
        this.zzgxt = zzcvw;
        this.zzgwo = zzctb;
    }

    public final void zza(zzaoh zzaoh) throws RemoteException {
        zzaoh unused = this.zzgxt.zzgxs = zzaoh;
        ((zzcuv) this.zzgwo.zzgvk).onAdLoaded();
    }

    public final void zzdm(String str) throws RemoteException {
        ((zzcuv) this.zzgwo.zzgvk).zzc(0, str);
    }

    public final void zzg(zzvh zzvh) throws RemoteException {
        ((zzcuv) this.zzgwo.zzgvk).zzc(zzvh);
    }
}
