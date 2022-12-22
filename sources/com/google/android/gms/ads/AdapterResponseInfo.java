package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzvx;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class AdapterResponseInfo {
    private final zzvx zzadn;
    private final AdError zzado;

    private AdapterResponseInfo(zzvx zzvx) {
        AdError adError;
        this.zzadn = zzvx;
        if (zzvx.zzcjc == null) {
            adError = null;
        } else {
            adError = zzvx.zzcjc.zzqh();
        }
        this.zzado = adError;
    }

    public static AdapterResponseInfo zza(zzvx zzvx) {
        if (zzvx != null) {
            return new AdapterResponseInfo(zzvx);
        }
        return null;
    }

    public final String getAdapterClassName() {
        return this.zzadn.zzcja;
    }

    public final long getLatencyMillis() {
        return this.zzadn.zzcjb;
    }

    public final AdError getAdError() {
        return this.zzado;
    }

    public final Bundle getCredentials() {
        return this.zzadn.zzcjd;
    }

    public final JSONObject zzds() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zzadn.zzcja);
        jSONObject.put("Latency", this.zzadn.zzcjb);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zzadn.zzcjd.keySet()) {
            jSONObject2.put(str, this.zzadn.zzcjd.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzado;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzds());
        }
        return jSONObject;
    }

    public final String toString() {
        try {
            return zzds().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
