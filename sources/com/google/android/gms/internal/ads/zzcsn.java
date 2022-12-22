package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsn implements zzdsr {
    private final zzcsh zzguk;
    private final zzcso zzguo;

    zzcsn(zzcsh zzcsh, zzcso zzcso) {
        this.zzguk = zzcsh;
        this.zzguo = zzcso;
    }

    public final Object apply(Object obj) {
        return this.zzguk.zza(this.zzguo, (SQLiteDatabase) obj);
    }
}
