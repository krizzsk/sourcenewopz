package com.didi.component.comp_selectseat.model;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.MapModel;
import com.didi.travel.psnger.model.response.estimate.StartEndCardModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ShiftSelectData implements BffGsonStruct {
    @SerializedName("confirm_infos")
    public List<ConfirmInfo> confirmInfos;
    @SerializedName("shift_info")
    public FrequencySelectModel shiftInfo;
    @SerializedName("unique_id")
    public String uniqueId;

    public static class ConfirmInfo implements BffGsonStruct {
        @SerializedName("info")
        public Info info;
        @SerializedName("route_id")
        public String routeId;
    }

    public static class Info implements BffGsonStruct {
        @SerializedName("card_module")
        public StartEndCardModel cardModel;
        @SerializedName("map_module")
        public MapModel mapModel;
    }
}
