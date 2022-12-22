package com.didi.payment.creditcard.global.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WithdrawPageInfo extends BaseSecResult {
    public static final int ERROR = 999999;
    public static final int WITHDRAW_COMPLETED = 100003;
    public static final int WITHDRAW_DEFAULT = 100000;
    public static final int WITHDRAW_INIT = 100002;
    public static final int WITHDRAW_IN_PROGRESS = 100001;
    @SerializedName("data")
    public Content content;

    public static class Content implements Serializable {
        @SerializedName("code")
        public int code;
        @SerializedName("extendResult")
        public List<ExtendContent> extendResultList;
        @SerializedName("frontMsg")
        public String frontMsg;
    }

    public static class ExtendContent implements Serializable {
        @SerializedName("currency")
        public String currency;
        public String defaultText;
        public int isDecimal;
        @SerializedName("order")
        public int isSuffix;
    }
}
