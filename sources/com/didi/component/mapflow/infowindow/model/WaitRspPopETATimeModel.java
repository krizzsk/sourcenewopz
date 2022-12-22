package com.didi.component.mapflow.infowindow.model;

import java.io.Serializable;

public class WaitRspPopETATimeModel extends CommonInfoWindowModel implements Serializable {
    private String waitedText;
    private long waitedTime;

    public String getWaitedText() {
        return this.waitedText;
    }

    public void setWaitedText(String str) {
        this.waitedText = str;
    }

    public long getWaitedTime() {
        return this.waitedTime;
    }

    public void setWaitedTime(long j) {
        this.waitedTime = j;
    }
}
