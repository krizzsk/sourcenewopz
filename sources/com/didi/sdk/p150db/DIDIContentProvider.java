package com.didi.sdk.p150db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.component.search.city.p148db.DIDIDbTables;

/* renamed from: com.didi.sdk.db.DIDIContentProvider */
public class DIDIContentProvider extends ContentProvider {
    public static final String AUTHORITY = (DIDIApplication.getAppContext().getPackageName() + ".sideprovider");

    /* renamed from: a */
    private static final String f35781a = "DIDIContentProvider";

    /* renamed from: c */
    private static final int f35782c = 1;

    /* renamed from: d */
    private static final int f35783d = 2;
    public static UriMatcher sUriMatcher;

    /* renamed from: b */
    private DIDISQLiteOpenHelper f35784b;

    public String getType(Uri uri) {
        return null;
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        sUriMatcher = uriMatcher;
        uriMatcher.addURI(AUTHORITY, DIDIDbTables.SideBarReddotColumn.TABLE_NAME, 1);
        sUriMatcher.addURI(AUTHORITY, DIDIDbTables.SideBarFireTorchColumn.TABLE_NAME, 2);
    }

    /* renamed from: a */
    private String m25343a(Uri uri) {
        if (uri == null) {
            return null;
        }
        int match = sUriMatcher.match(uri);
        if (match != 1) {
            return match != 2 ? "" : DIDIDbTables.SideBarFireTorchColumn.TABLE_NAME;
        }
        return DIDIDbTables.SideBarReddotColumn.TABLE_NAME;
    }

    public boolean onCreate() {
        this.f35784b = new DIDISQLiteOpenHelper(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f35784b.getReadableDatabase().query(m25343a(uri), strArr, str, strArr2, (String) null, (String) null, str2);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            if (this.f35784b.getWritableDatabase().insert(m25343a(uri), (String) null, contentValues) >= 0) {
                return uri;
            }
            return null;
        } catch (SQLiteCantOpenDatabaseException unused) {
            return null;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        try {
            return this.f35784b.getWritableDatabase().delete(m25343a(uri), str, strArr);
        } catch (SQLiteCantOpenDatabaseException unused) {
            return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return this.f35784b.getWritableDatabase().update(m25343a(uri), contentValues, str, strArr);
        } catch (SQLiteCantOpenDatabaseException unused) {
            return 0;
        }
    }

    public synchronized int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        String a = m25343a(uri);
        SystemUtils.log(4, f35781a, "Batch updateOrInsert data to flash DB. table:" + a, (Throwable) null, "com.didi.sdk.db.DIDIContentProvider", 130);
        try {
            SQLiteDatabase writableDatabase = this.f35784b.getWritableDatabase();
            if (contentValuesArr == null || a == null || writableDatabase == null) {
                return -1;
            }
            return m25341a(a, writableDatabase, contentValuesArr);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private int m25341a(String str, SQLiteDatabase sQLiteDatabase, ContentValues[] contentValuesArr) {
        SystemUtils.log(3, f35781a, "Start to batch update data in the flash DB. table:" + str, (Throwable) null, "com.didi.sdk.db.DIDIContentProvider", 154);
        int length = contentValuesArr.length;
        try {
            sQLiteDatabase.beginTransaction();
            for (int i = 0; i < length; i++) {
                if (contentValuesArr[i] != null) {
                    m25342a(contentValuesArr[i], str, sQLiteDatabase);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            return length;
        } catch (SQLException e) {
            SQLException sQLException = e;
            SystemUtils.log(6, f35781a, "BulkUpdate fail! table: " + str, sQLException, "com.didi.sdk.db.DIDIContentProvider", 172);
            return -1;
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* renamed from: a */
    private long m25342a(ContentValues contentValues, String str, SQLiteDatabase sQLiteDatabase) {
        SystemUtils.log(3, f35781a, "Start to updateOrInsert data to flash DB. table:" + str, (Throwable) null, "com.didi.sdk.db.DIDIContentProvider", 187);
        try {
            return sQLiteDatabase.insert(str, (String) null, contentValues);
        } catch (SQLException e) {
            SystemUtils.log(6, f35781a, "Insert data to client fail!", e, "com.didi.sdk.db.DIDIContentProvider", 191);
            return -1;
        }
    }
}
