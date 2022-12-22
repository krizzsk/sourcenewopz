package com.didi.sdk.logging.upload.persist;

import java.util.List;

public interface TaskRecordDao {
    void add(TaskRecord taskRecord);

    void delete(TaskRecord taskRecord);

    void deleteByTaskId(String str);

    List<TaskRecord> getRecordList();

    TaskRecord getRecordsByTaskId(String str);
}
