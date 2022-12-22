package com.didichuxing.publicservice.network;

public class ThreadTask implements Runnable {
    private TaskCallBack mTaskCallBack;
    private String mtag;
    private volatile boolean stop = false;

    public interface TaskCallBack {
        void setTaskContent();
    }

    public ThreadTask() {
    }

    public ThreadTask(String str) {
        this.mtag = str;
    }

    public void setTaskContentCallBack(TaskCallBack taskCallBack) {
        this.mTaskCallBack = taskCallBack;
    }

    public boolean isStopped() {
        return this.stop;
    }

    public String getTag() {
        return this.mtag;
    }

    public void stopTask() {
        if (!this.stop) {
            this.stop = true;
        }
    }

    public void run() {
        TaskCallBack taskCallBack = this.mTaskCallBack;
        if (taskCallBack != null) {
            taskCallBack.setTaskContent();
        }
    }
}
