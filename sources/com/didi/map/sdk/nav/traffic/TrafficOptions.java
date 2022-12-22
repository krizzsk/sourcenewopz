package com.didi.map.sdk.nav.traffic;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class TrafficOptions {
    public static final int DRAW_LINE_TYPE_COLOR = 1;
    public static final int DRAW_LINE_TYPE_TEXTURE = 2;
    public boolean clickable;
    public int drawLineType = 1;
    public int lineColor;
    public int lineMinorColor;
    public int lineMinorTextureIndex = -1;
    public int lineTextureIndex = -1;
    public int lineWidth;
    public List<LatLng> points;
    public List<TrafficData> trafficDatas;
    public boolean useNewCompLine = false;

    public boolean available() {
        List<LatLng> list = this.points;
        return list != null && list.size() > 1;
    }
}
