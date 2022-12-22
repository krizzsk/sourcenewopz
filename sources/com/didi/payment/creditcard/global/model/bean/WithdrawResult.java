package com.didi.payment.creditcard.global.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WithdrawResult extends BaseSecResult {
    public static final int ERROR = 999999;
    public static final int NOT_ENOUGH = 100001;
    public static final int OVER_TIME = 100003;
    public static final int SUCCESS = 100002;
    @SerializedName("data")
    public Content content;

    public static class Content implements Serializable {
        @SerializedName("code")
        public int code;
        @SerializedName("extendResult")
        public List<Extend> extend;
        @SerializedName("frontMsg")
        public String frontMsg;
    }

    public static class Extend implements Serializable {
        @SerializedName("polling_times")
        public int maxPollingTimes;
        @SerializedName("polling_frequency")
        public int pollingFrequency;
    }
}
