package com.didi.travel.psnger.model.response;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class StationBoardHintModel implements BffGsonStruct {
    @SerializedName("bg_color")
    public String mBgColor;
    @SerializedName("icon")
    public String mIcon;
    @SerializedName("show_arrow")
    public int mShowArrow;
    @SerializedName("station_icon")
    public String mStationIcon;
    @SerializedName("text")
    public String mText;
}
