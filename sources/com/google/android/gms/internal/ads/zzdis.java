package com.google.android.gms.internal.ads;

import com.didiglobal.domainservice.model.SuffixType;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdis implements zzdhb<JSONObject> {
    private String zzhhp;
    private String zzhhq;

    public zzdis(String str, String str2) {
        this.zzhhp = str;
        this.zzhhq = str2;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            JSONObject zzb = zzbh.zzb((JSONObject) obj, SuffixType.PII);
            zzb.put("doritos", this.zzhhp);
            zzb.put("doritos_v2", this.zzhhq);
        } catch (JSONException unused) {
            zzd.zzed("Failed putting doritos string.");
        }
    }
}
