package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhv implements zzdhb<JSONObject> {
    private final String zzhhb;

    public zzdhv(String str) {
        this.zzhhb = str;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.zzhhb);
        } catch (JSONException e) {
            zzd.zza("Failed putting Ad ID.", e);
        }
    }
}
