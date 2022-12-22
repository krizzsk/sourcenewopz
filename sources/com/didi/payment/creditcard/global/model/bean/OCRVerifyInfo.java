package com.didi.payment.creditcard.global.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class OCRVerifyInfo extends BaseResult {
    @SerializedName("action")
    public List<ActionInfo> action;

    public static class ActionInfo implements Serializable {
        @SerializedName("method")
        public int method;
        @SerializedName("title")
        public String title;
    }
}
