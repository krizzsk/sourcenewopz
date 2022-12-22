package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.didiglobal.domainservice.model.SuffixType;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdid implements zzdhb<JSONObject> {
    private String zzhhh;

    public zzdid(String str) {
        this.zzhhh = str;
    }

    public final /* synthetic */ void zzr(Object obj) {
        try {
            JSONObject zzb = zzbh.zzb((JSONObject) obj, SuffixType.PII);
            if (!TextUtils.isEmpty(this.zzhhh)) {
                zzb.put("attok", this.zzhhh);
            }
        } catch (JSONException e) {
            zzd.zza("Failed putting attestation token.", e);
        }
    }
}
