package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;

public class BaseLoginSuccessResponse extends BaseResponse {
    public String appeal_comment;
    public String appeal_tel;
    @SerializedName("country_calling_code")
    public String callingCode;
    public String cell;
    @SerializedName("country_id")
    public int countryId;
    public String email;
    @SerializedName("email_plain_text")
    public String emailPlainText;
    @SerializedName("remain")
    public int remain;
    public int role;
    public String ticket;
    public long uid;
    @SerializedName("usertype")
    public int userType;
}
