package com.sdk.poibase.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HttpResultBase implements Serializable {
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno = 0;

    public String toString() {
        return "HttpResultBase{errmsg='" + this.errmsg + '\'' + "errno=" + this.errno + '}';
    }
}
