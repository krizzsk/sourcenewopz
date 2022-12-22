package com.didi.payment.creditcard.open;

import com.didi.payment.creditcard.global.model.bean.BaseResult;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DidiGlobalCheckCardData {

    public static class CheckCardParam implements Serializable {
        public int businessId;
        public String cardIndex;
        public String cardNo;
    }

    public static class CheckCardResult extends BaseResult {
        @SerializedName("data")
        public DataBean data;

        public static class DataBean {
            @SerializedName("code")
            public int code;
            @SerializedName("explain")
            private String explain;
        }
    }
}
