package com.didi.component.comp_travel_detail_new.view.widget;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.StationModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TravelDetailNewModel implements BffGsonStruct {
    public Normal normal;

    public static class Data implements BffGsonStruct {
        @SerializedName("address_data")
        public List<StationModel> addressData;
    }

    public static class Normal implements BffGsonStruct {
        public Data data;
    }
}
