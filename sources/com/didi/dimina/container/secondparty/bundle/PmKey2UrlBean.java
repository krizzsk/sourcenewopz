package com.didi.dimina.container.secondparty.bundle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class PmKey2UrlBean implements Serializable {
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private List<String> data;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public List<String> getData() {
        return this.data;
    }

    public void setData(List<String> list) {
        this.data = list;
    }

    public String toString() {
        return "PmKey2UrlBean{success=" + this.success + ", message='" + this.message + '\'' + ", code=" + this.code + ", data=" + this.data + '}';
    }
}
