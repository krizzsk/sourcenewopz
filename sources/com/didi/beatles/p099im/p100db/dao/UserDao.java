package com.didi.beatles.p099im.p100db.dao;

import android.database.Cursor;
import com.didi.beatles.p099im.p100db.entity.IMUserDaoEntity;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.DatabaseStatement;
import com.didi.beatles.p099im.thirty.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.didi.beatles.im.db.dao.UserDao */
public class UserDao extends AbstractDao<IMUserDaoEntity, Void> {

    /* renamed from: com.didi.beatles.im.db.dao.UserDao$Properties */
    public static class Properties {
        public static final Property Avatar_url = new Property(2, String.class, "avatar_url", false, "AVATAR_URL");
        public static final Property M_icon = new Property(3, Integer.TYPE, "m_icon", false, "M_ICON");
        public static final Property ReserveStr1 = new Property(4, String.class, "reserveStr1", false, "RESERVE_STR1");
        public static final Property ReserveStr2 = new Property(5, String.class, "reserveStr2", false, "RESERVE_STR2");
        public static final Property User_id = new Property(0, Long.TYPE, "user_id", false, "USER_ID");
        public static final Property User_name = new Property(1, String.class, "user_name", false, "USER_NAME");
    }

    public Void getKey(IMUserDaoEntity iMUserDaoEntity) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isEntityUpdateable() {
        return true;
    }

    public Void readKey(Cursor cursor, int i) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Void updateKeyAfterInsert(IMUserDaoEntity iMUserDaoEntity, long j) {
        return null;
    }

    public UserDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public UserDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public UserDao(DaoConfig daoConfig, DaoSession daoSession, String str) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + DaoMaster.USER_TABLE + " (\"USER_ID\" INTEGER PRIMARY KEY NOT NULL ,\"USER_NAME\" TEXT,\"AVATAR_URL\" TEXT,\"M_ICON\" INTEGER NOT NULL ,\"RESERVE_STR1\" TEXT,\"RESERVE_STR2\" TEXT);");
    }

    public void createTableDynamic(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + this.config.tablename + " (\"USER_ID\" INTEGER PRIMARY KEY NOT NULL ,\"USER_NAME\" TEXT,\"AVATAR_URL\" TEXT,\"M_ICON\" INTEGER NOT NULL ,\"RESERVE_STR1\" TEXT,\"RESERVE_STR2\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append(DaoMaster.USER_TABLE);
        database.execSQL(sb.toString());
    }

    public void dropTableDynamic(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append(this.config.tablename);
        database.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void bindValues(DatabaseStatement databaseStatement, IMUserDaoEntity iMUserDaoEntity) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, iMUserDaoEntity.getUser_id());
        String user_name = iMUserDaoEntity.getUser_name();
        if (user_name != null) {
            databaseStatement.bindString(2, user_name);
        }
        String avatar_url = iMUserDaoEntity.getAvatar_url();
        if (avatar_url != null) {
            databaseStatement.bindString(3, avatar_url);
        }
        databaseStatement.bindLong(4, (long) iMUserDaoEntity.getM_icon());
        String reserveStr1 = iMUserDaoEntity.getReserveStr1();
        if (reserveStr1 != null) {
            databaseStatement.bindString(5, reserveStr1);
        }
        String reserveStr2 = iMUserDaoEntity.getReserveStr2();
        if (reserveStr2 != null) {
            databaseStatement.bindString(6, reserveStr2);
        }
    }

    public IMUserDaoEntity readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 3);
        int i5 = i + 4;
        int i6 = i + 5;
        return new IMUserDaoEntity(j, string, string2, i4, cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6));
    }

    public void readEntity(Cursor cursor, IMUserDaoEntity iMUserDaoEntity, int i) {
        iMUserDaoEntity.setUser_id(cursor.getLong(i + 0));
        int i2 = i + 1;
        String str = null;
        iMUserDaoEntity.setUser_name(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        iMUserDaoEntity.setAvatar_url(cursor.isNull(i3) ? null : cursor.getString(i3));
        iMUserDaoEntity.setM_icon(cursor.getInt(i + 3));
        int i4 = i + 4;
        iMUserDaoEntity.setReserveStr1(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 5;
        if (!cursor.isNull(i5)) {
            str = cursor.getString(i5);
        }
        iMUserDaoEntity.setReserveStr2(str);
    }
}
