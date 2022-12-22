package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdug {
    private final String zzdbu = zzadg.zzdec.get();

    public final String zzr(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zzdbu).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }
}
