package com.didi.travel.psnger.model.response.newbubbleParams;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BubbleLocation {
    @SerializedName("bubbles")
    public List<BubbleItemModel> bubbles;
    @SerializedName("loc")
    public int location;
}
