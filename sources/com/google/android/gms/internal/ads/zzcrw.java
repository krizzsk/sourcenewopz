package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzuh;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcrw implements zzdsr {
    private final boolean zzemp;
    private final zzcrx zzgtv;
    private final ArrayList zzgtw;
    private final zzuh.zzm zzgtx;
    private final zzuh.zzo.zzb zzgty;

    zzcrw(zzcrx zzcrx, boolean z, ArrayList arrayList, zzuh.zzm zzm, zzuh.zzo.zzb zzb) {
        this.zzgtv = zzcrx;
        this.zzemp = z;
        this.zzgtw = arrayList;
        this.zzgtx = zzm;
        this.zzgty = zzb;
    }

    public final Object apply(Object obj) {
        zzcrx zzcrx = this.zzgtv;
        boolean z = this.zzemp;
        ArrayList arrayList = this.zzgtw;
        zzuh.zzm zzm = this.zzgtx;
        zzuh.zzo.zzb zzb = this.zzgty;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (!zzcrx.zzgua.zzeci.zzzn()) {
            byte[] zza = zzcrx.zzgua.zza(z, arrayList, zzm, zzb);
            ContentValues contentValues = new ContentValues();
            contentValues.put("timestamp", Long.valueOf(zzr.zzlc().currentTimeMillis()));
            contentValues.put("serialized_proto_data", zza);
            sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
            if (!z) {
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
            }
        }
        return null;
    }
}
