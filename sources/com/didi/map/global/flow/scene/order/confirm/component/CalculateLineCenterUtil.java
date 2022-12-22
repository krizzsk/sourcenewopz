package com.didi.map.global.flow.scene.order.confirm.component;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.sdk.nav.jni.JniCreator;
import com.map.sdk.nav.libc.common.Convertor;
import com.map.sdk.nav.libc.common.DMKMatchResult;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import com.map.sdk.nav.libc.jni.JniWrapperInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J)\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000e2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/CalculateLineCenterUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mNavJniWrapper", "Lcom/map/sdk/nav/libc/jni/JniWrapperInterface;", "checkPointIsInRoute", "", "point", "Lcom/didi/common/map/model/LatLng;", "convertGeoPoint", "Lcom/map/sdk/nav/libc/common/GeoPoint;", "points", "", "", "(Ljava/util/List;)[Lcom/map/sdk/nav/libc/common/GeoPoint;", "startCalculate", "line1Data", "line2Data", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CalculateLineCenterUtil.kt */
public final class CalculateLineCenterUtil {

    /* renamed from: a */
    private final JniWrapperInterface f26581a = JniCreator.get();

    public CalculateLineCenterUtil(Context context) {
    }

    public final List<LatLng> startCalculate(List<LatLng> list, List<LatLng> list2) {
        Collection collection = list;
        boolean z = false;
        if (!(collection == null || collection.isEmpty())) {
            Collection collection2 = list2;
            if (collection2 == null || collection2.isEmpty()) {
                z = true;
            }
            if (!z) {
                List<LatLng> arrayList = new ArrayList<>();
                JniWrapperInterface jniWrapperInterface = this.f26581a;
                if (jniWrapperInterface != null) {
                    jniWrapperInterface.setRoutePoints(m18825a(list));
                    for (LatLng next : list2) {
                        if (!m18824a(next)) {
                            arrayList.add(next);
                        }
                    }
                }
                return arrayList;
            }
        }
        return new ArrayList<>();
    }

    /* renamed from: a */
    private final boolean m18824a(LatLng latLng) {
        DMKMatchResult dMKMatchResult = new DMKMatchResult();
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.point = m18826b(latLng);
        JniWrapperInterface jniWrapperInterface = this.f26581a;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.matchResult(routeGuidanceGPSPoint, dMKMatchResult);
        }
        CalculateLineCenterUtil calculateLineCenterUtil = this;
        return Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint).segmentIndex > 0 && LatLngUtils.isSameLatLng(latLng, Convertor.convert2LatLngFromGeoPoint(Convertor.convertToGeoPoints(dMKMatchResult.resMatchPoint.mapPoint)));
    }

    /* renamed from: b */
    private final GeoPoint m18826b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
        geoPoint.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        return geoPoint;
    }

    /* renamed from: a */
    private final GeoPoint[] m18825a(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        GeoPoint[] geoPointArr = new GeoPoint[size];
        int i = 0;
        if (size > 0) {
            while (true) {
                int i2 = i + 1;
                geoPointArr[i] = m18826b(list.get(i));
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return geoPointArr;
    }
}
