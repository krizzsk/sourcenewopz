package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbkl {
    private final Map<String, zzbkm> zzftg;
    private final Map<String, zzbkn> zzfth;

    zzbkl(Map<String, zzbkm> map, Map<String, zzbkn> map2) {
        this.zzftg = map;
        this.zzfth = map2;
    }

    public final void zzb(zzdpi zzdpi) throws Exception {
        for (zzdpf next : zzdpi.zzhnt.zzhnr) {
            if (this.zzftg.containsKey(next.name)) {
                this.zzftg.get(next.name).zzi(next.zzhnp);
            } else if (this.zzfth.containsKey(next.name)) {
                zzbkn zzbkn = this.zzfth.get(next.name);
                JSONObject jSONObject = next.zzhnp;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    String optString = jSONObject.optString(next2);
                    if (optString != null) {
                        hashMap.put(next2, optString);
                    }
                }
                zzbkn.zzm(hashMap);
            }
        }
    }
}
