package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;

public class WhatsAppLoginSuccessResponse extends BaseLoginSuccessResponse {
    @SerializedName("cell_encode")
    public String cellEncode;
}
