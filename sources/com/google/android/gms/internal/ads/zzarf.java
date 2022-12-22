package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzarf {
    private final boolean zzdrl;
    private final boolean zzdrm;
    private final boolean zzdrn;
    private final boolean zzdro;
    private final boolean zzdrp;

    private zzarf(zzarh zzarh) {
        this.zzdrl = zzarh.zzdrl;
        this.zzdrm = zzarh.zzdrm;
        this.zzdrn = zzarh.zzdrn;
        this.zzdro = zzarh.zzdro;
        this.zzdrp = zzarh.zzdrp;
    }

    public final JSONObject zzds() {
        try {
            return new JSONObject().put("sms", this.zzdrl).put("tel", this.zzdrm).put("calendar", this.zzdrn).put("storePicture", this.zzdro).put("inlineVideo", this.zzdrp);
        } catch (JSONException e) {
            zzd.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
