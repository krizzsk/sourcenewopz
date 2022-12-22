package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcys implements zzcym<zzcaj> {
    private final Context context;
    private final zzcbj zzgwq;

    public zzcys(Context context2, zzcbj zzcbj) {
        this.context = context2;
        this.zzgwq = zzcbj;
    }

    public final /* synthetic */ Object zza(zzdpi zzdpi, zzdot zzdot, View view, zzcyt zzcyt) {
        zzcal zza = this.zzgwq.zza(new zzbps(zzdpi, zzdot, (String) null), new zzcyu(this, zzcyv.zzhab));
        zzcyt.zza(new zzcyx(this, zza));
        return zza.zzait();
    }
}
