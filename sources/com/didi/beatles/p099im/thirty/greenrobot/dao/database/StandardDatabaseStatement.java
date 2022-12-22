package com.didi.beatles.p099im.thirty.greenrobot.dao.database;

import android.database.sqlite.SQLiteStatement;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.database.StandardDatabaseStatement */
public class StandardDatabaseStatement implements DatabaseStatement {

    /* renamed from: a */
    private final SQLiteStatement f9690a;

    public StandardDatabaseStatement(SQLiteStatement sQLiteStatement) {
        this.f9690a = sQLiteStatement;
    }

    public void execute() {
        this.f9690a.execute();
    }

    public long simpleQueryForLong() {
        return this.f9690a.simpleQueryForLong();
    }

    public void bindNull(int i) {
        this.f9690a.bindNull(i);
    }

    public long executeInsert() {
        return this.f9690a.executeInsert();
    }

    public void bindString(int i, String str) {
        this.f9690a.bindString(i, str);
    }

    public void bindBlob(int i, byte[] bArr) {
        this.f9690a.bindBlob(i, bArr);
    }

    public void bindLong(int i, long j) {
        this.f9690a.bindLong(i, j);
    }

    public void clearBindings() {
        this.f9690a.clearBindings();
    }

    public void bindDouble(int i, double d) {
        this.f9690a.bindDouble(i, d);
    }

    public void close() {
        this.f9690a.close();
    }

    public Object getRawStatement() {
        return this.f9690a;
    }
}
