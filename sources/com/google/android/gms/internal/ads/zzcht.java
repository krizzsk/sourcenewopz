package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcht extends zzagv {
    private final String zzcja;
    private final zzcdr zzgeo;
    private final zzcdf zzghx;

    public zzcht(String str, zzcdf zzcdf, zzcdr zzcdr) {
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

    public final List<?> getMuteThisAdReasons() throws RemoteException {
        if (isCustomMuteThisAdEnabled()) {
            return this.zzgeo.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return !this.zzgeo.getMuteThisAdReasons().isEmpty() && this.zzgeo.zzaor() != null;
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

    public final String getAdvertiser() throws RemoteException {
        return this.zzgeo.getAdvertiser();
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

    public final Bundle getExtras() throws RemoteException {
        return this.zzgeo.getExtras();
    }

    public final void zza(zzagr zzagr) throws RemoteException {
        this.zzghx.zza(zzagr);
    }

    public final void zza(zzys zzys) throws RemoteException {
        this.zzghx.zza(zzys);
    }

    public final void zza(zzyo zzyo) throws RemoteException {
        this.zzghx.zza(zzyo);
    }

    public final void zzud() {
        this.zzghx.zzud();
    }

    public final void recordCustomClickGesture() {
        this.zzghx.recordCustomClickGesture();
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.zzghx.isCustomClickGestureEnabled();
    }

    public final void cancelUnconfirmedClick() throws RemoteException {
        this.zzghx.cancelUnconfirmedClick();
    }

    public final zzaer zzue() throws RemoteException {
        return this.zzghx.zzaol().zzue();
    }

    public final zzzc zzkm() throws RemoteException {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            return null;
        }
        return this.zzghx.zzall();
    }

    public final void zza(zzyx zzyx) throws RemoteException {
        this.zzghx.zza(zzyx);
    }
}
