package com.sdk.poibase.model.recoperation;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;

public class RpcRecOperation extends HttpResultBase {
    @SerializedName("result")
    private String result;

    public String toString() {
        return "{errno=" + this.errno + ", result='" + this.result + '\'' + '}';
    }
}
