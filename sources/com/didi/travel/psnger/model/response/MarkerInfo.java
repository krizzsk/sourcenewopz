package com.didi.travel.psnger.model.response;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class MarkerInfo implements BffGsonStruct {
    public static final int MARKER_DROP_OFF = 3;
    public static final int MARKER_END = 4;
    public static final int MARKER_PICK_UP = 2;
    public static final int MARKER_START = 1;
    public String lat;
    public String lng;
    @SerializedName("marker_type")
    public int markerType;
}
