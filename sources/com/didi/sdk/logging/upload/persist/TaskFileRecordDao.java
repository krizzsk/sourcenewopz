package com.didi.sdk.logging.upload.persist;

import java.util.List;

public interface TaskFileRecordDao {
    void add(TaskFileRecord taskFileRecord);

    void addAll(List<TaskFileRecord> list);

    void delete(TaskFileRecord taskFileRecord);

    void deleteByTaskId(String str);

    List<TaskFileRecord> getRecordsByTaskId(String str);

    void update(TaskFileRecord taskFileRecord);
}
