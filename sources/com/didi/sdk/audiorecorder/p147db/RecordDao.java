package com.didi.sdk.audiorecorder.p147db;

import com.didi.sdk.audiorecorder.model.RecordResult;
import java.util.List;

/* renamed from: com.didi.sdk.audiorecorder.db.RecordDao */
public interface RecordDao {
    int count();

    void del(long j);

    List<RecordResult> getAll();

    void insert(RecordResult recordResult);

    void insertAll(RecordResult... recordResultArr);

    void update(RecordResult recordResult);
}
