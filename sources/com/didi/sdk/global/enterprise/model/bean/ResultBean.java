package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class ResultBean<T> implements Serializable {
    public static final int SUCCESS = 0;
    @SerializedName("data")
    public T data;
    @SerializedName("msg")
    public String msg;
    @SerializedName("status")
    public int status;
}
