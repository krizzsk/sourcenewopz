package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletUserProtocolsResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class AcceptedProtocol implements Serializable {
        @SerializedName("link")
        public String link;
        @SerializedName("type")
        public String type;
        @SerializedName("version")
        public String version;
    }

    public static class DataBean implements Serializable {
        @SerializedName("acceptedProtocol")
        public AcceptedProtocol acceptedProtocol;
        @SerializedName("waitForAcceptProtocol")
        public UnAcceptProtocol unAcceptProtocol;
    }

    public static class UnAcceptProtocol implements Serializable {
        @SerializedName("link")
        public String link;
        @SerializedName("type")
        public String type;
        @SerializedName("version")
        public String version;
    }
}
