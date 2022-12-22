package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UniversalPayChannelResponse implements Serializable {
    public static final int CANCEL_DISABLE = 0;
    public static final int CANCEL_ENABLE = 1;
    public static final int LEVEL_NOT_USEABLE = 3;
    public static final int LEVEL_RESTRICT_USEBLE = 1;
    public static final int LEVEL_USEABLE = 0;
    public static final int SELECTED = 1;
    public static final int UNSELECTED = 0;
    @SerializedName("balance")
    public long balance;
    @SerializedName("canCancel")
    public int canCancel;
    @SerializedName("canSelect")
    public int canSelect;
    @SerializedName("channel_id")
    public int channel_id;
    @SerializedName("channel_number")
    public String channel_number;
    @SerializedName("cost")
    public long cost;
    @SerializedName("deduction")
    public String deduction;
    @SerializedName("deposit_msg")
    public String deposit_msg;
    @SerializedName("deposit_status")
    public int deposit_status;
    @SerializedName("extention")
    public String extension;
    @SerializedName("flags")
    public String[] flags;
    @SerializedName("hidden")
    public int hidden;
    @SerializedName("icon")
    public String icon;
    @SerializedName("info")
    public String info;
    @SerializedName("level")
    public int level;
    @SerializedName("marketing_text")
    public String marketing_text;
    @SerializedName("name")
    public String name;
    @SerializedName("need_passwd")
    public int needPasswd;
    @SerializedName("need_sign")
    public int needSign;
    @SerializedName("selected")
    public int selected;
    @SerializedName("selected_sub_id")
    public String selected_sub_id;
    @SerializedName("sign_obj")
    public SignObj signObj;
    @SerializedName("sub_channels")
    public SubChannel[] sub_channels;
    @SerializedName("url")
    public String url;

    public static class DepositStatus implements Serializable {
        public static final int DEFAULT = 0;
        public static final int SIGNED_AND_BALANCE_INSUFFICIENT = 2;
        public static final int SIGNED_AND_BALANCE_SUFFICIENT = 1;
        public static final int UNSIGNED_AND_BALANCE_INSUFFICIENT = 3;
    }

    public static int getSelectedPayChannelIndex(UniversalPayChannelResponse[] universalPayChannelResponseArr) {
        for (int i = 0; i < universalPayChannelResponseArr.length; i++) {
            UniversalPayChannelResponse universalPayChannelResponse = universalPayChannelResponseArr[i];
            if (universalPayChannelResponse != null && universalPayChannelResponse.selected == 1) {
                return i;
            }
        }
        return -1;
    }
}
