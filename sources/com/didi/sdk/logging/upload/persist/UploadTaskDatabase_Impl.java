package com.didi.sdk.logging.upload.persist;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p008db.SupportSQLiteDatabase;
import androidx.sqlite.p008db.SupportSQLiteOpenHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.sdk.component.search.city.p148db.DIDIDbTables;
import java.util.HashMap;
import java.util.HashSet;

public final class UploadTaskDatabase_Impl extends UploadTaskDatabase {

    /* renamed from: b */
    private volatile TaskRecordDao f36641b;

    /* renamed from: c */
    private volatile SliceRecordDao f36642c;

    /* renamed from: d */
    private volatile TaskFileRecordDao f36643d;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(3) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TaskRecord` (`taskId` TEXT NOT NULL, `logPath` TEXT, `startTime` TEXT, `endTime` TEXT, `buffers` TEXT, `startTimestamp` INTEGER NOT NULL, `endTimestamp` INTEGER NOT NULL, PRIMARY KEY(`taskId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SliceRecord` (`taskId` TEXT NOT NULL, `sliceId` INTEGER NOT NULL, `sliceCount` INTEGER NOT NULL, `file` TEXT, `startPos` INTEGER NOT NULL, `endPos` INTEGER NOT NULL, `fileSize` INTEGER NOT NULL, `status` INTEGER NOT NULL, `uploadCount` INTEGER NOT NULL, PRIMARY KEY(`taskId`, `sliceId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TaskFileRecord` (`taskId` TEXT NOT NULL, `file` TEXT NOT NULL, PRIMARY KEY(`taskId`, `file`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd148433d550a5fdc4afba2cb1ac99a7c')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `TaskRecord`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SliceRecord`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `TaskFileRecord`");
                if (UploadTaskDatabase_Impl.this.mCallbacks != null) {
                    int size = UploadTaskDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UploadTaskDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (UploadTaskDatabase_Impl.this.mCallbacks != null) {
                    int size = UploadTaskDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UploadTaskDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = UploadTaskDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                UploadTaskDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (UploadTaskDatabase_Impl.this.mCallbacks != null) {
                    int size = UploadTaskDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UploadTaskDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(7);
                hashMap.put(DMWebSocketListener.KEY_TASK_ID, new TableInfo.Column(DMWebSocketListener.KEY_TASK_ID, "TEXT", true, 1, (String) null, 1));
                hashMap.put("logPath", new TableInfo.Column("logPath", "TEXT", false, 0, (String) null, 1));
                hashMap.put(DIDIDbTables.BaseSideBarNewColumn.START_TIME, new TableInfo.Column(DIDIDbTables.BaseSideBarNewColumn.START_TIME, "TEXT", false, 0, (String) null, 1));
                hashMap.put("endTime", new TableInfo.Column("endTime", "TEXT", false, 0, (String) null, 1));
                hashMap.put("buffers", new TableInfo.Column("buffers", "TEXT", false, 0, (String) null, 1));
                hashMap.put("startTimestamp", new TableInfo.Column("startTimestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("endTimestamp", new TableInfo.Column("endTimestamp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("TaskRecord", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "TaskRecord");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "TaskRecord(com.didi.sdk.logging.upload.persist.TaskRecord).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(9);
                hashMap2.put(DMWebSocketListener.KEY_TASK_ID, new TableInfo.Column(DMWebSocketListener.KEY_TASK_ID, "TEXT", true, 1, (String) null, 1));
                hashMap2.put("sliceId", new TableInfo.Column("sliceId", "INTEGER", true, 2, (String) null, 1));
                hashMap2.put("sliceCount", new TableInfo.Column("sliceCount", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("file", new TableInfo.Column("file", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("startPos", new TableInfo.Column("startPos", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("endPos", new TableInfo.Column("endPos", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("status", new TableInfo.Column("status", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("uploadCount", new TableInfo.Column("uploadCount", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("SliceRecord", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "SliceRecord");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "SliceRecord(com.didi.sdk.logging.upload.persist.SliceRecord).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put(DMWebSocketListener.KEY_TASK_ID, new TableInfo.Column(DMWebSocketListener.KEY_TASK_ID, "TEXT", true, 1, (String) null, 1));
                hashMap3.put("file", new TableInfo.Column("file", "TEXT", true, 2, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("TaskFileRecord", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "TaskFileRecord");
                if (tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "TaskFileRecord(com.didi.sdk.logging.upload.persist.TaskFileRecord).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
        }, "d148433d550a5fdc4afba2cb1ac99a7c", "9564db524ae97274f6001da0331fcdcb")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "TaskRecord", "SliceRecord", "TaskFileRecord");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `TaskRecord`");
            writableDatabase.execSQL("DELETE FROM `SliceRecord`");
            writableDatabase.execSQL("DELETE FROM `TaskFileRecord`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public TaskRecordDao getTaskRecordDao() {
        TaskRecordDao taskRecordDao;
        if (this.f36641b != null) {
            return this.f36641b;
        }
        synchronized (this) {
            if (this.f36641b == null) {
                this.f36641b = new TaskRecordDao_Impl(this);
            }
            taskRecordDao = this.f36641b;
        }
        return taskRecordDao;
    }

    public SliceRecordDao getFileRecordDao() {
        SliceRecordDao sliceRecordDao;
        if (this.f36642c != null) {
            return this.f36642c;
        }
        synchronized (this) {
            if (this.f36642c == null) {
                this.f36642c = new SliceRecordDao_Impl(this);
            }
            sliceRecordDao = this.f36642c;
        }
        return sliceRecordDao;
    }

    public TaskFileRecordDao getTaskFileRecordDao() {
        TaskFileRecordDao taskFileRecordDao;
        if (this.f36643d != null) {
            return this.f36643d;
        }
        synchronized (this) {
            if (this.f36643d == null) {
                this.f36643d = new TaskFileRecordDao_Impl(this);
            }
            taskFileRecordDao = this.f36643d;
        }
        return taskFileRecordDao;
    }
}
