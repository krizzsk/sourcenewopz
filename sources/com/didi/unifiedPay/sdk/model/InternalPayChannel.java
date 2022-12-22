package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InternalPayChannel implements Serializable {
    public static final int NOT_USEABLE = 3;
    public static final int RESTRICT_USEBLE = 1;
    public static final int SELECTED = 1;
    public static final int UNSELECTED = 0;
    public static final int USEABLE = 0;
    @SerializedName("balance")
    public long balance;
    @SerializedName("canCancel")
    public int canCancel;
    @SerializedName("canSelect")
    public int canSelect;
    @SerializedName("channel_id")
    public int channel_id;
    @SerializedName("cost")
    public long cost;
    @SerializedName("deduction")
    public String deduction;
    @SerializedName("extention")
    public String extention;
    @SerializedName("hidden")
    public int hidden;
    @SerializedName("icon")
    public String icon;
    @SerializedName("info")
    public String info;
    @SerializedName("level")
    public int level;
    @SerializedName("name")
    public String name;
    @SerializedName("need_passwd")
    public int needPasswd;
    @SerializedName("selected")
    public int selected;
    @SerializedName("type")
    public int type;
    @SerializedName("url")
    public String url;
}
