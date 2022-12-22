package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaeo implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzafo zzdgz;

    public zzaeo(zzafo zzafo) {
        this.zzdgz = zzafo;
        try {
            zzafo.zzua();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zzdgz.zztz();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return false;
        }
    }

    public final void setView(View view) {
        try {
            this.zzdgz.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
