package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.dmap.apollo.BuildConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqv implements zzbtc, zzbtq, zzbxb, zzve {
    private final Context context;
    private final zzdtw zzdjf;
    private final zzcsh zzdji;
    private final String zzdvx;
    private final zzdpi zzfbh;
    private final zzdot zzftr;
    private final zzdpz zzgnx;
    private Boolean zzgny;
    private final boolean zzgnz = ((Boolean) zzww.zzra().zzd(zzabq.zzczu)).booleanValue();

    public zzcqv(Context context2, zzdpz zzdpz, zzdpi zzdpi, zzdot zzdot, zzcsh zzcsh, zzdtw zzdtw, String str) {
        this.context = context2;
        this.zzgnx = zzdpz;
        this.zzfbh = zzdpi;
        this.zzftr = zzdot;
        this.zzdji = zzcsh;
        this.zzdjf = zzdtw;
        this.zzdvx = str;
    }

    public final void onAdClicked() {
        if (this.zzftr.zzhmz) {
            zza(zzgl("click"));
        }
    }

    public final void onAdImpression() {
        if (zzari() || this.zzftr.zzhmz) {
            zza(zzgl("impression"));
        }
    }

    public final void zzaly() {
        if (zzari()) {
            this.zzdjf.zzb(zzgl("adapter_impression"));
        }
    }

    public final void zzama() {
        if (zzari()) {
            this.zzdjf.zzb(zzgl("adapter_shown"));
        }
    }

    public final void zzl(zzvh zzvh) {
        if (this.zzgnz) {
            int i = zzvh.errorCode;
            String str = zzvh.zzchs;
            if (zzvh.zzcht.equals(MobileAds.ERROR_DOMAIN) && zzvh.zzchu != null && !zzvh.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
                i = zzvh.zzchu.errorCode;
                str = zzvh.zzchu.zzchs;
            }
            String zzgu = this.zzgnx.zzgu(str);
            zzdtx zzw = zzgl("ifts").zzw("reason", "adapter");
            if (i >= 0) {
                zzw.zzw("arec", String.valueOf(i));
            }
            if (zzgu != null) {
                zzw.zzw("areec", zzgu);
            }
            this.zzdjf.zzb(zzw);
        }
    }

    public final void zza(zzcbq zzcbq) {
        if (this.zzgnz) {
            zzdtx zzw = zzgl("ifts").zzw("reason", "exception");
            if (!TextUtils.isEmpty(zzcbq.getMessage())) {
                zzw.zzw("msg", zzcbq.getMessage());
            }
            this.zzdjf.zzb(zzw);
        }
    }

    public final void zzamj() {
        if (this.zzgnz) {
            this.zzdjf.zzb(zzgl("ifts").zzw("reason", "blocked"));
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

    private final zzdtx zzgl(String str) {
        zzdtx zzw = zzdtx.zzgy(str).zza(this.zzfbh, (zzbac) null).zzg(this.zzftr).zzw(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zzdvx);
        if (!this.zzftr.zzhmi.isEmpty()) {
            zzw.zzw("ancn", this.zzftr.zzhmi.get(0));
        }
        if (this.zzftr.zzhmz) {
            zzr.zzkv();
            zzw.zzw("device_connectivity", zzj.zzbd(this.context) ? BuildConfig.FLAVOR : "offline");
            zzw.zzw("event_timestamp", String.valueOf(zzr.zzlc().currentTimeMillis()));
            zzw.zzw("offline_ad", "1");
        }
        return zzw;
    }

    private final void zza(zzdtx zzdtx) {
        if (this.zzftr.zzhmz) {
            this.zzdji.zza(new zzcso(zzr.zzlc().currentTimeMillis(), this.zzfbh.zzhnt.zzeuy.zzbwe, this.zzdjf.zzc(zzdtx), zzcse.zzgui));
            return;
        }
        this.zzdjf.zzb(zzdtx);
    }
}
