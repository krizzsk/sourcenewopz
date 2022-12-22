package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;

public class SignInByFaceResponse extends BaseLoginSuccessResponse {
    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("session_id")
    public String sessionId;
}
