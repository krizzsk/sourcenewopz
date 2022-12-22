package com.didi.map.intl.commonwalkengine.impl.navbase;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.map.global.nav.libc.common.Convertor;
import com.map.global.nav.libc.common.DMKGPSPoint;
import com.map.global.nav.libc.common.DMKMapMatchConfig;
import com.map.global.nav.libc.common.DMKMapPoint;
import com.map.global.nav.libc.common.DMKMatchResult;
import com.map.global.nav.libc.common.GeoPoint;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import com.map.global.nav.libc.jni.DiDiNavJni;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u0019\u001a\u00020\f2\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH\u0016J\u001f\u0010\u001d\u001a\u00020\f2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010!R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/map/intl/commonwalkengine/impl/navbase/NavBaseJniWrapper;", "Lcom/didi/map/intl/commonwalkengine/impl/navbase/INavBaseJniInterface;", "()V", "mCurGps", "Lcom/map/global/nav/libc/common/DMKGPSPoint;", "mHandle", "", "mJni", "Lcom/map/global/nav/libc/jni/DiDiNavJni;", "mNextRouteLength", "", "clear", "", "destroy", "distanceLeft", "gpsPoint", "Lcom/map/global/nav/libc/common/RouteGuidanceGPSPoint;", "distanceLeft2", "isOutWay", "", "matchResult", "Lcom/map/global/nav/libc/common/DMKMatchResult;", "setMatchConfig", "config", "Lcom/map/global/nav/libc/common/DMKMapMatchConfig;", "setNextRoutePoints", "nextRoutePoints", "", "Lcom/didi/common/map/model/LatLng;", "setRoutePoints", "inputGpsPoint", "", "Lcom/map/global/nav/libc/common/GeoPoint;", "([Lcom/map/global/nav/libc/common/GeoPoint;)V", "Companion", "commonWalkEngine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NavBaseJniWrapper.kt */
public final class NavBaseJniWrapper implements INavBaseJniInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "NavBaseEngineWrapper";

    /* renamed from: a */
    private DiDiNavJni f27836a;

    /* renamed from: b */
    private long f27837b;

    /* renamed from: c */
    private int f27838c;

    /* renamed from: d */
    private DMKGPSPoint f27839d;

    public int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        return -1;
    }

    public int distanceLeft2() {
        return -1;
    }

    public NavBaseJniWrapper() {
        long j;
        DiDiNavJni diDiNavJni = new DiDiNavJni();
        this.f27836a = diDiNavJni;
        if (diDiNavJni == null) {
            j = 0;
        } else {
            j = diDiNavJni.create();
        }
        this.f27837b = j;
        DMKMapMatchConfig dMKMapMatchConfig = new DMKMapMatchConfig();
        dMKMapMatchConfig.filterAccuracy = 1000.0f;
        dMKMapMatchConfig.m_Min_offsetRadius = 30;
        dMKMapMatchConfig.m_Max_offsetRadius = 100;
        dMKMapMatchConfig.yaw_Min_offsetRadius = 30;
        dMKMapMatchConfig.yaw_Max_offsetRadius = 100;
        dMKMapMatchConfig.m_valid_angleDiff = 30.0f;
        dMKMapMatchConfig.yaw_valid_angleDiff = 30.0f;
        dMKMapMatchConfig.yaw_direct_speed = 1.0f;
        dMKMapMatchConfig.yaw_outWay_credit = 1.0f;
        dMKMapMatchConfig.yaw_accuracy_offset = 10;
        dMKMapMatchConfig.corner_yaw_strategy = 2;
        dMKMapMatchConfig.corner_yaw_distance_ratio = 0.45f;
        m19920a(dMKMapMatchConfig);
        DiDiNavJni diDiNavJni2 = this.f27836a;
        if (diDiNavJni2 != null) {
            diDiNavJni2.setMapMatchEngineType(this.f27837b, 1);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/map/intl/commonwalkengine/impl/navbase/NavBaseJniWrapper$Companion;", "", "()V", "TAG", "", "commonWalkEngine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NavBaseJniWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final void m19920a(DMKMapMatchConfig dMKMapMatchConfig) {
        DiDiNavJni diDiNavJni;
        long j = this.f27837b;
        if (j != 0 && (diDiNavJni = this.f27836a) != null && diDiNavJni != null) {
            diDiNavJni.setMatchConfig(j, dMKMapMatchConfig);
        }
    }

    public void setRoutePoints(GeoPoint[] geoPointArr) {
        List<DMKMapPoint> convertFromGeoPoints;
        DiDiNavJni diDiNavJni;
        if (this.f27837b != 0 && this.f27836a != null && (convertFromGeoPoints = Convertor.convertFromGeoPoints(geoPointArr)) != null && !convertFromGeoPoints.isEmpty() && (diDiNavJni = this.f27836a) != null) {
            diDiNavJni.setRoutePoints(this.f27837b, convertFromGeoPoints);
        }
    }

    public void setNextRoutePoints(List<LatLng> list) {
        this.f27838c = (list == null || !(list.isEmpty() ^ true)) ? 0 : (int) DDSphericalUtil.computeLength(list);
    }

    public boolean isOutWay() {
        DiDiNavJni diDiNavJni;
        boolean z;
        long j = this.f27837b;
        if (j == 0 || (diDiNavJni = this.f27836a) == null) {
            return false;
        }
        if (diDiNavJni == null) {
            z = false;
        } else {
            z = diDiNavJni.isOutWay(j);
        }
        DLog.m7384d(TAG, Intrinsics.stringPlus("isOutWay: ", Boolean.valueOf(z)), new Object[0]);
        return z;
    }

    public RouteGuidanceGPSPoint matchResult(RouteGuidanceGPSPoint routeGuidanceGPSPoint, DMKMatchResult dMKMatchResult) {
        DMKMapPoint dMKMapPoint;
        Float f;
        if (this.f27837b == 0 || this.f27836a == null || routeGuidanceGPSPoint == null) {
            return routeGuidanceGPSPoint;
        }
        DMKGPSPoint convert2DMKGPSPoint = Convertor.convert2DMKGPSPoint(routeGuidanceGPSPoint);
        this.f27839d = convert2DMKGPSPoint;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = null;
        if (convert2DMKGPSPoint != null) {
            if (convert2DMKGPSPoint == null) {
                dMKMapPoint = null;
            } else {
                dMKMapPoint = convert2DMKGPSPoint.mapPoint;
            }
            if (dMKMapPoint != null) {
                Object[] objArr = new Object[1];
                if (dMKMatchResult == null) {
                    f = null;
                } else {
                    f = Float.valueOf(dMKMatchResult.resGpsFrequency);
                }
                objArr[0] = f;
                DLog.m7384d(TAG, "[before match] resGpsFrequency:%.2f", objArr);
                DiDiNavJni diDiNavJni = this.f27836a;
                if (diDiNavJni != null) {
                    diDiNavJni.matchResult(this.f27837b, this.f27839d, dMKMatchResult);
                }
                DLog.m7384d(TAG, Intrinsics.stringPlus("[matchResult][start] gps  = ", routeGuidanceGPSPoint), new Object[0]);
                if (!(dMKMatchResult == null || (routeGuidanceGPSPoint2 = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint)) == null)) {
                    routeGuidanceGPSPoint2.originMatchPoint = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resOriginMatchPoint);
                }
                DLog.m7384d(TAG, Intrinsics.stringPlus("[matchResult] ios and Hawaii Matched: ", routeGuidanceGPSPoint2), new Object[0]);
                DLog.m7384d(TAG, Intrinsics.stringPlus("[matchResult][end] gps = ", routeGuidanceGPSPoint), new Object[0]);
            }
        }
        return routeGuidanceGPSPoint2;
    }

    public void clear() {
        DiDiNavJni diDiNavJni;
        long j = this.f27837b;
        if (j != 0 && (diDiNavJni = this.f27836a) != null && diDiNavJni != null) {
            diDiNavJni.clear(j);
        }
    }

    public void destroy() {
        DiDiNavJni diDiNavJni;
        long j = this.f27837b;
        if (j != 0 && (diDiNavJni = this.f27836a) != null) {
            if (diDiNavJni != null) {
                diDiNavJni.destroy(j);
            }
            this.f27836a = null;
            this.f27837b = 0;
            this.f27839d = null;
        }
    }
}
