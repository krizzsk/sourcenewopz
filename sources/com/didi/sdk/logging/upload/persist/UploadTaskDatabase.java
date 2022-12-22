package com.didi.sdk.logging.upload.persist;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.p008db.SupportSQLiteDatabase;

public abstract class UploadTaskDatabase extends RoomDatabase {

    /* renamed from: a */
    static final Migration f36639a = new Migration(2, 3) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE TaskRecord  ADD COLUMN startTimestamp INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE TaskRecord  ADD COLUMN endTimestamp INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* renamed from: b */
    private static UploadTaskDatabase f36640b;

    public abstract SliceRecordDao getFileRecordDao();

    public abstract TaskFileRecordDao getTaskFileRecordDao();

    public abstract TaskRecordDao getTaskRecordDao();

    public static UploadTaskDatabase initDatabase(Context context) {
        if (f36640b == null) {
            f36640b = Room.databaseBuilder(context.getApplicationContext(), UploadTaskDatabase.class, "log.db").addMigrations(f36639a).build();
        }
        return f36640b;
    }

    public static UploadTaskDatabase getDatabase() {
        return f36640b;
    }

    public static void onDestroy() {
        f36640b = null;
    }
}
