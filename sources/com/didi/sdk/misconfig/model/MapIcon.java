package com.didi.sdk.misconfig.model;

import java.io.Serializable;

public class MapIcon implements Serializable {
    private static final long serialVersionUID = 1;
    private String carId;
    private long endTime;
    private int groupId;
    private int iconFlipStatus;

    /* renamed from: id */
    private long f36814id;
    private String mapIcon;
    private String name;
    private long startTime;

    public static long getSerialVersionUID() {
        return 1;
    }

    public long getId() {
        return this.f36814id;
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

    public int getIconFlipStatus() {
        return this.iconFlipStatus;
    }

    public String getMapIcon() {
        return this.mapIcon;
    }

    public void setId(long j) {
        this.f36814id = j;
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

    public void setIconFlipStatus(int i) {
        this.iconFlipStatus = i;
    }

    public void setMapIcon(String str) {
        this.mapIcon = str;
    }
}
