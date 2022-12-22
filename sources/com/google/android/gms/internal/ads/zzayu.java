package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzayu {
    private final Context zzaai;
    private final Map<String, zzayw> zzedn = new HashMap();
    /* access modifiers changed from: private */
    public final List<zzayz> zzedo = new ArrayList();
    private final zzaxx zzedp;

    zzayu(Context context, zzaxx zzaxx) {
        this.zzaai = context;
        this.zzedp = zzaxx;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(zzayz zzayz) {
        this.zzedo.add(zzayz);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzea(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zzedn.containsKey(str)) {
            if ("__default__".equals(str)) {
                sharedPreferences = SystemUtils.getDefaultSharedPreferences(this.zzaai);
            } else {
                sharedPreferences = SystemUtils.getSharedPreferences(this.zzaai, str, 0);
            }
            zzayw zzayw = new zzayw(this, str);
            this.zzedn.put(str, zzayw);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzayw);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzedp.zzxp();
        }
    }
}
