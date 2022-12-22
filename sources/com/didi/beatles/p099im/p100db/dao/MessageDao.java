package com.didi.beatles.p099im.p100db.dao;

import android.database.Cursor;
import com.didi.beatles.p099im.p100db.entity.IMMessageDaoEntity;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.DatabaseStatement;
import com.didi.beatles.p099im.thirty.greenrobot.dao.internal.DaoConfig;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.security.uuid.share.ShareDBHelper;
import com.google.firebase.messaging.Constants;
import org.apache.commons.logging.LogFactory;

/* renamed from: com.didi.beatles.im.db.dao.MessageDao */
public class MessageDao extends AbstractDao<IMMessageDaoEntity, Long> {
    public String mTableName;

    /* renamed from: com.didi.beatles.im.db.dao.MessageDao$Properties */
    public static class Properties {
        public static final Property Business_id = new Property(8, Integer.TYPE, "business_id", false, "BUSINESS_ID");
        public static final Property Category = new Property(5, Integer.TYPE, "category", false, "CATEGORY");
        public static final Property Create_time = new Property(7, Long.TYPE, "create_time", false, "CREATE_TIME");
        public static final Property File_name = new Property(16, String.class, "file_name", false, "FILE_NAME");
        public static final Property File_uri = new Property(12, String.class, "file_uri", false, "FILE_URI");
        public static final Property Gift_fid = new Property(15, String.class, "gift_fid", false, "GIFT_FID");
        public static final Property Gift_ftoken = new Property(14, String.class, "gift_ftoken", false, "GIFT_FTOKEN");
        public static final Property Gift_ns = new Property(13, String.class, "gift_ns", false, "GIFT_NS");
        public static final Property Height = new Property(17, Integer.TYPE, "height", false, "HEIGHT");

        /* renamed from: Id */
        public static final Property f9175Id = new Property(0, Long.class, "id", true, ShareDBHelper.ID_NAME);
        public static final Property IsRead = new Property(22, Boolean.class, "isRead", false, "IS_READ");
        public static final Property Message_id = new Property(1, Long.TYPE, Constants.MessagePayloadKeys.MSGID_SERVER, false, "MESSAGE_ID");
        public static final Property Priority = new Property(9, Integer.TYPE, LogFactory.PRIORITY_KEY, false, "PRIORITY");
        public static final Property ReserveInt1 = new Property(23, Integer.TYPE, "reserveInt1", false, "RESERVE_INT1");
        public static final Property ReserveInt2 = new Property(24, Integer.TYPE, "reserveInt2", false, "RESERVE_INT2");
        public static final Property ReserveStr3 = new Property(25, String.class, "reserveStr3", false, "RESERVE_STR3");
        public static final Property Sec = new Property(19, Integer.TYPE, "sec", false, "SEC");
        public static final Property Send_uid = new Property(6, Long.TYPE, "send_uid", false, "SEND_UID");
        public static final Property Session_id = new Property(3, Long.TYPE, "session_id", false, "SESSION_ID");
        public static final Property Size = new Property(20, Integer.TYPE, "size", false, "SIZE");
        public static final Property Status = new Property(10, Integer.TYPE, "status", false, "STATUS");
        public static final Property Sys_type = new Property(21, Integer.TYPE, "sys_type", false, "SYS_TYPE");
        public static final Property Text_content = new Property(11, String.class, "text_content", false, "TEXT_CONTENT");
        public static final Property Type = new Property(4, Integer.TYPE, "type", false, "TYPE");
        public static final Property Unique_cloud_msg_id = new Property(26, String.class, "unique_cloud_msg_id", false, "UNIQUE_CLOUD_MSG_ID");
        public static final Property Unique_id = new Property(2, Long.TYPE, "unique_id", false, "UNIQUE_ID");
        public static final Property Width = new Property(18, Integer.TYPE, "width", false, "WIDTH");
    }

    /* access modifiers changed from: protected */
    public boolean isEntityUpdateable() {
        return true;
    }

    public MessageDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public MessageDao(DaoConfig daoConfig, DaoSession daoSession, String str) {
        super(daoConfig, daoSession);
        this.mTableName = str;
    }

    public void createTable(Database database, boolean z) {
        IMLog.m6631d("MessageDao", "createTable mTableName " + this.mTableName);
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + this.mTableName + " (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"MESSAGE_ID\" INTEGER NOT NULL ,\"UNIQUE_ID\" INTEGER NOT NULL UNIQUE ,\"SESSION_ID\" INTEGER NOT NULL ,\"TYPE\" INTEGER NOT NULL ,\"CATEGORY\" INTEGER NOT NULL ,\"SEND_UID\" INTEGER NOT NULL ,\"CREATE_TIME\" INTEGER NOT NULL ,\"BUSINESS_ID\" INTEGER NOT NULL ,\"PRIORITY\" INTEGER NOT NULL ,\"STATUS\" INTEGER NOT NULL ,\"TEXT_CONTENT\" TEXT,\"FILE_URI\" TEXT,\"GIFT_NS\" TEXT,\"GIFT_FTOKEN\" TEXT,\"GIFT_FID\" TEXT,\"FILE_NAME\" TEXT,\"HEIGHT\" INTEGER NOT NULL ,\"WIDTH\" INTEGER NOT NULL ,\"SEC\" INTEGER NOT NULL ,\"SIZE\" INTEGER NOT NULL ,\"SYS_TYPE\" INTEGER NOT NULL ,\"IS_READ\" INTEGER,\"RESERVE_INT1\" INTEGER NOT NULL ,\"RESERVE_INT2\" INTEGER NOT NULL ,\"RESERVE_STR3\" TEXT ,\"UNIQUE_CLOUD_MSG_ID\" TEXT);");
    }

    public void updateTable(Database database) {
        IMLog.m6631d("MessageDao", " updateTable " + this.config.tablename);
        try {
            if (!checkColumnExists(database, "UNIQUE_CLOUD_MSG_ID")) {
                IMLog.m6631d("MessageDao", " updateTable ALTER UNIQUE_CLOUD_MSG_ID");
                database.execSQL("ALTER TABLE " + this.config.tablename + " ADD UNIQUE_CLOUD_MSG_ID INTEGER");
            }
        } catch (Exception e) {
            IMLog.m6631d("MessageDao", " updateTable fail:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (r5 == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r0.isClosed() == false) goto L_0x0033;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkColumnExists(com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r2.<init>()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch:{ Exception -> 0x0039 }
            com.didi.beatles.im.thirty.greenrobot.dao.internal.DaoConfig r3 = r4.config     // Catch:{ Exception -> 0x0039 }
            java.lang.String r3 = r3.tablename     // Catch:{ Exception -> 0x0039 }
            r2.append(r3)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r3 = " LIMIT 0"
            r2.append(r3)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0039 }
            android.database.Cursor r0 = r5.rawQuery(r2, r0)     // Catch:{ Exception -> 0x0039 }
            if (r0 == 0) goto L_0x002b
            int r5 = r0.getColumnIndex(r6)     // Catch:{ Exception -> 0x0039 }
            r6 = -1
            if (r5 == r6) goto L_0x002b
            r5 = 1
            r1 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x0060
            boolean r5 = r0.isClosed()
            if (r5 != 0) goto L_0x0060
        L_0x0033:
            r0.close()
            goto L_0x0060
        L_0x0037:
            r5 = move-exception
            goto L_0x0061
        L_0x0039:
            r5 = move-exception
            java.lang.String r6 = "MessageDao"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r2.<init>()     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = "checkColumnExists.."
            r2.append(r3)     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = r5.getMessage()     // Catch:{ all -> 0x0037 }
            r2.append(r3)     // Catch:{ all -> 0x0037 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0037 }
            com.didi.beatles.p099im.utils.IMLog.m6631d(r6, r2)     // Catch:{ all -> 0x0037 }
            r5.printStackTrace()     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0060
            boolean r5 = r0.isClosed()
            if (r5 != 0) goto L_0x0060
            goto L_0x0033
        L_0x0060:
            return r1
        L_0x0061:
            if (r0 == 0) goto L_0x006c
            boolean r6 = r0.isClosed()
            if (r6 != 0) goto L_0x006c
            r0.close()
        L_0x006c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.p100db.dao.MessageDao.checkColumnExists(com.didi.beatles.im.thirty.greenrobot.dao.database.Database, java.lang.String):boolean");
    }

    public void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append(this.mTableName);
        database.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void bindValues(DatabaseStatement databaseStatement, IMMessageDaoEntity iMMessageDaoEntity) {
        databaseStatement.clearBindings();
        Long id = iMMessageDaoEntity.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindLong(2, iMMessageDaoEntity.getMessage_id());
        databaseStatement.bindLong(3, iMMessageDaoEntity.getUnique_id());
        databaseStatement.bindLong(4, iMMessageDaoEntity.getSession_id());
        databaseStatement.bindLong(5, (long) iMMessageDaoEntity.getType());
        databaseStatement.bindLong(6, (long) iMMessageDaoEntity.getCategory());
        databaseStatement.bindLong(7, iMMessageDaoEntity.getSend_uid());
        databaseStatement.bindLong(8, iMMessageDaoEntity.getCreate_time());
        databaseStatement.bindLong(9, (long) iMMessageDaoEntity.getBusiness_id());
        databaseStatement.bindLong(10, (long) iMMessageDaoEntity.getPriority());
        databaseStatement.bindLong(11, (long) iMMessageDaoEntity.getStatus());
        String text_content = iMMessageDaoEntity.getText_content();
        if (text_content != null) {
            databaseStatement.bindString(12, text_content);
        }
        String file_uri = iMMessageDaoEntity.getFile_uri();
        if (file_uri != null) {
            databaseStatement.bindString(13, file_uri);
        }
        String gift_ns = iMMessageDaoEntity.getGift_ns();
        if (gift_ns != null) {
            databaseStatement.bindString(14, gift_ns);
        }
        String gift_ftoken = iMMessageDaoEntity.getGift_ftoken();
        if (gift_ftoken != null) {
            databaseStatement.bindString(15, gift_ftoken);
        }
        String gift_fid = iMMessageDaoEntity.getGift_fid();
        if (gift_fid != null) {
            databaseStatement.bindString(16, gift_fid);
        }
        String file_name = iMMessageDaoEntity.getFile_name();
        if (file_name != null) {
            databaseStatement.bindString(17, file_name);
        }
        databaseStatement.bindLong(18, (long) iMMessageDaoEntity.getHeight());
        databaseStatement.bindLong(19, (long) iMMessageDaoEntity.getWidth());
        databaseStatement.bindLong(20, (long) iMMessageDaoEntity.getSec());
        databaseStatement.bindLong(21, (long) iMMessageDaoEntity.getSize());
        databaseStatement.bindLong(22, (long) iMMessageDaoEntity.getSys_type());
        Boolean isRead = iMMessageDaoEntity.getIsRead();
        if (isRead != null) {
            databaseStatement.bindLong(23, isRead.booleanValue() ? 1 : 0);
        }
        databaseStatement.bindLong(24, (long) iMMessageDaoEntity.getReserveInt1());
        databaseStatement.bindLong(25, (long) iMMessageDaoEntity.getReserveInt2());
        String reserveStr3 = iMMessageDaoEntity.getReserveStr3();
        if (reserveStr3 != null) {
            databaseStatement.bindString(26, reserveStr3);
        }
        String unique_cloud_msg_id = iMMessageDaoEntity.getUnique_cloud_msg_id();
        if (unique_cloud_msg_id != null) {
            databaseStatement.bindString(27, unique_cloud_msg_id);
        }
    }

    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    public IMMessageDaoEntity readEntity(Cursor cursor, int i) {
        Boolean bool;
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        Long valueOf = cursor2.isNull(i2) ? null : Long.valueOf(cursor2.getLong(i2));
        long j = cursor2.getLong(i + 1);
        long j2 = cursor2.getLong(i + 2);
        long j3 = cursor2.getLong(i + 3);
        int i3 = cursor2.getInt(i + 4);
        int i4 = cursor2.getInt(i + 5);
        long j4 = cursor2.getLong(i + 6);
        long j5 = cursor2.getLong(i + 7);
        int i5 = cursor2.getInt(i + 8);
        int i6 = cursor2.getInt(i + 9);
        int i7 = cursor2.getInt(i + 10);
        int i8 = i + 11;
        String string = cursor2.isNull(i8) ? null : cursor2.getString(i8);
        int i9 = i + 12;
        String string2 = cursor2.isNull(i9) ? null : cursor2.getString(i9);
        int i10 = i + 13;
        String string3 = cursor2.isNull(i10) ? null : cursor2.getString(i10);
        int i11 = i + 14;
        String string4 = cursor2.isNull(i11) ? null : cursor2.getString(i11);
        int i12 = i + 15;
        String string5 = cursor2.isNull(i12) ? null : cursor2.getString(i12);
        int i13 = i + 16;
        String string6 = cursor2.isNull(i13) ? null : cursor2.getString(i13);
        int i14 = cursor2.getInt(i + 17);
        int i15 = cursor2.getInt(i + 18);
        int i16 = cursor2.getInt(i + 19);
        int i17 = cursor2.getInt(i + 20);
        int i18 = cursor2.getInt(i + 21);
        int i19 = i + 22;
        if (cursor2.isNull(i19)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor2.getShort(i19) != 0);
        }
        int i20 = cursor2.getInt(i + 23);
        int i21 = cursor2.getInt(i + 24);
        int i22 = i + 25;
        String string7 = cursor2.isNull(i22) ? null : cursor2.getString(i22);
        int i23 = i + 26;
        return new IMMessageDaoEntity(valueOf, j, j2, j3, i3, i4, j4, j5, i5, i6, i7, string, string2, string3, string4, string5, string6, i14, i15, i16, i17, i18, bool, i20, i21, string7, cursor2.isNull(i23) ? null : cursor2.getString(i23));
    }

    public void readEntity(Cursor cursor, IMMessageDaoEntity iMMessageDaoEntity, int i) {
        Boolean bool;
        int i2 = i + 0;
        String str = null;
        iMMessageDaoEntity.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        iMMessageDaoEntity.setMessage_id(cursor.getLong(i + 1));
        iMMessageDaoEntity.setUnique_id(cursor.getLong(i + 2));
        iMMessageDaoEntity.setSession_id(cursor.getLong(i + 3));
        iMMessageDaoEntity.setType(cursor.getInt(i + 4));
        iMMessageDaoEntity.setCategory(cursor.getInt(i + 5));
        iMMessageDaoEntity.setSend_uid(cursor.getLong(i + 6));
        iMMessageDaoEntity.setCreate_time(cursor.getLong(i + 7));
        iMMessageDaoEntity.setBusiness_id(cursor.getInt(i + 8));
        iMMessageDaoEntity.setPriority(cursor.getInt(i + 9));
        iMMessageDaoEntity.setStatus(cursor.getInt(i + 10));
        int i3 = i + 11;
        iMMessageDaoEntity.setText_content(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 12;
        iMMessageDaoEntity.setFile_uri(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 13;
        iMMessageDaoEntity.setGift_ns(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 14;
        iMMessageDaoEntity.setGift_ftoken(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 15;
        iMMessageDaoEntity.setGift_fid(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 16;
        iMMessageDaoEntity.setFile_name(cursor.isNull(i8) ? null : cursor.getString(i8));
        iMMessageDaoEntity.setHeight(cursor.getInt(i + 17));
        iMMessageDaoEntity.setWidth(cursor.getInt(i + 18));
        iMMessageDaoEntity.setSec(cursor.getInt(i + 19));
        iMMessageDaoEntity.setSize(cursor.getInt(i + 20));
        iMMessageDaoEntity.setSys_type(cursor.getInt(i + 21));
        int i9 = i + 22;
        if (cursor.isNull(i9)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(i9) != 0);
        }
        iMMessageDaoEntity.setIsRead(bool);
        iMMessageDaoEntity.setReserveInt1(cursor.getInt(i + 23));
        iMMessageDaoEntity.setReserveInt2(cursor.getInt(i + 24));
        int i10 = i + 25;
        iMMessageDaoEntity.setReserveStr3(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 26;
        if (!cursor.isNull(i11)) {
            str = cursor.getString(i11);
        }
        iMMessageDaoEntity.setUnique_cloud_msg_id(str);
    }

    /* access modifiers changed from: protected */
    public Long updateKeyAfterInsert(IMMessageDaoEntity iMMessageDaoEntity, long j) {
        iMMessageDaoEntity.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public Long getKey(IMMessageDaoEntity iMMessageDaoEntity) {
        if (iMMessageDaoEntity != null) {
            return iMMessageDaoEntity.getId();
        }
        return null;
    }
}
