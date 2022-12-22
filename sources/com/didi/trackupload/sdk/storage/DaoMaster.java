package com.didi.trackupload.sdk.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.didi.sdk.apm.SystemUtils;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 2;

    public static void createAllTables(Database database, boolean z) {
        TrackNodeEntityDao.createTable(database, z);
        BizNodeEntityDao.createTable(database, z);
    }

    public static void dropAllTables(Database database, boolean z) {
        TrackNodeEntityDao.dropTable(database, z);
        BizNodeEntityDao.dropTable(database, z);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this((Database) new StandardDatabase(sQLiteDatabase));
    }

    public DaoMaster(Database database) {
        super(database, 2);
        registerDaoClass(TrackNodeEntityDao.class);
        registerDaoClass(BizNodeEntityDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(this.f6570db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.f6570db, identityScopeType, this.daoConfigMap);
    }

    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String str) {
            super(context, str, 2);
        }

        public OpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 2);
        }

        public void onCreate(Database database) {
            SystemUtils.log(4, "greenDAO", "Creating tables for schema version 2", (Throwable) null, "com.didi.trackupload.sdk.storage.DaoMaster$OpenHelper", 76);
            DaoMaster.createAllTables(database, false);
        }
    }

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        public DevOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        public void onUpgrade(Database database, int i, int i2) {
            SystemUtils.log(4, "greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables", (Throwable) null, "com.didi.trackupload.sdk.storage.DaoMaster$DevOpenHelper", 93);
            DaoMaster.dropAllTables(database, true);
            onCreate(database);
        }
    }
}
