package com.didi.component.comp_selectseat.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;

public class HybridIconAndTextListModel {
    @SerializedName("color_end")
    public String colorEnd;
    @SerializedName("color_start")
    public String colorStart;
    @SerializedName("icon")
    public String icon;
    @SerializedName("info")
    public LEGORichInfo info;
    @SerializedName("type")
    public int type;
}
