package com.didi.sdk.push;

public class PushConnResult {
    private String extraMsg;
    private int retCode;
    private int subCode;

    public int getRetCode() {
        return this.retCode;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public void setSubCode(int i) {
        this.subCode = i;
    }

    public String getExtraMsg() {
        return this.extraMsg;
    }

    public void setExtraMsg(String str) {
        this.extraMsg = str;
    }
}
