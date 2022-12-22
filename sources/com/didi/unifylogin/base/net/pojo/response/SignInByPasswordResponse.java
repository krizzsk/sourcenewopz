package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

public class SignInByPasswordResponse extends BaseLoginSuccessResponse {
    @SerializedName("remain_times_prompt")
    public String remainTimesPrompt;
    @SerializedName("verify_email_texts")
    public JsonArray verifyEmailTexts;
    public String verify_comment;
    public String verify_session_id;
}
