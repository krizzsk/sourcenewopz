package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GetEmailInfoResponse extends BaseResponse implements Serializable {
    @SerializedName("activation_time")
    public long activationTime;
    public String email;
    @SerializedName("email_status")
    public int emailStatus;
}
