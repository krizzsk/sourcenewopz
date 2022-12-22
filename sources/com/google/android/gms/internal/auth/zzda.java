package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzda implements zzck {
    private static final Map<String, zzda> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static zzda zza(Context context, String str) {
        zzda zzda;
        if (!zzcc.zza()) {
            synchronized (zzda.class) {
                zzda = zza.get((Object) null);
                if (zzda == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzda;
        }
        throw null;
    }

    static synchronized void zzc() {
        synchronized (zzda.class) {
            Iterator<zzda> it = zza.values().iterator();
            if (!it.hasNext()) {
                zza.clear();
            } else {
                zzda next = it.next();
                SharedPreferences sharedPreferences = next.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = next.zzc;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
