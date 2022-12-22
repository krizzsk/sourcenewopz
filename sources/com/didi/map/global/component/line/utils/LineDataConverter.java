package com.didi.map.global.component.line.utils;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import java.util.ArrayList;
import java.util.List;

public class LineDataConverter {
    public static List<LatLng> getLatLngListFromDiffGeoPoints(DiffGeoPoints diffGeoPoints) {
        ArrayList arrayList = new ArrayList();
        if (!(diffGeoPoints == null || diffGeoPoints.base == null)) {
            double floatValue = (double) diffGeoPoints.base.lat.floatValue();
            double floatValue2 = (double) diffGeoPoints.base.lng.floatValue();
            arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
            if (diffGeoPoints.dlats.size() == diffGeoPoints.dlngs.size()) {
                for (int i = 0; i < diffGeoPoints.dlats.size(); i++) {
                    floatValue += ((double) diffGeoPoints.dlats.get(i).intValue()) / 100.0d;
                    floatValue2 += ((double) diffGeoPoints.dlngs.get(i).intValue()) / 100.0d;
                    arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
                }
            }
        }
        return arrayList;
    }

    public static List<LatLng> getLatLngListFromDiffGeoPoints(List<DoublePoint> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (DoublePoint next : list) {
            if (next != null) {
                arrayList.add(new LatLng((double) next.lat.floatValue(), (double) next.lng.floatValue()));
            }
        }
        return arrayList;
    }

    public static DoublePoint latConvertToDoublePoint(LatLng latLng) {
        if (!LatLngUtils.locateCorrect(latLng)) {
            return null;
        }
        return new DoublePoint.Builder().lat(Float.valueOf((float) latLng.latitude)).lng(Float.valueOf((float) latLng.longitude)).dlat(Double.valueOf(latLng.latitude)).dlng(Double.valueOf(latLng.longitude)).timestamp(Long.valueOf(System.currentTimeMillis() / 1000)).gpsTimestamp(Long.valueOf(System.currentTimeMillis() / 1000)).build();
    }
}
