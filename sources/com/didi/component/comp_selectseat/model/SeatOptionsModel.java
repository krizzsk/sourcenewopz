package com.didi.component.comp_selectseat.model;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SeatOptionsModel {

    /* renamed from: a */
    private boolean f12404a;
    @SerializedName("hybrid_icon_and_text_list")
    public List<HybridIconAndTextListModel> hybridIconAndTextList;
    @SerializedName("extension")
    public Extension mExtension;
    @SerializedName("select_value_params")
    public JsonObject paramsModel;
    @SerializedName("price_list")
    public List<PriceValue> priceList;
    @SerializedName("seat_num")
    public int seatNum;
    @SerializedName("text")
    public LEGORichInfo text;

    public static class Extension {
        @SerializedName("log_data")
        public JsonObject mLogData;
    }

    public static class PriceValue implements BffGsonStruct {
        @SerializedName("line_spacing")
        public int length;
        @SerializedName("value")
        public LEGORichInfo valueText;
    }

    public boolean ismItemIsSelected() {
        return this.f12404a;
    }

    public void setmItemIsSelected(boolean z) {
        this.f12404a = z;
    }
}
