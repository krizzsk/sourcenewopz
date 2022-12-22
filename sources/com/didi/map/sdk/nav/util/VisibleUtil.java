package com.didi.map.sdk.nav.util;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import com.didi.common.map.Map;
import com.didi.common.map.Projection;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.map.sdk.nav.libc.common.CommonUtils;
import java.util.List;

public class VisibleUtil {

    /* renamed from: PI */
    public static final float f28545PI = 3.1415927f;

    /* renamed from: a */
    private static final String f28546a = "VisibleUtil";

    public static boolean IsInVisiableRect(List<LatLng> list, Context context, Map map, MapMargins mapMargins) {
        PointF screenLocation;
        if (map == null || context == null || mapMargins == null || list == null) {
            return false;
        }
        if (list != null && list.size() > 0) {
            Rect visiableRect = getVisiableRect(context, map, mapMargins);
            Projection projection = map.getProjection();
            for (LatLng next : list) {
                if ((next instanceof LatLng) && ((screenLocation = projection.toScreenLocation(next)) == null || screenLocation.x <= ((float) visiableRect.left) || screenLocation.x >= ((float) visiableRect.right) || screenLocation.y <= ((float) visiableRect.top) || screenLocation.y >= ((float) visiableRect.bottom))) {
                    DLog.m7384d(f28546a, "IsInVisiableRect :false", new Object[0]);
                    return false;
                }
            }
        }
        DLog.m7384d(f28546a, "IsCarInVisiableRect :true", new Object[0]);
        return true;
    }

    public static Rect getVisiableRect(Context context, Map map, MapMargins mapMargins) {
        if (map == null) {
            return new Rect(0, 0, 0, 0);
        }
        MapMargins mapPadding = getMapPadding(context);
        return new Rect(mapPadding.left + mapMargins.left, mapPadding.top + mapMargins.top, (((map.getWidth() - mapPadding.right) - mapPadding.left) - mapMargins.left) - mapMargins.right, (((map.getHeight() - mapPadding.top) - mapPadding.bottom) - mapMargins.top) - mapMargins.bottom);
    }

    public static MapMargins getMapPadding(Context context) {
        int dp2pixel = CommonUtils.dp2pixel(10);
        int dp2pixel2 = CommonUtils.dp2pixel(20);
        return new MapMargins(dp2pixel, CommonUtils.dp2pixel(10), CommonUtils.dp2pixel(10), dp2pixel2);
    }

    public static double getBestZoomByMetersPerPonit(double d, double d2) {
        return log2((Math.cos((d * 3.1415927410125732d) / 180.0d) * 156543.03392d) / d2);
    }

    public static double log2(double d) {
        return Math.log10(d) / Math.log10(2.0d);
    }
}
