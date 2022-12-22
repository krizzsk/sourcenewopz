package com.didi.beatles.p099im.p100db.dao;

import android.database.Cursor;
import com.didi.beatles.p099im.p100db.entity.IMSessionDaoEntity;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.DatabaseStatement;
import com.didi.beatles.p099im.thirty.greenrobot.dao.internal.DaoConfig;
import didihttpdns.prefs.HttpDnsPrefs;

/* renamed from: com.didi.beatles.im.db.dao.SessionDao */
public class SessionDao extends AbstractDao<IMSessionDaoEntity, Long> {

    /* renamed from: com.didi.beatles.im.db.dao.SessionDao$Properties */
    public static class Properties {
        public static final Property Business_id = new Property(13, Integer.TYPE, "business_id", false, "BUSINESS_ID");
        public static final Property ClientExtends = new Property(19, String.class, "client_extends", false, "CLIENT_EXTENDS");
        public static final Property Draft = new Property(4, String.class, "draft", false, "DRAFT");
        public static final Property Is_info_loaded = new Property(11, Boolean.class, "is_info_loaded", false, "IS_INFO_LOADED");
        public static final Property Last_message = new Property(12, String.class, "last_message", false, "LAST_MESSAGE");
        public static final Property Last_modify_id = new Property(9, String.class, "last_modify_id", false, "LAST_MODIFY_ID");
        public static final Property Last_modify_time = new Property(10, Long.TYPE, "last_modify_time", false, "LAST_MODIFY_TIME");
        public static final Property Last_recv_ack_mid = new Property(7, Long.TYPE, "last_recv_ack_mid", false, "LAST_RECV_ACK_MID");
        public static final Property Last_send_ack_mid = new Property(8, Long.TYPE, "last_send_ack_mid", false, "LAST_SEND_ACK_MID");
        public static final Property Recent_messages = new Property(18, String.class, "recent_messages", false, "RECENT_MESSAGES");
        public static final Property ReserveInt1 = new Property(14, Integer.TYPE, "reserveInt1", false, "RESERVE_INT1");
        public static final Property ReserveInt2 = new Property(15, Integer.TYPE, "reserveInt2", false, "RESERVE_INT2");
        public static final Property ReserveStr3 = new Property(16, String.class, "reserveStr3", false, "RESERVE_STR3");
        public static final Property ServiceExtends = new Property(20, String.class, "service_extends", false, "SERVICE_EXTENDS");
        public static final Property Session_id = new Property(0, Long.TYPE, "session_id", true, "SESSION_ID");
        public static final Property Session_img = new Property(17, String.class, "session_img", false, "SESSION_IMG");
        public static final Property Session_name = new Property(2, String.class, "session_name", false, "SESSION_NAME");
        public static final Property Type = new Property(5, Integer.TYPE, "type", false, "TYPE");
        public static final Property Uid_list = new Property(3, String.class, "uid_list", false, "UID_LIST");
        public static final Property Unread_count = new Property(6, Integer.TYPE, "unread_count", false, "UNREAD_COUNT");
        public static final Property Update_time = new Property(1, Long.TYPE, HttpDnsPrefs.KEY_UPDATE_TIME, false, "UPDATE_TIME");
    }

    /* access modifiers changed from: protected */
    public boolean isEntityUpdateable() {
        return true;
    }

    public SessionDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public SessionDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + DaoMaster.SESSION_TABLE + " (\"SESSION_ID\" INTEGER PRIMARY KEY NOT NULL ,\"UPDATE_TIME\" INTEGER NOT NULL ,\"SESSION_NAME\" TEXT,\"UID_LIST\" TEXT,\"DRAFT\" TEXT,\"TYPE\" INTEGER NOT NULL ,\"UNREAD_COUNT\" INTEGER NOT NULL ,\"LAST_RECV_ACK_MID\" INTEGER NOT NULL ,\"LAST_SEND_ACK_MID\" INTEGER NOT NULL ,\"LAST_MODIFY_ID\" TEXT,\"LAST_MODIFY_TIME\" INTEGER NOT NULL ,\"IS_INFO_LOADED\" INTEGER,\"LAST_MESSAGE\" TEXT,\"BUSINESS_ID\" INTEGER NOT NULL ,\"RESERVE_INT1\" INTEGER NOT NULL ,\"RESERVE_INT2\" INTEGER NOT NULL ,\"RESERVE_STR3\" TEXT,\"SESSION_IMG\" TEXT,\"RECENT_MESSAGES\" TEXT,\"CLIENT_EXTENDS\" TEXT,\"SERVICE_EXTENDS\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append(DaoMaster.SESSION_TABLE);
        database.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void bindValues(DatabaseStatement databaseStatement, IMSessionDaoEntity iMSessionDaoEntity) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, iMSessionDaoEntity.getSession_id());
        databaseStatement.bindLong(2, iMSessionDaoEntity.getUpdate_time());
        String session_name = iMSessionDaoEntity.getSession_name();
        if (session_name != null) {
            databaseStatement.bindString(3, session_name);
        }
        String uid_list = iMSessionDaoEntity.getUid_list();
        if (uid_list != null) {
            databaseStatement.bindString(4, uid_list);
        }
        String draft = iMSessionDaoEntity.getDraft();
        if (draft != null) {
            databaseStatement.bindString(5, draft);
        }
        databaseStatement.bindLong(6, (long) iMSessionDaoEntity.getType());
        databaseStatement.bindLong(7, (long) iMSessionDaoEntity.getUnread_count());
        databaseStatement.bindLong(8, iMSessionDaoEntity.getLast_recv_ack_mid());
        databaseStatement.bindLong(9, iMSessionDaoEntity.getLast_send_ack_mid());
        String last_modify_id = iMSessionDaoEntity.getLast_modify_id();
        if (last_modify_id != null) {
            databaseStatement.bindString(10, last_modify_id);
        }
        databaseStatement.bindLong(11, iMSessionDaoEntity.getLast_modify_time());
        Boolean is_info_loaded = iMSessionDaoEntity.getIs_info_loaded();
        if (is_info_loaded != null) {
            databaseStatement.bindLong(12, is_info_loaded.booleanValue() ? 1 : 0);
        }
        String last_message = iMSessionDaoEntity.getLast_message();
        if (last_message != null) {
            databaseStatement.bindString(13, last_message);
        }
        databaseStatement.bindLong(14, (long) iMSessionDaoEntity.getBusiness_id());
        databaseStatement.bindLong(15, (long) iMSessionDaoEntity.getReserveInt1());
        databaseStatement.bindLong(16, (long) iMSessionDaoEntity.getReserveInt2());
        String reserveStr3 = iMSessionDaoEntity.getReserveStr3();
        if (reserveStr3 != null) {
            databaseStatement.bindString(17, reserveStr3);
        }
        String session_img = iMSessionDaoEntity.getSession_img();
        if (session_img != null) {
            databaseStatement.bindString(18, session_img);
        }
        String recentMessages = iMSessionDaoEntity.getRecentMessages();
        if (recentMessages != null) {
            databaseStatement.bindString(19, recentMessages);
        }
        String clientExtends = iMSessionDaoEntity.getClientExtends();
        if (clientExtends != null) {
            databaseStatement.bindString(20, clientExtends);
        }
        String serviceExtends = iMSessionDaoEntity.getServiceExtends();
        if (serviceExtends != null) {
            databaseStatement.bindString(21, serviceExtends);
        }
    }

    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    public IMSessionDaoEntity readEntity(Cursor cursor, int i) {
        Boolean bool;
        Cursor cursor2 = cursor;
        long j = cursor2.getLong(i + 0);
        long j2 = cursor2.getLong(i + 1);
        int i2 = i + 2;
        String string = cursor2.isNull(i2) ? null : cursor2.getString(i2);
        int i3 = i + 3;
        String string2 = cursor2.isNull(i3) ? null : cursor2.getString(i3);
        int i4 = i + 4;
        String string3 = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        int i5 = cursor2.getInt(i + 5);
        int i6 = cursor2.getInt(i + 6);
        long j3 = cursor2.getLong(i + 7);
        long j4 = cursor2.getLong(i + 8);
        int i7 = i + 9;
        String string4 = cursor2.isNull(i7) ? null : cursor2.getString(i7);
        long j5 = cursor2.getLong(i + 10);
        int i8 = i + 11;
        if (cursor2.isNull(i8)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor2.getShort(i8) != 0);
        }
        int i9 = i + 12;
        String string5 = cursor2.isNull(i9) ? null : cursor2.getString(i9);
        int i10 = cursor2.getInt(i + 13);
        int i11 = cursor2.getInt(i + 14);
        int i12 = cursor2.getInt(i + 15);
        int i13 = i + 16;
        String string6 = cursor2.isNull(i13) ? null : cursor2.getString(i13);
        int i14 = i + 17;
        String string7 = cursor2.isNull(i14) ? null : cursor2.getString(i14);
        int i15 = i + 18;
        String string8 = cursor2.isNull(i15) ? null : cursor2.getString(i15);
        int i16 = i + 19;
        String string9 = cursor2.isNull(i16) ? null : cursor2.getString(i16);
        int i17 = i + 20;
        return new IMSessionDaoEntity(j, j2, string, string2, string3, i5, i6, j3, j4, string4, j5, bool, string5, i10, i11, i12, string6, string7, string8, string9, cursor2.isNull(i17) ? null : cursor2.getString(i17));
    }

    public void readEntity(Cursor cursor, IMSessionDaoEntity iMSessionDaoEntity, int i) {
        Boolean bool;
        iMSessionDaoEntity.setSession_id(cursor.getLong(i + 0));
        iMSessionDaoEntity.setUpdate_time(cursor.getLong(i + 1));
        int i2 = i + 2;
        String str = null;
        iMSessionDaoEntity.setSession_name(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 3;
        iMSessionDaoEntity.setUid_list(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        iMSessionDaoEntity.setDraft(cursor.isNull(i4) ? null : cursor.getString(i4));
        iMSessionDaoEntity.setType(cursor.getInt(i + 5));
        iMSessionDaoEntity.setUnread_count(cursor.getInt(i + 6));
        iMSessionDaoEntity.setLast_recv_ack_mid(cursor.getLong(i + 7));
        iMSessionDaoEntity.setLast_send_ack_mid(cursor.getLong(i + 8));
        int i5 = i + 9;
        iMSessionDaoEntity.setLast_modify_id(cursor.isNull(i5) ? null : cursor.getString(i5));
        iMSessionDaoEntity.setLast_modify_time(cursor.getLong(i + 10));
        int i6 = i + 11;
        if (cursor.isNull(i6)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(i6) != 0);
        }
        iMSessionDaoEntity.setIs_info_loaded(bool);
        int i7 = i + 12;
        iMSessionDaoEntity.setLast_message(cursor.isNull(i7) ? null : cursor.getString(i7));
        iMSessionDaoEntity.setBusiness_id(cursor.getInt(i + 13));
        iMSessionDaoEntity.setReserveInt1(cursor.getInt(i + 14));
        iMSessionDaoEntity.setReserveInt2(cursor.getInt(i + 15));
        int i8 = i + 16;
        iMSessionDaoEntity.setReserveStr3(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 17;
        if (!cursor.isNull(i9)) {
            str = cursor.getString(i9);
        }
        iMSessionDaoEntity.setSession_img(str);
        iMSessionDaoEntity.setRecentMessages(cursor.getString(i + 18));
        iMSessionDaoEntity.setClientExtends(cursor.getString(i + 19));
        iMSessionDaoEntity.setServiceExtends(cursor.getString(i + 20));
    }

    /* access modifiers changed from: protected */
    public Long updateKeyAfterInsert(IMSessionDaoEntity iMSessionDaoEntity, long j) {
        iMSessionDaoEntity.setSession_id(j);
        return Long.valueOf(j);
    }

    public Long getKey(IMSessionDaoEntity iMSessionDaoEntity) {
        if (iMSessionDaoEntity != null) {
            return Long.valueOf(iMSessionDaoEntity.getSession_id());
        }
        return null;
    }
}
