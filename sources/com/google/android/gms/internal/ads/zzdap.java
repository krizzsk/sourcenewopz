package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdap {
    /* access modifiers changed from: private */
    public zzzc zzaec;
    /* access modifiers changed from: private */
    public boolean zzafk = false;
    private final String zzbvf;
    private final zzdat<zzbpc> zzhbt;

    public zzdap(zzdat<zzbpc> zzdat, String str) {
        this.zzhbt = zzdat;
        this.zzbvf = str;
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzhbt.isLoading();
    }

    public final synchronized void zza(zzvq zzvq, int i) throws RemoteException {
        this.zzaec = null;
        this.zzafk = this.zzhbt.zza(zzvq, this.zzbvf, new zzdau(i), new zzdao(this));
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            if (this.zzaec == null) {
                return null;
            }
            return this.zzaec.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final synchronized String zzkl() {
        try {
            if (this.zzaec == null) {
                return null;
            }
            return this.zzaec.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
