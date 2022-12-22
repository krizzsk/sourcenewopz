package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.didi.raven.config.RavenKey;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdiw implements zzdhb<JSONObject> {
    private List<String> zzdvy;

    public zzdiw(List<String> list) {
        this.zzdvy = list;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            ((JSONObject) obj).put(RavenKey.EVENT_ID, TextUtils.join(",", this.zzdvy));
        } catch (JSONException unused) {
            zzd.zzed("Failed putting experiment ids.");
        }
    }
}
