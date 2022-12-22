package com.didi.beatles.p099im.thirty.greenrobot.dao.database;

import android.database.Cursor;
import android.database.SQLException;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.database.Database */
public interface Database {
    void beginTransaction();

    void close();

    DatabaseStatement compileStatement(String str);

    void endTransaction();

    void execSQL(String str) throws SQLException;

    void execSQL(String str, Object[] objArr) throws SQLException;

    String getPath();

    Object getRawDatabase();

    boolean inTransaction();

    boolean isDbLockedByCurrentThread();

    boolean isOpen();

    Cursor rawQuery(String str, String[] strArr);

    void setTransactionSuccessful();
}
