package com.google.android.gms.internal.ads;

import com.didichuxing.publicservice.p196db.base.AdDbHelper;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzanj {
    private final long zzdmz;
    private final String zzdnt;
    private final String zzdnu;
    public final List<String> zzdnv;
    private final String zzdnw;
    private final String zzdnx;
    private final List<String> zzdny;
    private final List<String> zzdnz;
    private final List<String> zzdoa;
    private final List<String> zzdob;
    private final List<String> zzdoc;
    public final String zzdod;
    private final List<String> zzdoe;
    private final List<String> zzdof;
    private final List<String> zzdog;
    private final String zzdoh;
    private final String zzdoi;
    private final String zzdoj;
    private final String zzdok;
    private final String zzdol;
    private final List<String> zzdom;
    private final String zzdon;
    public final String zzdoo;

    public zzanj(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzdnu = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdnv = Collections.unmodifiableList(arrayList);
        this.zzdnw = jSONObject.optString("allocation_id", (String) null);
        zzr.zzln();
        this.zzdny = zzanl.zza(jSONObject, "clickurl");
        zzr.zzln();
        this.zzdnz = zzanl.zza(jSONObject, "imp_urls");
        zzr.zzln();
        this.zzdoa = zzanl.zza(jSONObject, "downloaded_imp_urls");
        zzr.zzln();
        this.zzdoc = zzanl.zza(jSONObject, "fill_urls");
        zzr.zzln();
        this.zzdoe = zzanl.zza(jSONObject, "video_start_urls");
        zzr.zzln();
        this.zzdog = zzanl.zza(jSONObject, "video_complete_urls");
        zzr.zzln();
        this.zzdof = zzanl.zza(jSONObject, "video_reward_urls");
        this.zzdoh = jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.zzdoi = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject(AdDbHelper.DB_NAME);
        if (optJSONObject != null) {
            zzr.zzln();
            list = zzanl.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdob = list;
        this.zzdnt = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdod = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdnx = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzdoj = jSONObject.optString("html_template", (String) null);
        this.zzdok = jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzdol = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzr.zzln();
        this.zzdom = zzanl.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzdon = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdoo = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, (String) null);
        this.zzdmz = jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
