package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzce {
    private final Context zza;
    private final Map<String, SharedPreferences.Editor> zzb = new HashMap();

    public zzce(Context context) {
        this.zza = context;
    }

    public final boolean zza(String str, Object obj) {
        zzcb zza2 = zzcc.zza(this.zza, str);
        if (zza2 == null) {
            return false;
        }
        SharedPreferences.Editor zza3 = zza(zza2.zza);
        if (obj instanceof Integer) {
            zza3.putInt(zza2.zzb, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Long) {
            zza3.putLong(zza2.zzb, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof Double) {
            zza3.putFloat(zza2.zzb, ((Double) obj).floatValue());
            return true;
        } else if (obj instanceof Float) {
            zza3.putFloat(zza2.zzb, ((Float) obj).floatValue());
            return true;
        } else if (obj instanceof Boolean) {
            zza3.putBoolean(zza2.zzb, ((Boolean) obj).booleanValue());
            return true;
        } else if (!(obj instanceof String)) {
            return false;
        } else {
            zza3.putString(zza2.zzb, (String) obj);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final SharedPreferences.Editor zza(String str) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, SystemUtils.getSharedPreferences(this.zza, str, 0).edit());
        }
        return this.zzb.get(str);
    }

    public final void zza() {
        for (SharedPreferences.Editor apply : this.zzb.values()) {
            apply.apply();
        }
    }
}
