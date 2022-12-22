package com.didi.onehybrid.resource.offline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FusionDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "hybridmodules.db";
    private static final int DB_VERSION = 2;
    private static final String SQL_CREATE_FUSION_BUNDLE = "CREATE TABLE IF NOT EXISTS offlinebundles (_id INTEGER PRIMARY KEY AUTOINCREMENT,bundle_name TEXT UNIQUE,download_url TEXT,version TEXT,md5 TEXT,state INTEGER,download_mode INTEGER);";
    private static final String SQL_DELETE_FUSION_BUNDLE = "DROP TABLE IF EXISTS offlinebundles";

    public FusionDbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_FUSION_BUNDLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(SQL_DELETE_FUSION_BUNDLE);
        onCreate(sQLiteDatabase);
    }
}
