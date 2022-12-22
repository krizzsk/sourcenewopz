package com.didi.hawaii.mapsdkv2;

import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.map.base.PolygonPoint;
import com.didi.map.outer.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class PolygonUtilsV2 {
    public static List<List<LatLng>> polygonClipp(List<LatLng> list, List<LatLng> list2, int i) {
        if (list == null || list2 == null || list.size() == 0 || list2.size() == 0) {
            return null;
        }
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = list.get(i2).latitude;
            dArr2[i2] = list.get(i2).longitude;
        }
        int size2 = list2.size();
        double[] dArr3 = new double[size2];
        double[] dArr4 = new double[size2];
        for (int i3 = 0; i3 < size2; i3++) {
            dArr3[i3] = list2.get(i3).latitude;
            dArr4[i3] = list2.get(i3).longitude;
        }
        PolygonPoint[] polygonPointArr = (PolygonPoint[]) MapEngineJNI.PolygonClipp(i, dArr, dArr2, size, dArr3, dArr4, size2, i);
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        for (PolygonPoint polygonPoint : polygonPointArr) {
            LatLng latLng = new LatLng(polygonPoint.f24576y, polygonPoint.f24575x);
            int i5 = polygonPoint.index;
            if (i4 != i5) {
                arrayList.add(new ArrayList());
                i4 = i5;
            }
            if (arrayList.size() > i4 && i4 != -1) {
                ((List) arrayList.get(i4)).add(latLng);
            }
        }
        return arrayList;
    }

    public static List<LatLng> generateCirclePoints(LatLng latLng, float f) {
        double[] dArr = new double[128];
        double[] dArr2 = new double[128];
        int GenerateCirclePoint = MapEngineJNI.GenerateCirclePoint(latLng.latitude, latLng.longitude, f * 10.0f, 128, dArr2, dArr, 128);
        ArrayList arrayList = new ArrayList();
        if (GenerateCirclePoint < 0) {
            return arrayList;
        }
        for (int i = 0; i < 128; i++) {
            arrayList.add(new LatLng(dArr2[i], dArr[i]));
        }
        return arrayList;
    }
}
