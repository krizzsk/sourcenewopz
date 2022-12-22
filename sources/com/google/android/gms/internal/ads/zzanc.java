package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzanc implements zzaiu {
    private final zzbbe<O> zzdml;
    private final /* synthetic */ zzana zzdmq;

    public zzanc(zzana zzana, zzbbe<O> zzbbe) {
        this.zzdmq = zzana;
        this.zzdml = zzbbe;
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdml.set(this.zzdmq.zzdmh.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdml.setException(e);
        }
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdml.setException(new zzamh());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzdml.setException(new zzamh(str));
        }
    }
}
