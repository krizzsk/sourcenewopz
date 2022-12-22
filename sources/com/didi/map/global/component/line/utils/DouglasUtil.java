package com.didi.map.global.component.line.utils;

import android.graphics.PointF;
import com.didi.common.map.Projection;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DouglasUtil {

    /* renamed from: a */
    private int f25956a = 5;

    /* renamed from: b */
    private Projection f25957b;

    /* renamed from: c */
    private List<LatLng> f25958c;

    /* renamed from: d */
    private List<PointF> f25959d;

    public DouglasUtil(Projection projection) {
        this.f25957b = projection;
    }

    public void setThreshold(int i) {
        this.f25956a = i;
    }

    public void setRoutePoints(List<LatLng> list) {
        this.f25958c = list;
    }

    public List<PointF> getPointFsAfter() {
        return this.f25959d;
    }

    public List<PointF> getDouglasOptimiseResult() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f25958c)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng screenLocation : this.f25958c) {
            PointF screenLocation2 = this.f25957b.toScreenLocation(screenLocation);
            if (screenLocation2 != null) {
                arrayList.add(screenLocation2);
            }
        }
        List<PointF> a = m18448a(arrayList);
        this.f25959d = a;
        return a;
    }

    public List<LatLng> getDouglasOptimisePoints() {
        List<PointF> douglasOptimiseResult = getDouglasOptimiseResult();
        if (CollectionUtil.isEmpty((Collection<?>) douglasOptimiseResult)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PointF fromScreenLocation : douglasOptimiseResult) {
            arrayList.add(this.f25957b.fromScreenLocation(fromScreenLocation));
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<PointF> m18448a(List<PointF> list) {
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
            double a = m18446a(list.get(i2), list.get(0), list.get(i));
            if (a > d) {
                i3 = i2;
                d = a;
            }
            i2++;
        }
        ArrayList arrayList = new ArrayList();
        if (d > ((double) this.f25956a)) {
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
            List<PointF> a2 = m18448a(arrayList2);
            List<PointF> a3 = m18448a(arrayList3);
            a3.remove(0);
            a2.addAll(a3);
            return a2;
        }
        arrayList.add(list.get(0));
        arrayList.add(list.get(i));
        return arrayList;
    }

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
            double a = m18447a(list.get(i2), list.get(0), list.get(i));
            if (a > d) {
                i3 = i2;
                d = a;
            }
            i2++;
        }
        ArrayList arrayList = new ArrayList();
        if (d > ((double) this.f25956a)) {
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
    private static double m18447a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
        return (m18445a(computeDistanceBetween, DDSphericalUtil.computeDistanceBetween(latLng, latLng3), DDSphericalUtil.computeDistanceBetween(latLng2, latLng3)) * 2.0d) / computeDistanceBetween;
    }

    /* renamed from: a */
    private static double m18446a(PointF pointF, PointF pointF2, PointF pointF3) {
        double distance = distance(pointF2, pointF3);
        return (m18445a(distance(pointF, pointF2), distance(pointF, pointF3), distance) * 2.0d) / distance;
    }

    public static double distance(PointF pointF, PointF pointF2) {
        double d = (double) pointF.y;
        double d2 = ((double) pointF.x) - ((double) pointF2.x);
        double d3 = d - ((double) pointF2.y);
        return Math.sqrt((d2 * d2) + (d3 * d3));
    }

    /* renamed from: a */
    private static double m18445a(double d, double d2, double d3) {
        double d4 = ((d + d2) + d3) / 2.0d;
        return Math.sqrt((d4 - d) * d4 * (d4 - d2) * (d4 - d3));
    }
}
