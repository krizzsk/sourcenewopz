package com.google.android.gms.internal.ads;

import com.appsflyer.internal.referrer.Payload;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcga implements Callable {
    private final zzdot zzfxi;
    private final zzcgb zzgjx;
    private final zzdpi zzgjy;
    private final JSONObject zzgjz;

    zzcga(zzcgb zzcgb, zzdpi zzdpi, zzdot zzdot, JSONObject jSONObject) {
        this.zzgjx = zzcgb;
        this.zzgjy = zzdpi;
        this.zzfxi = zzdot;
        this.zzgjz = jSONObject;
    }

    public final Object call() {
        zzdpi zzdpi = this.zzgjy;
        zzdot zzdot = this.zzfxi;
        JSONObject jSONObject = this.zzgjz;
        zzcdr zzcdr = new zzcdr();
        zzcdr.zzeh(jSONObject.optInt("template_id", -1));
        zzcdr.zzfy(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzcdr.zzfz(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzdpm zzdpm = zzdpi.zzhns.zzfzg;
        if (zzdpm.zzhnz.contains(Integer.toString(zzcdr.zzaoo()))) {
            if (zzcdr.zzaoo() == 3) {
                if (zzcdr.getCustomTemplateId() == null) {
                    throw new zzcwo(zzdqj.INTERNAL_ERROR, "No custom template id for custom template ad response.");
                } else if (!zzdpm.zzhoa.contains(zzcdr.getCustomTemplateId())) {
                    throw new zzcwo(zzdqj.INTERNAL_ERROR, "Unexpected custom template id in the response.");
                }
            }
            zzcdr.setStarRating(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzdot.zzead) {
                zzr.zzkv();
                String zzzu = zzj.zzzu();
                StringBuilder sb = new StringBuilder(String.valueOf(zzzu).length() + 3 + String.valueOf(optString).length());
                sb.append(zzzu);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzcdr.zzo("headline", optString);
            zzcdr.zzo("body", jSONObject.optString("body", (String) null));
            zzcdr.zzo("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzcdr.zzo(Payload.TYPE_STORE, jSONObject.optString(Payload.TYPE_STORE, (String) null));
            zzcdr.zzo("price", jSONObject.optString("price", (String) null));
            zzcdr.zzo("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzcdr;
        }
        zzdqj zzdqj = zzdqj.INTERNAL_ERROR;
        int zzaoo = zzcdr.zzaoo();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(zzaoo);
        throw new zzcwo(zzdqj, sb2.toString());
    }
}
