package com.didi.map.utils;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.google.util.ConvertUtil;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/map/utils/MatchPointDisHandler;", "", "()V", "nextLength", "", "segmentInfoList", "", "Lcom/didi/map/utils/SegmentInfo;", "checkIsSamePoint", "", "p1", "Lcom/didi/common/map/model/LatLng;", "p2", "distanceToTail", "point", "Lcom/map/sdk/nav/libc/common/RouteGuidanceGPSPoint;", "pointToRouteTail", "setRoutePoints", "", "points", "", "routeWayIndex", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: MatchPointDisHandler.kt */
public final class MatchPointDisHandler {

    /* renamed from: a */
    private int f29028a;

    /* renamed from: b */
    private final List<SegmentInfo> f29029b = new ArrayList();

    public final void setRoutePoints(List<LatLng> list) {
        Intrinsics.checkParameterIsNotNull(list, "points");
        this.f29029b.clear();
        if (list.size() > 1) {
            int size = list.size();
            for (int i = 1; i < size; i++) {
                int i2 = i - 1;
                LatLng latLng = list.get(i2);
                LatLng latLng2 = list.get(i);
                this.f29029b.add(new SegmentInfo(i2, latLng, latLng2, (int) DDSphericalUtil.computeDistanceBetween(latLng, latLng2)));
            }
        }
        this.f29028a = 0;
    }

    public final void setRoutePoints(List<LatLng> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "points");
        if (list.size() > 1) {
            int size = list.size();
            if (i >= 0 && size > i) {
                setRoutePoints(list.subList(0, i));
                this.f29028a = (int) DDSphericalUtil.computeLength(list.subList(i, list.size()));
                return;
            }
        }
        setRoutePoints(list);
    }

    public final int distanceToTail(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        if ((routeGuidanceGPSPoint != null ? routeGuidanceGPSPoint.point : null) == null) {
            return -1;
        }
        int a = m20433a(routeGuidanceGPSPoint);
        return a < 0 ? a : a + this.f29028a;
    }

    /* renamed from: a */
    private final int m20433a(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        LatLng convertFromGeoPoint;
        SegmentInfo segmentInfo;
        LatLng point_e;
        int i = -1;
        if (!(routeGuidanceGPSPoint.segmentIndex < 0 || routeGuidanceGPSPoint.segmentIndex + 1 >= this.f29029b.size() + 1 || (convertFromGeoPoint = ConvertUtil.convertFromGeoPoint(routeGuidanceGPSPoint.point)) == null || (segmentInfo = (SegmentInfo) CollectionsKt.getOrNull(this.f29029b, routeGuidanceGPSPoint.segmentIndex)) == null || (point_e = segmentInfo.getPoint_e()) == null)) {
            i = 0;
            if (!LatLngUtils.isSameLatLng(convertFromGeoPoint, point_e)) {
                i = 0 + ((int) DDSphericalUtil.computeDistanceBetween(convertFromGeoPoint, point_e));
            }
            int size = this.f29029b.size();
            int i2 = routeGuidanceGPSPoint.segmentIndex + 1;
            if (i2 >= 0 && size > i2) {
                int size2 = this.f29029b.size();
                for (int i3 = routeGuidanceGPSPoint.segmentIndex + 1; i3 < size2; i3++) {
                    i += this.f29029b.get(i3).getSegDis();
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private final boolean m20434a(LatLng latLng, LatLng latLng2) {
        return Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-6d && Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-6d;
    }
}
