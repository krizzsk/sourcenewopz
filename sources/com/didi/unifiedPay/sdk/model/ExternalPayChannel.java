package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ExternalPayChannel implements Serializable {
    public static final int CANCEL_DISABLE = 0;
    public static final int CANCEL_ENABLE = 1;
    public static final int LEVEL_NOT_USEABLE = 3;
    public static final int LEVEL_RESTRICT_USEBLE = 1;
    public static final int LEVEL_USEABLE = 0;
    public static final int SELECTED = 1;
    public static final int UNSELECTED = 0;
    @SerializedName("amount_notice")
    public String amount_notice;
    public int canCancel;
    @SerializedName("canSelect")
    public int canSelect;
    @SerializedName("channel_id")
    public int channel_id;
    @SerializedName("channel_number")
    public String channel_number;
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
    @SerializedName("is_new_channel")
    public boolean is_new_channel;
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
    @SerializedName("need_guide_page")
    public boolean need_guide_page;
    @SerializedName("new_channel_tip")
    public String new_channel_tip;
    @SerializedName("payment_select_name")
    public String payment_select_name;
    @SerializedName("selected")
    public int selected;
    @SerializedName("selected_sub_id")
    public String selected_sub_id;
    @SerializedName("sign_obj")
    public SignObj signObj;
    @SerializedName("sub_channels")
    public SubChannel[] sub_channels;
    @SerializedName("type")
    public int type;
    @SerializedName("url")
    public String url;
}
