package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzov;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzai extends zzke {
    /* access modifiers changed from: private */
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzah zzj;
    /* access modifiers changed from: private */
    public final zzka zzk = new zzka(this.zzs.zzay());

    zzai(zzkn zzkn) {
        super(zzkn);
        this.zzs.zzc();
        this.zzj = new zzah(this, this.zzs.zzax(), "google_app_measurement.db");
    }

    static final void zzX(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long zzab(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = zze().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzac(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zze().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzg();
        zzZ();
        if (zzM()) {
            long zza2 = this.zzf.zzn().zza.zza();
            long elapsedRealtime = this.zzs.zzay().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            this.zzs.zzc();
            if (abs > zzea.zzx.zzb(null).longValue()) {
                this.zzf.zzn().zza.zzb(elapsedRealtime);
                zzg();
                zzZ();
                if (zzM()) {
                    SQLiteDatabase zze2 = zze();
                    this.zzs.zzc();
                    int delete = zze2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.zzs.zzay().currentTimeMillis()), String.valueOf(zzae.zzA())});
                    if (delete > 0) {
                        this.zzs.zzau().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB(List<Long> list) {
        zzg();
        zzZ();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzM()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzab(sb3.toString(), (String[]) null) > 0) {
                this.zzs.zzau().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < ");
                sb4.append(Integer.MAX_VALUE);
                sb4.append(")");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                this.zzs.zzau().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object zzC(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzs.zzau().zzb().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                this.zzs.zzau().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.zzs.zzau().zzb().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long zzD() {
        return zzac("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final long zzE(String str, String str2) {
        String str3 = str;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzZ();
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(48);
            sb.append("select ");
            sb.append("first_open_count");
            sb.append(" from app2 where app_id=?");
            long zzac = zzac(sb.toString(), new String[]{str3}, -1);
            if (zzac == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (zze2.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.zzs.zzau().zzb().zzc("Failed to insert column (got -1). appId", zzem.zzl(str), "first_open_count");
                    zze2.endTransaction();
                    return -1;
                }
                zzac = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put("first_open_count", Long.valueOf(1 + zzac));
                if (((long) zze2.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    this.zzs.zzau().zzb().zzc("Failed to update column (got 0). appId", zzem.zzl(str), "first_open_count");
                    zze2.endTransaction();
                    return -1;
                }
                zze2.setTransactionSuccessful();
                zze2.endTransaction();
                return zzac;
            } catch (SQLiteException e) {
                e = e;
                j = zzac;
                try {
                    this.zzs.zzau().zzb().zzd("Error inserting column. appId", zzem.zzl(str), "first_open_count", e);
                    zze2.endTransaction();
                    return j;
                } catch (Throwable th) {
                    zze2.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            this.zzs.zzau().zzb().zzd("Error inserting column. appId", zzem.zzl(str), "first_open_count", e);
            zze2.endTransaction();
            return j;
        }
    }

    public final long zzF() {
        return zzac("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzG() {
        return zzab("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzH() {
        return zzab("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzI(String str) {
        Preconditions.checkNotEmpty(str);
        return zzac("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final boolean zzJ(String str, Long l, long j, zzfo zzfo) {
        zzg();
        zzZ();
        Preconditions.checkNotNull(zzfo);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbp = zzfo.zzbp();
        this.zzs.zzau().zzk().zzc("Saving complex main event, appId, data size", this.zzs.zzm().zzc(str), Integer.valueOf(zzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(ParamKeys.PARAM_EVENT_ID, l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbp);
        try {
            if (zze().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzs.zzau().zzb().zzb("Failed to insert complex main event (got -1). appId", zzem.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing complex main event. appId", zzem.zzl(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzK(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzZ()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zze()     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c3 }
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c3 }
            r3 = 0
            r2[r3] = r8     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c3 }
            java.lang.String r4 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r4, r2)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c3 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00c1 }
            if (r2 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzfu r8 = r7.zzs     // Catch:{ SQLiteException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()     // Catch:{ SQLiteException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzk()     // Catch:{ SQLiteException -> 0x00c1 }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00c1 }
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        L_0x0033:
            byte[] r2 = r1.getBlob(r3)     // Catch:{ SQLiteException -> 0x00c1 }
            com.google.android.gms.internal.measurement.zzfn r3 = com.google.android.gms.internal.measurement.zzfo.zzk()     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzlh r2 = com.google.android.gms.measurement.internal.zzkp.zzt(r3, r2)     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzkd r2 = r2.zzaA()     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzkn r8 = r7.zzf     // Catch:{ SQLiteException -> 0x00c1 }
            r8.zzm()     // Catch:{ SQLiteException -> 0x00c1 }
            java.util.List r8 = r2.zza()     // Catch:{ SQLiteException -> 0x00c1 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00c1 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00c1 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00c1 }
        L_0x0059:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00c1 }
            if (r3 == 0) goto L_0x00a1
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00c1 }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ SQLiteException -> 0x00c1 }
            java.lang.String r4 = r3.zzb()     // Catch:{ SQLiteException -> 0x00c1 }
            boolean r5 = r3.zzi()     // Catch:{ SQLiteException -> 0x00c1 }
            if (r5 == 0) goto L_0x0077
            double r5 = r3.zzj()     // Catch:{ SQLiteException -> 0x00c1 }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00c1 }
            goto L_0x0059
        L_0x0077:
            boolean r5 = r3.zzg()     // Catch:{ SQLiteException -> 0x00c1 }
            if (r5 == 0) goto L_0x0085
            float r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00c1 }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00c1 }
            goto L_0x0059
        L_0x0085:
            boolean r5 = r3.zzc()     // Catch:{ SQLiteException -> 0x00c1 }
            if (r5 == 0) goto L_0x0093
            java.lang.String r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00c1 }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00c1 }
            goto L_0x0059
        L_0x0093:
            boolean r5 = r3.zze()     // Catch:{ SQLiteException -> 0x00c1 }
            if (r5 == 0) goto L_0x0059
            long r5 = r3.zzf()     // Catch:{ SQLiteException -> 0x00c1 }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00c1 }
            goto L_0x0059
        L_0x00a1:
            if (r1 == 0) goto L_0x00a6
            r1.close()
        L_0x00a6:
            return r2
        L_0x00a7:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r7.zzs     // Catch:{ SQLiteException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ SQLiteException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x00c1 }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r8)     // Catch:{ SQLiteException -> 0x00c1 }
            r3.zzc(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00c1 }
            if (r1 == 0) goto L_0x00c0
            r1.close()
        L_0x00c0:
            return r0
        L_0x00c1:
            r8 = move-exception
            goto L_0x00c7
        L_0x00c3:
            r8 = move-exception
            goto L_0x00de
        L_0x00c5:
            r8 = move-exception
            r1 = r0
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzfu r2 = r7.zzs     // Catch:{ all -> 0x00dc }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x00db
            r1.close()
        L_0x00db:
            return r0
        L_0x00dc:
            r8 = move-exception
            r0 = r1
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            r0.close()
        L_0x00e3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzK(java.lang.String):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0327, code lost:
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0339, code lost:
        if (r3.zzg() == false) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x033b, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0344, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0345, code lost:
        r11.put("session_scoped", r0);
        r11.put("data", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0359, code lost:
        if (zze().insertWithOnConflict("property_filters", (java.lang.String) null, r11, 5) != -1) goto L_0x036f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x035b, code lost:
        r9.zzs.zzau().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzem.zzl(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x036f, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0373, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r9.zzs.zzau().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzem.zzl(r24), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03be, code lost:
        r3 = r25;
        r4 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x018b, code lost:
        r11 = r0.zzc().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0197, code lost:
        if (r11.hasNext() == false) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01a3, code lost:
        if (r11.next().zza() != false) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a5, code lost:
        r9.zzs.zzau().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzem.zzl(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01be, code lost:
        r11 = r0.zzf().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d5, code lost:
        if (r11.hasNext() == false) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r12 = r11.next();
        zzZ();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01f1, code lost:
        if (android.text.TextUtils.isEmpty(r12.zzc()) == false) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01f3, code lost:
        r0 = r9.zzs.zzau().zze();
        r8 = com.google.android.gms.measurement.internal.zzem.zzl(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x020b, code lost:
        if (r12.zza() == false) goto L_0x0218;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x020d, code lost:
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0218, code lost:
        r20 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x021a, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r8, r11, java.lang.String.valueOf(r20));
        r21 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0225, code lost:
        r3 = r12.zzbp();
        r21 = r4;
        r4 = new android.content.ContentValues();
        r4.put("app_id", r2);
        r4.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x023e, code lost:
        if (r12.zza() == false) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0240, code lost:
        r8 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0249, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x024a, code lost:
        r4.put("filter_id", r8);
        r4.put(com.didi.soda.blocks.constant.TrackConst.Params.EVENT_NAME, r12.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025a, code lost:
        if (r12.zzk() == false) goto L_0x0265;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x025c, code lost:
        r8 = java.lang.Boolean.valueOf(r12.zzm());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0265, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0266, code lost:
        r4.put("session_scoped", r8);
        r4.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x027a, code lost:
        if (zze().insertWithOnConflict("event_filters", (java.lang.String) null, r4, 5) != -1) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x027c, code lost:
        r9.zzs.zzau().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzem.zzl(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x028f, code lost:
        r3 = r25;
        r4 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02ab, code lost:
        r21 = r4;
        r0 = r0.zzc().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02b9, code lost:
        if (r0.hasNext() == false) goto L_0x03be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02bb, code lost:
        r3 = r0.next();
        zzZ();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02d5, code lost:
        if (android.text.TextUtils.isEmpty(r3.zzc()) == false) goto L_0x0304;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02d7, code lost:
        r0 = r9.zzs.zzau().zze();
        r7 = com.google.android.gms.measurement.internal.zzem.zzl(r24);
        r8 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02ef, code lost:
        if (r3.zza() == false) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02f1, code lost:
        r3 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02fa, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02fb, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r7, r8, java.lang.String.valueOf(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0304, code lost:
        r4 = r3.zzbp();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r2);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x031b, code lost:
        if (r3.zza() == false) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x031d, code lost:
        r12 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0326, code lost:
        r12 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(java.lang.String r24, java.util.List<com.google.android.gms.internal.measurement.zzeh> r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r8 = 0
        L_0x0012:
            int r9 = r25.size()
            if (r8 >= r9) goto L_0x00e9
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzeh r9 = (com.google.android.gms.internal.measurement.zzeh) r9
            com.google.android.gms.internal.measurement.zzjz r9 = r9.zzbu()
            com.google.android.gms.internal.measurement.zzeg r9 = (com.google.android.gms.internal.measurement.zzeg) r9
            int r11 = r9.zzd()
            if (r11 == 0) goto L_0x00a6
            r12 = r9
            r11 = 0
        L_0x002c:
            int r13 = r12.zzd()
            if (r11 >= r13) goto L_0x00a3
            com.google.android.gms.internal.measurement.zzej r13 = r12.zze(r11)
            com.google.android.gms.internal.measurement.zzjz r13 = r13.zzbu()
            com.google.android.gms.internal.measurement.zzei r13 = (com.google.android.gms.internal.measurement.zzei) r13
            com.google.android.gms.internal.measurement.zzjz r14 = r13.zzaq()
            com.google.android.gms.internal.measurement.zzei r14 = (com.google.android.gms.internal.measurement.zzei) r14
            java.lang.String r15 = r13.zza()
            java.lang.String r15 = com.google.android.gms.measurement.internal.zzgr.zzb(r15)
            if (r15 == 0) goto L_0x0051
            r14.zzb(r15)
            r15 = 1
            goto L_0x0052
        L_0x0051:
            r15 = 0
        L_0x0052:
            r7 = 0
        L_0x0053:
            int r10 = r13.zzc()
            if (r7 >= r10) goto L_0x008b
            com.google.android.gms.internal.measurement.zzel r10 = r13.zzd(r7)
            r16 = r13
            java.lang.String r13 = r10.zzh()
            r17 = r4
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgs.zza
            java.lang.String[] r1 = com.google.android.gms.measurement.internal.zzgs.zzb
            java.lang.String r1 = com.google.android.gms.measurement.internal.zzic.zzc(r13, r4, r1)
            if (r1 == 0) goto L_0x0082
            com.google.android.gms.internal.measurement.zzjz r4 = r10.zzbu()
            com.google.android.gms.internal.measurement.zzek r4 = (com.google.android.gms.internal.measurement.zzek) r4
            r4.zza(r1)
            com.google.android.gms.internal.measurement.zzkd r1 = r4.zzaA()
            com.google.android.gms.internal.measurement.zzel r1 = (com.google.android.gms.internal.measurement.zzel) r1
            r14.zze(r7, r1)
            r15 = 1
        L_0x0082:
            int r7 = r7 + 1
            r1 = r23
            r13 = r16
            r4 = r17
            goto L_0x0053
        L_0x008b:
            r17 = r4
            if (r15 == 0) goto L_0x009c
            r12.zzf(r11, r14)
            com.google.android.gms.internal.measurement.zzkd r1 = r9.zzaA()
            com.google.android.gms.internal.measurement.zzeh r1 = (com.google.android.gms.internal.measurement.zzeh) r1
            r3.set(r8, r1)
            r12 = r9
        L_0x009c:
            int r11 = r11 + 1
            r1 = r23
            r4 = r17
            goto L_0x002c
        L_0x00a3:
            r17 = r4
            goto L_0x00a9
        L_0x00a6:
            r17 = r4
            r12 = r9
        L_0x00a9:
            int r1 = r12.zza()
            if (r1 == 0) goto L_0x00e1
            r1 = 0
        L_0x00b0:
            int r4 = r12.zza()
            if (r1 >= r4) goto L_0x00e1
            com.google.android.gms.internal.measurement.zzes r4 = r12.zzb(r1)
            java.lang.String r7 = r4.zzc()
            java.lang.String[] r10 = com.google.android.gms.measurement.internal.zzgt.zza
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzgt.zzb
            java.lang.String r7 = com.google.android.gms.measurement.internal.zzic.zzc(r7, r10, r11)
            if (r7 == 0) goto L_0x00de
            com.google.android.gms.internal.measurement.zzjz r4 = r4.zzbu()
            com.google.android.gms.internal.measurement.zzer r4 = (com.google.android.gms.internal.measurement.zzer) r4
            r4.zza(r7)
            r12.zzc(r1, r4)
            com.google.android.gms.internal.measurement.zzkd r4 = r9.zzaA()
            com.google.android.gms.internal.measurement.zzeh r4 = (com.google.android.gms.internal.measurement.zzeh) r4
            r3.set(r8, r4)
            r12 = r9
        L_0x00de:
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00e1:
            int r8 = r8 + 1
            r1 = r23
            r4 = r17
            goto L_0x0012
        L_0x00e9:
            r17 = r4
            r23.zzZ()
            r23.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            android.database.sqlite.SQLiteDatabase r1 = r23.zze()
            r1.beginTransaction()
            r23.zzZ()     // Catch:{ all -> 0x04c0 }
            r23.zzg()     // Catch:{ all -> 0x04c0 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x04c0 }
            android.database.sqlite.SQLiteDatabase r4 = r23.zze()     // Catch:{ all -> 0x04c0 }
            r7 = 1
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ all -> 0x04c0 }
            r9 = 0
            r8[r9] = r2     // Catch:{ all -> 0x04c0 }
            r4.delete(r6, r0, r8)     // Catch:{ all -> 0x04c0 }
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ all -> 0x04c0 }
            r8[r9] = r2     // Catch:{ all -> 0x04c0 }
            r4.delete(r5, r0, r8)     // Catch:{ all -> 0x04c0 }
            java.util.Iterator r4 = r25.iterator()     // Catch:{ all -> 0x04c0 }
        L_0x011f:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x04c0 }
            if (r0 == 0) goto L_0x03c4
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x04c0 }
            com.google.android.gms.internal.measurement.zzeh r0 = (com.google.android.gms.internal.measurement.zzeh) r0     // Catch:{ all -> 0x04c0 }
            r23.zzZ()     // Catch:{ all -> 0x04c0 }
            r23.zzg()     // Catch:{ all -> 0x04c0 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x04c0 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x04c0 }
            boolean r9 = r0.zza()     // Catch:{ all -> 0x04c0 }
            if (r9 != 0) goto L_0x0153
            r9 = r23
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x04be }
            java.lang.String r7 = "Audience with no ID. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            r0.zzb(r7, r8)     // Catch:{ all -> 0x04be }
            goto L_0x011f
        L_0x0153:
            r9 = r23
            int r10 = r0.zzb()     // Catch:{ all -> 0x04be }
            java.util.List r11 = r0.zzf()     // Catch:{ all -> 0x04be }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x04be }
        L_0x0161:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x04be }
            if (r12 == 0) goto L_0x018b
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x04be }
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12     // Catch:{ all -> 0x04be }
            boolean r12 = r12.zza()     // Catch:{ all -> 0x04be }
            if (r12 != 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x04be }
            java.lang.String r7 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04be }
            r0.zzc(r7, r8, r10)     // Catch:{ all -> 0x04be }
            goto L_0x011f
        L_0x018b:
            java.util.List r11 = r0.zzc()     // Catch:{ all -> 0x04be }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x04be }
        L_0x0193:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x04be }
            if (r12 == 0) goto L_0x01be
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x04be }
            com.google.android.gms.internal.measurement.zzes r12 = (com.google.android.gms.internal.measurement.zzes) r12     // Catch:{ all -> 0x04be }
            boolean r12 = r12.zza()     // Catch:{ all -> 0x04be }
            if (r12 != 0) goto L_0x0193
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x04be }
            java.lang.String r7 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04be }
            r0.zzc(r7, r8, r10)     // Catch:{ all -> 0x04be }
            goto L_0x011f
        L_0x01be:
            java.util.List r11 = r0.zzf()     // Catch:{ all -> 0x04be }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x04be }
        L_0x01c6:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x04be }
            java.lang.String r7 = "data"
            java.lang.String r13 = "session_scoped"
            java.lang.String r14 = "filter_id"
            java.lang.String r8 = "audience_id"
            java.lang.String r15 = "app_id"
            if (r12 == 0) goto L_0x02ab
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x04be }
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12     // Catch:{ all -> 0x04be }
            r23.zzZ()     // Catch:{ all -> 0x04be }
            r23.zzg()     // Catch:{ all -> 0x04be }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x04be }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)     // Catch:{ all -> 0x04be }
            java.lang.String r21 = r12.zzc()     // Catch:{ all -> 0x04be }
            boolean r21 = android.text.TextUtils.isEmpty(r21)     // Catch:{ all -> 0x04be }
            if (r21 == 0) goto L_0x0225
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x04be }
            java.lang.String r7 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04be }
            boolean r13 = r12.zza()     // Catch:{ all -> 0x04be }
            if (r13 == 0) goto L_0x0218
            int r12 = r12.zzb()     // Catch:{ all -> 0x04be }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x04be }
            r20 = r12
            goto L_0x021a
        L_0x0218:
            r20 = 0
        L_0x021a:
            java.lang.String r12 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x04be }
            r0.zzd(r7, r8, r11, r12)     // Catch:{ all -> 0x04be }
            r21 = r4
            goto L_0x0387
        L_0x0225:
            byte[] r3 = r12.zzbp()     // Catch:{ all -> 0x04be }
            r21 = r4
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x04be }
            r4.<init>()     // Catch:{ all -> 0x04be }
            r4.put(r15, r2)     // Catch:{ all -> 0x04be }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04be }
            r4.put(r8, r15)     // Catch:{ all -> 0x04be }
            boolean r8 = r12.zza()     // Catch:{ all -> 0x04be }
            if (r8 == 0) goto L_0x0249
            int r8 = r12.zzb()     // Catch:{ all -> 0x04be }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x04be }
            goto L_0x024a
        L_0x0249:
            r8 = 0
        L_0x024a:
            r4.put(r14, r8)     // Catch:{ all -> 0x04be }
            java.lang.String r8 = "event_name"
            java.lang.String r14 = r12.zzc()     // Catch:{ all -> 0x04be }
            r4.put(r8, r14)     // Catch:{ all -> 0x04be }
            boolean r8 = r12.zzk()     // Catch:{ all -> 0x04be }
            if (r8 == 0) goto L_0x0265
            boolean r8 = r12.zzm()     // Catch:{ all -> 0x04be }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x04be }
            goto L_0x0266
        L_0x0265:
            r8 = 0
        L_0x0266:
            r4.put(r13, r8)     // Catch:{ all -> 0x04be }
            r4.put(r7, r3)     // Catch:{ all -> 0x04be }
            android.database.sqlite.SQLiteDatabase r3 = r23.zze()     // Catch:{ SQLiteException -> 0x0295 }
            r7 = 5
            r8 = 0
            long r3 = r3.insertWithOnConflict(r5, r8, r4, r7)     // Catch:{ SQLiteException -> 0x0295 }
            r7 = -1
            int r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x028f
            com.google.android.gms.measurement.internal.zzfu r3 = r9.zzs     // Catch:{ SQLiteException -> 0x0295 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ SQLiteException -> 0x0295 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0295 }
            java.lang.String r4 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ SQLiteException -> 0x0295 }
            r3.zzb(r4, r7)     // Catch:{ SQLiteException -> 0x0295 }
        L_0x028f:
            r3 = r25
            r4 = r21
            goto L_0x01c6
        L_0x0295:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x04be }
            java.lang.String r4 = "Error storing event filter. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            r3.zzc(r4, r7, r0)     // Catch:{ all -> 0x04be }
            goto L_0x0387
        L_0x02ab:
            r21 = r4
            java.util.List r0 = r0.zzc()     // Catch:{ all -> 0x04be }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x04be }
        L_0x02b5:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x04be }
            if (r3 == 0) goto L_0x03be
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x04be }
            com.google.android.gms.internal.measurement.zzes r3 = (com.google.android.gms.internal.measurement.zzes) r3     // Catch:{ all -> 0x04be }
            r23.zzZ()     // Catch:{ all -> 0x04be }
            r23.zzg()     // Catch:{ all -> 0x04be }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x04be }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x04be }
            java.lang.String r4 = r3.zzc()     // Catch:{ all -> 0x04be }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x04be }
            if (r4 == 0) goto L_0x0304
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x04be }
            java.lang.String r4 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04be }
            boolean r11 = r3.zza()     // Catch:{ all -> 0x04be }
            if (r11 == 0) goto L_0x02fa
            int r3 = r3.zzb()     // Catch:{ all -> 0x04be }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x04be }
            goto L_0x02fb
        L_0x02fa:
            r3 = 0
        L_0x02fb:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x04be }
            r0.zzd(r4, r7, r8, r3)     // Catch:{ all -> 0x04be }
            goto L_0x0387
        L_0x0304:
            byte[] r4 = r3.zzbp()     // Catch:{ all -> 0x04be }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ all -> 0x04be }
            r11.<init>()     // Catch:{ all -> 0x04be }
            r11.put(r15, r2)     // Catch:{ all -> 0x04be }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x04be }
            r11.put(r8, r12)     // Catch:{ all -> 0x04be }
            boolean r12 = r3.zza()     // Catch:{ all -> 0x04be }
            if (r12 == 0) goto L_0x0326
            int r12 = r3.zzb()     // Catch:{ all -> 0x04be }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x04be }
            goto L_0x0327
        L_0x0326:
            r12 = 0
        L_0x0327:
            r11.put(r14, r12)     // Catch:{ all -> 0x04be }
            java.lang.String r12 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.zzc()     // Catch:{ all -> 0x04be }
            r11.put(r12, r0)     // Catch:{ all -> 0x04be }
            boolean r0 = r3.zzg()     // Catch:{ all -> 0x04be }
            if (r0 == 0) goto L_0x0344
            boolean r0 = r3.zzh()     // Catch:{ all -> 0x04be }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x04be }
            goto L_0x0345
        L_0x0344:
            r0 = 0
        L_0x0345:
            r11.put(r13, r0)     // Catch:{ all -> 0x04be }
            r11.put(r7, r4)     // Catch:{ all -> 0x04be }
            android.database.sqlite.SQLiteDatabase r0 = r23.zze()     // Catch:{ SQLiteException -> 0x0373 }
            r3 = 0
            r4 = 5
            long r11 = r0.insertWithOnConflict(r6, r3, r11, r4)     // Catch:{ SQLiteException -> 0x0373 }
            r18 = -1
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x036f
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs     // Catch:{ SQLiteException -> 0x0373 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0373 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0373 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ SQLiteException -> 0x0373 }
            r0.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x0373 }
            goto L_0x0387
        L_0x036f:
            r0 = r22
            goto L_0x02b5
        L_0x0373:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x04be }
            java.lang.String r4 = "Error storing property filter. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            r3.zzc(r4, r7, r0)     // Catch:{ all -> 0x04be }
        L_0x0387:
            r23.zzZ()     // Catch:{ all -> 0x04be }
            r23.zzg()     // Catch:{ all -> 0x04be }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x04be }
            android.database.sqlite.SQLiteDatabase r0 = r23.zze()     // Catch:{ all -> 0x04be }
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ all -> 0x04be }
            r3 = 0
            r4[r3] = r2     // Catch:{ all -> 0x04be }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x04be }
            r7 = 1
            r4[r7] = r3     // Catch:{ all -> 0x04be }
            r3 = r17
            r0.delete(r6, r3, r4)     // Catch:{ all -> 0x04be }
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x04be }
            r7 = 0
            r4[r7] = r2     // Catch:{ all -> 0x04be }
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x04be }
            r8 = 1
            r4[r8] = r7     // Catch:{ all -> 0x04be }
            r0.delete(r5, r3, r4)     // Catch:{ all -> 0x04be }
            r17 = r3
            r4 = r21
            r3 = r25
            goto L_0x011f
        L_0x03be:
            r3 = r25
            r4 = r21
            goto L_0x011f
        L_0x03c4:
            r3 = 0
            r9 = r23
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x04be }
            r0.<init>()     // Catch:{ all -> 0x04be }
            java.util.Iterator r4 = r25.iterator()     // Catch:{ all -> 0x04be }
        L_0x03d0:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x04be }
            if (r5 == 0) goto L_0x03f0
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x04be }
            com.google.android.gms.internal.measurement.zzeh r5 = (com.google.android.gms.internal.measurement.zzeh) r5     // Catch:{ all -> 0x04be }
            boolean r6 = r5.zza()     // Catch:{ all -> 0x04be }
            if (r6 == 0) goto L_0x03eb
            int r5 = r5.zzb()     // Catch:{ all -> 0x04be }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x04be }
            goto L_0x03ec
        L_0x03eb:
            r8 = r3
        L_0x03ec:
            r0.add(r8)     // Catch:{ all -> 0x04be }
            goto L_0x03d0
        L_0x03f0:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x04be }
            r23.zzZ()     // Catch:{ all -> 0x04be }
            r23.zzg()     // Catch:{ all -> 0x04be }
            android.database.sqlite.SQLiteDatabase r3 = r23.zze()     // Catch:{ all -> 0x04be }
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x04a3 }
            r4 = 0
            r5[r4] = r2     // Catch:{ SQLiteException -> 0x04a3 }
            java.lang.String r4 = "select count(1) from audience_filter_values where app_id=?"
            long r4 = r9.zzab(r4, r5)     // Catch:{ SQLiteException -> 0x04a3 }
            com.google.android.gms.measurement.internal.zzfu r6 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ all -> 0x04be }
            r7 = 2000(0x7d0, float:2.803E-42)
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzea.zzE     // Catch:{ all -> 0x04be }
            int r6 = r6.zzk(r2, r8)     // Catch:{ all -> 0x04be }
            int r6 = java.lang.Math.min(r7, r6)     // Catch:{ all -> 0x04be }
            r7 = 0
            int r6 = java.lang.Math.max(r7, r6)     // Catch:{ all -> 0x04be }
            long r7 = (long) r6     // Catch:{ all -> 0x04be }
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x0428
            goto L_0x04b7
        L_0x0428:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x04be }
            r4.<init>()     // Catch:{ all -> 0x04be }
            r5 = 0
        L_0x042e:
            int r7 = r0.size()     // Catch:{ all -> 0x04be }
            if (r5 >= r7) goto L_0x044a
            java.lang.Object r7 = r0.get(r5)     // Catch:{ all -> 0x04be }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x04be }
            if (r7 == 0) goto L_0x04b7
            int r7 = r7.intValue()     // Catch:{ all -> 0x04be }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x04be }
            r4.add(r7)     // Catch:{ all -> 0x04be }
            int r5 = r5 + 1
            goto L_0x042e
        L_0x044a:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r4)     // Catch:{ all -> 0x04be }
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04be }
            int r4 = r4.length()     // Catch:{ all -> 0x04be }
            r5 = 2
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x04be }
            r5.<init>(r4)     // Catch:{ all -> 0x04be }
            java.lang.String r4 = "("
            r5.append(r4)     // Catch:{ all -> 0x04be }
            r5.append(r0)     // Catch:{ all -> 0x04be }
            java.lang.String r0 = ")"
            r5.append(r0)     // Catch:{ all -> 0x04be }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x04be }
            java.lang.String r4 = "audience_filter_values"
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04be }
            int r5 = r5.length()     // Catch:{ all -> 0x04be }
            int r5 = r5 + 140
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x04be }
            r7.<init>(r5)     // Catch:{ all -> 0x04be }
            java.lang.String r5 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r7.append(r5)     // Catch:{ all -> 0x04be }
            r7.append(r0)     // Catch:{ all -> 0x04be }
            java.lang.String r0 = " order by rowid desc limit -1 offset ?)"
            r7.append(r0)     // Catch:{ all -> 0x04be }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x04be }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x04be }
            r7 = 0
            r5[r7] = r2     // Catch:{ all -> 0x04be }
            java.lang.String r2 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x04be }
            r6 = 1
            r5[r6] = r2     // Catch:{ all -> 0x04be }
            r3.delete(r4, r0, r5)     // Catch:{ all -> 0x04be }
            goto L_0x04b7
        L_0x04a3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r9.zzs     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x04be }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x04be }
            java.lang.String r4 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzem.zzl(r24)     // Catch:{ all -> 0x04be }
            r3.zzc(r4, r2, r0)     // Catch:{ all -> 0x04be }
        L_0x04b7:
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x04be }
            r1.endTransaction()
            return
        L_0x04be:
            r0 = move-exception
            goto L_0x04c3
        L_0x04c0:
            r0 = move-exception
            r9 = r23
        L_0x04c3:
            r1.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzL(java.lang.String, java.util.List):void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzM() {
        Context zzax = this.zzs.zzax();
        this.zzs.zzc();
        return zzax.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0091=Splitter:B:29:0x0091, B:12:0x003e=Splitter:B:12:0x003e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzW(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.zzkm r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r26
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r26)
            r20.zzg()
            r20.zzZ()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r20.zze()     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r5 = ""
            r13 = -1
            r15 = 2
            r12 = 1
            r11 = 0
            if (r4 == 0) goto L_0x007a
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0032
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r6[r11] = r7     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            goto L_0x003a
        L_0x0032:
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r6[r11] = r7     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
        L_0x003a:
            if (r4 == 0) goto L_0x003e
            java.lang.String r5 = "rowid <= ? and "
        L_0x003e:
            int r4 = r5.length()     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            int r4 = r4 + 148
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r7.<init>(r4)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where "
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r7.append(r5)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r4 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r4 = r7.toString()     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r5 != 0) goto L_0x006b
            if (r4 == 0) goto L_0x006a
            r4.close()
        L_0x006a:
            return
        L_0x006b:
            java.lang.String r3 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0077 }
            r4.close()     // Catch:{ SQLiteException -> 0x0077 }
            goto L_0x00c5
        L_0x0077:
            r0 = move-exception
            goto L_0x0228
        L_0x007a:
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0089
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r6[r11] = r3     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            goto L_0x008d
        L_0x0089:
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
        L_0x008d:
            if (r4 == 0) goto L_0x0091
            java.lang.String r5 = " and rowid <= ?"
        L_0x0091:
            int r4 = r5.length()     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            int r4 = r4 + 84
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r7.<init>(r4)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r4 = "select metadata_fingerprint from raw_events where app_id = ?"
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            r7.append(r5)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r4 = " order by rowid limit 1;"
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            java.lang.String r4 = r7.toString()     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x0226, all -> 0x0224 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r5 != 0) goto L_0x00be
            if (r4 == 0) goto L_0x00bd
            r4.close()
        L_0x00bd:
            return
        L_0x00be:
            java.lang.String r5 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x0077 }
            r4.close()     // Catch:{ SQLiteException -> 0x0077 }
        L_0x00c5:
            r16 = r4
            r17 = r5
            java.lang.String r4 = "metadata"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0220, all -> 0x021c }
            java.lang.String[] r8 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0220, all -> 0x021c }
            r8[r11] = r3     // Catch:{ SQLiteException -> 0x0220, all -> 0x021c }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0220, all -> 0x021c }
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r9 = 0
            r10 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "2"
            r4 = r0
            r15 = 0
            r11 = r18
            r12 = r19
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021c }
            boolean r4 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            if (r4 != 0) goto L_0x0108
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            if (r12 == 0) goto L_0x0107
            r12.close()
        L_0x0107:
            return
        L_0x0108:
            byte[] r4 = r12.getBlob(r15)     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            com.google.android.gms.internal.measurement.zzfv r5 = com.google.android.gms.internal.measurement.zzfw.zzaj()     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzlh r4 = com.google.android.gms.measurement.internal.zzkp.zzt(r5, r4)     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzfv r4 = (com.google.android.gms.internal.measurement.zzfv) r4     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzkd r4 = r4.zzaA()     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzfw r4 = (com.google.android.gms.internal.measurement.zzfw) r4     // Catch:{ IOException -> 0x01f5 }
            boolean r5 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            if (r5 == 0) goto L_0x0135
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zze()     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
        L_0x0135:
            r12.close()     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r2.zza = r4     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r11 = 3
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0155
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r5[r15] = r3     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r13 = 1
            r5[r13] = r17     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r7 = 2
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r7 = r4
            r8 = r5
            goto L_0x0161
        L_0x0155:
            r13 = 1
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            r5 = 2
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r6[r15] = r3     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r6[r13] = r17     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            r7 = r4
            r8 = r6
        L_0x0161:
            java.lang.String r4 = "rowid"
            java.lang.String r5 = "name"
            java.lang.String r6 = "timestamp"
            java.lang.String r9 = "data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r9}     // Catch:{ SQLiteException -> 0x0218, all -> 0x0214 }
            java.lang.String r5 = "raw_events"
            r9 = 0
            r10 = 0
            java.lang.String r14 = "rowid"
            r16 = 0
            r4 = r0
            r13 = 3
            r11 = r14
            r14 = r12
            r12 = r16
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r0 == 0) goto L_0x01dc
        L_0x0186:
            long r5 = r4.getLong(r15)     // Catch:{ SQLiteException -> 0x0077 }
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.internal.measurement.zzfn r7 = com.google.android.gms.internal.measurement.zzfo.zzk()     // Catch:{ IOException -> 0x01ba }
            com.google.android.gms.internal.measurement.zzlh r0 = com.google.android.gms.measurement.internal.zzkp.zzt(r7, r0)     // Catch:{ IOException -> 0x01ba }
            com.google.android.gms.internal.measurement.zzfn r0 = (com.google.android.gms.internal.measurement.zzfn) r0     // Catch:{ IOException -> 0x01ba }
            r7 = 1
            java.lang.String r8 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x0077 }
            r0.zzl(r8)     // Catch:{ SQLiteException -> 0x0077 }
            r8 = 2
            long r9 = r4.getLong(r8)     // Catch:{ SQLiteException -> 0x0077 }
            r0.zzo(r9)     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.internal.measurement.zzfo r0 = (com.google.android.gms.internal.measurement.zzfo) r0     // Catch:{ SQLiteException -> 0x0077 }
            boolean r0 = r2.zza(r5, r0)     // Catch:{ SQLiteException -> 0x0077 }
            if (r0 != 0) goto L_0x01d0
            if (r4 == 0) goto L_0x01b9
            r4.close()
        L_0x01b9:
            return
        L_0x01ba:
            r0 = move-exception
            r7 = 1
            r8 = 2
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0077 }
            r5.zzc(r6, r9, r0)     // Catch:{ SQLiteException -> 0x0077 }
        L_0x01d0:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0077 }
            if (r0 != 0) goto L_0x0186
            if (r4 == 0) goto L_0x0240
            r4.close()
            return
        L_0x01dc:
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0077 }
            r0.zzb(r2, r5)     // Catch:{ SQLiteException -> 0x0077 }
            if (r4 == 0) goto L_0x01f4
            r4.close()
        L_0x01f4:
            return
        L_0x01f5:
            r0 = move-exception
            r14 = r12
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r2.zzc(r4, r5, r0)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            if (r14 == 0) goto L_0x020f
            r14.close()
        L_0x020f:
            return
        L_0x0210:
            r0 = move-exception
            goto L_0x0216
        L_0x0212:
            r0 = move-exception
            goto L_0x021a
        L_0x0214:
            r0 = move-exception
            r14 = r12
        L_0x0216:
            r3 = r14
            goto L_0x0243
        L_0x0218:
            r0 = move-exception
            r14 = r12
        L_0x021a:
            r4 = r14
            goto L_0x0228
        L_0x021c:
            r0 = move-exception
            r3 = r16
            goto L_0x0243
        L_0x0220:
            r0 = move-exception
            r4 = r16
            goto L_0x0228
        L_0x0224:
            r0 = move-exception
            goto L_0x0243
        L_0x0226:
            r0 = move-exception
            r4 = r3
        L_0x0228:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x0241 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0241 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0241 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x0241 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0241 }
            if (r4 == 0) goto L_0x0240
            r4.close()
        L_0x0240:
            return
        L_0x0241:
            r0 = move-exception
            r3 = r4
        L_0x0243:
            if (r3 == 0) goto L_0x0248
            r3.close()
        L_0x0248:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzW(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzkm):void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzaA() {
        return false;
    }

    public final void zzb() {
        zzZ();
        zze().beginTransaction();
    }

    public final void zzc() {
        zzZ();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzZ();
        zze().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzs.zzau().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzao zzf(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r15 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            r27.zzg()
            r27.zzZ()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r19 = 0
            android.database.sqlite.SQLiteDatabase r2 = r27.zze()     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r10 = 0
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r4 = r0
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r6[r10] = r28     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r11 = 1
            r6[r11] = r15     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.String r3 = "events"
            java.lang.String r5 = "app_id=? and name=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r2 != 0) goto L_0x005e
            if (r13 == 0) goto L_0x005d
            r13.close()
        L_0x005d:
            return r19
        L_0x005e:
            long r5 = r13.getLong(r10)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            long r7 = r13.getLong(r11)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            long r16 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r0 = 3
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r3 = 0
            if (r2 == 0) goto L_0x0076
            r20 = r3
            goto L_0x007a
        L_0x0076:
            long r20 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
        L_0x007a:
            r0 = 4
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r2 == 0) goto L_0x0084
            r0 = r19
            goto L_0x008c
        L_0x0084:
            long r22 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
        L_0x008c:
            r2 = 5
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 == 0) goto L_0x0096
            r18 = r19
            goto L_0x00a0
        L_0x0096:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r18 = r2
        L_0x00a0:
            r2 = 6
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 == 0) goto L_0x00aa
            r22 = r19
            goto L_0x00b4
        L_0x00aa:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r22 = r2
        L_0x00b4:
            r2 = 7
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 != 0) goto L_0x00cd
            long r23 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r25 = 1
            int r2 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r2 != 0) goto L_0x00c6
            r10 = 1
        L_0x00c6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r23 = r2
            goto L_0x00cf
        L_0x00cd:
            r23 = r19
        L_0x00cf:
            r2 = 8
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 == 0) goto L_0x00d9
            r9 = r3
            goto L_0x00de
        L_0x00d9:
            long r2 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r9 = r2
        L_0x00de:
            com.google.android.gms.measurement.internal.zzao r24 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r2 = r24
            r3 = r28
            r4 = r29
            r11 = r16
            r25 = r13
            r13 = r20
            r15 = r0
            r16 = r18
            r17 = r22
            r18 = r23
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            boolean r0 = r25.moveToNext()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            if (r0 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r28)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            r0.zzb(r2, r3)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
        L_0x010f:
            if (r25 == 0) goto L_0x0114
            r25.close()
        L_0x0114:
            return r24
        L_0x0115:
            r0 = move-exception
            goto L_0x011c
        L_0x0117:
            r0 = move-exception
            goto L_0x0122
        L_0x0119:
            r0 = move-exception
            r25 = r13
        L_0x011c:
            r19 = r25
            goto L_0x0152
        L_0x011f:
            r0 = move-exception
            r25 = r13
        L_0x0122:
            r13 = r25
            goto L_0x012a
        L_0x0125:
            r0 = move-exception
            goto L_0x0152
        L_0x0127:
            r0 = move-exception
            r13 = r19
        L_0x012a:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x014f }
            java.lang.String r3 = "Error querying events. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r28)     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ all -> 0x014f }
            r6 = r29
            java.lang.String r5 = r5.zzc(r6)     // Catch:{ all -> 0x014f }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x014f }
            if (r13 == 0) goto L_0x014e
            r13.close()
        L_0x014e:
            return r19
        L_0x014f:
            r0 = move-exception
            r19 = r13
        L_0x0152:
            if (r19 == 0) goto L_0x0157
            r19.close()
        L_0x0157:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzf(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzao");
    }

    public final void zzh(zzao zzao) {
        Preconditions.checkNotNull(zzao);
        zzg();
        zzZ();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzao.zza);
        contentValues.put("name", zzao.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzao.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzao.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzao.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzao.zzg));
        contentValues.put("last_bundled_day", zzao.zzh);
        contentValues.put("last_sampled_complex_event_id", zzao.zzi);
        contentValues.put("last_sampling_rate", zzao.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzao.zze));
        Boolean bool = zzao.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzem.zzl(zzao.zza));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing event aggregates. appId", zzem.zzl(zzao.zza), e);
        }
    }

    public final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzZ();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzd("Error deleting user property. appId", zzem.zzl(str), this.zzs.zzm().zze(str2), e);
        }
    }

    public final boolean zzj(zzks zzks) {
        Preconditions.checkNotNull(zzks);
        zzg();
        zzZ();
        if (zzk(zzks.zza, zzks.zzc) == null) {
            if (zzku.zzh(zzks.zzc)) {
                if (zzab("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzks.zza}) >= ((long) this.zzs.zzc().zzl(zzks.zza, zzea.zzF, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zzks.zzc)) {
                long zzab = zzab("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzks.zza, zzks.zzb});
                this.zzs.zzc();
                if (zzab >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzks.zza);
        contentValues.put("origin", zzks.zzb);
        contentValues.put("name", zzks.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzks.zzd));
        zzX(contentValues, "value", zzks.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update user property (got -1). appId", zzem.zzl(zzks.zza));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing user property. appId", zzem.zzl(zzks.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzks zzk(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r19.zzg()
            r19.zzZ()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.zze()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r2 = 0
            r15[r2] = r20     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r3 = 1
            r15[r3] = r9     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r12 = "user_attributes"
            java.lang.String r14 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            boolean r4 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0082 }
            if (r4 != 0) goto L_0x0045
            if (r11 == 0) goto L_0x0044
            r11.close()
        L_0x0044:
            return r10
        L_0x0045:
            long r6 = r11.getLong(r2)     // Catch:{ SQLiteException -> 0x0082 }
            java.lang.Object r8 = r1.zzC(r11, r3)     // Catch:{ SQLiteException -> 0x0082 }
            if (r8 != 0) goto L_0x0055
            if (r11 == 0) goto L_0x0054
            r11.close()
        L_0x0054:
            return r10
        L_0x0055:
            java.lang.String r4 = r11.getString(r0)     // Catch:{ SQLiteException -> 0x0082 }
            com.google.android.gms.measurement.internal.zzks r0 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ SQLiteException -> 0x0082 }
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x0082 }
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0082 }
            if (r2 == 0) goto L_0x007c
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x0082 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0082 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0082 }
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r20)     // Catch:{ SQLiteException -> 0x0082 }
            r2.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x0082 }
        L_0x007c:
            if (r11 == 0) goto L_0x0081
            r11.close()
        L_0x0081:
            return r0
        L_0x0082:
            r0 = move-exception
            goto L_0x0088
        L_0x0084:
            r0 = move-exception
            goto L_0x00ad
        L_0x0086:
            r0 = move-exception
            r11 = r10
        L_0x0088:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x00ab }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x00ab }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r20)     // Catch:{ all -> 0x00ab }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ all -> 0x00ab }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ all -> 0x00ab }
            java.lang.String r5 = r5.zze(r9)     // Catch:{ all -> 0x00ab }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x00ab }
            if (r11 == 0) goto L_0x00aa
            r11.close()
        L_0x00aa:
            return r10
        L_0x00ab:
            r0 = move-exception
            r10 = r11
        L_0x00ad:
            if (r10 == 0) goto L_0x00b2
            r10.close()
        L_0x00b2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzks");
    }

    public final List<zzks> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.zzs.zzc();
            Cursor query = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = query.getLong(2);
                    Object zzC = zzC(query, 3);
                    if (zzC == null) {
                        this.zzs.zzau().zzb().zzb("Read invalid user property value, ignoring it. appId", zzem.zzl(str));
                    } else {
                        arrayList.add(new zzks(str, str2, string, j, zzC));
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error querying user properties. appId", zzem.zzl(str), e);
            List<zzks> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0124 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzks> zzm(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r16 = this;
            r1 = r16
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r17)
            r16.zzg()
            r16.zzZ()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r10 = "1001"
            r11 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0106 }
            r12 = 3
            r2.<init>(r12)     // Catch:{ SQLiteException -> 0x0106 }
            r13 = r17
            r2.add(r13)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r4 = "app_id=?"
            r3.<init>(r4)     // Catch:{ SQLiteException -> 0x0104 }
            boolean r4 = android.text.TextUtils.isEmpty(r18)     // Catch:{ SQLiteException -> 0x0104 }
            if (r4 != 0) goto L_0x0036
            r14 = r18
            r2.add(r14)     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r4 = " and origin=?"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0100 }
            goto L_0x0038
        L_0x0036:
            r14 = r18
        L_0x0038:
            boolean r4 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x0100 }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = java.lang.String.valueOf(r19)     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r5 = "*"
            java.lang.String r4 = r4.concat(r5)     // Catch:{ SQLiteException -> 0x0100 }
            r2.add(r4)     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r4 = " and name glob ?"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0100 }
        L_0x0050:
            int r4 = r2.size()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.Object[] r2 = r2.toArray(r4)     // Catch:{ SQLiteException -> 0x0100 }
            r6 = r2
            java.lang.String[] r6 = (java.lang.String[]) r6     // Catch:{ SQLiteException -> 0x0100 }
            android.database.sqlite.SQLiteDatabase r2 = r16.zze()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r4 = "user_attributes"
            java.lang.String r5 = "name"
            java.lang.String r7 = "set_timestamp"
            java.lang.String r8 = "value"
            java.lang.String r9 = "origin"
            java.lang.String[] r5 = new java.lang.String[]{r5, r7, r8, r9}     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r7 = r3.toString()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r9 = "rowid"
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ SQLiteException -> 0x0100 }
            r3.zzc()     // Catch:{ SQLiteException -> 0x0100 }
            r8 = 0
            r15 = 0
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r8
            r8 = r15
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0100 }
            boolean r2 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0100 }
            if (r2 != 0) goto L_0x0094
            if (r11 == 0) goto L_0x0093
            r11.close()
        L_0x0093:
            return r0
        L_0x0094:
            int r2 = r0.size()     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ SQLiteException -> 0x0100 }
            r3.zzc()     // Catch:{ SQLiteException -> 0x0100 }
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 < r3) goto L_0x00ba
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x0100 }
            r5.zzc()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0100 }
            r2.zzb(r4, r3)     // Catch:{ SQLiteException -> 0x0100 }
            goto L_0x00fa
        L_0x00ba:
            r2 = 0
            java.lang.String r6 = r11.getString(r2)     // Catch:{ SQLiteException -> 0x0100 }
            r2 = 1
            long r7 = r11.getLong(r2)     // Catch:{ SQLiteException -> 0x0100 }
            r2 = 2
            java.lang.Object r9 = r1.zzC(r11, r2)     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r14 = r11.getString(r12)     // Catch:{ SQLiteException -> 0x0100 }
            if (r9 != 0) goto L_0x00e5
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r3 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r17)     // Catch:{ SQLiteException -> 0x0100 }
            r10 = r19
            r2.zzd(r3, r4, r14, r10)     // Catch:{ SQLiteException -> 0x0100 }
            goto L_0x00f3
        L_0x00e5:
            r10 = r19
            com.google.android.gms.measurement.internal.zzks r2 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ SQLiteException -> 0x0100 }
            r3 = r2
            r4 = r17
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x0100 }
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0100 }
        L_0x00f3:
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0100 }
            if (r2 == 0) goto L_0x00fa
            goto L_0x0094
        L_0x00fa:
            if (r11 == 0) goto L_0x00ff
            r11.close()
        L_0x00ff:
            return r0
        L_0x0100:
            r0 = move-exception
            goto L_0x010b
        L_0x0102:
            r0 = move-exception
            goto L_0x0128
        L_0x0104:
            r0 = move-exception
            goto L_0x0109
        L_0x0106:
            r0 = move-exception
            r13 = r17
        L_0x0109:
            r14 = r18
        L_0x010b:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x0102 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r17)     // Catch:{ all -> 0x0102 }
            r2.zzd(r3, r4, r14, r0)     // Catch:{ all -> 0x0102 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0102 }
            if (r11 == 0) goto L_0x0127
            r11.close()
        L_0x0127:
            return r0
        L_0x0128:
            if (r11 == 0) goto L_0x012d
            r11.close()
        L_0x012d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzm(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zzn(zzaa zzaa) {
        Preconditions.checkNotNull(zzaa);
        zzg();
        zzZ();
        String str = zzaa.zza;
        Preconditions.checkNotNull(str);
        if (zzk(str, zzaa.zzc.zzb) == null) {
            long zzab = zzab("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzs.zzc();
            if (zzab >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaa.zzb);
        contentValues.put("name", zzaa.zzc.zzb);
        zzX(contentValues, "value", Preconditions.checkNotNull(zzaa.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzaa.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaa.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaa.zzh));
        contentValues.put("timed_out_event", this.zzs.zzl().zzX(zzaa.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaa.zzd));
        contentValues.put("triggered_event", this.zzs.zzl().zzX(zzaa.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaa.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaa.zzj));
        contentValues.put("expired_event", this.zzs.zzl().zzX(zzaa.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzem.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing conditional user property", zzem.zzl(str), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzaa zzo(java.lang.String r31, java.lang.String r32) {
        /*
            r30 = this;
            r1 = r30
            r8 = r32
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            r30.zzg()
            r30.zzZ()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r30.zze()     // Catch:{ SQLiteException -> 0x0106, all -> 0x0104 }
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x0106, all -> 0x0104 }
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0106, all -> 0x0104 }
            r2 = 0
            r14[r2] = r31     // Catch:{ SQLiteException -> 0x0106, all -> 0x0104 }
            r3 = 1
            r14[r3] = r8     // Catch:{ SQLiteException -> 0x0106, all -> 0x0104 }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r13 = "app_id=? and name=?"
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0106, all -> 0x0104 }
            boolean r4 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0102 }
            if (r4 != 0) goto L_0x0058
            if (r10 == 0) goto L_0x0057
            r10.close()
        L_0x0057:
            return r9
        L_0x0058:
            java.lang.String r17 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.Object r6 = r1.zzC(r10, r3)     // Catch:{ SQLiteException -> 0x0102 }
            int r0 = r10.getInt(r0)     // Catch:{ SQLiteException -> 0x0102 }
            if (r0 == 0) goto L_0x0069
            r21 = 1
            goto L_0x006b
        L_0x0069:
            r21 = 0
        L_0x006b:
            r0 = 3
            java.lang.String r22 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0102 }
            r0 = 4
            long r24 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzkn r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzm()     // Catch:{ SQLiteException -> 0x0102 }
            r2 = 5
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0102 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzas> r3 = com.google.android.gms.measurement.internal.zzas.CREATOR     // Catch:{ SQLiteException -> 0x0102 }
            android.os.Parcelable r0 = r0.zzk(r2, r3)     // Catch:{ SQLiteException -> 0x0102 }
            r23 = r0
            com.google.android.gms.measurement.internal.zzas r23 = (com.google.android.gms.measurement.internal.zzas) r23     // Catch:{ SQLiteException -> 0x0102 }
            r0 = 6
            long r19 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzkn r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzm()     // Catch:{ SQLiteException -> 0x0102 }
            r2 = 7
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0102 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzas> r3 = com.google.android.gms.measurement.internal.zzas.CREATOR     // Catch:{ SQLiteException -> 0x0102 }
            android.os.Parcelable r0 = r0.zzk(r2, r3)     // Catch:{ SQLiteException -> 0x0102 }
            r26 = r0
            com.google.android.gms.measurement.internal.zzas r26 = (com.google.android.gms.measurement.internal.zzas) r26     // Catch:{ SQLiteException -> 0x0102 }
            r0 = 8
            long r4 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0102 }
            r0 = 9
            long r27 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzkn r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzm()     // Catch:{ SQLiteException -> 0x0102 }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0102 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzas> r3 = com.google.android.gms.measurement.internal.zzas.CREATOR     // Catch:{ SQLiteException -> 0x0102 }
            android.os.Parcelable r0 = r0.zzk(r2, r3)     // Catch:{ SQLiteException -> 0x0102 }
            r29 = r0
            com.google.android.gms.measurement.internal.zzas r29 = (com.google.android.gms.measurement.internal.zzas) r29     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzkq r18 = new com.google.android.gms.measurement.internal.zzkq     // Catch:{ SQLiteException -> 0x0102 }
            r2 = r18
            r3 = r32
            r7 = r17
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzaa r0 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ SQLiteException -> 0x0102 }
            r15 = r0
            r16 = r31
            r15.<init>(r16, r17, r18, r19, r21, r22, r23, r24, r26, r27, r29)     // Catch:{ SQLiteException -> 0x0102 }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0102 }
            if (r2 == 0) goto L_0x00fc
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r31)     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r5 = r5.zze(r8)     // Catch:{ SQLiteException -> 0x0102 }
            r2.zzc(r3, r4, r5)     // Catch:{ SQLiteException -> 0x0102 }
        L_0x00fc:
            if (r10 == 0) goto L_0x0101
            r10.close()
        L_0x0101:
            return r0
        L_0x0102:
            r0 = move-exception
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            goto L_0x012d
        L_0x0106:
            r0 = move-exception
            r10 = r9
        L_0x0108:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x012b }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x012b }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x012b }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r31)     // Catch:{ all -> 0x012b }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ all -> 0x012b }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ all -> 0x012b }
            java.lang.String r5 = r5.zze(r8)     // Catch:{ all -> 0x012b }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x012b }
            if (r10 == 0) goto L_0x012a
            r10.close()
        L_0x012a:
            return r9
        L_0x012b:
            r0 = move-exception
            r9 = r10
        L_0x012d:
            if (r9 == 0) goto L_0x0132
            r9.close()
        L_0x0132:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzo(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaa");
    }

    public final int zzp(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzZ();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzd("Error deleting conditional property", zzem.zzl(str), this.zzs.zzm().zze(str2), e);
            return 0;
        }
    }

    public final List<zzaa> zzq(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzr(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzaa> zzr(String str, String[] strArr) {
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase zze2 = zze();
            String[] strArr2 = {"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            this.zzs.zzc();
            Cursor query = zze2.query("conditional_properties", strArr2, str, strArr, (String) null, (String) null, "rowid", NativeContentAd.ASSET_HEADLINE);
            if (query.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    this.zzs.zzc();
                    if (size < 1000) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zzC = zzC(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        arrayList.add(new zzaa(string, string2, new zzkq(string3, query.getLong(10), zzC, string2), query.getLong(8), z, string4, (zzas) this.zzf.zzm().zzk(query.getBlob(7), zzas.CREATOR), j, (zzas) this.zzf.zzm().zzk(query.getBlob(9), zzas.CREATOR), query.getLong(11), (zzas) this.zzf.zzm().zzk(query.getBlob(12), zzas.CREATOR)));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } else {
                        zzek zzb2 = this.zzs.zzau().zzb();
                        this.zzs.zzc();
                        zzb2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzb("Error querying conditional user property value", e);
            List<zzaa> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x011a A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x011e A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x015a A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0173 A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x018f A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0190 A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x019f A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01c2 A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d4 A[Catch:{ SQLiteException -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0210  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzs(java.lang.String r34) {
        /*
            r33 = this;
            r1 = r33
            r2 = r34
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            r33.zzg()
            r33.zzZ()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r33.zze()     // Catch:{ SQLiteException -> 0x01f1, all -> 0x01ef }
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "admob_app_id"
            java.lang.String r30 = "dynamite_version"
            java.lang.String r31 = "safelisted_events"
            java.lang.String r32 = "ga_app_id"
            java.lang.String[] r6 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32}     // Catch:{ SQLiteException -> 0x01f1, all -> 0x01ef }
            r0 = 1
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x01f1, all -> 0x01ef }
            r12 = 0
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x01f1, all -> 0x01ef }
            java.lang.String r5 = "apps"
            java.lang.String r7 = "app_id=?"
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x01f1, all -> 0x01ef }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x01ed }
            if (r5 != 0) goto L_0x006c
            if (r4 == 0) goto L_0x006b
            r4.close()
        L_0x006b:
            return r3
        L_0x006c:
            com.google.android.gms.measurement.internal.zzg r5 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzkn r6 = r1.zzf     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzN()     // Catch:{ SQLiteException -> 0x01ed }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x01ed }
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zze(r6)     // Catch:{ SQLiteException -> 0x01ed }
            java.lang.String r6 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzg(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 2
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzm(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzH(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 4
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzq(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 5
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzs(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 6
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzu(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 7
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzy(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 8
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzA(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 9
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzC(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 10
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x01ed }
            if (r7 != 0) goto L_0x00d8
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x01ed }
            if (r6 == 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            r6 = 0
            goto L_0x00d9
        L_0x00d8:
            r6 = 1
        L_0x00d9:
            r5.zzG(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 11
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzP(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 12
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzR(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 13
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzT(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 14
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzV(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 15
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzK(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 16
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzM(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 17
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x01ed }
            if (r7 == 0) goto L_0x011e
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0123
        L_0x011e:
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x01ed }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x01ed }
        L_0x0123:
            r5.zzw(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 18
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzo(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 19
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzZ(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 20
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzX(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r6 = 21
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzac(r6)     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzs     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzea.zzat     // Catch:{ SQLiteException -> 0x01ed }
            boolean r6 = r6.zzn(r3, r7)     // Catch:{ SQLiteException -> 0x01ed }
            r7 = 0
            if (r6 != 0) goto L_0x016b
            r6 = 22
            boolean r9 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x01ed }
            if (r9 == 0) goto L_0x0164
            r9 = r7
            goto L_0x0168
        L_0x0164:
            long r9 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01ed }
        L_0x0168:
            r5.zzae(r9)     // Catch:{ SQLiteException -> 0x01ed }
        L_0x016b:
            r6 = 23
            boolean r9 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x01ed }
            if (r9 != 0) goto L_0x017b
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x01ed }
            if (r6 == 0) goto L_0x017a
            goto L_0x017b
        L_0x017a:
            r0 = 0
        L_0x017b:
            r5.zzag(r0)     // Catch:{ SQLiteException -> 0x01ed }
            r0 = 24
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzi(r0)     // Catch:{ SQLiteException -> 0x01ed }
            r0 = 25
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x01ed }
            if (r6 == 0) goto L_0x0190
            goto L_0x0194
        L_0x0190:
            long r7 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x01ed }
        L_0x0194:
            r5.zzE(r7)     // Catch:{ SQLiteException -> 0x01ed }
            r0 = 26
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x01ed }
            if (r6 != 0) goto L_0x01b1
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01ed }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x01ed }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzak(r0)     // Catch:{ SQLiteException -> 0x01ed }
        L_0x01b1:
            com.google.android.gms.internal.measurement.zzov.zzb()     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzea.zzag     // Catch:{ SQLiteException -> 0x01ed }
            boolean r0 = r0.zzn(r2, r6)     // Catch:{ SQLiteException -> 0x01ed }
            if (r0 == 0) goto L_0x01cb
            r0 = 27
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01ed }
            r5.zzk(r0)     // Catch:{ SQLiteException -> 0x01ed }
        L_0x01cb:
            r5.zzb()     // Catch:{ SQLiteException -> 0x01ed }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x01ed }
            if (r0 == 0) goto L_0x01e7
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x01ed }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x01ed }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r34)     // Catch:{ SQLiteException -> 0x01ed }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x01ed }
        L_0x01e7:
            if (r4 == 0) goto L_0x01ec
            r4.close()
        L_0x01ec:
            return r5
        L_0x01ed:
            r0 = move-exception
            goto L_0x01f3
        L_0x01ef:
            r0 = move-exception
            goto L_0x020e
        L_0x01f1:
            r0 = move-exception
            r4 = r3
        L_0x01f3:
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ all -> 0x020c }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ all -> 0x020c }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ all -> 0x020c }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzem.zzl(r34)     // Catch:{ all -> 0x020c }
            r5.zzc(r6, r2, r0)     // Catch:{ all -> 0x020c }
            if (r4 == 0) goto L_0x020b
            r4.close()
        L_0x020b:
            return r3
        L_0x020c:
            r0 = move-exception
            r3 = r4
        L_0x020e:
            if (r3 == 0) goto L_0x0213
            r3.close()
        L_0x0213:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzs(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    public final void zzt(zzg zzg2) {
        Preconditions.checkNotNull(zzg2);
        zzg();
        zzZ();
        String zzc2 = zzg2.zzc();
        Preconditions.checkNotNull(zzc2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzc2);
        contentValues.put("app_instance_id", zzg2.zzd());
        contentValues.put("gmp_app_id", zzg2.zzf());
        contentValues.put("resettable_device_id_hash", zzg2.zzl());
        contentValues.put("last_bundle_index", Long.valueOf(zzg2.zzI()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg2.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg2.zzr()));
        contentValues.put("app_version", zzg2.zzt());
        contentValues.put("app_store", zzg2.zzx());
        contentValues.put("gmp_version", Long.valueOf(zzg2.zzz()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg2.zzB()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg2.zzF()));
        contentValues.put("day", Long.valueOf(zzg2.zzO()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg2.zzQ()));
        contentValues.put("daily_events_count", Long.valueOf(zzg2.zzS()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg2.zzU()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg2.zzJ()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg2.zzL()));
        contentValues.put("app_version_int", Long.valueOf(zzg2.zzv()));
        contentValues.put("firebase_instance_id", zzg2.zzn());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg2.zzY()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg2.zzW()));
        contentValues.put("health_monitor_sample", zzg2.zzaa());
        contentValues.put("android_id", Long.valueOf(zzg2.zzad()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg2.zzaf()));
        contentValues.put("admob_app_id", zzg2.zzh());
        contentValues.put("dynamite_version", Long.valueOf(zzg2.zzD()));
        List<String> zzaj = zzg2.zzaj();
        if (zzaj != null) {
            if (zzaj.size() == 0) {
                this.zzs.zzau().zze().zzb("Safelisted events should not be an empty list. appId", zzc2);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzaj));
            }
        }
        zzov.zzb();
        if (this.zzs.zzc().zzn(zzc2, zzea.zzag)) {
            contentValues.put("ga_app_id", zzg2.zzj());
        }
        try {
            SQLiteDatabase zze2 = zze();
            if (((long) zze2.update("apps", contentValues, "app_id = ?", new String[]{zzc2})) == 0 && zze2.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update app (got -1). appId", zzem.zzl(zzc2));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing app. appId", zzem.zzl(zzc2), e);
        }
    }

    public final zzag zzu(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zzv(j, str, 1, false, false, z3, false, z5);
    }

    public final zzag zzv(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        String[] strArr = {str};
        zzag zzag = new zzag();
        Cursor cursor = null;
        try {
            SQLiteDatabase zze2 = zze();
            cursor = zze2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.zzs.zzau().zze().zzb("Not updating daily counts, app is not known. appId", zzem.zzl(str));
                if (cursor != null) {
                    cursor.close();
                }
                return zzag;
            }
            if (cursor.getLong(0) == j) {
                zzag.zzb = cursor.getLong(1);
                zzag.zza = cursor.getLong(2);
                zzag.zzc = cursor.getLong(3);
                zzag.zzd = cursor.getLong(4);
                zzag.zze = cursor.getLong(5);
            }
            if (z) {
                zzag.zzb += j2;
            }
            if (z2) {
                zzag.zza += j2;
            }
            if (z3) {
                zzag.zzc += j2;
            }
            if (z4) {
                zzag.zzd += j2;
            }
            if (z5) {
                zzag.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzag.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzag.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzag.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzag.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzag.zze));
            zze2.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return zzag;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error updating daily counts. appId", zzem.zzl(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzag;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzw(String str, byte[] bArr, String str2) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        try {
            if (((long) zze().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                this.zzs.zzau().zzb().zzb("Failed to update remote config (got 0). appId", zzem.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing remote config. appId", zzem.zzl(str), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0047, code lost:
        if (r2 > (com.google.android.gms.measurement.internal.zzae.zzA() + r0)) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzx(com.google.android.gms.internal.measurement.zzfw r8, boolean r9) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzZ()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.lang.String r0 = r8.zzA()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            boolean r0 = r8.zzn()
            com.google.android.gms.common.internal.Preconditions.checkState(r0)
            r7.zzA()
            com.google.android.gms.measurement.internal.zzfu r0 = r7.zzs
            com.google.android.gms.common.util.Clock r0 = r0.zzay()
            long r0 = r0.currentTimeMillis()
            long r2 = r8.zzo()
            com.google.android.gms.measurement.internal.zzfu r4 = r7.zzs
            r4.zzc()
            long r4 = com.google.android.gms.measurement.internal.zzae.zzA()
            long r4 = r0 - r4
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0049
            long r2 = r8.zzo()
            com.google.android.gms.measurement.internal.zzfu r4 = r7.zzs
            r4.zzc()
            long r4 = com.google.android.gms.measurement.internal.zzae.zzA()
            long r4 = r4 + r0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x006c
        L_0x0049:
            com.google.android.gms.measurement.internal.zzfu r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zze()
            java.lang.String r3 = r8.zzA()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r4 = r8.zzo()
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            r2.zzd(r4, r3, r0, r1)
        L_0x006c:
            byte[] r0 = r8.zzbp()
            r1 = 0
            com.google.android.gms.measurement.internal.zzkn r2 = r7.zzf     // Catch:{ IOException -> 0x010f }
            com.google.android.gms.measurement.internal.zzkp r2 = r2.zzm()     // Catch:{ IOException -> 0x010f }
            byte[] r0 = r2.zzs(r0)     // Catch:{ IOException -> 0x010f }
            com.google.android.gms.measurement.internal.zzfu r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzk()
            int r3 = r0.length
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "Saving bundle, size"
            r2.zzb(r4, r3)
            android.content.ContentValues r2 = new android.content.ContentValues
            r2.<init>()
            java.lang.String r3 = r8.zzA()
            java.lang.String r4 = "app_id"
            r2.put(r4, r3)
            long r3 = r8.zzo()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "bundle_end_timestamp"
            r2.put(r4, r3)
            java.lang.String r3 = "data"
            r2.put(r3, r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "has_realtime"
            r2.put(r0, r9)
            boolean r9 = r8.zzab()
            if (r9 == 0) goto L_0x00cb
            int r9 = r8.zzac()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "retry_count"
            r2.put(r0, r9)
        L_0x00cb:
            android.database.sqlite.SQLiteDatabase r9 = r7.zze()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.String r0 = "queue"
            r3 = 0
            long r2 = r9.insert(r0, r3, r2)     // Catch:{ SQLiteException -> 0x00f6 }
            r4 = -1
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zzfu r9 = r7.zzs     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzb()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.String r0 = "Failed to insert bundle (got -1). appId"
            java.lang.String r2 = r8.zzA()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzem.zzl(r2)     // Catch:{ SQLiteException -> 0x00f6 }
            r9.zzb(r0, r2)     // Catch:{ SQLiteException -> 0x00f6 }
            return r1
        L_0x00f4:
            r8 = 1
            return r8
        L_0x00f6:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzfu r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()
            java.lang.String r8 = r8.zzA()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r8)
            java.lang.String r2 = "Error storing bundle. appId"
            r0.zzc(r2, r8, r9)
            return r1
        L_0x010f:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzfu r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()
            java.lang.String r8 = r8.zzA()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r8)
            java.lang.String r2 = "Data loss. Failed to serialize bundle. appId"
            r0.zzc(r2, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzx(com.google.android.gms.internal.measurement.zzfw, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzy() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zze()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0027, all -> 0x0025 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0023 }
            if (r2 == 0) goto L_0x001d
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0023 }
            if (r0 == 0) goto L_0x001c
            r0.close()
        L_0x001c:
            return r1
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.close()
        L_0x0022:
            return r1
        L_0x0023:
            r2 = move-exception
            goto L_0x002a
        L_0x0025:
            r0 = move-exception
            goto L_0x0043
        L_0x0027:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x002a:
            com.google.android.gms.measurement.internal.zzfu r3 = r6.zzs     // Catch:{ all -> 0x003f }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x003f }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x003f }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            return r1
        L_0x003f:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.close()
        L_0x0048:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzy():java.lang.String");
    }

    public final boolean zzz() {
        return zzab("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }
}
