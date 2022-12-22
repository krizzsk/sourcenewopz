package com.didi.dqr.task.base;

public abstract class DqrTask {
    protected TaskExecutor executor;

    public abstract DqrTaskType getTaskType();

    public abstract DqrTaskData run(DqrTaskData dqrTaskData) throws Exception;

    public void setExecutor(TaskExecutor taskExecutor) {
        this.executor = taskExecutor;
    }
}
