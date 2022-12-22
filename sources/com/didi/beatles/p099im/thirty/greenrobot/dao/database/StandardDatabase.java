package com.didi.beatles.p099im.thirty.greenrobot.dao.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.database.StandardDatabase */
public class StandardDatabase implements Database {

    /* renamed from: a */
    private final SQLiteDatabase f9689a;

    public StandardDatabase(SQLiteDatabase sQLiteDatabase) {
        this.f9689a = sQLiteDatabase;
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return this.f9689a.rawQuery(str, strArr);
    }

    public void execSQL(String str) throws SQLException {
        this.f9689a.execSQL(str);
    }

    public void beginTransaction() {
        this.f9689a.beginTransaction();
    }

    public void endTransaction() {
        this.f9689a.endTransaction();
    }

    public boolean inTransaction() {
        return this.f9689a.inTransaction();
    }

    public void setTransactionSuccessful() {
        this.f9689a.setTransactionSuccessful();
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        this.f9689a.execSQL(str, objArr);
    }

    public DatabaseStatement compileStatement(String str) {
        return new StandardDatabaseStatement(this.f9689a.compileStatement(str));
    }

    public boolean isDbLockedByCurrentThread() {
        return this.f9689a.isDbLockedByCurrentThread();
    }

    public boolean isOpen() {
        return this.f9689a.isOpen();
    }

    public void close() {
        this.f9689a.close();
    }

    public Object getRawDatabase() {
        return this.f9689a;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return this.f9689a;
    }

    public String getPath() {
        return this.f9689a.getPath();
    }
}
