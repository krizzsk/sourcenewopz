package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsi implements Runnable {
    private final String zzdkl;
    private final SQLiteDatabase zzgul;
    private final zzbas zzgum;

    zzcsi(SQLiteDatabase sQLiteDatabase, String str, zzbas zzbas) {
        this.zzgul = sQLiteDatabase;
        this.zzdkl = str;
        this.zzgum = zzbas;
    }

    public final void run() {
        zzcsh.zza(this.zzgul, this.zzdkl, this.zzgum);
    }
}
