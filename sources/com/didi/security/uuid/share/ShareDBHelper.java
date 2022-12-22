package com.didi.security.uuid.share;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShareDBHelper extends SQLiteOpenHelper {
    public static final String ID_NAME = "_id";
    public static final String TABLE_NAME = "token";
    public static final String TOKEN_NAME = "data";

    /* renamed from: a */
    private static final String f38557a = "device_token.db";

    /* renamed from: b */
    private static final int f38558b = 1;

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public ShareDBHelper(Context context) {
        super(context, f38557a, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS token(_id INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT)");
    }
}
