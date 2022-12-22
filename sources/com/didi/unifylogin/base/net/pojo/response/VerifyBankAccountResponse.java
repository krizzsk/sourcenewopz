package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;

public class VerifyBankAccountResponse extends BaseLoginSuccessResponse {
    @SerializedName("remain_times_prompt")
    public String remainTimesPrompt;
    @SerializedName("verify_session_id")
    public String verifySessionId;
}
