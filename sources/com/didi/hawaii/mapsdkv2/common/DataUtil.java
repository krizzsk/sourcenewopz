package com.didi.hawaii.mapsdkv2.common;

import android.graphics.Rect;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import java.util.List;

public final class DataUtil {
    private DataUtil() {
    }

    public static LatLng[] latLng2array(List<LatLng> list) {
        if (list == null) {
            return new LatLng[0];
        }
        int size = list.size();
        LatLng[] latLngArr = new LatLng[size];
        for (int i = 0; i < size; i++) {
            latLngArr[i] = list.get(i);
        }
        return latLngArr;
    }

    public static String intArray2String(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        while (i < iArr.length && iArr[i] != 0) {
            iArr2[i] = iArr[i];
            i++;
        }
        return new String(iArr2, 0, i);
    }

    public static String shortArray2String(short[] sArr) {
        char[] cArr = new char[sArr.length];
        int i = 0;
        while (i < sArr.length && ((char) sArr[i]) != 0) {
            cArr[i] = (char) sArr[i];
            i++;
        }
        return new String(cArr, 0, i);
    }

    public static GeoPoint toGeoPoint(LatLng latLng) {
        return new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }

    public static LatLng toLatLng(GeoPoint geoPoint) {
        return new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
    }

    public static Rect toRect(LatLngBounds latLngBounds) {
        return new Rect((int) (latLngBounds.northeast.longitude * 1000000.0d), (int) (latLngBounds.northeast.latitude * 1000000.0d), (int) (latLngBounds.southwest.longitude * 1000000.0d), (int) (latLngBounds.southwest.latitude * 1000000.0d));
    }
}
