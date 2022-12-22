package com.google.android.gms.internal.ads;

import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcou implements zzear {
    private final zzcov zzgqy;
    private final zzvf zzgqz;

    zzcou(zzcov zzcov, zzvf zzvf) {
        this.zzgqy = zzcov;
        this.zzgqz = zzvf;
    }

    public final zzebt zzf(Object obj) {
        zzvf zzvf = this.zzgqz;
        String str = (String) obj;
        String str2 = zzvf.zzchp;
        String str3 = zzvf.zzchq;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ErrorConst.ErrorParam.HEADERS, new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzebh.zzag(jSONObject);
    }
}
