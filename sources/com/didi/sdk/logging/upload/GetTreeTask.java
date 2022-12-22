package com.didi.sdk.logging.upload;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class GetTreeTask {
    public static final long MAX_MESSAGE_TIME_DELTA = 20000;
    @SerializedName("event_id")
    private String eventId;
    @SerializedName("event_type")
    private int eventType;
    @SerializedName("timestamp")
    private long serverPushTimestamp;
    @SerializedName("task_id")
    private String taskId;

    public boolean hasTaskId() {
        return !TextUtils.isEmpty(this.taskId);
    }

    public String getTaskId() {
        return this.taskId;
    }

    public long getPushTimestamp() {
        return this.serverPushTimestamp * 1000;
    }

    public static GetTreeTask parseGetTreeTask(String str) {
        try {
            return (GetTreeTask) new Gson().fromJson(str, GetTreeTask.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
