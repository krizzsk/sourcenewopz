package com.didi.raven.model;

import java.io.Serializable;

public class RavenTimeRequestModel implements Serializable {
    private long duration;
    private int success;

    public RavenTimeRequestModel(long j, int i) {
        this.duration = j;
        this.success = i;
    }
}
