package com.didi.sdk.logging.upload.persist;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class TaskRecord {
    @SerializedName("buffers")
    private String buffers;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("end_timestamp")
    private long endTimestamp;
    @SerializedName("log_path")
    private String logPath;
    private transient String rawData;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("start_timestamp")
    private long startTimestamp;
    @SerializedName("task_id")
    private String taskId;

    public TaskRecord(String str) {
        this.taskId = str;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public static TaskRecord fromJson(String str) {
        TaskRecord taskRecord = (TaskRecord) new Gson().fromJson(str, TaskRecord.class);
        taskRecord.setRawData(str);
        return taskRecord;
    }

    public static TaskRecord fromJson(JsonElement jsonElement) {
        return (TaskRecord) new Gson().fromJson(jsonElement, TaskRecord.class);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.taskId) && !TextUtils.isEmpty(this.startTime) && !TextUtils.isEmpty(this.endTime);
    }

    public String getBuffers() {
        return this.buffers;
    }

    public void setBuffers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.buffers = str;
        }
    }

    public TaskRecord setRawData(String str) {
        this.rawData = str;
        return this;
    }

    public String getRawData() {
        return this.rawData;
    }

    public String toString() {
        return "TaskRecord{taskId='" + this.taskId + '\'' + ", logPath='" + this.logPath + '\'' + ", startTime='" + this.startTime + '\'' + ", endTime='" + this.endTime + '\'' + ", buffers='" + this.buffers + '\'' + '}';
    }

    public long getStartTimestamp() {
        return this.startTimestamp;
    }

    public void setStartTimestamp(long j) {
        this.startTimestamp = j;
    }

    public long getEndTimestamp() {
        return this.endTimestamp;
    }

    public void setEndTimestamp(long j) {
        this.endTimestamp = j;
    }
}
