package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaiv implements zzaiu {
    private final /* synthetic */ zzbbe zzdjs;

    zzaiv(zzais zzais, zzbbe zzbbe) {
        this.zzdjs = zzbbe;
    }

    public final void zzc(JSONObject jSONObject) {
        this.zzdjs.set(jSONObject);
    }

    public final void onFailure(String str) {
        this.zzdjs.setException(new zzamh(str));
    }
}
