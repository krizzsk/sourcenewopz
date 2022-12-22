package com.didi.map.global.sctx;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.Collection;

public class SXUtils {

    /* renamed from: a */
    private static final String f27622a = "SXUtils";

    public static int getLastOrderEda(String str, MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        try {
            if (!TextUtils.isEmpty(str) && !CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes.odPoints)) {
                OdPoint odPoint = null;
                for (OdPoint next : mapPassengeOrderRouteRes.odPoints) {
                    if (next.pointType.intValue() == 2 && next.odType.intValue() == 1) {
                        odPoint = next;
                    }
                }
                if (mapPassengeOrderRouteRes.driverPoint == null || !LatLngUtils.locateCorrect((double) mapPassengeOrderRouteRes.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes.driverPoint.lng.floatValue()) || odPoint == null || odPoint.point == null || !LatLngUtils.locateCorrect((double) odPoint.point.lat.floatValue(), (double) odPoint.point.lng.floatValue())) {
                    return -1;
                }
                return (int) DDSphericalUtil.computeDistanceBetween(new LatLng((double) mapPassengeOrderRouteRes.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes.driverPoint.lng.floatValue()), new LatLng((double) odPoint.point.lat.floatValue(), (double) odPoint.point.lng.floatValue()));
            }
        } catch (Exception e) {
            DLog.m7384d(f27622a, "Last Order Eda error", new Object[0]);
            e.printStackTrace();
        }
        return -1;
    }
}
