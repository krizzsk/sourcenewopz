package com.didi.sdk.fastframe.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RpcBase implements Serializable {
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno = 0;
}
