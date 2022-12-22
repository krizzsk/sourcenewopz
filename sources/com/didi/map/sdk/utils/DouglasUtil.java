package com.didi.map.sdk.utils;

import android.graphics.PointF;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import java.util.ArrayList;
import java.util.List;

public class DouglasUtil {

    /* renamed from: a */
    private int f28919a = 5;

    public List<LatLng> getDouglasOptimiseLatLngs(List<LatLng> list) {
        int i;
        int size = list.size();
        int i2 = 1;
        double d = 0.0d;
        int i3 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            double a = m20364a(list.get(i2), list.get(0), list.get(i));
            if (a > d) {
                i3 = i2;
                d = a;
            }
            i2++;
        }
        ArrayList arrayList = new ArrayList();
        if (d > ((double) this.f28919a)) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < size; i4++) {
                if (i4 <= i3) {
                    arrayList2.add(list.get(i4));
                    if (i4 == i3) {
                        arrayList3.add(list.get(i4));
                    }
                } else {
                    arrayList3.add(list.get(i4));
                }
            }
            List<LatLng> douglasOptimiseLatLngs = getDouglasOptimiseLatLngs(arrayList2);
            List<LatLng> douglasOptimiseLatLngs2 = getDouglasOptimiseLatLngs(arrayList3);
            douglasOptimiseLatLngs2.remove(0);
            douglasOptimiseLatLngs.addAll(douglasOptimiseLatLngs2);
            return douglasOptimiseLatLngs;
        }
        arrayList.add(list.get(0));
        arrayList.add(list.get(i));
        return arrayList;
    }

    /* renamed from: a */
    private static double m20364a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
        return (m20363a(computeDistanceBetween, DDSphericalUtil.computeDistanceBetween(latLng, latLng3), DDSphericalUtil.computeDistanceBetween(latLng2, latLng3)) * 2.0d) / computeDistanceBetween;
    }

    public static double distance(PointF pointF, PointF pointF2) {
        double d = (double) pointF.y;
        double d2 = ((double) pointF.x) - ((double) pointF2.x);
        double d3 = d - ((double) pointF2.y);
        return Math.sqrt((d2 * d2) + (d3 * d3));
    }

    /* renamed from: a */
    private static double m20363a(double d, double d2, double d3) {
        double d4 = ((d + d2) + d3) / 2.0d;
        return Math.sqrt((d4 - d) * d4 * (d4 - d2) * (d4 - d3));
    }
}
