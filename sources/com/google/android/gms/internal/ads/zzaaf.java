package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaaf extends zzxh {
    final /* synthetic */ zzaad zzclv;

    private zzaaf(zzaad zzaad) {
        this.zzclv = zzaad;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final String zzkl() throws RemoteException {
        return null;
    }

    public final void zzb(zzvq zzvq) throws RemoteException {
        zza(zzvq, 1);
    }

    public final void zza(zzvq zzvq, int i) throws RemoteException {
        zzbao.zzex("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbae.zzaah.post(new zzaae(this));
    }
}
