package com.google.android.gms.internal.ads;

import com.didi.soda.customer.app.constant.Const;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzani {
    public final List<zzanj> zzdmy;
    private final long zzdmz;
    private final List<String> zzdna;
    private final List<String> zzdnb;
    private final List<String> zzdnc;
    private final List<String> zzdnd;
    private final List<String> zzdne;
    private final boolean zzdnf;
    private final String zzdng;
    private final long zzdnh;
    private final String zzdni;
    private final int zzdnj;
    private final int zzdnk;
    private final long zzdnl;
    private final boolean zzdnm;
    private final boolean zzdnn;
    private final boolean zzdno;
    private final boolean zzdnp;
    private int zzdnq;
    private int zzdnr;
    private boolean zzdns;

    public zzani(JSONObject jSONObject) throws JSONException {
        if (zzd.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzd.zzed(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzanj zzanj = new zzanj(jSONArray.getJSONObject(i2));
                boolean z = true;
                if (Const.ComponentType.BANNER.equalsIgnoreCase(zzanj.zzdoo)) {
                    this.zzdns = true;
                }
                arrayList.add(zzanj);
                if (i < 0) {
                    Iterator<String> it = zzanj.zzdnv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdnq = i;
        this.zzdnr = jSONArray.length();
        this.zzdmy = Collections.unmodifiableList(arrayList);
        this.zzdng = jSONObject.optString("qdata");
        this.zzdnk = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.zzdnl = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzdmz = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzr.zzln();
            this.zzdna = zzanl.zza(optJSONObject, "click_urls");
            zzr.zzln();
            this.zzdnb = zzanl.zza(optJSONObject, "imp_urls");
            zzr.zzln();
            this.zzdnc = zzanl.zza(optJSONObject, "downloaded_imp_urls");
            zzr.zzln();
            this.zzdnd = zzanl.zza(optJSONObject, "nofill_urls");
            zzr.zzln();
            this.zzdne = zzanl.zza(optJSONObject, "remote_ping_urls");
            this.zzdnf = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzdnh = optLong > 0 ? 1000 * optLong : j;
            zzavy zza = zzavy.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzdni = null;
                this.zzdnj = 0;
            } else {
                this.zzdni = zza.type;
                this.zzdnj = zza.zzean;
            }
            this.zzdnm = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdnn = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdno = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdnp = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzdmz = -1;
        this.zzdna = null;
        this.zzdnb = null;
        this.zzdnc = null;
        this.zzdnd = null;
        this.zzdne = null;
        this.zzdnh = -1;
        this.zzdni = null;
        this.zzdnj = 0;
        this.zzdnm = false;
        this.zzdnf = false;
        this.zzdnn = false;
        this.zzdno = false;
        this.zzdnp = false;
    }
}
