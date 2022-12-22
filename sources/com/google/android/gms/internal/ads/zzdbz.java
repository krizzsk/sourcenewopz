package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdbz implements zzear {
    private final zzauj zzgca;

    zzdbz(zzauj zzauj) {
        this.zzgca = zzauj;
    }

    public final zzebt zzf(Object obj) {
        return zzebh.zzag(new zzdcb(new JsonReader(new InputStreamReader((InputStream) obj))).zzn(this.zzgca.zzdys));
    }
}
