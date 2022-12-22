package com.didichuxing.publicservice.p196db.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;

/* renamed from: com.didichuxing.publicservice.db.base.BaseModel */
public abstract class BaseModel {
    public static final String DEFAULT_ORDER_SORT = "_id ASC";
    public String tableName;

    public abstract String getCreateSql();

    public void onUpdate(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SystemUtils.log(3, AdDbHelper.TAG, getClass().getSimpleName() + ".onUpdate oldVersion:" + i + ", newVersion:" + i2, (Throwable) null, "com.didichuxing.publicservice.db.base.BaseModel", 23);
        defaultUpdate(sQLiteDatabase);
    }

    /* access modifiers changed from: protected */
    public void defaultUpdate(SQLiteDatabase sQLiteDatabase) {
        SystemUtils.log(3, AdDbHelper.TAG, getClass().getSimpleName() + ".defaultUpdate", (Throwable) null, "com.didichuxing.publicservice.db.base.BaseModel", 28);
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.tableName);
            sQLiteDatabase.execSQL(getCreateSql());
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public long insert(ContentValues contentValues, SQLiteOpenHelper sQLiteOpenHelper) {
        try {
            return sQLiteOpenHelper.getWritableDatabase().insert(this.tableName, (String) null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            SystemUtils.log(6, AdDbHelper.TAG, getClass().getSimpleName() + ".insert exception", (Throwable) null, "com.didichuxing.publicservice.db.base.BaseModel", 46);
        } catch (Throwable unused) {
        }
        return 0;
    }

    public int bulkInsert(ContentValues[] contentValuesArr, SQLiteOpenHelper sQLiteOpenHelper) {
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        int i = 0;
        int i2 = 0;
        while (i2 < contentValuesArr.length) {
            try {
                writableDatabase.insert(this.tableName, (String) null, contentValuesArr[i2]);
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
                SystemUtils.log(6, AdDbHelper.TAG, getClass().getSimpleName() + ".bulkInsert exception", (Throwable) null, "com.didichuxing.publicservice.db.base.BaseModel", 64);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
        writableDatabase.setTransactionSuccessful();
        i = contentValuesArr.length;
        writableDatabase.endTransaction();
        return i;
    }

    public int delete(String str, String[] strArr, SQLiteOpenHelper sQLiteOpenHelper) {
        return sQLiteOpenHelper.getWritableDatabase().delete(this.tableName, str, strArr);
    }

    public int update(ContentValues contentValues, String str, String[] strArr, SQLiteOpenHelper sQLiteOpenHelper) {
        return sQLiteOpenHelper.getWritableDatabase().update(this.tableName, contentValues, str, strArr);
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, SQLiteOpenHelper sQLiteOpenHelper) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(this.tableName);
        sQLiteQueryBuilder.setProjectionMap((Map) null);
        if (TextUtils.isEmpty(str2)) {
            str2 = DEFAULT_ORDER_SORT;
        }
        try {
            return sQLiteQueryBuilder.query(sQLiteOpenHelper.getReadableDatabase(), strArr, str, strArr2, (String) null, (String) null, str2);
        } catch (SQLiteException e) {
            e.printStackTrace();
            SystemUtils.log(6, AdDbHelper.TAG, getClass().getSimpleName() + ".query exception", (Throwable) null, "com.didichuxing.publicservice.db.base.BaseModel", 98);
            return null;
        }
    }
}
