package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdeb implements zzdhb<Bundle> {
    @Nullable
    private final JSONObject zzgnb;
    @Nullable
    private final JSONObject zzhen;

    public zzdeb(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        this.zzhen = jSONObject;
        this.zzgnb = jSONObject2;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        JSONObject jSONObject = this.zzhen;
        if (jSONObject != null) {
            bundle.putString("fwd_cld", jSONObject.toString());
        }
        JSONObject jSONObject2 = this.zzgnb;
        if (jSONObject2 != null) {
            bundle.putString("fwd_common_cld", jSONObject2.toString());
        }
    }
}
