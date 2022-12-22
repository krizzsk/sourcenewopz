package com.didi.onehybrid.resource.offline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.didi.sdk.apm.SystemUtils;

public class FusionDbHelperA extends SQLiteOpenHelper {
    private static final String DB_NAME = "offlinebundles.db";
    private static final String SQL_CREATE_FUSION_BUNDLE = "CREATE TABLE IF NOT EXISTS offlinebundles (_id INTEGER PRIMARY KEY AUTOINCREMENT,bundle_name TEXT UNIQUE,version TEXT,state INTEGER,md5 TEXT)";
    private static final String SQL_CREATE_FUSION_RESOURCE_BUNDLE = "CREATE TABLE IF NOT EXISTS offlinebundleresource (_id INTEGER PRIMARY KEY AUTOINCREMENT,bundle_name TEXT,resource_name TEXT,resource_url TEXT UNIQUE,md5 TEXT)";
    private static final String SQL_DELETE_FUSION_BUNDLE = "DROP TABLE IF EXISTS offlinebundles";
    private static final String SQL_DELETE_FUSION_RESOURCE_BUNDLE = "DROP TABLE IF EXISTS offlinebundleresource";
    private static FusionDbHelperA fusionDbHelperA;

    public static FusionDbHelperA getInstance(Context context) {
        if (fusionDbHelperA == null) {
            fusionDbHelperA = new FusionDbHelperA(context);
        }
        return fusionDbHelperA;
    }

    public FusionDbHelperA(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 810);
        setWriteAheadLoggingEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(SQL_CREATE_FUSION_BUNDLE);
            sQLiteDatabase.execSQL(SQL_CREATE_FUSION_RESOURCE_BUNDLE);
        } catch (Exception e) {
            SystemUtils.log(3, "OfflineBundleError", e.getMessage(), (Throwable) null, "com.didi.onehybrid.resource.offline.FusionDbHelperA", 63);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(SQL_DELETE_FUSION_BUNDLE);
        sQLiteDatabase.execSQL(SQL_DELETE_FUSION_RESOURCE_BUNDLE);
        onCreate(sQLiteDatabase);
    }
}
