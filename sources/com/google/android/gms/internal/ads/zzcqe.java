package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcqe implements zzdsr {
    static final zzdsr zzgqm = new zzcqe();

    private zzcqe() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzd.zzed("Ad request signals:");
        zzd.zzed(jSONObject.toString(2));
        return jSONObject;
    }
}
