package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzamu implements zzaiu {
    private final /* synthetic */ zzamt zzdmg;
    private final zzalv zzdmk;
    private final zzbbe<O> zzdml;

    public zzamu(zzamt zzamt, zzalv zzalv, zzbbe<O> zzbbe) {
        this.zzdmg = zzamt;
        this.zzdmk = zzalv;
        this.zzdml = zzbbe;
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdml.set(this.zzdmg.zzdmh.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdml.setException(e);
        } finally {
            this.zzdmk.release();
        }
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdml.setException(new zzamh());
            } catch (IllegalStateException unused) {
                this.zzdmk.release();
                return;
            } catch (Throwable th) {
                this.zzdmk.release();
                throw th;
            }
        } else {
            this.zzdml.setException(new zzamh(str));
        }
        this.zzdmk.release();
    }
}
