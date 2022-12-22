package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzbak implements zzbal {
    private final Map zzeds;
    private final int zzejz;

    zzbak(int i, Map map) {
        this.zzejz = i;
        this.zzeds = map;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzbai.zza(this.zzejz, this.zzeds, jsonWriter);
    }
}
