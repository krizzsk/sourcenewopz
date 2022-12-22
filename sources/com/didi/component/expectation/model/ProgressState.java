package com.didi.component.expectation.model;

import com.google.gson.annotations.SerializedName;

public class ProgressState {
    @SerializedName("count_order")
    private int countOrder = -1000;
    @SerializedName("end_icon_type")
    private int endIconType;
    @SerializedName("end_icon_uri")
    private String endIconUri;
    @SerializedName("end_progress")
    private float endProgress;
    @SerializedName("process_icon_type")
    private int processIconType;
    @SerializedName("process_icon_uri")
    private String processIconUri;
    @SerializedName("show_time")
    private int showTime;
    @SerializedName("start_progress")
    private float startProgress;
    @SerializedName("time_interval")
    private int timeInterval;

    public int getProcessIconType() {
        return this.processIconType;
    }

    public void setProcessIconType(int i) {
        this.processIconType = i;
    }

    public String getProcessIconUri() {
        return this.processIconUri;
    }

    public void setProcessIconUri(String str) {
        this.processIconUri = str;
    }

    public int getEndIconType() {
        return this.endIconType;
    }

    public void setEndIconType(int i) {
        this.endIconType = i;
    }

    public String getEndIconUri() {
        return this.endIconUri;
    }

    public void setEndIconUri(String str) {
        this.endIconUri = str;
    }

    public int getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(int i) {
        this.timeInterval = i;
    }

    public float getStartProgress() {
        return this.startProgress;
    }

    public void setStartProgress(float f) {
        this.startProgress = f;
    }

    public float getEndProgress() {
        return this.endProgress;
    }

    public void setEndProgress(float f) {
        this.endProgress = f;
    }

    public int getShowTime() {
        return this.showTime;
    }

    public void setShowTime(int i) {
        this.showTime = i;
    }

    public int getCountOrder() {
        return this.countOrder;
    }

    public void setCountOrder(int i) {
        this.countOrder = i;
    }

    public String toString() {
        return "ProgressState{timeInterval=" + this.timeInterval + ", startProgress=" + this.startProgress + ", endProgress=" + this.endProgress + ", showTime=" + this.showTime + ", processIconType=" + this.processIconType + ", processIconUri='" + this.processIconUri + '\'' + ", endIconType=" + this.endIconType + ", endIconUri='" + this.endIconUri + '\'' + '}';
    }
}
