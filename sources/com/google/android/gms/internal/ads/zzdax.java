package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdax implements zzdat<zzbpc> {
    /* access modifiers changed from: private */
    public final zzbhh zzgxu;
    private final Context zzham;
    private final zzdpo zzhan;
    /* access modifiers changed from: private */
    public final zzdar zzhca;
    private zzbpn zzhcb;

    public zzdax(zzbhh zzbhh, Context context, zzdar zzdar, zzdpo zzdpo) {
        this.zzgxu = zzbhh;
        this.zzham = context;
        this.zzhca = zzdar;
        this.zzhan = zzdpo;
    }

    public final boolean isLoading() {
        zzbpn zzbpn = this.zzhcb;
        return zzbpn != null && zzbpn.isLoading();
    }

    public final boolean zza(zzvq zzvq, String str, zzdas zzdas, zzdav<? super zzbpc> zzdav) throws RemoteException {
        zzr.zzkv();
        if (zzj.zzbc(this.zzham) && zzvq.zzcip == null) {
            zzd.zzex("Failed to load the ad because app ID is missing.");
            this.zzgxu.zzafv().execute(new zzdaw(this));
            return false;
        } else if (str == null) {
            zzd.zzex("Ad unit ID should not be null for NativeAdLoader.");
            this.zzgxu.zzafv().execute(new zzdaz(this));
            return false;
        } else {
            zzdqa.zze(this.zzham, zzvq.zzcid);
            zzccf zzahf = this.zzgxu.zzagj().zza(new zzbsj.zza().zzci(this.zzham).zza(this.zzhan.zzh(zzvq).zzem(zzdas instanceof zzdau ? ((zzdau) zzdas).zzhby : 1).zzawg()).zzami()).zza(new zzbxr.zza().zzanf()).zza(this.zzhca.zzatk()).zza(new zzbnd((ViewGroup) null)).zzahf();
            this.zzgxu.zzagp().ensureSize(1);
            zzbpn zzbpn = new zzbpn(this.zzgxu.zzafx(), this.zzgxu.zzafw(), zzahf.zzahd().zzalv());
            this.zzhcb = zzbpn;
            zzbpn.zza((zzebi<zzbpc>) new zzday(this, zzdav, zzahf));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzato() {
        this.zzhca.zzatn().zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, (String) null, (zzvh) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatp() {
        this.zzhca.zzatn().zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, (String) null, (zzvh) null));
    }
}
