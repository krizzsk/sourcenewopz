package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CarDatepickInfo implements BffGsonStruct {
    @SerializedName("begin_time_second")
    public long beginTime;
    @SerializedName("confirm_text")
    public JsonObject confirmTitle;
    @SerializedName("detail_title")
    public JsonObject detailTitle;
    @SerializedName("end_time_second")
    public long endTime;
    @SerializedName("selected_date_icon")
    public String icon;
    @SerializedName("interval_second")
    public int interval;
    @SerializedName("service_begin_second")
    public int serviceBegin;
    @SerializedName("service_end_second")
    public int serviceEnd;
    @SerializedName("selected_date_title")
    public GlobalRichInfo title;

    public GlobalRichInfo getdetailTitle() {
        if (this.detailTitle != null) {
            return (GlobalRichInfo) new Gson().fromJson(this.detailTitle.toString(), GlobalRichInfo.class);
        }
        return null;
    }

    public GlobalRichInfo getconfirmTitle() {
        if (this.confirmTitle != null) {
            return (GlobalRichInfo) new Gson().fromJson(this.confirmTitle.toString(), GlobalRichInfo.class);
        }
        return null;
    }
}
