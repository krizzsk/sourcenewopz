package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzckd {
    private final Executor executor;
    private final Map<String, Map<String, JSONObject>> zzgna = new ConcurrentHashMap();
    private JSONObject zzgnb;
    private JSONObject zzgnc;
    private boolean zzxj;

    public zzckd(Executor executor2) {
        this.executor = executor2;
    }

    public final void zzaqq() {
        zzr.zzkz().zzyl().zzb(new zzckc(this));
        this.executor.execute(new zzckf(this));
    }

    @CheckForNull
    public final JSONObject zzr(String str, String str2) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcum)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzxj) {
            zzaqv();
        }
        Map map = this.zzgna.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza = zzckg.zza(this.zzgnc, str, str2);
        if (zza == null) {
            return null;
        }
        return (JSONObject) map.get(zza);
    }

    @CheckForNull
    public final JSONObject zzaqr() {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcun)).booleanValue()) {
            return null;
        }
        return this.zzgnb;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzaqs */
    public final synchronized void zzaqv() {
        Map map;
        this.zzxj = true;
        zzazt zzzg = zzr.zzkz().zzyl().zzzg();
        if (zzzg != null) {
            JSONObject zzyu = zzzg.zzyu();
            if (zzyu != null) {
                this.zzgnb = ((Boolean) zzww.zzra().zzd(zzabq.zzcun)).booleanValue() ? zzyu.optJSONObject("common_settings") : null;
                this.zzgnc = zzyu.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzyu.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString("format");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.zzgna.containsKey(optString2)) {
                                    map = this.zzgna.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zzgna.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqu() {
        this.executor.execute(new zzcke(this));
    }
}
