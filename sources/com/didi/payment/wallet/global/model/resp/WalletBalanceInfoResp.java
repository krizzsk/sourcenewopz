package com.didi.payment.wallet.global.model.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletBalanceInfoResp implements Serializable {
    @SerializedName("data")
    public BalanceInfoData data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class BalanceInfoData implements Serializable {
        @SerializedName("cashback")
        public int cashback;
        @SerializedName("cashbackLabel")
        public String cashbackLabel;
        @SerializedName("hasHit")
        public boolean hasHit;
        @SerializedName("interestLabel")
        public String interestLabel;
        @SerializedName("interests")
        public int interests;
        @SerializedName("totalBalance")
        public int totalBalance;
        @SerializedName("totalBalanceLabel")
        public String totalBalanceLabel;
        @SerializedName("totalEarning")
        public int totalEarning;
        @SerializedName("totalEarningLabel")
        public String totalEarningLabel;
        @SerializedName("withoutHistory")
        public boolean withoutHistory;
    }
}
