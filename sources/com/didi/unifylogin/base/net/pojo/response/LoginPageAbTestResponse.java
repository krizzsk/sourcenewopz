package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

public class LoginPageAbTestResponse extends BaseResponse {
    @SerializedName("ab_result")
    public int abResult;
    @SerializedName("ab_result_extra")
    public JSONObject abResultExtra;
}
