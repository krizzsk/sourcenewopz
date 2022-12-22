package com.didi.sdk.logging.upload.persist;

import java.util.List;

public interface SliceRecordDao {
    void add(SliceRecord sliceRecord);

    void addAll(List<SliceRecord> list);

    void delete(SliceRecord sliceRecord);

    void deleteByTaskId(String str);

    List<SliceRecord> getRecordsByTaskId(String str);

    void update(SliceRecord sliceRecord);
}
