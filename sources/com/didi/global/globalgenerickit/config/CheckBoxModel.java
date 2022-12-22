package com.didi.global.globalgenerickit.config;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;

public class CheckBoxModel implements BffGsonStruct {
    @SerializedName("action_id")
    public String actionId;
    public int checked;
    public String link;
    public LEGORichInfo title;
}
