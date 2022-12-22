package com.didi.raven.model;

import com.didi.raven.RavenSdk;
import java.io.Serializable;

public class RavenRequestTrack implements Serializable {
    private Object body;
    private long endTime;
    private String path;
    private long startTime = System.currentTimeMillis();

    public RavenRequestTrack(String str, Object obj) {
        this.path = str;
        this.body = obj;
    }

    public void track(String str, String str2, Object obj, int i) {
        this.endTime = System.currentTimeMillis();
        RavenSdk.getInstance().trackRequest(str, this.path, str2, this.body, obj, this.startTime, this.endTime, i);
    }

    public void track(String str, String str2, Object obj) {
        this.endTime = System.currentTimeMillis();
        RavenSdk.getInstance().trackRequest(str, this.path, str2, this.body, obj, this.startTime, this.endTime, 0);
    }
}
