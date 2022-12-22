package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletSettingsResp extends WBaseResp {
    @SerializedName("data")
    public WalletSettings data;

    public static class WalletSettingExtra implements Serializable {
        @SerializedName("setStatus")
        public int setStatus;
        @SerializedName("toBeValidText")
        public String toBeValidText;
    }

    public static class WalletSettingItem implements Serializable {
        @SerializedName("extra")
        public WalletSettingExtra extra;
        @SerializedName("hasPoint")
        public boolean hasRedPoint;
        public String linkUrl;
        public String note;
        @SerializedName("subSetting")
        public List<WalletSettingItem> subSetting;
        @SerializedName("subTitle")
        public String subtitle;
        @SerializedName("title")
        public String title;
        @SerializedName("type")
        public int type;
    }

    public static class WalletSettings implements Serializable {
        @SerializedName("settings")
        public List<WalletSettingItem> settings;
    }
}
