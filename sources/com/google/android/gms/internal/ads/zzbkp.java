package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbkp implements zzbkn {
    private zzf zzecl;

    public zzbkp(zzf zzf) {
        this.zzecl = zzf;
    }

    public final void zzm(Map<String, String> map) {
        this.zzecl.zzas(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
