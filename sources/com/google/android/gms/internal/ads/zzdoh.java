package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdoh extends zzawe {
    private final String zzbvf;
    private final zzdph zzgbf;
    private final Context zzham;
    private boolean zzhbk = ((Boolean) zzww.zzra().zzd(zzabq.zzcpl)).booleanValue();
    private final zzdnz zzhlq;
    private final zzdnb zzhlr;
    /* access modifiers changed from: private */
    public zzcip zzhls;

    public zzdoh(String str, zzdnz zzdnz, Context context, zzdnb zzdnb, zzdph zzdph) {
        this.zzbvf = str;
        this.zzhlq = zzdnz;
        this.zzhlr = zzdnb;
        this.zzgbf = zzdph;
        this.zzham = context;
    }

    public final synchronized void zza(zzvq zzvq, zzawn zzawn) throws RemoteException {
        zza(zzvq, zzawn, zzdpe.zzhnm);
    }

    public final synchronized void zzb(zzvq zzvq, zzawn zzawn) throws RemoteException {
        zza(zzvq, zzawn, zzdpe.zzhnn);
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, this.zzhbk);
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzhls == null) {
            zzd.zzez("Rewarded can not be shown before loaded");
            this.zzhlr.zzk(zzdqh.zza(zzdqj.NOT_READY, (String) null, (zzvh) null));
            return;
        }
        this.zzhls.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzhls == null || this.zzhls.zzall() == null) {
            return null;
        }
        return this.zzhls.zzall().getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcip zzcip = this.zzhls;
        return zzcip != null && !zzcip.isUsed();
    }

    public final void zza(zzawg zzawg) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhlr.zzb(zzawg);
    }

    public final void zza(zzawo zzawo) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhlr.zzb(zzawo);
    }

    public final void zza(zzyw zzyw) {
        if (zzyw == null) {
            this.zzhlr.zza((AdMetadataListener) null);
        } else {
            this.zzhlr.zza(new zzdok(this, zzyw));
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcip zzcip = this.zzhls;
        return zzcip != null ? zzcip.getAdMetadata() : new Bundle();
    }

    public final zzawa zzsb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcip zzcip = this.zzhls;
        if (zzcip != null) {
            return zzcip.zzsb();
        }
        return null;
    }

    public final synchronized void zza(zzaww zzaww) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdph zzdph = this.zzgbf;
        zzdph.zzear = zzaww.zzear;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpz)).booleanValue()) {
            zzdph.zzeas = zzaww.zzeas;
        }
    }

    public final zzzc zzkm() {
        zzcip zzcip;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue() && (zzcip = this.zzhls) != null) {
            return zzcip.zzall();
        }
        return null;
    }

    public final void zza(zzyx zzyx) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzhlr.zzd(zzyx);
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzhbk = z;
    }

    private final synchronized void zza(zzvq zzvq, zzawn zzawn, int i) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhlr.zzb(zzawn);
        zzr.zzkv();
        if (zzj.zzbc(this.zzham) && zzvq.zzcip == null) {
            zzd.zzex("Failed to load the ad because app ID is missing.");
            this.zzhlr.zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, (String) null, (zzvh) null));
        } else if (this.zzhls == null) {
            zzdoa zzdoa = new zzdoa((String) null);
            this.zzhlq.zzek(i);
            this.zzhlq.zza(zzvq, this.zzbvf, zzdoa, new zzdoj(this));
        }
    }
}
