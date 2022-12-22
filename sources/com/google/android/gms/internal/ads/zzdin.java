package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdin implements zzdhe<zzdhb<JSONObject>> {
    private final JSONObject zzhhm;

    zzdin(Context context) {
        this.zzhhm = zzauv.zzw(context);
    }

    public final zzebt<zzdhb<JSONObject>> zzatu() {
        return zzebh.zzag(new zzdiq(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzhhm);
        } catch (JSONException unused) {
            zzd.zzed("Failed putting version constants.");
        }
    }
}
