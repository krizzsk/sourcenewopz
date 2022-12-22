package com.didi.beatles.p099im.thirty.greenrobot.dao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.database.DatabaseOpenHelper */
public abstract class DatabaseOpenHelper extends SQLiteOpenHelper {
    private final Context context;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    public abstract void onCreate(Database database);

    public void onOpen(Database database) {
    }

    public abstract void onUpgrade(Database database, int i, int i2);

    public DatabaseOpenHelper(Context context2, String str, int i) {
        this(context2, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    public DatabaseOpenHelper(Context context2, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context2, str, cursorFactory, i);
        this.loadSQLCipherNativeLibs = true;
        this.context = context2;
        this.name = str;
        this.version = i;
    }

    public void setLoadSQLCipherNativeLibs(boolean z) {
        this.loadSQLCipherNativeLibs = z;
    }

    public Database getWritableDb() {
        return wrap(getWritableDatabase());
    }

    public Database getReadableDb() {
        return wrap(getReadableDatabase());
    }

    /* access modifiers changed from: protected */
    public Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new StandardDatabase(sQLiteDatabase);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(wrap(sQLiteDatabase), i, i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }
}
