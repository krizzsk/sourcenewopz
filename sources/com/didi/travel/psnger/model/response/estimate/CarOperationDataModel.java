package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarOperationDataModel implements BffGsonStruct {
    @SerializedName("seat_list")
    public List<AnycarCarpoolSeat> anycarCarpoolSeatList;
    @SerializedName("link")
    public String link;
    @SerializedName("options")
    public List<CarChoiceModel> operationChoices;
    @SerializedName("content")
    public String operationContent;
    @SerializedName("icon")
    public String operationIcon;
    @SerializedName("intro")
    public GlobalRichInfo operationText;
    @SerializedName("introV2")
    public LEGORichInfo operationTextV2;
    @SerializedName("title")
    public String operationTitle;

    public static class AnycarCarpoolSeat implements BffGsonStruct {
        public int count;
        public String icon;
        @SerializedName("select_value_params")
        public JsonObject selectValueParams;
        public int selected;
    }
}
