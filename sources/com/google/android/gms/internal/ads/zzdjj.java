package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdjj implements zzdhb<JSONObject> {
    private final Map<String, Object> zzhhx;

    public zzdjj(Map<String, Object> map) {
        this.zzhhx = map;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzr.zzkv().zzj(this.zzhhx));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.zzed(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
