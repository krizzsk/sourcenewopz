package com.didi.sdk.logging.upload.persist;

public class TaskFileRecord {
    private String file;
    private String taskId;

    public TaskFileRecord(String str, String str2) {
        this.taskId = str;
        this.file = str2;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public String toString() {
        return "TaskFileRecord{taskId='" + this.taskId + '\'' + ", file='" + this.file + '\'' + '}';
    }
}
