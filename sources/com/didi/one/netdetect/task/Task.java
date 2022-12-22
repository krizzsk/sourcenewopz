package com.didi.one.netdetect.task;

import com.didi.one.netdetect.model.DetectionItem;

public interface Task<T> {
    T doTask(DetectionItem detectionItem);
}
