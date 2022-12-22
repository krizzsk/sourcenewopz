package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.soda.customer.app.constant.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclz {
    private final zzbac zzedz;
    private ConcurrentHashMap<String, String> zzgod;

    public zzclz(zzcmg zzcmg, zzbac zzbac) {
        this.zzgod = new ConcurrentHashMap<>(zzcmg.zzgof);
        this.zzedz = zzbac;
    }

    public final void zze(zzdpi zzdpi) {
        if (zzdpi.zzhnt.zzhnq.size() > 0) {
            switch (zzdpi.zzhnt.zzhnq.get(0).zzhlz) {
                case 1:
                    this.zzgod.put(FirebaseAnalytics.Param.AD_FORMAT, Const.ComponentType.BANNER);
                    break;
                case 2:
                    this.zzgod.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zzgod.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zzgod.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zzgod.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zzgod.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    this.zzgod.put("as", this.zzedz.zzyy() ? "1" : "0");
                    break;
                default:
                    this.zzgod.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        if (!TextUtils.isEmpty(zzdpi.zzhnt.zzeuy.zzbwe)) {
            this.zzgod.put("gqi", zzdpi.zzhnt.zzeuy.zzbwe);
        }
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzgod.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzgod.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzsx() {
        return this.zzgod;
    }
}
