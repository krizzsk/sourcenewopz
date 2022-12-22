package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcsm implements zzebi<SQLiteDatabase> {
    private final /* synthetic */ zzdsr zzgtc;

    zzcsm(zzcsh zzcsh, zzdsr zzdsr) {
        this.zzgtc = zzdsr;
    }

    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzd.zzex(valueOf.length() != 0 ? "Failed to get offline buffered ping database: ".concat(valueOf) : new String("Failed to get offline buffered ping database: "));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzgtc.apply((SQLiteDatabase) obj);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.zzex(valueOf.length() != 0 ? "Error executing function on offline buffered ping database: ".concat(valueOf) : new String("Error executing function on offline buffered ping database: "));
        }
    }
}
