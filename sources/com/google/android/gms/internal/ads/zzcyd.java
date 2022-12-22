package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzcyd extends zzans {
    private final zzbui zzfyn;
    private final zzbty zzfzc;
    private final zzbtb zzgdp;
    private final zzbur zzgds;
    private final zzbtl zzgep;
    private final zzbst zzgeq;
    private final zzbxe zzglt;
    private final zzbwx zzgza;
    private final zzcaa zzgzl;

    public zzcyd(zzbst zzbst, zzbtl zzbtl, zzbty zzbty, zzbui zzbui, zzbxe zzbxe, zzbur zzbur, zzcaa zzcaa, zzbwx zzbwx, zzbtb zzbtb) {
        this.zzgeq = zzbst;
        this.zzgep = zzbtl;
        this.zzfzc = zzbty;
        this.zzfyn = zzbui;
        this.zzglt = zzbxe;
        this.zzgds = zzbur;
        this.zzgzl = zzcaa;
        this.zzgza = zzbwx;
        this.zzgdp = zzbtb;
    }

    public final void onAdFailedToLoad(int i) {
    }

    public final void zza(zzafo zzafo, String str) {
    }

    public final void zza(zzanz zzanz) {
    }

    public void zza(zzawa zzawa) throws RemoteException {
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public void zzb(zzavy zzavy) {
    }

    public final void zzc(int i, String str) {
    }

    public final void zzc(zzvh zzvh) {
    }

    public final void zzdj(String str) {
    }

    public void zzvq() throws RemoteException {
    }

    public final void onAdClicked() {
        this.zzgeq.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzgds.zza(zzl.OTHER);
    }

    public final void onAdLeftApplication() {
        this.zzfzc.onAdLeftApplication();
    }

    public final void onAdOpened() {
        this.zzgds.zzvz();
        this.zzgza.zzama();
    }

    public final void onAppEvent(String str, String str2) {
        this.zzglt.onAppEvent(str, str2);
    }

    public final void onAdLoaded() {
        this.zzfyn.onAdLoaded();
    }

    public void onAdImpression() {
        this.zzgep.onAdImpression();
        this.zzgza.zzaly();
    }

    public final void onVideoPause() {
        this.zzgzl.onVideoPause();
    }

    public void zzvp() {
        this.zzgzl.onVideoStart();
    }

    public void onVideoEnd() {
        this.zzgzl.onVideoEnd();
    }

    public final void onVideoPlay() throws RemoteException {
        this.zzgzl.onVideoPlay();
    }

    @Deprecated
    public final void zzde(int i) throws RemoteException {
        zzf(new zzvh(i, "", "undefined", (zzvh) null, (IBinder) null));
    }

    public final void zzdk(String str) {
        zzf(new zzvh(0, str, "undefined", (zzvh) null, (IBinder) null));
    }

    public final void zzf(zzvh zzvh) {
        this.zzgdp.zzl(zzdqh.zza(zzdqj.MEDIATION_SHOW_ERROR, zzvh));
    }
}
