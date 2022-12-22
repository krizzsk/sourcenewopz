package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzczl extends zzxh {
    private final zzdap zzhau;

    public zzczl(Context context, zzbhh zzbhh, zzdpo zzdpo, zzcdy zzcdy, zzxc zzxc) {
        zzdar zzdar = new zzdar(zzcdy, zzbhh.zzafu());
        zzdar.zzd(zzxc);
        this.zzhau = new zzdap(new zzdax(zzbhh, context, zzdar, zzdpo), zzdpo.zzawe());
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzhau.isLoading();
    }

    public final void zzb(zzvq zzvq) throws RemoteException {
        this.zzhau.zza(zzvq, 1);
    }

    public final synchronized void zza(zzvq zzvq, int i) throws RemoteException {
        this.zzhau.zza(zzvq, i);
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.zzhau.getMediationAdapterClassName();
    }

    public final synchronized String zzkl() {
        return this.zzhau.zzkl();
    }
}
