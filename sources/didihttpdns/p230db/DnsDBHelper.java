package didihttpdns.p230db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import didihttpdns.model.DnsRecord;
import didihttpdns.model.IpRecord;
import didinet.Logger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: didihttpdns.db.DnsDBHelper */
public class DnsDBHelper extends SQLiteOpenHelper implements DnsConstants {

    /* renamed from: a */
    private static final String f57024a = "DnsDBHelper";

    /* renamed from: b */
    private static DnsDBHelper f57025b;

    /* renamed from: c */
    private Context f57026c;

    private DnsDBHelper(Context context) {
        super(context, DnsConstants.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 5);
        this.f57026c = context;
    }

    public static DnsDBHelper getInstance(Context context) {
        if (f57025b == null) {
            synchronized (DnsDBHelper.class) {
                if (f57025b == null) {
                    f57025b = new DnsDBHelper(context.getApplicationContext());
                }
            }
        }
        return f57025b;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Logger.m40928d(f57024a, "DnsDBHelper.onCreate");
        sQLiteDatabase.execSQL(DnsConstants.CREATE_DNS_TABLE_SQL);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Logger.m40928d(f57024a, "DnsDBHelper.onUpgrade");
        if (i != i2) {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS dns;");
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            onCreate(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Logger.m40928d(f57024a, "DnsDBHelper.onDowngrade");
        throw new UnsupportedOperationException("onDowngrade not supported");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a0, code lost:
        if (r2.inTransaction() != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a2, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
        if (r2.inTransaction() != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c9 A[SYNTHETIC, Splitter:B:26:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6 A[SYNTHETIC, Splitter:B:34:0x00d6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized didihttpdns.model.DnsRecord insertOrUpdateDnsRecord(didihttpdns.model.DnsRecord r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            if (r8 != 0) goto L_0x0006
            monitor-exit(r7)
            return r0
        L_0x0006:
            java.lang.String r1 = r8.getHost()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            didihttpdns.model.DnsRecord r1 = r7.queryDnsInfo(r1)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            android.database.sqlite.SQLiteDatabase r2 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x00a6 }
            r3.<init>()     // Catch:{ Exception -> 0x00a6 }
            r2.beginTransaction()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = "host"
            java.lang.String r5 = r8.getHost()     // Catch:{ Exception -> 0x00a6 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = "ttl"
            int r5 = r8.getT()     // Catch:{ Exception -> 0x00a6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a6 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = "ips"
            java.util.List r5 = r8.getIps()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00a6 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = "type"
            int r5 = r8.getType()     // Catch:{ Exception -> 0x00a6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a6 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00a6 }
            if (r1 == 0) goto L_0x0078
            java.lang.String r0 = "dns"
            java.lang.String r1 = "host = ?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00a6 }
            r5 = 0
            java.lang.String r6 = r8.getHost()     // Catch:{ Exception -> 0x00a6 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a6 }
            r2.update(r0, r3, r1, r4)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r0 = "DnsDBHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6 }
            r1.<init>()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = r8.getHost()     // Catch:{ Exception -> 0x00a6 }
            r1.append(r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = " update success"
            r1.append(r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00a6 }
            didinet.Logger.m40928d(r0, r1)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x0097
        L_0x0078:
            java.lang.String r1 = "dns"
            r2.insert(r1, r0, r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r0 = "DnsDBHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6 }
            r1.<init>()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = r8.getHost()     // Catch:{ Exception -> 0x00a6 }
            r1.append(r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = " insert success"
            r1.append(r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00a6 }
            didinet.Logger.m40928d(r0, r1)     // Catch:{ Exception -> 0x00a6 }
        L_0x0097:
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x00d0
            boolean r0 = r2.inTransaction()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00d0
        L_0x00a2:
            r2.endTransaction()     // Catch:{ all -> 0x00e0 }
            goto L_0x00d0
        L_0x00a6:
            r0 = move-exception
            goto L_0x00ad
        L_0x00a8:
            r8 = move-exception
            goto L_0x00d4
        L_0x00aa:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x00ad:
            java.lang.String r1 = "DnsDBHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r3.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = "insertOrUpdateDnsRecord: "
            r3.append(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x00d2 }
            r3.append(r0)     // Catch:{ all -> 0x00d2 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00d2 }
            didinet.Logger.m40928d(r1, r0)     // Catch:{ all -> 0x00d2 }
            if (r2 == 0) goto L_0x00d0
            boolean r0 = r2.inTransaction()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00d0
            goto L_0x00a2
        L_0x00d0:
            monitor-exit(r7)
            return r8
        L_0x00d2:
            r8 = move-exception
            r0 = r2
        L_0x00d4:
            if (r0 == 0) goto L_0x00df
            boolean r1 = r0.inTransaction()     // Catch:{ all -> 0x00e0 }
            if (r1 == 0) goto L_0x00df
            r0.endTransaction()     // Catch:{ all -> 0x00e0 }
        L_0x00df:
            throw r8     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.p230db.DnsDBHelper.insertOrUpdateDnsRecord(didihttpdns.model.DnsRecord):didihttpdns.model.DnsRecord");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r0 = f57024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r5 = "batchAddDnsRecord: " + android.util.Log.getStackTraceString(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        if (r0 != null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r0.inTransaction() != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0094, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        didinet.Logger.m40928d(f57024a, "batchAddDnsRecord: " + android.util.Log.getStackTraceString(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00af, code lost:
        throw r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:19:0x0035, B:29:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void batchAddDnsRecord(java.util.List<didihttpdns.model.DnsRecord> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L_0x000e
            boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r4)
            return
        L_0x000b:
            r5 = move-exception
            goto L_0x00b0
        L_0x000e:
            r0 = 0
            android.database.sqlite.SQLiteDatabase r0 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0057 }
            r0.beginTransaction()     // Catch:{ Exception -> 0x0057 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0057 }
        L_0x001a:
            boolean r1 = r5.hasNext()     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r5.next()     // Catch:{ Exception -> 0x0057 }
            didihttpdns.model.DnsRecord r1 = (didihttpdns.model.DnsRecord) r1     // Catch:{ Exception -> 0x0057 }
            r4.insertOrUpdateDnsRecord(r1)     // Catch:{ Exception -> 0x0057 }
            goto L_0x001a
        L_0x002a:
            r0.setTransactionSuccessful()     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x0086
            boolean r5 = r0.inTransaction()     // Catch:{ all -> 0x000b }
            if (r5 == 0) goto L_0x0086
            r0.endTransaction()     // Catch:{ Exception -> 0x0039 }
            goto L_0x0086
        L_0x0039:
            r5 = move-exception
            java.lang.String r0 = "DnsDBHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000b }
            r1.<init>()     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "batchAddDnsRecord: "
            r1.append(r2)     // Catch:{ all -> 0x000b }
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)     // Catch:{ all -> 0x000b }
            r1.append(r5)     // Catch:{ all -> 0x000b }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x000b }
        L_0x0051:
            didinet.Logger.m40928d(r0, r5)     // Catch:{ all -> 0x000b }
            goto L_0x0086
        L_0x0055:
            r5 = move-exception
            goto L_0x0088
        L_0x0057:
            r5 = move-exception
            java.lang.String r1 = "DnsDBHelper"
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)     // Catch:{ all -> 0x0055 }
            didinet.Logger.m40928d(r1, r5)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0086
            boolean r5 = r0.inTransaction()     // Catch:{ all -> 0x000b }
            if (r5 == 0) goto L_0x0086
            r0.endTransaction()     // Catch:{ Exception -> 0x006d }
            goto L_0x0086
        L_0x006d:
            r5 = move-exception
            java.lang.String r0 = "DnsDBHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000b }
            r1.<init>()     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "batchAddDnsRecord: "
            r1.append(r2)     // Catch:{ all -> 0x000b }
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)     // Catch:{ all -> 0x000b }
            r1.append(r5)     // Catch:{ all -> 0x000b }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x000b }
            goto L_0x0051
        L_0x0086:
            monitor-exit(r4)
            return
        L_0x0088:
            if (r0 == 0) goto L_0x00af
            boolean r1 = r0.inTransaction()     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x00af
            r0.endTransaction()     // Catch:{ Exception -> 0x0094 }
            goto L_0x00af
        L_0x0094:
            r0 = move-exception
            java.lang.String r1 = "DnsDBHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x000b }
            r2.<init>()     // Catch:{ all -> 0x000b }
            java.lang.String r3 = "batchAddDnsRecord: "
            r2.append(r3)     // Catch:{ all -> 0x000b }
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x000b }
            r2.append(r0)     // Catch:{ all -> 0x000b }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x000b }
            didinet.Logger.m40928d(r1, r0)     // Catch:{ all -> 0x000b }
        L_0x00af:
            throw r5     // Catch:{ all -> 0x000b }
        L_0x00b0:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.p230db.DnsDBHelper.batchAddDnsRecord(java.util.List):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: didihttpdns.model.DnsRecord} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: didihttpdns.model.DnsRecord} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: didihttpdns.model.DnsRecord} */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa A[SYNTHETIC, Splitter:B:36:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b4 A[SYNTHETIC, Splitter:B:44:0x00b4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized didihttpdns.model.DnsRecord queryDnsInfo(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00b8 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r6)
            return r1
        L_0x000a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r0.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "SELECT * FROM "
            r0.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "dns"
            r0.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = " WHERE "
            r0.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "host"
            r0.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = " =? "
            r0.append(r2)     // Catch:{ all -> 0x00b8 }
            android.database.sqlite.SQLiteDatabase r2 = r6.getReadableDatabase()     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            r4 = 0
            r3[r4] = r7     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            android.database.Cursor r7 = r2.rawQuery(r0, r3)     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            if (r7 == 0) goto L_0x0093
            int r0 = r7.getCount()     // Catch:{ Exception -> 0x008e }
            if (r0 <= 0) goto L_0x0093
            r7.moveToFirst()     // Catch:{ Exception -> 0x008e }
        L_0x0045:
            didihttpdns.model.DnsRecord r0 = new didihttpdns.model.DnsRecord     // Catch:{ Exception -> 0x008e }
            r0.<init>()     // Catch:{ Exception -> 0x008e }
            java.lang.String r1 = "host"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x008c }
            r0.setHost(r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = "ttl"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c }
            int r1 = r7.getInt(r1)     // Catch:{ Exception -> 0x008c }
            r0.setT(r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = "ips"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x008c }
            java.util.List r1 = r6.m40918b(r1)     // Catch:{ Exception -> 0x008c }
            r0.setIps(r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = "type"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x008c }
            int r1 = r7.getInt(r1)     // Catch:{ Exception -> 0x008c }
            r0.setType(r1)     // Catch:{ Exception -> 0x008c }
            boolean r1 = r7.moveToNext()     // Catch:{ Exception -> 0x008c }
            if (r1 != 0) goto L_0x008a
            r1 = r0
            goto L_0x0093
        L_0x008a:
            r1 = r0
            goto L_0x0045
        L_0x008c:
            r1 = move-exception
            goto L_0x009f
        L_0x008e:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x009f
        L_0x0093:
            if (r7 == 0) goto L_0x00ae
            r7.close()     // Catch:{ all -> 0x00b8 }
            goto L_0x00ae
        L_0x0099:
            r0 = move-exception
            goto L_0x00b2
        L_0x009b:
            r7 = move-exception
            r0 = r1
            r1 = r7
            r7 = r0
        L_0x009f:
            java.lang.String r2 = "DnsDBHelper"
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)     // Catch:{ all -> 0x00b0 }
            didinet.Logger.m40928d(r2, r1)     // Catch:{ all -> 0x00b0 }
            if (r7 == 0) goto L_0x00ad
            r7.close()     // Catch:{ all -> 0x00b8 }
        L_0x00ad:
            r1 = r0
        L_0x00ae:
            monitor-exit(r6)
            return r1
        L_0x00b0:
            r0 = move-exception
            r1 = r7
        L_0x00b2:
            if (r1 == 0) goto L_0x00b7
            r1.close()     // Catch:{ all -> 0x00b8 }
        L_0x00b7:
            throw r0     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.p230db.DnsDBHelper.queryDnsInfo(java.lang.String):didihttpdns.model.DnsRecord");
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
        if (r2 == 0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        if (r2 == 0) goto L_0x0080;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<didihttpdns.model.DnsRecord> queryAllDnsInfo() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0088 }
            r0.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "SELECT * FROM "
            r1.append(r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "dns"
            r1.append(r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = " ; "
            r1.append(r2)     // Catch:{ all -> 0x0088 }
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0073 }
            android.database.Cursor r2 = r3.rawQuery(r1, r2)     // Catch:{ Exception -> 0x0073 }
            if (r2 == 0) goto L_0x006b
            int r1 = r2.getCount()     // Catch:{ Exception -> 0x0073 }
            if (r1 <= 0) goto L_0x006b
            r2.moveToFirst()     // Catch:{ Exception -> 0x0073 }
        L_0x0032:
            didihttpdns.model.DnsRecord r1 = new didihttpdns.model.DnsRecord     // Catch:{ Exception -> 0x0073 }
            r1.<init>()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r3 = "host"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0073 }
            r1.setHost(r3)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r3 = "ttl"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x0073 }
            int r3 = r2.getInt(r3)     // Catch:{ Exception -> 0x0073 }
            r1.setT(r3)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r3 = "ips"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x0073 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0073 }
            java.util.List r3 = r4.m40918b(r3)     // Catch:{ Exception -> 0x0073 }
            r1.setIps(r3)     // Catch:{ Exception -> 0x0073 }
            r0.add(r1)     // Catch:{ Exception -> 0x0073 }
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x0073 }
            if (r1 != 0) goto L_0x0032
        L_0x006b:
            if (r2 == 0) goto L_0x0080
        L_0x006d:
            r2.close()     // Catch:{ all -> 0x0088 }
            goto L_0x0080
        L_0x0071:
            r0 = move-exception
            goto L_0x0082
        L_0x0073:
            r1 = move-exception
            java.lang.String r3 = "DnsDBHelper"
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)     // Catch:{ all -> 0x0071 }
            didinet.Logger.m40928d(r3, r1)     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x0080
            goto L_0x006d
        L_0x0080:
            monitor-exit(r4)
            return r0
        L_0x0082:
            if (r2 == 0) goto L_0x0087
            r2.close()     // Catch:{ all -> 0x0088 }
        L_0x0087:
            throw r0     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.p230db.DnsDBHelper.queryAllDnsInfo():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r1 == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (r1 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r1.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int queryCount() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = -1
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.getReadableDatabase()     // Catch:{ Exception -> 0x002b }
            java.lang.String r3 = "dns"
            java.lang.String r4 = "COUNT(*)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x002b }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x002b }
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x002b }
            if (r2 == 0) goto L_0x0023
            r2 = 0
            int r0 = r1.getInt(r2)     // Catch:{ Exception -> 0x002b }
        L_0x0023:
            if (r1 == 0) goto L_0x0038
        L_0x0025:
            r1.close()     // Catch:{ all -> 0x0040 }
            goto L_0x0038
        L_0x0029:
            r0 = move-exception
            goto L_0x003a
        L_0x002b:
            r2 = move-exception
            java.lang.String r3 = "DnsDBHelper"
            java.lang.String r2 = android.util.Log.getStackTraceString(r2)     // Catch:{ all -> 0x0029 }
            didinet.Logger.m40928d(r3, r2)     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0038
            goto L_0x0025
        L_0x0038:
            monitor-exit(r10)
            return r0
        L_0x003a:
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ all -> 0x0040 }
        L_0x003f:
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.p230db.DnsDBHelper.queryCount():int");
    }

    /* renamed from: a */
    private synchronized void m40917a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                getWritableDatabase().delete(DnsConstants.DNS_TABLE_NAME, "host = ?", new String[]{str});
            } catch (Exception e) {
                Logger.m40928d(f57024a, Log.getStackTraceString(e));
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void deleteDnsInfo(DnsRecord dnsRecord) {
        m40917a(dnsRecord.getHost());
    }

    public synchronized void deleteDnsInfo(List<DnsRecord> list) {
        for (DnsRecord host : list) {
            m40917a(host.getHost());
        }
    }

    public synchronized void deleteAll() {
        try {
            getWritableDatabase().execSQL(DnsConstants.DELETE_ALL_DNS_SQL);
            Logger.m40928d(f57024a, "---delete all db cache---");
        } catch (Exception e) {
            Logger.m40928d(f57024a, Log.getStackTraceString(e));
        }
        return;
    }

    /* renamed from: b */
    private List<IpRecord> m40918b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.substring(str.indexOf(Const.jaLeft) + 1, str.indexOf(Const.jaRight)).split(",");
        ArrayList arrayList = new ArrayList();
        for (String trim : split) {
            IpRecord ipRecord = new IpRecord();
            ipRecord.setIp(trim.trim());
            arrayList.add(ipRecord);
        }
        return arrayList;
    }
}
