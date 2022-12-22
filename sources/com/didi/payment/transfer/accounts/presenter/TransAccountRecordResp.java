package com.didi.payment.transfer.accounts.presenter;

import com.didi.payment.transfer.net.TransBaseResp;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TransAccountRecordResp extends TransBaseResp {
    @SerializedName("data")
    public HistoryReceiver data;

    public static class HistoryReceiver {
        @SerializedName("lists")
        public List<NNPayAccount> transAccounts;
    }
}
