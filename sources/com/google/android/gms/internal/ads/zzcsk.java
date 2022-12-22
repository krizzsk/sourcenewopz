package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsk implements zzdsr {
    private final String zzdkl;
    private final zzcsh zzguk;

    zzcsk(zzcsh zzcsh, String str) {
        this.zzguk = zzcsh;
        this.zzdkl = str;
    }

    public final Object apply(Object obj) {
        zzcsh.zza((SQLiteDatabase) obj, this.zzdkl);
        return null;
    }
}
