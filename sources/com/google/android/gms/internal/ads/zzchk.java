package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchk extends zzafj {
    private final String zzcja;
    private final zzcdr zzgeo;
    private final zzcdf zzghx;

    public zzchk(String str, zzcdf zzcdf, zzcdr zzcdr) {
        this.zzcja = str;
        this.zzghx = zzcdf;
        this.zzgeo = zzcdr;
    }

    public final IObjectWrapper zzts() throws RemoteException {
        return ObjectWrapper.wrap(this.zzghx);
    }

    public final String getHeadline() throws RemoteException {
        return this.zzgeo.getHeadline();
    }

    public final List<?> getImages() throws RemoteException {
        return this.zzgeo.getImages();
    }

    public final String getBody() throws RemoteException {
        return this.zzgeo.getBody();
    }

    public final zzaes zztt() throws RemoteException {
        return this.zzgeo.zztt();
    }

    public final String getCallToAction() throws RemoteException {
        return this.zzgeo.getCallToAction();
    }

    public final double getStarRating() throws RemoteException {
        return this.zzgeo.getStarRating();
    }

    public final String getStore() throws RemoteException {
        return this.zzgeo.getStore();
    }

    public final String getPrice() throws RemoteException {
        return this.zzgeo.getPrice();
    }

    public final Bundle getExtras() throws RemoteException {
        return this.zzgeo.getExtras();
    }

    public final void destroy() throws RemoteException {
        this.zzghx.destroy();
    }

    public final zzzd getVideoController() throws RemoteException {
        return this.zzgeo.getVideoController();
    }

    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzghx.zzf(bundle);
    }

    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzghx.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzghx.zzg(bundle);
    }

    public final zzaek zztu() throws RemoteException {
        return this.zzgeo.zztu();
    }

    public final IObjectWrapper zztv() throws RemoteException {
        return this.zzgeo.zztv();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzcja;
    }
}
