package com.didi.travel.psnger.model.response;

public class PreAuthModel {
    public String errorMsg;
    public int errorType;
    public String oid;

    public PreAuthModel(String str, int i, String str2) {
        this.oid = str;
        this.errorType = i;
        this.errorMsg = str2;
    }
}
