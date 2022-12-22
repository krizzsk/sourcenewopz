package com.didi.dqr.task.transform;

import com.didi.dqr.task.base.DqrTask;
import com.didi.dqr.task.base.DqrTaskData;
import com.didi.dqr.task.base.DqrTaskType;

public class TransformTask extends DqrTask {
    public DqrTaskData run(DqrTaskData dqrTaskData) {
        return null;
    }

    public DqrTaskType getTaskType() {
        return DqrTaskType.TASK_TRANSFORM;
    }
}
