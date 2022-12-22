package com.didi.safety.god.http;

import java.io.Serializable;

public class SafetyResponse<T> implements Serializable {
    private long apiCode;
    private String apiMsg;
    private T data;

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public long getApiCode() {
        return this.apiCode;
    }

    public void setApiCode(long j) {
        this.apiCode = j;
    }

    public String getApiMsg() {
        return this.apiMsg;
    }

    public void setApiMsg(String str) {
        this.apiMsg = str;
    }
}
