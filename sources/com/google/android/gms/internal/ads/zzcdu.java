package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbh;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdu extends zzcdv {
    private final boolean zzdnn;
    private final boolean zzdno;
    private final boolean zzdyg;
    private final JSONObject zzghg;
    private final boolean zzghh;

    public zzcdu(zzdot zzdot, JSONObject jSONObject) {
        super(zzdot);
        this.zzghg = zzbh.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzdno = zzbh.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdnn = zzbh.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdyg = zzbh.zza(false, jSONObject, "enable_omid");
        if (!(jSONObject == null || jSONObject.optJSONObject("overlay") == null)) {
            z = true;
        }
        this.zzghh = z;
    }

    public final JSONObject zzaoz() {
        JSONObject jSONObject = this.zzghg;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzghi.zzdxq);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzapa() {
        return this.zzghh;
    }

    public final boolean zzapb() {
        return this.zzdno;
    }

    public final boolean zzaok() {
        return this.zzdyg;
    }

    public final boolean zzapc() {
        return this.zzdnn;
    }
}
