package com.didi.sdk.audiorecorder.p147db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.p008db.SupportSQLiteDatabase;
import androidx.sqlite.p008db.SupportSQLiteOpenHelper;
import com.didi.sdk.audiorecorder.model.RecordResult;
import com.didichuxing.afanty.common.utils.Constants;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.didi.sdk.audiorecorder.db.RecordDatabase_Impl */
public class RecordDatabase_Impl extends RecordDatabase {

    /* renamed from: b */
    private volatile RecordDao f35304b;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(4) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `record_result` (`caller` TEXT, `businessId` TEXT, `businessAlias` TEXT, `audioFilePath` TEXT, `fileSizeInBytes` INTEGER NOT NULL, `voiceLenInSeconds` INTEGER NOT NULL, `startRecordTime` INTEGER NOT NULL, `finishRecordTime` INTEGER NOT NULL, `orderIds` TEXT, `clientType` INTEGER NOT NULL, `utcOffsetInMinutes` INTEGER NOT NULL, `token` TEXT, `language` TEXT, `uploadRetryCount` INTEGER NOT NULL, `extraJson` TEXT, `uploadUrl` TEXT, `signKey` TEXT, `userId` TEXT, PRIMARY KEY(`startRecordTime`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b74c5f35976942f15fb7e1bc8ae93dd7\")");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `record_result`");
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (RecordDatabase_Impl.this.mCallbacks != null) {
                    int size = RecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) RecordDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = RecordDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                RecordDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (RecordDatabase_Impl.this.mCallbacks != null) {
                    int size = RecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) RecordDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(18);
                hashMap.put("caller", new TableInfo.Column("caller", "TEXT", false, 0));
                hashMap.put(Constants.JSON_BUSINESS_ID, new TableInfo.Column(Constants.JSON_BUSINESS_ID, "TEXT", false, 0));
                hashMap.put("businessAlias", new TableInfo.Column("businessAlias", "TEXT", false, 0));
                hashMap.put("audioFilePath", new TableInfo.Column("audioFilePath", "TEXT", false, 0));
                hashMap.put("fileSizeInBytes", new TableInfo.Column("fileSizeInBytes", "INTEGER", true, 0));
                hashMap.put("voiceLenInSeconds", new TableInfo.Column("voiceLenInSeconds", "INTEGER", true, 0));
                hashMap.put("startRecordTime", new TableInfo.Column("startRecordTime", "INTEGER", true, 1));
                hashMap.put("finishRecordTime", new TableInfo.Column("finishRecordTime", "INTEGER", true, 0));
                hashMap.put("orderIds", new TableInfo.Column("orderIds", "TEXT", false, 0));
                hashMap.put("clientType", new TableInfo.Column("clientType", "INTEGER", true, 0));
                hashMap.put("utcOffsetInMinutes", new TableInfo.Column("utcOffsetInMinutes", "INTEGER", true, 0));
                hashMap.put("token", new TableInfo.Column("token", "TEXT", false, 0));
                hashMap.put("language", new TableInfo.Column("language", "TEXT", false, 0));
                hashMap.put("uploadRetryCount", new TableInfo.Column("uploadRetryCount", "INTEGER", true, 0));
                hashMap.put("extraJson", new TableInfo.Column("extraJson", "TEXT", false, 0));
                hashMap.put("uploadUrl", new TableInfo.Column("uploadUrl", "TEXT", false, 0));
                hashMap.put("signKey", new TableInfo.Column("signKey", "TEXT", false, 0));
                hashMap.put("userId", new TableInfo.Column("userId", "TEXT", false, 0));
                TableInfo tableInfo = new TableInfo(RecordResult.TABLE_NAME, hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, RecordResult.TABLE_NAME);
                if (!tableInfo.equals(read)) {
                    throw new IllegalStateException("Migration didn't properly handle record_result(com.didi.sdk.audiorecorder.model.RecordResult).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
            }
        }, "b74c5f35976942f15fb7e1bc8ae93dd7", "d07d11fafa761a6c54baa73061a1be00")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, RecordResult.TABLE_NAME);
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `record_result`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public RecordDao recordDao() {
        RecordDao recordDao;
        if (this.f35304b != null) {
            return this.f35304b;
        }
        synchronized (this) {
            if (this.f35304b == null) {
                this.f35304b = new RecordDao_Impl(this);
            }
            recordDao = this.f35304b;
        }
        return recordDao;
    }
}
