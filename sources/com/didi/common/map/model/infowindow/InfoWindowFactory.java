package com.didi.common.map.model.infowindow;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.Marker;

public class InfoWindowFactory {
    public static InfoWindow getInfowindow(Map map, Context context, Marker marker) {
        if (map == null || context == null || marker == null) {
            return null;
        }
        if (map.getMapVendor() == MapVendor.DIDI) {
            return new InfoWindowV2(map, context, marker);
        }
        return new InfoWindowV1(map, context, marker);
    }
}
