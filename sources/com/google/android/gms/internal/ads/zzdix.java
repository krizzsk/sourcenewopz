package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdix implements zzdhb<JSONObject> {
    private Bundle zzhhs;

    public zzdix(Bundle bundle) {
        this.zzhhs = bundle;
    }

    public final /* synthetic */ void zzr(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zzhhs != null) {
            try {
                zzbh.zzb(zzbh.zzb(jSONObject, "device"), "play_store").put("parental_controls", zzr.zzkv().zzc(this.zzhhs));
            } catch (JSONException unused) {
                zzd.zzed("Failed putting parental controls bundle.");
            }
        }
    }
}
