package com.didichuxing.security.cardverify.model.bean;

import com.didichuxing.security.cardverify.model.bean.WithdrawPageInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WithdrawPollResult extends BaseSecResult {
    public static final int ERROR = 999999;
    public static final int WITHDRAW_FAILURE = 100003;
    public static final int WITHDRAW_IN_PROGRESS = 100002;
    public static final int WITHDRAW_SUCCESS = 100001;
    @SerializedName("data")
    public Content content;

    public static class Content implements Serializable {
        @SerializedName("code")
        public int code;
        @SerializedName("extendResult")
        public List<WithdrawPageInfo.ExtendContent> extendResultList;
        @SerializedName("frontMsg")
        public String frontMsg;
    }
}
