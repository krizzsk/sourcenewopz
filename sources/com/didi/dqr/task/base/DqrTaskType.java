package com.didi.dqr.task.base;

public enum DqrTaskType {
    TASK_BINARIZER(1),
    TASK_DETECTOR(2),
    TASK_TRANSFORM(3),
    TASK_DECODE(4);
    
    private int type;

    private DqrTaskType(int i) {
        this.type = i;
    }
}
