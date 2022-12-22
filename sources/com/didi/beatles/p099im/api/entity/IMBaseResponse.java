package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMBaseResponse */
public class IMBaseResponse implements Serializable {
    public int data_ver;
    public String errmsg;
    public int errno;
    public int product;
    public boolean result;

    public boolean isSuccess() {
        return this.errno == 0;
    }
}
