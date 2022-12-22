package com.didi.map.sdk.nav.util;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.map.sdk.nav.traffic.TrafficData;
import java.util.Collection;
import java.util.List;

public class MapLineSegmentorUtil {

    /* renamed from: a */
    static final String f28541a = "MapLineSegmentorUtil";

    /* renamed from: b */
    static final int f28542b = 100;

    /* renamed from: c */
    static final int f28543c = 6;

    /* renamed from: d */
    static final int f28544d = 30;

    public static void insertPoints(List<LatLng> list, List<LatLng> list2, List<TrafficData> list3, List<TrafficData> list4) {
        TrafficData trafficData;
        int i;
        List<LatLng> list5 = list;
        List<LatLng> list6 = list2;
        List<TrafficData> list7 = list3;
        List<TrafficData> list8 = list4;
        if (!CollectionUtil.isEmpty((Collection<?>) list) && list6 != null) {
            list2.clear();
            if (CollectionUtil.isEmpty((Collection<?>) list3) || list8 == null) {
                insertPoints(list, list2);
                return;
            }
            list4.clear();
            if (list3.size() == 1) {
                insertPoints(list, list2);
                TrafficData trafficData2 = new TrafficData();
                trafficData2.color = list7.get(0).color;
                trafficData2.minorColor = list7.get(0).minorColor;
                trafficData2.fromIndex = 0;
                trafficData2.toIndex = list2.size() - 1;
                list8.add(trafficData2);
                return;
            }
            int size = list.size() - 1;
            double a = m20185a(list);
            list6.add(list5.get(0));
            int i2 = 0;
            TrafficData trafficData3 = null;
            TrafficData trafficData4 = null;
            LatLng latLng = null;
            int i3 = 0;
            while (i2 < size) {
                LatLng latLng2 = list5.get(i2);
                int i4 = i2 + 1;
                LatLng latLng3 = list5.get(i4);
                if (trafficData4 == null || i2 >= trafficData4.toIndex) {
                    if (trafficData3 != null) {
                        list6.add(latLng2);
                        i = 1;
                        trafficData3.toIndex = list2.size() - 1;
                        list8.add(trafficData3);
                        trafficData3 = null;
                    } else {
                        i = 1;
                    }
                    trafficData = m20187a(list7, i3, i2);
                    if (trafficData != null) {
                        TrafficData trafficData5 = new TrafficData();
                        trafficData5.fromIndex = list2.size() - i;
                        if (trafficData5.fromIndex < 0) {
                            trafficData5.fromIndex = 0;
                        }
                        trafficData5.color = trafficData.color;
                        trafficData5.minorColor = trafficData.minorColor;
                        trafficData3 = trafficData5;
                    }
                    i3++;
                    latLng = latLng2;
                } else {
                    trafficData = trafficData4;
                    if (latLng == null) {
                        latLng = latLng2;
                    }
                }
                latLng = m20186a(list6, latLng, latLng3, a);
                trafficData4 = trafficData;
                i2 = i4;
            }
            list6.add(list5.get(size));
            if (trafficData3 != null) {
                trafficData3.toIndex = list2.size() - 1;
                list8.add(trafficData3);
            }
        }
    }

    public static void insertPoints(List<LatLng> list, List<LatLng> list2) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && list2 != null) {
            list2.clear();
            double a = m20185a(list);
            int size = list.size() - 1;
            LatLng latLng = null;
            int i = 0;
            list2.add(list.get(0));
            while (i < size) {
                if (latLng == null) {
                    latLng = list.get(i);
                }
                i++;
                latLng = m20186a(list2, latLng, list.get(i), a);
            }
            list2.add(list.get(size));
        }
    }

    /* renamed from: a */
    private static LatLng m20186a(List<LatLng> list, LatLng latLng, LatLng latLng2, double d) {
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
        if (computeDistanceBetween < d) {
            return latLng;
        }
        LatLng interpolate = DDSphericalUtil.interpolate(latLng, latLng2, d / computeDistanceBetween);
        if (interpolate == latLng) {
            list.add(latLng2);
            return null;
        }
        list.add(interpolate);
        return m20186a(list, interpolate, latLng2, d);
    }

    public static void insertPoints(List<LatLng> list, List<LatLng> list2, int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && list2 != null) {
            list2.clear();
        }
    }

    /* renamed from: a */
    private static TrafficData m20187a(List<TrafficData> list, int i, int i2) {
        int size = list.size();
        while (i < size) {
            TrafficData trafficData = list.get(i);
            if (i2 >= trafficData.fromIndex && i2 <= trafficData.toIndex) {
                return trafficData;
            }
            i++;
        }
        return null;
    }

    /* renamed from: a */
    private static double m20185a(List<LatLng> list) {
        int size = list.size() - 1;
        double d = 0.0d;
        int i = 0;
        while (i < size) {
            i++;
            d += DDSphericalUtil.computeDistanceBetween(list.get(i), list.get(i));
        }
        return Math.min(Math.max(d / ((double) Math.max(size + 1, 100)), 6.0d), 30.0d);
    }
}
