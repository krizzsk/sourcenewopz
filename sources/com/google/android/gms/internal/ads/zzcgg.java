package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcgg implements zzdxw {
    private final JSONObject zzfvb;
    private final zzcgf zzgkp;

    zzcgg(zzcgf zzcgf, JSONObject jSONObject) {
        this.zzgkp = zzcgf;
        this.zzfvb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zzgkp.zza(this.zzfvb, (List) obj);
    }
}
