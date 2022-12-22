package com.didi.payment.creditcard.global.model.bean;

import com.didi.payment.creditcard.global.model.ThreeDSInfo;
import com.google.gson.annotations.SerializedName;

public class SignResult extends BaseResult {
    @SerializedName("back_url")
    public String backUrl;
    @SerializedName("button2_txt")
    public String buttonCancel;
    @SerializedName("button1_txt")
    public String buttonConfirm;
    @SerializedName("cancel_url")
    public String cancelUrl;
    @SerializedName("card_index")
    public String cardIndex;
    @SerializedName("cs_phone")
    public String csPhone;
    @SerializedName("cancel_txt")
    public String dialogCancelBtn;
    @SerializedName("confirm_txt")
    public String dialogConfirmBtn;
    @SerializedName("title_txt")
    public String dialogTitle;
    @SerializedName("android_download_url")
    public String downLoadUrl;
    @SerializedName("extraValueMap")
    public ThreeDSInfo extraValueMap;
    @SerializedName("faqURL")
    public String faqURL;
    @SerializedName("sign_url_new")
    public String newSginUrl;
    @SerializedName("polling_frequency")
    public int pollingFrequency = 5000;
    @SerializedName("polling_times")
    public int pollingTimes = 10;
    @SerializedName("sign_param")
    public String signParam;
    @SerializedName("sign_url")
    public String signUrl;
}
