package com.didichuxing.dfbasesdk.logupload2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.didi.security.uuid.share.ShareDBHelper;
import com.didichuxing.dfbasesdk.logupload.LogRecord;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.publicservice.p196db.base.BaseModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.p071io.FileUtils;

class LogDbHelper2 extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final int f46628a = 1;

    /* renamed from: b */
    private static final String f46629b = "bizsafety_dfbasesdk.db";

    /* renamed from: c */
    private static final String f46630c = "logs";

    /* renamed from: d */
    private static final String f46631d = "5";

    /* renamed from: e */
    private static final long f46632e = -1;

    /* renamed from: f */
    private static final String f46633f = "CREATE TABLE logs (_id INTEGER PRIMARY KEY,content TEXT NOT NULL,url TEXT NOT NULL,extraParams TEXT,upStatus INTEGER DEFAULT 0,cTime INTEGER,uTime INTEGER,failCount INTEGER DEFAULT 0)";

    public static class LogColumns implements BaseColumns {
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_CREATE_TIME = "cTime";
        public static final String COLUMN_NAME_FAIL_COUNT = "failCount";
        public static final String COLUMN_NAME_POST_EXTRAS = "extraParams";
        public static final String COLUMN_NAME_UPDATE_TIME = "uTime";
        public static final String COLUMN_NAME_UPLOAD_STATUS = "upStatus";
        public static final String COLUMN_NAME_URL = "url";
    }

    public LogDbHelper2(Context context) {
        super(context, f46629b, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public LogDbHelper2(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f46633f);
        sQLiteDatabase.setMaximumSize(FileUtils.ONE_GB);
        LogUtils.m33564d("LogInnerTask", "db onCreate");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtils.m33564d("LogInnerTask", "db onUpgrade");
    }

    /* renamed from: e */
    private SQLiteDatabase m33480e() {
        return m33478a(false);
    }

    /* renamed from: a */
    private SQLiteDatabase m33478a(boolean z) {
        SQLiteDatabase sQLiteDatabase;
        if (z) {
            try {
                sQLiteDatabase = getWritableDatabase();
            } catch (SQLiteException e) {
                LogUtils.logStackTrace(e);
                sQLiteDatabase = null;
            }
        } else {
            sQLiteDatabase = getReadableDatabase();
        }
        if (sQLiteDatabase == null) {
            LogUtils.m33565e("the dfbasesdk.db cannot be opened!!!");
        }
        return sQLiteDatabase;
    }

    static class DbRecord {
        final String content;
        final String extraParams;
        final String url;

        DbRecord(String str, String str2, String str3) {
            this.url = str;
            this.content = str2;
            this.extraParams = str3;
        }
    }

    /* renamed from: a */
    public long mo115677a(DbRecord dbRecord) {
        SQLiteDatabase a = m33478a(true);
        if (a == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", dbRecord.url);
        contentValues.put("content", dbRecord.content);
        contentValues.put(LogColumns.COLUMN_NAME_POST_EXTRAS, dbRecord.extraParams);
        long currentTimeMillis = System.currentTimeMillis();
        contentValues.put(LogColumns.COLUMN_NAME_CREATE_TIME, Long.valueOf(currentTimeMillis));
        contentValues.put(LogColumns.COLUMN_NAME_UPDATE_TIME, Long.valueOf(currentTimeMillis));
        try {
            return a.insert(f46630c, (String) null, contentValues);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return -1;
        }
    }

    /* renamed from: a */
    public void mo115679a(String str) {
        SQLiteDatabase a = m33478a(true);
        if (a != null) {
            try {
                a.delete(f46630c, "_id = ?", new String[]{str});
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    /* renamed from: a */
    public int mo115676a(List<String> list) {
        SQLiteDatabase a = m33478a(true);
        if (a == null) {
            return 0;
        }
        try {
            return a.delete(f46630c, "_id IN (" + TextUtils.join(",", list) + ")", (String[]) null);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return 0;
        }
    }

    /* renamed from: a */
    public void mo115678a() {
        SQLiteDatabase a = m33478a(true);
        if (a != null) {
            try {
                a.execSQL("UPDATE logs SET upStatus = 1 WHERE upStatus = 0");
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    /* renamed from: b */
    public void mo115682b(List<Object> list) {
        SQLiteDatabase a = m33478a(true);
        if (a != null) {
            try {
                a.execSQL("UPDATE logs SET upStatus = 1 WHERE _id IN (" + TextUtils.join(",", list) + ")");
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    /* renamed from: c */
    public void mo115684c(List<String> list) {
        SQLiteDatabase a = m33478a(true);
        if (a != null) {
            try {
                a.execSQL("UPDATE logs SET upStatus = 0, failCount = failCount+1 WHERE _id IN (" + TextUtils.join(",", list) + ")");
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo115680b() {
        SQLiteDatabase e = m33480e();
        String str = null;
        if (e == null) {
            return null;
        }
        Cursor rawQuery = e.rawQuery("select * from logs where upStatus =? order by _id ASC limit 1", new String[]{"0"});
        while (m33479a(rawQuery)) {
            try {
                str = rawQuery.getString(rawQuery.getColumnIndexOrThrow("url"));
            } catch (Exception unused) {
            }
        }
        rawQuery.close();
        return str;
    }

    /* renamed from: b */
    public List<LogRecord> mo115681b(String str) {
        SQLiteDatabase e;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || (e = m33480e()) == null) {
            return arrayList;
        }
        Cursor rawQuery = e.rawQuery("select * from logs where upStatus =? and url=? order by _id ASC limit 15", new String[]{"0", str});
        while (m33479a(rawQuery)) {
            long j = rawQuery.getLong(rawQuery.getColumnIndexOrThrow(ShareDBHelper.ID_NAME));
            String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("content"));
            long j2 = rawQuery.getLong(rawQuery.getColumnIndexOrThrow("upStatus"));
            long j3 = rawQuery.getLong(rawQuery.getColumnIndexOrThrow("failCount"));
            LogUtils.m33564d("LogInnerTask", "fetch records, id=" + j + ", content=" + string + ", status=" + j2 + ", failCount=" + j3);
            LogRecord logRecord = new LogRecord(String.valueOf(j), string, j2, j3);
            String string2 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("url"));
            String string3 = rawQuery.getString(rawQuery.getColumnIndexOrThrow(LogColumns.COLUMN_NAME_POST_EXTRAS));
            long j4 = rawQuery.getLong(rawQuery.getColumnIndexOrThrow(LogColumns.COLUMN_NAME_CREATE_TIME));
            long j5 = rawQuery.getLong(rawQuery.getColumnIndexOrThrow(LogColumns.COLUMN_NAME_UPDATE_TIME));
            LogUtils.m33564d("LogInnerTask", "fetch records, url=" + string2 + ", extras=" + string3 + ", ctime=" + j4 + ", utime=" + j5);
            logRecord.url = string2;
            logRecord.extras = string3;
            logRecord.ctime = j4;
            logRecord.utime = j5;
            arrayList.add(logRecord);
        }
        rawQuery.close();
        return arrayList;
    }

    /* renamed from: a */
    private boolean m33479a(Cursor cursor) {
        try {
            return cursor.moveToNext();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return false;
        }
    }

    /* renamed from: c */
    public List<LogRecord> mo115683c() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase e = m33480e();
        if (e == null) {
            return arrayList;
        }
        Cursor query = e.query(f46630c, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, BaseModel.DEFAULT_ORDER_SORT);
        while (m33479a(query)) {
            long j = query.getLong(query.getColumnIndexOrThrow(ShareDBHelper.ID_NAME));
            String string = query.getString(query.getColumnIndexOrThrow("content"));
            long j2 = query.getLong(query.getColumnIndexOrThrow("upStatus"));
            long j3 = query.getLong(query.getColumnIndexOrThrow("failCount"));
            LogUtils.m33564d("LogInnerTask", "fetch all logs, id=" + j + ", content=" + string + ", status=" + j2 + ", failCount=" + j3);
            arrayList.add(new LogRecord(String.valueOf(j), string, j2, j3));
        }
        query.close();
        return arrayList;
    }

    /* renamed from: d */
    public void mo115685d() {
        try {
            close();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }
}
