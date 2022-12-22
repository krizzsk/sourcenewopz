package com.didichuxing.security.cardverify.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WithdrawVerifyResult extends BaseSecResult {
    public static final int ERROR = 999999;
    public static final int VERIFY_FAILURE_1 = 100002;
    public static final int VERIFY_FAILURE_2 = 100003;
    public static final int VERIFY_FAILURE_3 = 100004;
    public static final int VERIFY_SUCCESS = 100001;
    @SerializedName("data")
    public Content content;

    public static class Content implements Serializable {
        @SerializedName("code")
        public int code;
        @SerializedName("extendResult")
        public List<ExtendResultItem> extendResult;
        @SerializedName("frontMsg")
        public String frontMsg;
    }

    public static class ExtendResultItem {
        @SerializedName("url")
        public String contactH5Url;
    }

    public String getContactH5Url() {
        ExtendResultItem extendResultItem;
        Content content2 = this.content;
        if (content2 == null || content2.extendResult == null || this.content.extendResult.size() <= 0 || (extendResultItem = this.content.extendResult.get(0)) == null) {
            return "";
        }
        return extendResultItem.contactH5Url;
    }
}
