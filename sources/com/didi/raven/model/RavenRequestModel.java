package com.didi.raven.model;

public class RavenRequestModel {
    private long duration;
    private Object req;
    private Object res;
    private int status = 0;

    public RavenRequestModel(Object obj, Object obj2, long j, int i) {
        this.req = obj;
        this.res = obj2;
        this.duration = j;
        this.status = i;
    }

    public Object getReq() {
        return this.req;
    }

    public void setReq(Object obj) {
        this.req = obj;
    }

    public Object getRes() {
        return this.res;
    }

    public void setRes(Object obj) {
        this.res = obj;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
