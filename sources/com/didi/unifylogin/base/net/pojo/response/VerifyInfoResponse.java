package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

public class VerifyInfoResponse extends BaseResponse {
    @SerializedName("help_link")
    public String helpLink;
    @SerializedName("remain")
    public int remain;
    @SerializedName("verify_comment")
    public JsonArray verifyComment;
    @SerializedName("verify_session_id")
    public String verifySessionId;
}
