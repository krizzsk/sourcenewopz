package com.didi.payment.transfer.newaccount;

import com.didi.payment.transfer.net.TransBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class TransBankAccountTypeResp extends TransBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class AccountType implements Serializable {
        @SerializedName("key")
        String key;
        @SerializedName("value")
        int value;
    }

    public static class DataBean implements Serializable {
        @SerializedName("accountTypeList")
        ArrayList<AccountType> accountTypeList;
        @SerializedName("hitBankImprove")
        boolean hitBankImprove;
    }
}
