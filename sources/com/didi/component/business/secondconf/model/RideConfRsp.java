package com.didi.component.business.secondconf.model;

import java.io.Serializable;

public class RideConfRsp implements Serializable {
    private RideConfModel data;
    private String errmsg;
    private int errno;

    public int getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public RideConfModel getData() {
        return this.data;
    }
}
