package com.didichuxing.publicservice.p196db.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.publicservice.p196db.model.ScreenAdModel;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didichuxing.publicservice.db.base.AdDbHelper */
public class AdDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "ad";
    public static final String TAG = "AdDbHelper";
    static Set<BaseModel> createTables = new HashSet();
    static DbModifyRecord[] dbModifyRecords = {new DbModifyRecord(dbVersion).addTable(ScreenAdModel.getInstance()).addTable(ScreenAdNewModel.getInstance())};
    private static int dbVersion = 6;
    private static AdDbHelper instance;

    static {
        createTables.add(ScreenAdModel.getInstance());
        createTables.add(ScreenAdNewModel.getInstance());
    }

    private AdDbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, dbVersion);
    }

    public static AdDbHelper getInstance(Context context) {
        synchronized (AdDbHelper.class) {
            if (instance == null) {
                instance = new AdDbHelper(context.getApplicationContext());
            }
        }
        return instance;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SystemUtils.log(3, TAG, "AdDbHelper.onCreate", (Throwable) null, "com.didichuxing.publicservice.db.base.AdDbHelper", 45);
        for (BaseModel createSql : createTables) {
            sQLiteDatabase.execSQL(createSql.getCreateSql());
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SystemUtils.log(3, TAG, "AdDbHelper.onUpgrade", (Throwable) null, "com.didichuxing.publicservice.db.base.AdDbHelper", 52);
        HashSet<BaseModel> hashSet = new HashSet<>();
        DbModifyRecord[] dbModifyRecordArr = dbModifyRecords;
        if (dbModifyRecordArr.length > 0) {
            for (DbModifyRecord dbModifyRecord : dbModifyRecordArr) {
                if (dbModifyRecord.modifyVersion > i && dbModifyRecord.modifyVersion <= i2) {
                    hashSet.addAll(dbModifyRecord.modifiedTables);
                }
            }
        }
        for (BaseModel onUpdate : hashSet) {
            onUpdate.onUpdate(sQLiteDatabase, i, i2);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SystemUtils.log(3, TAG, "AdDbHelper.onDowngrade", (Throwable) null, "com.didichuxing.publicservice.db.base.AdDbHelper", 64);
        if (createTables.size() > 0) {
            sQLiteDatabase.beginTransaction();
            try {
                for (BaseModel baseModel : createTables) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + baseModel.tableName);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        onCreate(sQLiteDatabase);
    }
}
