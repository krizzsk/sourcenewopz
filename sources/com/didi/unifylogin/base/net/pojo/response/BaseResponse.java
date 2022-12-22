package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BaseResponse implements Serializable {
    public int errno = -1;
    public String error;
    public String text;
    @SerializedName("traceid")
    public String traceId;
}
