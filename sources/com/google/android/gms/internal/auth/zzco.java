package com.google.android.gms.internal.auth;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzco {
    private final Map<String, Map<String, String>> zza;

    zzco(Map<String, Map<String, String>> map) {
        this.zza = map;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        Map map;
        if (uri == null || (map = this.zza.get(uri.toString())) == null) {
            return null;
        }
        String valueOf = String.valueOf(str3);
        return (String) map.get(valueOf.length() != 0 ? "".concat(valueOf) : new String(""));
    }
}
