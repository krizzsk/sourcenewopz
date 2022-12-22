package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcip extends zzbpc {
    private final Context context;
    private final zzawa zzeaz;
    private final WeakReference<zzbfi> zzgdl;
    private final zzbyz zzgdm;
    private final zzbpz zzgdn;
    private final zzdvj zzgdo;
    private final zzbtb zzgdp;
    private final zzcbr zzgdq;
    private boolean zzglb = false;
    private final zzbum zzgls;

    zzcip(zzbpf zzbpf, Context context2, zzbfi zzbfi, zzcbr zzcbr, zzbyz zzbyz, zzbtb zzbtb, zzbum zzbum, zzbpz zzbpz, zzdot zzdot, zzdvj zzdvj) {
        super(zzbpf);
        this.context = context2;
        this.zzgdq = zzcbr;
        this.zzgdl = new WeakReference<>(zzbfi);
        this.zzgdm = zzbyz;
        this.zzgdp = zzbtb;
        this.zzgls = zzbum;
        this.zzgdn = zzbpz;
        this.zzgdo = zzdvj;
        this.zzeaz = new zzaxb(zzdot.zzdxw);
    }

    public final boolean zzb(boolean z, Activity activity) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpj)).booleanValue()) {
            zzr.zzkv();
            if (zzj.zzat(this.context)) {
                zzd.zzez("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzgdp.zzamj();
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpk)).booleanValue()) {
                    this.zzgdo.zzhg(this.zzftl.zzhnt.zzeuy.zzbwe);
                }
                return false;
            }
        }
        if (this.zzglb) {
            zzd.zzez("The rewarded ad have been showed.");
            this.zzgdp.zzl(zzdqh.zza(zzdqj.AD_REUSED, (String) null, (zzvh) null));
            return false;
        }
        this.zzglb = true;
        this.zzgdm.zzalz();
        Context context2 = activity;
        if (activity == null) {
            context2 = this.context;
        }
        try {
            this.zzgdq.zza(z, context2);
            this.zzgdm.zzalx();
            return true;
        } catch (zzcbq e) {
            this.zzgdp.zza(e);
            return false;
        }
    }

    public final boolean isUsed() {
        return this.zzglb;
    }

    public final zzawa zzsb() {
        return this.zzeaz;
    }

    public final boolean isClosed() {
        return this.zzgdn.isClosed();
    }

    public final boolean zzsc() {
        zzbfi zzbfi = (zzbfi) this.zzgdl.get();
        return zzbfi != null && !zzbfi.zzaeu();
    }

    public final Bundle getAdMetadata() {
        return this.zzgls.getAdMetadata();
    }

    public final void finalize() throws Throwable {
        try {
            zzbfi zzbfi = (zzbfi) this.zzgdl.get();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzczr)).booleanValue()) {
                if (!this.zzglb && zzbfi != null) {
                    zzebs zzebs = zzbat.zzeki;
                    zzbfi.getClass();
                    zzebs.execute(zzcio.zze(zzbfi));
                }
            } else if (zzbfi != null) {
                zzbfi.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
