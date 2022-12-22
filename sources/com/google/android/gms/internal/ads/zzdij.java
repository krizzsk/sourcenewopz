package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdij implements zzdhb<JSONObject> {
    private JSONObject zzhhj;

    public zzdij(JSONObject jSONObject) {
        this.zzhhj = jSONObject;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", this.zzhhj);
        } catch (JSONException unused) {
            zzd.zzed("Unable to get cache_state");
        }
    }
}
