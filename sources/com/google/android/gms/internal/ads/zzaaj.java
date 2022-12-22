package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaaj extends zzyk {
    private zzajt zzcly;

    public final String getVersionString() {
        return "";
    }

    public final void setAppMuted(boolean z) throws RemoteException {
    }

    public final void setAppVolume(float f) throws RemoteException {
    }

    public final void zza(zzaat zzaat) throws RemoteException {
    }

    public final void zza(zzann zzann) throws RemoteException {
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzcd(String str) throws RemoteException {
    }

    public final void zzce(String str) throws RemoteException {
    }

    public final float zzrg() throws RemoteException {
        return 1.0f;
    }

    public final boolean zzrh() throws RemoteException {
        return false;
    }

    public final void zzrj() {
    }

    public final void initialize() throws RemoteException {
        zzbao.zzex("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzbae.zzaah.post(new zzaai(this));
    }

    public final void zza(zzajt zzajt) throws RemoteException {
        this.zzcly = zzajt;
    }

    public final List<zzajm> zzri() throws RemoteException {
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzsa() {
        zzajt zzajt = this.zzcly;
        if (zzajt != null) {
            try {
                zzajt.zze(Collections.emptyList());
            } catch (RemoteException e) {
                zzbao.zzd("Could not notify onComplete event.", e);
            }
        }
    }
}
