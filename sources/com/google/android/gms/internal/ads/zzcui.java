package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcui extends zzapr {
    private zzctb<zzaqa, zzcuv> zzgwo;
    private final /* synthetic */ zzcue zzgwp;

    private zzcui(zzcue zzcue, zzctb<zzaqa, zzcuv> zzctb) {
        this.zzgwp = zzcue;
        this.zzgwo = zzctb;
    }

    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        View unused = this.zzgwp.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcuv) this.zzgwo.zzgvk).onAdLoaded();
    }

    public final void zzdm(String str) throws RemoteException {
        ((zzcuv) this.zzgwo.zzgvk).zzc(0, str);
    }

    public final void zzg(zzvh zzvh) throws RemoteException {
        ((zzcuv) this.zzgwo.zzgvk).zzc(zzvh);
    }

    public final void zza(zzanu zzanu) throws RemoteException {
        zzanu unused = this.zzgwp.zzgwl = zzanu;
        ((zzcuv) this.zzgwo.zzgvk).onAdLoaded();
    }
}
