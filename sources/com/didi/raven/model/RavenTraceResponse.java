package com.didi.raven.model;

import java.io.Serializable;

public class RavenTraceResponse implements Serializable {

    /* renamed from: c */
    private int f33108c;

    /* renamed from: i */
    private String f33109i;

    public int getC() {
        return this.f33108c;
    }

    public String getI() {
        return this.f33109i;
    }

    public String toString() {
        return "RavenTraceResponse{c=" + this.f33108c + ", i='" + this.f33109i + '\'' + '}';
    }
}
