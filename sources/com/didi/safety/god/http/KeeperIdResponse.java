package com.didi.safety.god.http;

import java.io.Serializable;

public class KeeperIdResponse implements Serializable {
    private int code;
    private String keeperId;
    public String result;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getKeeperId() {
        return this.keeperId;
    }

    public void setKeeperId(String str) {
        this.keeperId = str;
    }
}
