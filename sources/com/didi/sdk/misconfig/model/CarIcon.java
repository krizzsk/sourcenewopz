package com.didi.sdk.misconfig.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CarIcon implements Serializable {
    private static final long serialVersionUID = 1;
    private String carIcon;
    private String carId;
    @SerializedName("endTime")
    private long endTime;
    private int groupId;

    /* renamed from: id */
    private long f36808id;
    private String name;
    @SerializedName("startTime")
    private long startTime;

    public static long getSerialVersionUID() {
        return 1;
    }

    public long getId() {
        return this.f36808id;
    }

    public String getName() {
        return this.name;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public String getCarId() {
        return this.carId;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getCarIcon() {
        return this.carIcon;
    }

    public void setId(long j) {
        this.f36808id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public void setCarId(String str) {
        this.carId = str;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setCarIcon(String str) {
        this.carIcon = str;
    }
}
