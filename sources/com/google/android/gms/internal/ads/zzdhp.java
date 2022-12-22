package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.domainservice.model.SuffixType;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhp implements zzdhb<JSONObject> {
    private final AdvertisingIdClient.Info zzhgw;
    private final String zzhgx;

    public zzdhp(AdvertisingIdClient.Info info, String str) {
        this.zzhgw = info;
        this.zzhgx = str;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            JSONObject zzb = zzbh.zzb((JSONObject) obj, SuffixType.PII);
            if (this.zzhgw == null || TextUtils.isEmpty(this.zzhgw.getId())) {
                zzb.put("pdid", this.zzhgx);
                zzb.put("pdidtype", "ssaid");
                return;
            }
            zzb.put("rdid", this.zzhgw.getId());
            zzb.put("is_lat", this.zzhgw.isLimitAdTrackingEnabled());
            zzb.put("idtype", Constants.JSON_KEY_ANDID);
        } catch (JSONException e) {
            zzd.zza("Failed putting Ad ID.", e);
        }
    }
}
