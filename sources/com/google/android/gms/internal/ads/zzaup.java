package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaup {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzdvx;
    private final String zzdyi;
    private final boolean zzdyj;
    private final String zzdyv;
    private final List<String> zzdzx;
    private final String zzdzy;
    private final String zzdzz;
    private final boolean zzeaa;
    private final boolean zzeab;
    private final String zzeac;
    private final boolean zzead;
    private final JSONObject zzeae;

    private static boolean parseBoolean(String str) {
        if (str != null) {
            return str.equals("1") || str.equals("true");
        }
        return false;
    }

    public zzaup(JSONObject jSONObject) {
        List<String> list;
        this.url = jSONObject.optString("url");
        this.zzdzy = jSONObject.optString("base_uri");
        this.zzdzz = jSONObject.optString("post_parameters");
        this.zzeaa = parseBoolean(jSONObject.optString("drt_include"));
        this.zzeab = parseBoolean(jSONObject.optString("cookies_include", "true"));
        this.zzdvx = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
        this.type = jSONObject.optString("type");
        String optString = jSONObject.optString("errors");
        if (optString == null) {
            list = null;
        } else {
            list = Arrays.asList(optString.split(","));
        }
        this.zzdzx = list;
        this.errorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.zzeac = jSONObject.optString("fetched_ad");
        this.zzead = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzeae = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzdyi = jSONObject.optString("analytics_query_ad_event_id");
        this.zzdyj = jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzdyv = jSONObject.optString("pool_key");
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final List<String> zzww() {
        return this.zzdzx;
    }

    public final String zzwx() {
        return this.zzdzy;
    }

    public final String zzwy() {
        return this.zzdzz;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzwz() {
        return this.zzeaa;
    }

    public final boolean zzxa() {
        return this.zzeab;
    }

    public final JSONObject zzxb() {
        return this.zzeae;
    }

    public final String zzxc() {
        return this.zzdyv;
    }
}
