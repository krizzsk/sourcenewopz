package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzark implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzafo zzdrw;

    public zzark(zzafo zzafo) {
        this.zzdrw = zzafo;
        try {
            zzafo.zzua();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zzdrw.zztz();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return false;
        }
    }

    public final void setView(View view) {
        try {
            this.zzdrw.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
