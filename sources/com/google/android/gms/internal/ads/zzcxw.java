package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbug;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcxw<AdT, AdapterT, ListenerT extends zzbug> implements zzcsz<AdT> {
    private final zzcta<AdapterT, ListenerT> zzfss;
    private final zzdtg zzfzh;
    private final zzcth<AdT, AdapterT, ListenerT> zzgzc;
    private final zzebs zzgzd;

    public zzcxw(zzdtg zzdtg, zzebs zzebs, zzcta<AdapterT, ListenerT> zzcta, zzcth<AdT, AdapterT, ListenerT> zzcth) {
        this.zzfzh = zzdtg;
        this.zzgzd = zzebs;
        this.zzgzc = zzcth;
        this.zzfss = zzcta;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return !zzdot.zzhmi.isEmpty();
    }

    public final zzebt<AdT> zzb(zzdpi zzdpi, zzdot zzdot) {
        zzctb<AdapterT, ListenerT> zzctb;
        Iterator<String> it = zzdot.zzhmi.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzctb = null;
                break;
            }
            try {
                zzctb = this.zzfss.zzf(it.next(), zzdot.zzhmk);
                break;
            } catch (zzdpq unused) {
            }
        }
        if (zzctb == null) {
            return zzebh.immediateFailedFuture(new zzcwa("unable to instantiate mediation adapter class"));
        }
        zzbbe zzbbe = new zzbbe();
        zzctb.zzgvk.zza(new zzcyb(this, zzctb, zzbbe));
        if (zzdot.zzead) {
            Bundle bundle = zzdpi.zzhns.zzfzg.zzhnx.zzcih;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfzh.zzt(zzdth.ADAPTER_LOAD_AD_SYN).zza((zzdsq) new zzcxz(this, zzdpi, zzdot, zzctb), this.zzgzd).zzv(zzdth.ADAPTER_LOAD_AD_ACK).zze(zzbbe).zzv(zzdth.ADAPTER_WRAP_ADAPTER).zzb(new zzcxy(this, zzdpi, zzdot, zzctb)).zzayi();
    }

    static String zza(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzdpi zzdpi, zzdot zzdot, zzctb zzctb, Void voidR) throws Exception {
        return this.zzgzc.zzb(zzdpi, zzdot, zzctb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws Exception {
        this.zzgzc.zza(zzdpi, zzdot, zzctb);
    }
}
