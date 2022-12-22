package com.didi.common.map.util;

import android.graphics.PointF;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.PolygonOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PolygonUtil {
    public static boolean contains(List<PointF> list, PointF pointF) {
        if (CollectionUtil.isEmpty((Collection<?>) list) || pointF == null) {
            return false;
        }
        return contains((PointF[]) list.toArray(new PointF[list.size()]), pointF);
    }

    public static boolean contains(PointF[] pointFArr, PointF pointF) {
        int length = pointFArr.length - 1;
        boolean z = false;
        for (int i = 0; i < pointFArr.length; i++) {
            if ((pointFArr[i].y > pointF.y) != (pointFArr[length].y > pointF.y) && pointF.x < (((pointFArr[length].x - pointFArr[i].x) * (pointF.y - pointFArr[i].y)) / (pointFArr[length].y - pointFArr[i].y)) + pointFArr[i].x) {
                z = !z;
            }
            length = i;
        }
        return z;
    }

    public static boolean contains(Map map, PolygonOptions polygonOptions, LatLng latLng) {
        if (polygonOptions == null) {
            return false;
        }
        return contains(map, polygonOptions.getPoints(), latLng);
    }

    public static boolean contains(Map map, List<LatLng> list, LatLng latLng) {
        if (CollectionUtil.isEmpty((Collection<?>) list) || latLng == null || map == null || map.getProjection() == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng next : list) {
            if (next != null) {
                arrayList.add(map.getProjection().toScreenLocation(next));
            }
        }
        return contains((List<PointF>) arrayList, map.getProjection().toScreenLocation(latLng));
    }
}
