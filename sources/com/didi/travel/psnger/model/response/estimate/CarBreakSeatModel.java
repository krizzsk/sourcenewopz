package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarBreakSeatModel implements BffGsonStruct {
    @SerializedName("options")
    public List<CarSeatChoiceModel> seatBreakChoice;
    @SerializedName("content")
    public String seatBreakContent;
    @SerializedName("title")
    public String seatBreakTitle;
}
