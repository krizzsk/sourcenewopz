package com.google.android.gms.ads.query;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.internal.ads.zzbao;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class AdInfo {
    private final QueryInfo zzhvb;
    private final String zzhvc;

    public static String getRequestId(String str) {
        if (str == null) {
            zzbao.zzez("adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            return new JSONObject(str).optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
        } catch (JSONException unused) {
            zzbao.zzez("Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
    }

    public AdInfo(QueryInfo queryInfo, String str) {
        this.zzhvb = queryInfo;
        this.zzhvc = str;
    }

    public QueryInfo getQueryInfo() {
        return this.zzhvb;
    }

    public String getAdString() {
        return this.zzhvc;
    }
}
