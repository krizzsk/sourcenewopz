package com.didi.sdk.logging.upload.persist;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import java.util.ArrayList;
import java.util.List;

public final class SliceRecordDao_Impl implements SliceRecordDao {

    /* renamed from: a */
    private final RoomDatabase f36625a;

    /* renamed from: b */
    private final EntityInsertionAdapter<SliceRecord> f36626b;

    /* renamed from: c */
    private final EntityDeletionOrUpdateAdapter<SliceRecord> f36627c;

    /* renamed from: d */
    private final EntityDeletionOrUpdateAdapter<SliceRecord> f36628d;

    /* renamed from: e */
    private final SharedSQLiteStatement f36629e;

    public SliceRecordDao_Impl(RoomDatabase roomDatabase) {
        this.f36625a = roomDatabase;
        this.f36626b = new EntityInsertionAdapter<SliceRecord>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SliceRecord` (`taskId`,`sliceId`,`sliceCount`,`file`,`startPos`,`endPos`,`fileSize`,`status`,`uploadCount`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SliceRecord sliceRecord) {
                if (sliceRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, sliceRecord.getTaskId());
                }
                supportSQLiteStatement.bindLong(2, (long) sliceRecord.getSliceId());
                supportSQLiteStatement.bindLong(3, (long) sliceRecord.getSliceCount());
                if (sliceRecord.getFile() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, sliceRecord.getFile());
                }
                supportSQLiteStatement.bindLong(5, sliceRecord.getStartPos());
                supportSQLiteStatement.bindLong(6, sliceRecord.getEndPos());
                supportSQLiteStatement.bindLong(7, sliceRecord.getFileSize());
                supportSQLiteStatement.bindLong(8, (long) sliceRecord.getStatus());
                supportSQLiteStatement.bindLong(9, (long) sliceRecord.getUploadCount());
            }
        };
        this.f36627c = new EntityDeletionOrUpdateAdapter<SliceRecord>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `SliceRecord` WHERE `taskId` = ? AND `sliceId` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SliceRecord sliceRecord) {
                if (sliceRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, sliceRecord.getTaskId());
                }
                supportSQLiteStatement.bindLong(2, (long) sliceRecord.getSliceId());
            }
        };
        this.f36628d = new EntityDeletionOrUpdateAdapter<SliceRecord>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `SliceRecord` SET `taskId` = ?,`sliceId` = ?,`sliceCount` = ?,`file` = ?,`startPos` = ?,`endPos` = ?,`fileSize` = ?,`status` = ?,`uploadCount` = ? WHERE `taskId` = ? AND `sliceId` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SliceRecord sliceRecord) {
                if (sliceRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, sliceRecord.getTaskId());
                }
                supportSQLiteStatement.bindLong(2, (long) sliceRecord.getSliceId());
                supportSQLiteStatement.bindLong(3, (long) sliceRecord.getSliceCount());
                if (sliceRecord.getFile() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, sliceRecord.getFile());
                }
                supportSQLiteStatement.bindLong(5, sliceRecord.getStartPos());
                supportSQLiteStatement.bindLong(6, sliceRecord.getEndPos());
                supportSQLiteStatement.bindLong(7, sliceRecord.getFileSize());
                supportSQLiteStatement.bindLong(8, (long) sliceRecord.getStatus());
                supportSQLiteStatement.bindLong(9, (long) sliceRecord.getUploadCount());
                if (sliceRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, sliceRecord.getTaskId());
                }
                supportSQLiteStatement.bindLong(11, (long) sliceRecord.getSliceId());
            }
        };
        this.f36629e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM SliceRecord WHERE taskId = ?";
            }
        };
    }

    public void add(SliceRecord sliceRecord) {
        this.f36625a.assertNotSuspendingTransaction();
        this.f36625a.beginTransaction();
        try {
            this.f36626b.insert(sliceRecord);
            this.f36625a.setTransactionSuccessful();
        } finally {
            this.f36625a.endTransaction();
        }
    }

    public void addAll(List<SliceRecord> list) {
        this.f36625a.assertNotSuspendingTransaction();
        this.f36625a.beginTransaction();
        try {
            this.f36626b.insert(list);
            this.f36625a.setTransactionSuccessful();
        } finally {
            this.f36625a.endTransaction();
        }
    }

    public void delete(SliceRecord sliceRecord) {
        this.f36625a.assertNotSuspendingTransaction();
        this.f36625a.beginTransaction();
        try {
            this.f36627c.handle(sliceRecord);
            this.f36625a.setTransactionSuccessful();
        } finally {
            this.f36625a.endTransaction();
        }
    }

    public void update(SliceRecord sliceRecord) {
        this.f36625a.assertNotSuspendingTransaction();
        this.f36625a.beginTransaction();
        try {
            this.f36628d.handle(sliceRecord);
            this.f36625a.setTransactionSuccessful();
        } finally {
            this.f36625a.endTransaction();
        }
    }

    public void deleteByTaskId(String str) {
        this.f36625a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f36629e.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f36625a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f36625a.setTransactionSuccessful();
        } finally {
            this.f36625a.endTransaction();
            this.f36629e.release(acquire);
        }
    }

    public List<SliceRecord> getRecordsByTaskId(String str) {
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SliceRecord WHERE taskId = ? ORDER BY sliceId ASC", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.f36625a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f36625a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, DMWebSocketListener.KEY_TASK_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "sliceId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "sliceCount");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "file");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "startPos");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "endPos");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "fileSize");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "uploadCount");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow);
                int i = query.getInt(columnIndexOrThrow2);
                SliceRecord sliceRecord = new SliceRecord(string, query.getInt(columnIndexOrThrow3), i, query.getString(columnIndexOrThrow4), query.getLong(columnIndexOrThrow7), query.getLong(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6));
                sliceRecord.setStatus(query.getInt(columnIndexOrThrow8));
                sliceRecord.setUploadCount(query.getInt(columnIndexOrThrow9));
                arrayList.add(sliceRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
