package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.dmap.apollo.BuildConfig;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclp implements zzbtc, zzbtq, zzbxb, zzve {
    private final Context context;
    private final zzcmb zzdje;
    private final zzcsh zzdji;
    private final zzdpi zzfbh;
    private final zzdot zzftr;
    private final zzdpz zzgnx;
    private Boolean zzgny;
    private final boolean zzgnz = ((Boolean) zzww.zzra().zzd(zzabq.zzczu)).booleanValue();

    public zzclp(Context context2, zzdpz zzdpz, zzcmb zzcmb, zzdpi zzdpi, zzdot zzdot, zzcsh zzcsh) {
        this.context = context2;
        this.zzgnx = zzdpz;
        this.zzdje = zzcmb;
        this.zzfbh = zzdpi;
        this.zzftr = zzdot;
        this.zzdji = zzcsh;
    }

    public final void onAdClicked() {
        if (this.zzftr.zzhmz) {
            zza(zzgf("click"));
        }
    }

    public final void onAdImpression() {
        if (zzari() || this.zzftr.zzhmz) {
            zza(zzgf("impression"));
        }
    }

    public final void zzaly() {
        if (zzari()) {
            zzgf("adapter_impression").zzarm();
        }
    }

    public final void zzama() {
        if (zzari()) {
            zzgf("adapter_shown").zzarm();
        }
    }

    public final void zzl(zzvh zzvh) {
        if (this.zzgnz) {
            zzcma zzgf = zzgf("ifts");
            zzgf.zzs("reason", "adapter");
            int i = zzvh.errorCode;
            String str = zzvh.zzchs;
            if (zzvh.zzcht.equals(MobileAds.ERROR_DOMAIN) && zzvh.zzchu != null && !zzvh.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
                i = zzvh.zzchu.errorCode;
                str = zzvh.zzchu.zzchs;
            }
            if (i >= 0) {
                zzgf.zzs("arec", String.valueOf(i));
            }
            String zzgu = this.zzgnx.zzgu(str);
            if (zzgu != null) {
                zzgf.zzs("areec", zzgu);
            }
            zzgf.zzarm();
        }
    }

    public final void zza(zzcbq zzcbq) {
        if (this.zzgnz) {
            zzcma zzgf = zzgf("ifts");
            zzgf.zzs("reason", "exception");
            if (!TextUtils.isEmpty(zzcbq.getMessage())) {
                zzgf.zzs("msg", zzcbq.getMessage());
            }
            zzgf.zzarm();
        }
    }

    public final void zzamj() {
        if (this.zzgnz) {
            zzcma zzgf = zzgf("ifts");
            zzgf.zzs("reason", "blocked");
            zzgf.zzarm();
        }
    }

    private final boolean zzari() {
        if (this.zzgny == null) {
            synchronized (this) {
                if (this.zzgny == null) {
                    zzabf zzabf = zzabq.zzcrr;
                    zzr.zzkv();
                    this.zzgny = Boolean.valueOf(zze((String) zzww.zzra().zzd(zzabf), zzj.zzbb(this.context)));
                }
            }
        }
        return this.zzgny.booleanValue();
    }

    private static boolean zze(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzr.zzkz().zza(e, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    private final zzcma zzgf(String str) {
        zzcma zzc = this.zzdje.zzarp().zza(this.zzfbh.zzhnt.zzeuy).zzc(this.zzftr);
        zzc.zzs("action", str);
        if (!this.zzftr.zzhmi.isEmpty()) {
            zzc.zzs("ancn", this.zzftr.zzhmi.get(0));
        }
        if (this.zzftr.zzhmz) {
            zzr.zzkv();
            zzc.zzs("device_connectivity", zzj.zzbd(this.context) ? BuildConfig.FLAVOR : "offline");
            zzc.zzs("event_timestamp", String.valueOf(zzr.zzlc().currentTimeMillis()));
            zzc.zzs("offline_ad", "1");
        }
        return zzc;
    }

    private final void zza(zzcma zzcma) {
        if (this.zzftr.zzhmz) {
            this.zzdji.zza(new zzcso(zzr.zzlc().currentTimeMillis(), this.zzfbh.zzhnt.zzeuy.zzbwe, zzcma.zzarn(), zzcse.zzgui));
            return;
        }
        zzcma.zzarm();
    }
}
