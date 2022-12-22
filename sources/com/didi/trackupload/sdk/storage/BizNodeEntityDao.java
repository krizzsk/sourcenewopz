package com.didi.trackupload.sdk.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class BizNodeEntityDao extends AbstractDao<BizNodeEntity, String> {
    public static final String TABLENAME = "tbl_biz_nodes";

    public static class Properties {
        public static final Property Client_type = new Property(1, Integer.class, "client_type", false, "client_type");
        public static final Property Extra_data = new Property(2, byte[].class, "extra_data", false, "extra_data");
        public static final Property Tag = new Property(0, String.class, "tag", true, "tag");
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }

    public BizNodeEntityDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BizNodeEntityDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"tbl_biz_nodes\" (\"tag\" TEXT PRIMARY KEY NOT NULL ,\"client_type\" INTEGER,\"extra_data\" BLOB);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"tbl_biz_nodes\"");
        database.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(DatabaseStatement databaseStatement, BizNodeEntity bizNodeEntity) {
        databaseStatement.clearBindings();
        String tag = bizNodeEntity.getTag();
        if (tag != null) {
            databaseStatement.bindString(1, tag);
        }
        Integer client_type = bizNodeEntity.getClient_type();
        if (client_type != null) {
            databaseStatement.bindLong(2, (long) client_type.intValue());
        }
        byte[] extra_data = bizNodeEntity.getExtra_data();
        if (extra_data != null) {
            databaseStatement.bindBlob(3, extra_data);
        }
    }

    /* access modifiers changed from: protected */
    public final void bindValues(SQLiteStatement sQLiteStatement, BizNodeEntity bizNodeEntity) {
        sQLiteStatement.clearBindings();
        String tag = bizNodeEntity.getTag();
        if (tag != null) {
            sQLiteStatement.bindString(1, tag);
        }
        Integer client_type = bizNodeEntity.getClient_type();
        if (client_type != null) {
            sQLiteStatement.bindLong(2, (long) client_type.intValue());
        }
        byte[] extra_data = bizNodeEntity.getExtra_data();
        if (extra_data != null) {
            sQLiteStatement.bindBlob(3, extra_data);
        }
    }

    public String readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }

    public BizNodeEntity readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        byte[] bArr = null;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 1;
        Integer valueOf = cursor.isNull(i3) ? null : Integer.valueOf(cursor.getInt(i3));
        int i4 = i + 2;
        if (!cursor.isNull(i4)) {
            bArr = cursor.getBlob(i4);
        }
        return new BizNodeEntity(string, valueOf, bArr);
    }

    public void readEntity(Cursor cursor, BizNodeEntity bizNodeEntity, int i) {
        int i2 = i + 0;
        byte[] bArr = null;
        bizNodeEntity.setTag(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        bizNodeEntity.setClient_type(cursor.isNull(i3) ? null : Integer.valueOf(cursor.getInt(i3)));
        int i4 = i + 2;
        if (!cursor.isNull(i4)) {
            bArr = cursor.getBlob(i4);
        }
        bizNodeEntity.setExtra_data(bArr);
    }

    /* access modifiers changed from: protected */
    public final String updateKeyAfterInsert(BizNodeEntity bizNodeEntity, long j) {
        return bizNodeEntity.getTag();
    }

    public String getKey(BizNodeEntity bizNodeEntity) {
        if (bizNodeEntity != null) {
            return bizNodeEntity.getTag();
        }
        return null;
    }

    public boolean hasKey(BizNodeEntity bizNodeEntity) {
        return bizNodeEntity.getTag() != null;
    }
}
