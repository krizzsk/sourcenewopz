package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarSeatChoiceModel implements BffGsonStruct {
    @SerializedName("text")
    public GlobalRichInfo choiceText;
    @SerializedName("extra_text")
    public GlobalRichInfo extraText;
    @SerializedName("intro")
    public Intro intro;
    @SerializedName("is_unavailable")
    public boolean isUnavailable = false;
    @SerializedName("select_value_params")
    public JsonObject selectValueObject;
    @SerializedName("value_list")
    public List<PriceValue> valueList;
    @SerializedName("value")
    public GlobalRichInfo valueText;

    public static class Intro implements BffGsonStruct {
        @SerializedName("color_end")
        public String colorEnd;
        @SerializedName("color_start")
        public String colorStart;
        @SerializedName("rich_text")
        public GlobalRichInfo richText;
    }

    public static class PriceValue implements BffGsonStruct {
        @SerializedName("line_spacing")
        public int length;
        @SerializedName("value")
        public GlobalRichInfo valueText;
    }

    public SelectedValueParams getselectValue() {
        if (this.selectValueObject != null) {
            return (SelectedValueParams) new Gson().fromJson(this.selectValueObject.toString(), SelectedValueParams.class);
        }
        return null;
    }
}
