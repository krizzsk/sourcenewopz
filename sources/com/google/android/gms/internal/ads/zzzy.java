package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzy {
    private final String zzbrl;
    private final Bundle zzclr;

    public zzzy(String str, Bundle bundle) {
        this.zzbrl = str;
        this.zzclr = bundle;
    }

    public final String getQuery() {
        return this.zzbrl;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzww.zzre().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final Bundle getQueryBundle() {
        return this.zzclr;
    }
}
