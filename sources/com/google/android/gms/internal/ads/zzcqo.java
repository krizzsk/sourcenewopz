package com.google.android.gms.internal.ads;

import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.google.android.gms.ads.internal.zzr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcqo implements zzaml<zzcqp> {
    zzcqo() {
    }

    public final /* synthetic */ JSONObject zzi(Object obj) throws JSONException {
        zzcqp zzcqp = (zzcqp) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcqp.zzgsg.zzwx());
        jSONObject2.put("signals", zzcqp.zzgsh);
        jSONObject3.put("body", zzcqp.zzgsj.zzdxg);
        jSONObject3.put(ErrorConst.ErrorParam.HEADERS, zzr.zzkv().zzj(zzcqp.zzgsj.zzaj));
        jSONObject3.put("response_code", zzcqp.zzgsj.zzgsr);
        jSONObject3.put("latency", zzcqp.zzgsj.zzgss);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcqp.zzgsg.zzxb());
        return jSONObject;
    }
}
