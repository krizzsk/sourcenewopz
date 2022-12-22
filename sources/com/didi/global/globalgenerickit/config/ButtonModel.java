package com.didi.global.globalgenerickit.config;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class ButtonModel implements BffGsonStruct {
    @SerializedName("action_id")
    public String actionId;
    public String button_type;

    /* renamed from: id */
    public String f22052id;
    public String link;
    public int nodismiss;
    public String text;
}
