package com.didi.consume.phone.model;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.view.PayRichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class CsDefaultPhoneNumberResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        public IWalletService.AccountInfo accountStatus;
        @SerializedName("history")
        public HistoryDataBean history;
        public PayRichInfo mobileRechargeTopMessage;
        @SerializedName("phoneCountryCodes")
        public List<String> phoneCountryCodes;
        public int status;
        public String statusMessage;
    }

    public static class HistoryDataBean implements Serializable {
        @SerializedName("phoneCountryCode")
        public String phoneCountryCode;
        @SerializedName("phoneNumber")
        public String phoneNumber;
    }
}
