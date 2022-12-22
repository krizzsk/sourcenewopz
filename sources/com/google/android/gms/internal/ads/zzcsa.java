package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsa implements zzdsr {
    private final boolean zzemp;
    private final zzcsb zzguc;

    zzcsa(zzcsb zzcsb, boolean z) {
        this.zzguc = zzcsb;
        this.zzemp = z;
    }

    public final Object apply(Object obj) {
        return this.zzguc.zza(this.zzemp, (SQLiteDatabase) obj);
    }
}
