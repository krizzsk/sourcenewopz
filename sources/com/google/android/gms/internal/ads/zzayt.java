package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzayt {
    private static zzayt zzedm;

    /* access modifiers changed from: package-private */
    public abstract zzaxt zzxr();

    /* access modifiers changed from: package-private */
    public abstract zzaxx zzxs();

    /* access modifiers changed from: package-private */
    public abstract zzayu zzxt();

    public static synchronized zzayt zzaj(Context context) {
        synchronized (zzayt.class) {
            if (zzedm != null) {
                zzayt zzayt = zzedm;
                return zzayt;
            }
            Context applicationContext = context.getApplicationContext();
            zzabq.initialize(applicationContext);
            zzf zzyl = zzr.zzkz().zzyl();
            zzyl.initialize(applicationContext);
            zzayt zzxu = new zzayb().zzz(applicationContext).zza(zzyl).zza(zzr.zzlt()).zzxu();
            zzedm = zzxu;
            zzxu.zzxr().zzxn();
            zzedm.zzxs().zzxq();
            zzayu zzxt = zzedm.zzxt();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpe)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) zzww.zzra().zzd(zzabq.zzcpf));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String optString = optJSONArray.optString(i);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String zzea : hashMap.keySet()) {
                        zzxt.zzea(zzea);
                    }
                    zzxt.zza((zzayz) new zzayx(zzxt, hashMap));
                } catch (JSONException e) {
                    zzd.zzb("Failed to parse listening list", e);
                }
            }
            zzayt zzayt2 = zzedm;
            return zzayt2;
        }
    }
}
