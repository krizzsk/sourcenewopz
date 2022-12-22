package com.didi.consume.channels.model;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.google.gson.annotations.SerializedName;

public class CsTopUpChannelResp extends WBaseResp {
    @SerializedName("data")
    public Data data;

    public static class Data extends WalletTopUpChannelResp.DataBean {
        @SerializedName("accountStatus")
        public IWalletService.AccountInfo accountInfo;
        @SerializedName("status")
        public int status;
        @SerializedName("statusMessage")
        public String statusMsg;
    }
}
