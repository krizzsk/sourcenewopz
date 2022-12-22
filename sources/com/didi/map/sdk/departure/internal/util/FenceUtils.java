package com.didi.map.sdk.departure.internal.util;

import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.MapUtils;
import com.didi.common.map.util.PolygonUtil;
import com.didi.map.sdk.fencecomponent.FencePolygon;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.FenceLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FenceUtils {

    /* renamed from: a */
    private static final float f28240a = 14.0f;

    /* renamed from: b */
    private static final float f28241b = 18.0f;

    public static boolean isInFenceCondition(FenceInfo fenceInfo) {
        return fenceInfo != null && !TextUtils.isEmpty(fenceInfo.fenceId);
    }

    public static float getBestLevelInFenceController(FenceInfo fenceInfo, Map map, LatLng latLng, Padding padding) {
        if (!isInFenceCondition(fenceInfo)) {
            return -1.0f;
        }
        if (padding == null) {
            padding = new Padding();
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (FenceLatLng next : fenceInfo.polygon) {
            builder.include(new LatLng(next.lat, next.lng));
        }
        LatLngBounds recalculateBounds = MapUtils.recalculateBounds(builder.build(), latLng);
        Map map2 = map;
        float calculateZoomToSpanLevel = map2.calculateZoomToSpanLevel(padding.left, padding.right, padding.top, padding.bottom, new LatLng(recalculateBounds.northeast.latitude, recalculateBounds.southwest.longitude), new LatLng(recalculateBounds.southwest.latitude, recalculateBounds.northeast.longitude));
        if (calculateZoomToSpanLevel > 0.0f && calculateZoomToSpanLevel < 14.0f) {
            return 14.0f;
        }
        if (calculateZoomToSpanLevel > 18.0f) {
            return 18.0f;
        }
        return calculateZoomToSpanLevel;
    }

    public static boolean positionIsInFence(Map map, FenceInfo fenceInfo, LatLng latLng) {
        if (!(map == null || fenceInfo == null || latLng == null || CollectionUtil.isEmpty((Collection<?>) fenceInfo.polygon) || map == null)) {
            ArrayList arrayList = new ArrayList(fenceInfo.polygon.size());
            for (FenceLatLng next : fenceInfo.polygon) {
                arrayList.add(new LatLng(next.lat, next.lng));
            }
            if (PolygonUtil.contains(map, (List<LatLng>) arrayList, latLng)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFenceMustAbsorb(FenceInfo fenceInfo) {
        return fenceInfo != null && fenceInfo.infenceAbsorb == 2 && !TextUtils.isEmpty(fenceInfo.fenceId);
    }

    public static FencePolygon convert2FencePolygon(List<FenceLatLng> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        FencePolygon fencePolygon = new FencePolygon();
        fencePolygon.polygon = new ArrayList();
        for (FenceLatLng next : list) {
            fencePolygon.polygon.add(new LatLng(next.lat, next.lng));
        }
        return fencePolygon;
    }
}
