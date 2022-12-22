package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.model.response.StationModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class StartEndCardModel implements BffGsonStruct {
    @SerializedName("bubble_text")
    public LEGORichInfo bubbleText;
    public Map<String, Object> extraLogData;
    @SerializedName("address_data")
    public List<StationModel> stationList;
    public LEGORichInfo title;
    public JsonObject xmlData;
}
