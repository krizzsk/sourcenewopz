package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzbah implements zzbal {
    private final String zzdkl;
    private final String zzdmo;
    private final Map zzejt;
    private final byte[] zzeju;

    zzbah(String str, String str2, Map map, byte[] bArr) {
        this.zzdmo = str;
        this.zzdkl = str2;
        this.zzejt = map;
        this.zzeju = bArr;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzbai.zza(this.zzdmo, this.zzdkl, this.zzejt, this.zzeju, jsonWriter);
    }
}
