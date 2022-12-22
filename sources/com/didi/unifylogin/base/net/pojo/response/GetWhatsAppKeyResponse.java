package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GetWhatsAppKeyResponse extends BaseResponse implements Serializable {
    @SerializedName("whatsapp_deeplink")
    public String whatsAppDeepLink;
    @SerializedName("whatsapp_key")
    public String whatsAppKey;
}
