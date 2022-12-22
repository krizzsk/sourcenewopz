package com.didi.travel.psnger.model.response;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MapLineInfo implements BffGsonStruct {
    public static final int LINE_DROPOFF_END = 3;
    public static final int LINE_PICKUP_DROPOFF = 2;
    public static final int LINE_START_PICKUP = 1;
    public Point endPoints;
    public String lineColor;
    public int lineMode;
    @SerializedName("line_style")
    public int lineStyle;
    public int lineWidth;
    public Point startPoints;
    public List<Point> wayPoints;

    public static class Point implements BffGsonStruct {
        public double lat;
        public double lng;
    }
}
