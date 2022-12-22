package com.didi.map.global.component.slideCars.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NearDriver implements Serializable {
    @SerializedName("data")
    public NearCarDriver data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno = 0;

    public String toString() {
        return "NearDrivers{data=" + this.data + ", errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + '}';
    }
}
