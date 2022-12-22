package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdci implements zzdhb<Bundle> {
    private final zzdpm zzfzg;

    public zzdci(zzdpm zzdpm) {
        Preconditions.checkNotNull(zzdpm, "the targeting must not be null");
        this.zzfzg = zzdpm;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzvq zzvq = this.zzfzg.zzhnx;
        bundle.putInt("http_timeout_millis", this.zzfzg.zzhnx.zzcio);
        bundle.putString("slotname", this.zzfzg.zzhny);
        boolean z = true;
        int i = zzdch.zzgmf[this.zzfzg.zzhof.zzhnj - 1];
        if (i == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        zzdpw.zza(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzvq.zzcia)), zzvq.zzcia != -1);
        zzdpw.zza(bundle, "extras", zzvq.extras);
        zzdpw.zza(bundle, "cust_gender", Integer.valueOf(zzvq.zzcib), zzvq.zzcib != -1);
        zzdpw.zza(bundle, "kw", zzvq.zzcic);
        zzdpw.zza(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zzvq.zzadv), zzvq.zzadv != -1);
        if (zzvq.zzcid) {
            bundle.putBoolean("test_request", zzvq.zzcid);
        }
        zzdpw.zza(bundle, "d_imp_hdr", (Integer) 1, zzvq.versionCode >= 2 && zzvq.zzbns);
        zzdpw.zza(bundle, "ppid", zzvq.zzcie, zzvq.versionCode >= 2 && !TextUtils.isEmpty(zzvq.zzcie));
        if (zzvq.zzng != null) {
            Location location = zzvq.zzng;
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", valueOf.floatValue());
            bundle2.putLong("lat", valueOf3.longValue());
            bundle2.putLong("long", valueOf4.longValue());
            bundle2.putLong("time", valueOf2.longValue());
            bundle.putBundle("uule", bundle2);
        }
        zzdpw.zza(bundle, "url", zzvq.zzcig);
        zzdpw.zza(bundle, "neighboring_content_urls", zzvq.zzcin);
        zzdpw.zza(bundle, "custom_targeting", zzvq.zzcii);
        zzdpw.zza(bundle, "category_exclusions", zzvq.zzcij);
        zzdpw.zza(bundle, "request_agent", zzvq.zzcik);
        zzdpw.zza(bundle, "request_pkg", zzvq.zzcil);
        zzdpw.zza(bundle, "is_designed_for_families", Boolean.valueOf(zzvq.zzcim), zzvq.versionCode >= 7);
        if (zzvq.versionCode >= 8) {
            Integer valueOf5 = Integer.valueOf(zzvq.zzadw);
            if (zzvq.zzadw == -1) {
                z = false;
            }
            zzdpw.zza(bundle, "tag_for_under_age_of_consent", valueOf5, z);
            zzdpw.zza(bundle, "max_ad_content_rating", zzvq.zzadx);
        }
    }
}
