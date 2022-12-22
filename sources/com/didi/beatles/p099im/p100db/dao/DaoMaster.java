package com.didi.beatles.p099im.p100db.dao;

import android.content.Context;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDaoMaster;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.DatabaseOpenHelper;
import com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope.IdentityScopeType;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.db.dao.DaoMaster */
public class DaoMaster extends AbstractDaoMaster {
    public static final String MESSAGE_TABLE = "im_message_table";
    public static final int SCHEMA_VERSION = 11;
    public static final String SESSION_TABLE = "im_session_table_new";
    public static final String USER_TABLE = "im_user_table";

    public static void createAllTables(Database database, boolean z) {
        SessionDao.createTable(database, z);
        UserDao.createTable(database, z);
    }

    public static void dropAllTables(Database database, boolean z) {
        SessionDao.dropTable(database, z);
        UserDao.dropTable(database, z);
    }

    /* renamed from: com.didi.beatles.im.db.dao.DaoMaster$OpenHelper */
    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String str) {
            super(context, str, 11);
        }

        public void onCreate(Database database) {
            IMLog.m6635i("greenDAO", "Creating tables for schema version 11");
            DaoMaster.createAllTables(database, true);
        }
    }

    /* renamed from: com.didi.beatles.im.db.dao.DaoMaster$DevOpenHelper */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x002b, code lost:
            r5.execSQL("ALTER TABLE im_user_table ADD M_ICON INTEGER DEFAULT 0 NOT NULL");
            r5.execSQL("ALTER TABLE im_user_table ADD RESERVE_STR1 TEXT");
            r5.execSQL("ALTER TABLE im_user_table ADD RESERVE_STR2 TEXT");
            r5.execSQL("ALTER TABLE im_session_table_new ADD COLUMN SESSION_IMG TEXT");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x003f, code lost:
            r5.execSQL("ALTER TABLE im_session_table_new ADD COLUMN RECENT_MESSAGES TEXT");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0044, code lost:
            r5.execSQL("ALTER TABLE im_session_table_new ADD COLUMN CLIENT_EXTENDS TEXT");
            r5.execSQL("ALTER TABLE im_session_table_new ADD COLUMN SERVICE_EXTENDS TEXT");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onUpgrade(com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database r5, int r6, int r7) {
            /*
                r4 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Upgrading schema from version "
                r2.append(r3)
                r2.append(r6)
                java.lang.String r3 = " to "
                r2.append(r3)
                r2.append(r7)
                java.lang.String r7 = r2.toString()
                r2 = 0
                r1[r2] = r7
                java.lang.String r7 = "greenDAO"
                com.didi.beatles.p099im.utils.IMLog.m6635i(r7, r1)
                switch(r6) {
                    case 1: goto L_0x0028;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0028;
                    case 4: goto L_0x0028;
                    case 5: goto L_0x0028;
                    case 6: goto L_0x0028;
                    case 7: goto L_0x0028;
                    case 8: goto L_0x002b;
                    case 9: goto L_0x003f;
                    case 10: goto L_0x0044;
                    default: goto L_0x0027;
                }
            L_0x0027:
                goto L_0x004e
            L_0x0028:
                com.didi.beatles.p099im.p100db.dao.SessionDao.createTable(r5, r0)
            L_0x002b:
                java.lang.String r6 = "ALTER TABLE im_user_table ADD M_ICON INTEGER DEFAULT 0 NOT NULL"
                r5.execSQL(r6)
                java.lang.String r6 = "ALTER TABLE im_user_table ADD RESERVE_STR1 TEXT"
                r5.execSQL(r6)
                java.lang.String r6 = "ALTER TABLE im_user_table ADD RESERVE_STR2 TEXT"
                r5.execSQL(r6)
                java.lang.String r6 = "ALTER TABLE im_session_table_new ADD COLUMN SESSION_IMG TEXT"
                r5.execSQL(r6)
            L_0x003f:
                java.lang.String r6 = "ALTER TABLE im_session_table_new ADD COLUMN RECENT_MESSAGES TEXT"
                r5.execSQL(r6)
            L_0x0044:
                java.lang.String r6 = "ALTER TABLE im_session_table_new ADD COLUMN CLIENT_EXTENDS TEXT"
                r5.execSQL(r6)
                java.lang.String r6 = "ALTER TABLE im_session_table_new ADD COLUMN SERVICE_EXTENDS TEXT"
                r5.execSQL(r6)
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.p100db.dao.DaoMaster.DevOpenHelper.onUpgrade(com.didi.beatles.im.thirty.greenrobot.dao.database.Database, int, int):void");
        }
    }

    public DaoMaster(Database database) {
        super(database, 11);
        registerDaoClass(SessionDao.class, SESSION_TABLE);
        registerDaoClass(UserDao.class, USER_TABLE);
    }

    public DaoSession newSession() {
        return new DaoSession(this.f9656db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.f9656db, identityScopeType, this.daoConfigMap);
    }
}
