package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SetEmailResponse extends BaseResponse {
    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("biz_code")
    public int bizCode;
    public String email;
    @SerializedName("information_verify_url")
    public String informationVerifyUrl;
    @SerializedName("promo_config")
    public PromoConfig promoConfig;
    @SerializedName("session_id")
    public String sessionId;

    public static class PromoConfig implements Serializable {
        @SerializedName("back_btn")
        public String backBtn;
        @SerializedName("continue_btn")
        public String continueBtn;
        @SerializedName("err_msg")
        public String msg;
        public String title;
    }
}
