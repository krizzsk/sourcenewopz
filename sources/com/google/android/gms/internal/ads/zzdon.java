package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdon extends zzavj {
    private final zzdph zzgbf;
    private boolean zzhbk = false;
    private final zzdnz zzhlq;
    private final zzdnb zzhlr;
    /* access modifiers changed from: private */
    public zzcip zzhls;

    public zzdon(zzdnz zzdnz, zzdnb zzdnb, zzdph zzdph) {
        this.zzhlq = zzdnz;
        this.zzhlr = zzdnb;
        this.zzgbf = zzdph;
    }

    public final void setAppPackageName(String str) throws RemoteException {
    }

    public final synchronized void zza(zzavt zzavt) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (!zzabs.zzcp(zzavt.zzbvf)) {
            if (zzati()) {
                if (!((Boolean) zzww.zzra().zzd(zzabq.zzcxc)).booleanValue()) {
                    return;
                }
            }
            zzdoa zzdoa = new zzdoa((String) null);
            this.zzhls = null;
            this.zzhlq.zzek(zzdpe.zzhnl);
            this.zzhlq.zza(zzavt.zzdvn, zzavt.zzbvf, zzdoa, new zzdoq(this));
        }
    }

    public final void destroy() throws RemoteException {
        zzl((IObjectWrapper) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdnb r0 = r2.zzhlr     // Catch:{ all -> 0x0025 }
            r1 = 0
            r0.zza(r1)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzcip r0 = r2.zzhls     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            if (r3 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0025 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0025 }
        L_0x001a:
            com.google.android.gms.internal.ads.zzcip r3 = r2.zzhls     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbts r3 = r3.zzalk()     // Catch:{ all -> 0x0025 }
            r3.zzcg(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdon.zzl(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void pause() {
        zzj((IObjectWrapper) null);
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhls != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzhls.zzalk().zzce(context);
        }
    }

    public final void resume() {
        zzk((IObjectWrapper) null);
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhls != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzhls.zzalk().zzcf(context);
        }
    }

    public final synchronized void show() throws RemoteException {
        zzi((IObjectWrapper) null);
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzhls != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.zzhls.zzb(this.zzhbk, activity);
                }
            }
            activity = null;
            this.zzhls.zzb(this.zzhbk, activity);
        }
    }

    public final boolean zzsc() {
        zzcip zzcip = this.zzhls;
        return zzcip != null && zzcip.zzsc();
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzhls == null || this.zzhls.zzall() == null) {
            return null;
        }
        return this.zzhls.zzall().getMediationAdapterClassName();
    }

    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzati();
    }

    public final void zza(zzavn zzavn) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzhlr.zzb(zzavn);
    }

    public final void zza(zzave zzave) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzhlr.zzb(zzave);
    }

    public final void zza(zzxt zzxt) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzxt == null) {
            this.zzhlr.zza((AdMetadataListener) null);
        } else {
            this.zzhlr.zza(new zzdop(this, zzxt));
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzcip zzcip = this.zzhls;
        return zzcip != null ? zzcip.getAdMetadata() : new Bundle();
    }

    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzgbf.zzear = str;
    }

    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpz)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzgbf.zzeas = str;
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzhbk = z;
    }

    public final synchronized zzzc zzkm() throws RemoteException {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            return null;
        }
        if (this.zzhls == null) {
            return null;
        }
        return this.zzhls.zzall();
    }

    private final synchronized boolean zzati() {
        return this.zzhls != null && !this.zzhls.isClosed();
    }
}
