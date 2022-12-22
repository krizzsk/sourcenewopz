package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhz implements zzdhb<JSONObject> {
    private final JSONObject zzhhd;

    public zzdhz(JSONObject jSONObject) {
        this.zzhhd = jSONObject;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            JSONObject zzb = zzbh.zzb((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zzhhd;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            zzd.zzed("Failed putting app indexing json.");
        }
    }
}
