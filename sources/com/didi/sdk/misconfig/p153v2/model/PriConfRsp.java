package com.didi.sdk.misconfig.p153v2.model;

import java.io.Serializable;

/* renamed from: com.didi.sdk.misconfig.v2.model.PriConfRsp */
public class PriConfRsp implements Serializable {
    private PriConfModel data;
    private String errmsg;
    private int errno;

    public int getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public PriConfModel getData() {
        return this.data;
    }
}
