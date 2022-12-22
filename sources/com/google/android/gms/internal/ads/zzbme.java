package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbme {
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzdpi zzfbh;

    public zzbme(zzcmb zzcmb, zzdpi zzdpi, zzdtw zzdtw) {
        this.zzdjf = zzdtw;
        this.zzdje = zzcmb;
        this.zzfbh = zzdpi;
    }

    public final void zzb(long j, int i) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            this.zzdjf.zzb(zzdtx.zzgy("ad_closed").zzb(this.zzfbh.zzhnt.zzeuy).zzw("show_time", String.valueOf(j)).zzw(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad").zzw("acr", zzee(i)));
        } else {
            this.zzdje.zzarp().zza(this.zzfbh.zzhnt.zzeuy).zzs("action", "ad_closed").zzs("show_time", String.valueOf(j)).zzs(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad").zzs("acr", zzee(i)).zzarm();
        }
    }

    private static String zzee(int i) {
        int i2 = zzbmh.zzfwh[i - 1];
        if (i2 == 1) {
            return "bb";
        }
        if (i2 == 2) {
            return "h";
        }
        if (i2 == 3) {
            return "cc";
        }
        if (i2 != 4) {
            return i2 != 5 ? "u" : "cb";
        }
        return "ac";
    }
}
