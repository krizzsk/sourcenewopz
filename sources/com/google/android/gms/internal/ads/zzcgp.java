package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcgp {
    private final Executor executor;
    private final zzcgf zzgkb;

    public zzcgp(Executor executor2, zzcgf zzcgf) {
        this.executor = executor2;
        this.zzgkb = zzcgf;
    }

    public final zzebt<List<zzcgq>> zzg(JSONObject jSONObject, String str) {
        zzebt<O> zzebt;
        String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzebh.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                String optString2 = optJSONObject.optString("type");
                if (TypedValues.Custom.S_STRING.equals(optString2)) {
                    c = 1;
                } else {
                    c = "image".equals(optString2) ? (char) 2 : 0;
                }
                if (c == 1) {
                    zzebt = zzebh.zzag(new zzcgq(optString, optJSONObject.optString("string_value")));
                } else if (c == 2) {
                    zzebt = zzebh.zzb(this.zzgkb.zzc(optJSONObject, "image_value"), new zzcgr(optString), this.executor);
                }
                arrayList.add(zzebt);
            }
            zzebt = zzebh.zzag(null);
            arrayList.add(zzebt);
        }
        return zzebh.zzb(zzebh.zzi(arrayList), zzcgo.zzebv, this.executor);
    }
}
