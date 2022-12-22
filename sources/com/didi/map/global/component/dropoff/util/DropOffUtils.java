package com.didi.map.global.component.dropoff.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.dropoff.DropOffComConstants;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.taxis99.R;

public class DropOffUtils {
    public static void LOGD(String str) {
        DLog.m7384d(DropOffComConstants.DROP_OFF_COM, str, new Object[0]);
    }

    public static LatLng getMapCenterPoint(Map map) {
        if (map == null || map.getCameraPosition() == null) {
            return null;
        }
        return map.getCameraPosition().target;
    }

    public static RecPointStyle getRecPointStyle(Context context, RecPointStyle recPointStyle) {
        RecPointStyle recPointStyle2 = new RecPointStyle();
        if (recPointStyle == null) {
            recPointStyle2.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_input_icon_destination);
            recPointStyle2.selectedIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_input_icon_destination);
            return recPointStyle2;
        }
        if (recPointStyle.icon == null) {
            int i = recPointStyle.defaultStyle;
            recPointStyle.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_input_icon_destination);
            recPointStyle.selectedIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.map_input_icon_destination);
        }
        if (recPointStyle.selectedIcon != null) {
            return recPointStyle;
        }
        recPointStyle.selectedIcon = recPointStyle.icon;
        return recPointStyle;
    }
}
