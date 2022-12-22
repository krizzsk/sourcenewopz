package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcsh extends SQLiteOpenHelper {
    private final Context context;
    private final zzebs zzgta;

    public zzcsh(Context context2, zzebs zzebs) {
        super(context2, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzww.zzra().zzd(zzabq.zzdbd)).intValue());
        this.context = context2;
        this.zzgta = zzebs;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    private final void zza(zzdsr<SQLiteDatabase, Void> zzdsr) {
        zzebh.zza(this.zzgta.zze(new zzcsg(this)), new zzcsm(this, zzdsr), this.zzgta);
    }

    /* access modifiers changed from: private */
    public static void zza(SQLiteDatabase sQLiteDatabase, zzbas zzbas) {
        sQLiteDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("event_state = 1");
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{"url"}, sb.toString(), (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("url");
                if (columnIndex != -1) {
                    strArr[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzbas.zzen(strArr[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void zza(zzbas zzbas) {
        zza((zzdsr<SQLiteDatabase, Void>) new zzcsj(zzbas));
    }

    /* access modifiers changed from: package-private */
    public final void zza(SQLiteDatabase sQLiteDatabase, zzbas zzbas, String str) {
        this.zzgta.execute(new zzcsi(sQLiteDatabase, str, zzbas));
    }

    public final void zzb(zzbas zzbas, String str) {
        zza((zzdsr<SQLiteDatabase, Void>) new zzcsl(this, zzbas, str));
    }

    static void zza(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    public final void zzgn(String str) {
        zza((zzdsr<SQLiteDatabase, Void>) new zzcsk(this, str));
    }

    public final void zza(zzcso zzcso) {
        zza((zzdsr<SQLiteDatabase, Void>) new zzcsn(this, zzcso));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzcso zzcso, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzcso.timestamp));
        contentValues.put("gws_query_id", zzcso.zzbwe);
        contentValues.put("url", zzcso.url);
        contentValues.put("event_state", Integer.valueOf(zzcso.zzgup - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzr.zzkv();
        zzbg zzbg = zzj.zzbg(this.context);
        if (zzbg != null) {
            try {
                zzbg.zzaq(ObjectWrapper.wrap(this.context));
            } catch (RemoteException e) {
                zzd.zza("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzbas zzbas, String str, SQLiteDatabase sQLiteDatabase) throws Exception {
        zza(sQLiteDatabase, zzbas, str);
        return null;
    }

    static final /* synthetic */ void zza(SQLiteDatabase sQLiteDatabase, String str, zzbas zzbas) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zza(sQLiteDatabase, zzbas);
    }
}
