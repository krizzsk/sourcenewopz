package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzazt {
    private final List<String> zzdvy;
    private String zzdwj;
    private final List<String> zzeeo = new ArrayList();
    private final List<String> zzeep = new ArrayList();
    private final Map<String, zzani> zzeeq = new HashMap();
    private String zzeer;
    private long zzees;
    private JSONObject zzeet;
    private boolean zzeeu;

    public zzazt(String str, long j) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        this.zzeeu = false;
        this.zzdvy = new ArrayList();
        this.zzdwj = str;
        this.zzees = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.zzeet = jSONObject;
                if (jSONObject.optInt("status", -1) != 1) {
                    this.zzeeu = false;
                    zzd.zzez("App settings could not be fetched successfully.");
                    return;
                }
                this.zzeeu = true;
                this.zzeer = this.zzeet.optString("app_id");
                JSONArray optJSONArray2 = this.zzeet.optJSONArray("ad_unit_id_settings");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject2.optString("format");
                        String optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzeep.add(optString2);
                                } else if (("rewarded".equalsIgnoreCase(optString) || "rewarded_interstitial".equals(optString)) && (optJSONObject2 = jSONObject2.optJSONObject("mediation_config")) != null) {
                                    this.zzeeq.put(optString2, new zzani(optJSONObject2));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray3 = this.zzeet.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray3 != null) {
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        this.zzeeo.add(optJSONArray3.optString(i2));
                    }
                }
                if (((Boolean) zzww.zzra().zzd(zzabq.zzczx)).booleanValue() && (optJSONObject = this.zzeet.optJSONObject("common_settings")) != null && (optJSONArray = optJSONObject.optJSONArray("loeid")) != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        this.zzdvy.add(optJSONArray.get(i3).toString());
                    }
                }
            } catch (JSONException e) {
                zzd.zzd("Exception occurred while processing app setting json", e);
                zzr.zzkz().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final void zzez(long j) {
        this.zzees = j;
    }

    public final long zzyp() {
        return this.zzees;
    }

    public final boolean zzyq() {
        return this.zzeeu;
    }

    public final String zzyr() {
        return this.zzdwj;
    }

    public final String zzys() {
        return this.zzeer;
    }

    public final Map<String, zzani> zzyt() {
        return this.zzeeq;
    }

    public final JSONObject zzyu() {
        return this.zzeet;
    }

    public final List<String> zznm() {
        return this.zzdvy;
    }
}
