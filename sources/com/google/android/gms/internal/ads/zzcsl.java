package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsl implements zzdsr {
    private final String zzdmx;
    private final zzcsh zzguk;
    private final zzbas zzgun;

    zzcsl(zzcsh zzcsh, zzbas zzbas, String str) {
        this.zzguk = zzcsh;
        this.zzgun = zzbas;
        this.zzdmx = str;
    }

    public final Object apply(Object obj) {
        return this.zzguk.zza(this.zzgun, this.zzdmx, (SQLiteDatabase) obj);
    }
}
