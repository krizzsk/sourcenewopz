package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzayx implements zzayz {
    private final zzayu zzedr;
    private final Map zzeds;

    zzayx(zzayu zzayu, Map map) {
        this.zzedr = zzayu;
        this.zzeds = map;
    }

    public final void zza(SharedPreferences sharedPreferences, String str, String str2) {
        this.zzedr.zza(this.zzeds, sharedPreferences, str, str2);
    }
}
