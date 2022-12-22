package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdlc implements zzdat<zzbne> {
    /* access modifiers changed from: private */
    public final Executor zzfur;
    /* access modifiers changed from: private */
    public final ViewGroup zzfwu;
    private final zzdpo zzhan;
    /* access modifiers changed from: private */
    public final zzczm zzhas;
    private final zzbhh zzhco;
    private final Context zzhik;
    /* access modifiers changed from: private */
    public final zzdaj zzhji;
    private zzacm zzhjj;
    /* access modifiers changed from: private */
    public final zzbve zzhjk;
    /* access modifiers changed from: private */
    public zzebt<zzbne> zzhjl;

    public zzdlc(Context context, Executor executor, zzvt zzvt, zzbhh zzbhh, zzczm zzczm, zzdaj zzdaj, zzdpo zzdpo) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhh;
        this.zzhas = zzczm;
        this.zzhji = zzdaj;
        this.zzhan = zzdpo;
        this.zzhjk = zzbhh.zzafz();
        this.zzfwu = new FrameLayout(context);
        zzdpo.zzg(zzvt);
    }

    public final boolean isLoading() {
        zzebt<zzbne> zzebt = this.zzhjl;
        return zzebt != null && !zzebt.isDone();
    }

    public final boolean zza(zzvq zzvq, String str, zzdas zzdas, zzdav<? super zzbne> zzdav) throws RemoteException {
        zzboa zzboa;
        if (str == null) {
            zzd.zzex("Ad unit ID should not be null for banner ad.");
            this.zzfur.execute(new zzdlb(this));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            zzdpm zzawg = this.zzhan.zzgt(str).zzh(zzvq).zzawg();
            if (!zzado.zzdfj.get().booleanValue() || !this.zzhan.zzkk().zzciv) {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                    zzboa = this.zzhco.zzagc().zzd(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zzd(new zzbxr.zza().zza((zzbvm) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zzanf()).zza(new zzcyo(this.zzhjj)).zzb(new zzccb(zzcdy.zzghq, (zzxc) null)).zza(new zzboz(this.zzhjk)).zzd(new zzbnd(this.zzfwu)).zzaie();
                } else {
                    zzboa = this.zzhco.zzagc().zzd(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zzd(new zzbxr.zza().zza((zzbvm) this.zzhas, this.zzfur).zza((zzve) this.zzhas, this.zzfur).zza((zzve) this.zzhji, this.zzfur).zza((zzbtq) this.zzhas, this.zzfur).zza((zzbsy) this.zzhas, this.zzfur).zza((zzbuj) this.zzhas, this.zzfur).zza((zzbsz) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zza((zzbvb) this.zzhas, this.zzfur).zzanf()).zza(new zzcyo(this.zzhjj)).zzb(new zzccb(zzcdy.zzghq, (zzxc) null)).zza(new zzboz(this.zzhjk)).zzd(new zzbnd(this.zzfwu)).zzaie();
                }
                zzebt<zzbne> zzalv = zzboa.zzahd().zzalv();
                this.zzhjl = zzalv;
                zzebh.zza(zzalv, new zzdle(this, zzdav, zzboa), this.zzfur);
                return true;
            }
            zzczm zzczm = this.zzhas;
            if (zzczm != null) {
                zzczm.zzd(zzdqh.zza(zzdqj.INVALID_AD_SIZE, (String) null, (zzvh) null));
            }
            return false;
        }
    }

    public final ViewGroup zzavh() {
        return this.zzfwu;
    }

    public final void zza(zzacm zzacm) {
        this.zzhjj = zzacm;
    }

    public final void zza(zzwx zzwx) {
        this.zzhji.zzb(zzwx);
    }

    public final zzdpo zzavi() {
        return this.zzhan;
    }

    public final boolean zzavj() {
        ViewParent parent = this.zzfwu.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzr.zzkv().zza(view, view.getContext());
    }

    public final void zza(zzbvi zzbvi) {
        this.zzhjk.zza(zzbvi, this.zzfur);
    }

    public final void zzavk() {
        this.zzhjk.zzef(60);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzavl() {
        this.zzhas.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, (String) null, (zzvh) null));
    }
}
