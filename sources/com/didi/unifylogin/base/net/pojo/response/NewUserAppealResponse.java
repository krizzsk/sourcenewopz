package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;

public class NewUserAppealResponse extends BaseResponse {
    @SerializedName("appeal_tel")
    public String appealTel;
    @SerializedName("verify_session_id")
    public String verifySessionId;
}
