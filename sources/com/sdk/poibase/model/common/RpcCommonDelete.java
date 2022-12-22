package com.sdk.poibase.model.common;

import com.google.gson.annotations.SerializedName;

public class RpcCommonDelete {
    @SerializedName("delete")
    public int delete;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public String toString() {
        return "{errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + ", delete=" + this.delete + '}';
    }
}
