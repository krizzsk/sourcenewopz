package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzbm;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpa implements zzbm {
    public final String zzdug = this.zzhnk.optString("ad_base_url", (String) null);
    public final String zzdui;
    public final JSONObject zzgem = this.zzhnk.optJSONObject("ad_json");
    private final JSONObject zzhnk;

    zzdpa(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzc = zzbh.zzc(jsonReader);
        this.zzhnk = zzc;
        this.zzdui = zzc.optString("ad_html", (String) null);
    }

    public final void zza(JsonWriter jsonWriter) throws IOException {
        zzbh.zza(jsonWriter, this.zzhnk);
    }
}
