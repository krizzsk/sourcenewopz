package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcuu extends zzavx implements zzbug {
    private zzavu zzgxa;
    private zzbuf zzgxb;
    private zzbzy zzgxc;

    public final synchronized void zza(zzavu zzavu) {
        this.zzgxa = zzavu;
    }

    public final synchronized void zza(zzbuf zzbuf) {
        this.zzgxb = zzbuf;
    }

    public final synchronized void zza(zzbzy zzbzy) {
        this.zzgxc = zzbzy;
    }

    public final synchronized void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzag(iObjectWrapper);
        }
        if (this.zzgxc != null) {
            this.zzgxc.onInitializationSucceeded();
        }
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzd(iObjectWrapper, i);
        }
        if (this.zzgxc != null) {
            this.zzgxc.zzeg(i);
        }
    }

    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzaj(iObjectWrapper);
        }
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzavy zzavy) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zza(iObjectWrapper, zzavy);
        }
    }

    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzal(iObjectWrapper);
        }
    }

    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzak(iObjectWrapper);
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zze(iObjectWrapper, i);
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdFailedToLoad(i);
        }
    }

    public final synchronized void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzam(iObjectWrapper);
        }
    }

    public final synchronized void zzan(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzan(iObjectWrapper);
        }
    }

    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzai(iObjectWrapper);
        }
    }

    public final synchronized void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzah(iObjectWrapper);
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdLoaded();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzgxa != null) {
            this.zzgxa.zzb(bundle);
        }
    }
}
