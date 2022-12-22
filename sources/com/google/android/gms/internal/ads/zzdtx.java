package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.soda.customer.app.constant.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.internal.zzr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdtx {
    private final HashMap<String, String> zzhul = new HashMap<>();
    private final zzdua zzhum = new zzdua(zzr.zzlc());

    private zzdtx() {
    }

    public static zzdtx zzgy(String str) {
        zzdtx zzdtx = new zzdtx();
        zzdtx.zzhul.put("action", str);
        return zzdtx;
    }

    public static zzdtx zzgz(String str) {
        zzdtx zzdtx = new zzdtx();
        zzdtx.zzw(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str);
        return zzdtx;
    }

    public final zzdtx zzw(String str, String str2) {
        this.zzhul.put(str, str2);
        return this;
    }

    public final zzdtx zzha(String str) {
        this.zzhum.zzhb(str);
        return this;
    }

    public final zzdtx zzx(String str, String str2) {
        this.zzhum.zzy(str, str2);
        return this;
    }

    public final zzdtx zzq(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzhul.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzhul.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final zzdtx zza(zzdpi zzdpi, zzbac zzbac) {
        if (zzdpi.zzhnt == null) {
            return this;
        }
        zzdpg zzdpg = zzdpi.zzhnt;
        if (zzdpg.zzeuy != null) {
            zzb(zzdpg.zzeuy);
        }
        if (!zzdpg.zzhnq.isEmpty()) {
            switch (zzdpg.zzhnq.get(0).zzhlz) {
                case 1:
                    this.zzhul.put(FirebaseAnalytics.Param.AD_FORMAT, Const.ComponentType.BANNER);
                    break;
                case 2:
                    this.zzhul.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zzhul.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zzhul.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zzhul.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zzhul.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    if (zzbac != null) {
                        this.zzhul.put("as", zzbac.zzyy() ? "1" : "0");
                        break;
                    }
                    break;
                default:
                    this.zzhul.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzdtx zzb(zzdoy zzdoy) {
        if (!TextUtils.isEmpty(zzdoy.zzbwe)) {
            this.zzhul.put("gqi", zzdoy.zzbwe);
        }
        return this;
    }

    public final zzdtx zzg(zzdot zzdot) {
        this.zzhul.put("aai", zzdot.zzdnw);
        return this;
    }

    public final Map<String, String> zzlw() {
        HashMap hashMap = new HashMap(this.zzhul);
        for (zzdud next : this.zzhum.zzayk()) {
            hashMap.put(next.label, next.value);
        }
        return hashMap;
    }
}
