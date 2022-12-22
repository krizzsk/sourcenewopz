package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbmy extends zzso {
    private boolean zzbpu = false;
    private final zzxq zzbvo;
    private final zzbmz zzfwo;
    private final zzdkd zzfwp;

    public zzbmy(zzbmz zzbmz, zzxq zzxq, zzdkd zzdkd) {
        this.zzfwo = zzbmz;
        this.zzbvo = zzxq;
        this.zzfwp = zzdkd;
    }

    public final void zza(zzsv zzsv) {
    }

    public final zzxq zzea() {
        return this.zzbvo;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzsw zzsw) {
        try {
            this.zzfwp.zza(zzsw);
            this.zzfwo.zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzsw, this.zzbpu);
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }

    public final zzzc zzkm() {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            return null;
        }
        return this.zzfwo.zzall();
    }

    public final void setImmersiveMode(boolean z) {
        this.zzbpu = z;
    }

    public final void zza(zzyx zzyx) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        zzdkd zzdkd = this.zzfwp;
        if (zzdkd != null) {
            zzdkd.zzb(zzyx);
        }
    }
}
