package com.didi.sdk.audiorecorder.p147db;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import com.didi.sdk.audiorecorder.model.RecordResult;
import com.didichuxing.afanty.common.utils.Constants;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.audiorecorder.db.RecordDao_Impl */
public class RecordDao_Impl implements RecordDao {

    /* renamed from: a */
    private final RoomDatabase f35293a;

    /* renamed from: b */
    private final EntityInsertionAdapter f35294b;

    /* renamed from: c */
    private final EntityInsertionAdapter f35295c;

    /* renamed from: d */
    private final EntityDeletionOrUpdateAdapter f35296d;

    /* renamed from: e */
    private final SharedSQLiteStatement f35297e;

    public RecordDao_Impl(RoomDatabase roomDatabase) {
        this.f35293a = roomDatabase;
        this.f35294b = new EntityInsertionAdapter<RecordResult>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `record_result`(`caller`,`businessId`,`businessAlias`,`audioFilePath`,`fileSizeInBytes`,`voiceLenInSeconds`,`startRecordTime`,`finishRecordTime`,`orderIds`,`clientType`,`utcOffsetInMinutes`,`token`,`language`,`uploadRetryCount`,`extraJson`,`uploadUrl`,`signKey`,`userId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, RecordResult recordResult) {
                if (recordResult.getCaller() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, recordResult.getCaller());
                }
                if (recordResult.getBusinessId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, recordResult.getBusinessId());
                }
                if (recordResult.getBusinessAlias() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, recordResult.getBusinessAlias());
                }
                if (recordResult.getAudioFilePath() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, recordResult.getAudioFilePath());
                }
                supportSQLiteStatement.bindLong(5, recordResult.getFileSizeInBytes());
                supportSQLiteStatement.bindLong(6, recordResult.getVoiceLenInSeconds());
                supportSQLiteStatement.bindLong(7, recordResult.getStartRecordTime());
                supportSQLiteStatement.bindLong(8, recordResult.getFinishRecordTime());
                if (recordResult.getOrderIds() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, recordResult.getOrderIds());
                }
                supportSQLiteStatement.bindLong(10, (long) recordResult.getClientType());
                supportSQLiteStatement.bindLong(11, (long) recordResult.getUtcOffsetInMinutes());
                if (recordResult.getToken() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, recordResult.getToken());
                }
                if (recordResult.getLanguage() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, recordResult.getLanguage());
                }
                supportSQLiteStatement.bindLong(14, (long) recordResult.getUploadRetryCount());
                if (recordResult.getExtraJson() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, recordResult.getExtraJson());
                }
                if (recordResult.getUploadUrl() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, recordResult.getUploadUrl());
                }
                if (recordResult.getSignKey() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, recordResult.getSignKey());
                }
                if (recordResult.getUserId() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, recordResult.getUserId());
                }
            }
        };
        this.f35295c = new EntityInsertionAdapter<RecordResult>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `record_result`(`caller`,`businessId`,`businessAlias`,`audioFilePath`,`fileSizeInBytes`,`voiceLenInSeconds`,`startRecordTime`,`finishRecordTime`,`orderIds`,`clientType`,`utcOffsetInMinutes`,`token`,`language`,`uploadRetryCount`,`extraJson`,`uploadUrl`,`signKey`,`userId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, RecordResult recordResult) {
                if (recordResult.getCaller() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, recordResult.getCaller());
                }
                if (recordResult.getBusinessId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, recordResult.getBusinessId());
                }
                if (recordResult.getBusinessAlias() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, recordResult.getBusinessAlias());
                }
                if (recordResult.getAudioFilePath() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, recordResult.getAudioFilePath());
                }
                supportSQLiteStatement.bindLong(5, recordResult.getFileSizeInBytes());
                supportSQLiteStatement.bindLong(6, recordResult.getVoiceLenInSeconds());
                supportSQLiteStatement.bindLong(7, recordResult.getStartRecordTime());
                supportSQLiteStatement.bindLong(8, recordResult.getFinishRecordTime());
                if (recordResult.getOrderIds() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, recordResult.getOrderIds());
                }
                supportSQLiteStatement.bindLong(10, (long) recordResult.getClientType());
                supportSQLiteStatement.bindLong(11, (long) recordResult.getUtcOffsetInMinutes());
                if (recordResult.getToken() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, recordResult.getToken());
                }
                if (recordResult.getLanguage() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, recordResult.getLanguage());
                }
                supportSQLiteStatement.bindLong(14, (long) recordResult.getUploadRetryCount());
                if (recordResult.getExtraJson() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, recordResult.getExtraJson());
                }
                if (recordResult.getUploadUrl() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, recordResult.getUploadUrl());
                }
                if (recordResult.getSignKey() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, recordResult.getSignKey());
                }
                if (recordResult.getUserId() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, recordResult.getUserId());
                }
            }
        };
        this.f35296d = new EntityDeletionOrUpdateAdapter<RecordResult>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR REPLACE `record_result` SET `caller` = ?,`businessId` = ?,`businessAlias` = ?,`audioFilePath` = ?,`fileSizeInBytes` = ?,`voiceLenInSeconds` = ?,`startRecordTime` = ?,`finishRecordTime` = ?,`orderIds` = ?,`clientType` = ?,`utcOffsetInMinutes` = ?,`token` = ?,`language` = ?,`uploadRetryCount` = ?,`extraJson` = ?,`uploadUrl` = ?,`signKey` = ?,`userId` = ? WHERE `startRecordTime` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, RecordResult recordResult) {
                if (recordResult.getCaller() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, recordResult.getCaller());
                }
                if (recordResult.getBusinessId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, recordResult.getBusinessId());
                }
                if (recordResult.getBusinessAlias() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, recordResult.getBusinessAlias());
                }
                if (recordResult.getAudioFilePath() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, recordResult.getAudioFilePath());
                }
                supportSQLiteStatement.bindLong(5, recordResult.getFileSizeInBytes());
                supportSQLiteStatement.bindLong(6, recordResult.getVoiceLenInSeconds());
                supportSQLiteStatement.bindLong(7, recordResult.getStartRecordTime());
                supportSQLiteStatement.bindLong(8, recordResult.getFinishRecordTime());
                if (recordResult.getOrderIds() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, recordResult.getOrderIds());
                }
                supportSQLiteStatement.bindLong(10, (long) recordResult.getClientType());
                supportSQLiteStatement.bindLong(11, (long) recordResult.getUtcOffsetInMinutes());
                if (recordResult.getToken() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, recordResult.getToken());
                }
                if (recordResult.getLanguage() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, recordResult.getLanguage());
                }
                supportSQLiteStatement.bindLong(14, (long) recordResult.getUploadRetryCount());
                if (recordResult.getExtraJson() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, recordResult.getExtraJson());
                }
                if (recordResult.getUploadUrl() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, recordResult.getUploadUrl());
                }
                if (recordResult.getSignKey() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, recordResult.getSignKey());
                }
                if (recordResult.getUserId() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, recordResult.getUserId());
                }
                supportSQLiteStatement.bindLong(19, recordResult.getStartRecordTime());
            }
        };
        this.f35297e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM record_result WHERE startRecordTime = ?";
            }
        };
    }

    public void insertAll(RecordResult... recordResultArr) {
        this.f35293a.beginTransaction();
        try {
            this.f35294b.insert((T[]) recordResultArr);
            this.f35293a.setTransactionSuccessful();
        } finally {
            this.f35293a.endTransaction();
        }
    }

    public void insert(RecordResult recordResult) {
        this.f35293a.beginTransaction();
        try {
            this.f35295c.insert(recordResult);
            this.f35293a.setTransactionSuccessful();
        } finally {
            this.f35293a.endTransaction();
        }
    }

    public void update(RecordResult recordResult) {
        this.f35293a.beginTransaction();
        try {
            this.f35296d.handle(recordResult);
            this.f35293a.setTransactionSuccessful();
        } finally {
            this.f35293a.endTransaction();
        }
    }

    public void del(long j) {
        SupportSQLiteStatement acquire = this.f35297e.acquire();
        this.f35293a.beginTransaction();
        try {
            acquire.bindLong(1, j);
            acquire.executeUpdateDelete();
            this.f35293a.setTransactionSuccessful();
        } finally {
            this.f35293a.endTransaction();
            this.f35297e.release(acquire);
        }
    }

    public int count() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM record_result", 0);
        Cursor query = this.f35293a.query(acquire);
        try {
            if (query.moveToFirst()) {
                i = query.getInt(0);
            }
            return i;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<RecordResult> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM record_result", 0);
        Cursor query = this.f35293a.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("caller");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow(Constants.JSON_BUSINESS_ID);
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("businessAlias");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("audioFilePath");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("fileSizeInBytes");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("voiceLenInSeconds");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("startRecordTime");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("finishRecordTime");
            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("orderIds");
            int columnIndexOrThrow10 = query.getColumnIndexOrThrow("clientType");
            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("utcOffsetInMinutes");
            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("token");
            int columnIndexOrThrow13 = query.getColumnIndexOrThrow("language");
            int columnIndexOrThrow14 = query.getColumnIndexOrThrow("uploadRetryCount");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = query.getColumnIndexOrThrow("extraJson");
                int columnIndexOrThrow16 = query.getColumnIndexOrThrow("uploadUrl");
                int columnIndexOrThrow17 = query.getColumnIndexOrThrow("signKey");
                int columnIndexOrThrow18 = query.getColumnIndexOrThrow("userId");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    RecordResult recordResult = new RecordResult();
                    ArrayList arrayList2 = arrayList;
                    recordResult.setCaller(query.getString(columnIndexOrThrow));
                    recordResult.setBusinessId(query.getString(columnIndexOrThrow2));
                    recordResult.setBusinessAlias(query.getString(columnIndexOrThrow3));
                    recordResult.setAudioFilePath(query.getString(columnIndexOrThrow4));
                    int i2 = columnIndexOrThrow;
                    recordResult.setFileSizeInBytes(query.getLong(columnIndexOrThrow5));
                    recordResult.setVoiceLenInSeconds(query.getLong(columnIndexOrThrow6));
                    recordResult.setStartRecordTime(query.getLong(columnIndexOrThrow7));
                    recordResult.setFinishRecordTime(query.getLong(columnIndexOrThrow8));
                    recordResult.setOrderIds(query.getString(columnIndexOrThrow9));
                    recordResult.setClientType(query.getInt(columnIndexOrThrow10));
                    recordResult.setUtcOffsetInMinutes(query.getInt(columnIndexOrThrow11));
                    recordResult.setToken(query.getString(columnIndexOrThrow12));
                    recordResult.setLanguage(query.getString(columnIndexOrThrow13));
                    int i3 = i;
                    recordResult.setUploadRetryCount(query.getInt(i3));
                    i = i3;
                    int i4 = columnIndexOrThrow15;
                    recordResult.setExtraJson(query.getString(i4));
                    columnIndexOrThrow15 = i4;
                    int i5 = columnIndexOrThrow16;
                    recordResult.setUploadUrl(query.getString(i5));
                    columnIndexOrThrow16 = i5;
                    int i6 = columnIndexOrThrow17;
                    recordResult.setSignKey(query.getString(i6));
                    columnIndexOrThrow17 = i6;
                    int i7 = columnIndexOrThrow18;
                    recordResult.setUserId(query.getString(i7));
                    arrayList = arrayList2;
                    arrayList.add(recordResult);
                    columnIndexOrThrow18 = i7;
                    columnIndexOrThrow = i2;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
