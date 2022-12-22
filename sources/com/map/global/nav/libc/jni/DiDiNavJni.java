package com.map.global.nav.libc.jni;

import com.map.global.nav.libc.common.DMKEventPoint;
import com.map.global.nav.libc.common.DMKGPSPoint;
import com.map.global.nav.libc.common.DMKMapMatchABConfig;
import com.map.global.nav.libc.common.DMKMapMatchConfig;
import com.map.global.nav.libc.common.DMKMapPoint;
import com.map.global.nav.libc.common.DMKMatchResult;
import com.map.global.nav.libc.common.DMKMockConfig;
import java.util.ArrayList;
import java.util.List;

public class DiDiNavJni {
    public native void clear(long j);

    public native synchronized long create();

    public native void destroy(long j);

    public native int distanceLeft(long j, DMKGPSPoint dMKGPSPoint);

    public native int distanceLeft2(long j);

    public native void findClosetPointToRoute(long j, DMKGPSPoint dMKGPSPoint, DMKGPSPoint dMKGPSPoint2, boolean z);

    public native void getEventPointList(long j, ArrayList arrayList);

    public native long getEventPointSize(long j);

    public native boolean isOutWay(long j);

    public native void matchEvent(long j, DMKGPSPoint dMKGPSPoint, DMKGPSPoint dMKGPSPoint2, DMKEventPoint dMKEventPoint);

    public native void matchResult(long j, DMKGPSPoint dMKGPSPoint, DMKMatchResult dMKMatchResult);

    public native synchronized void setMapMatchEngineType(long j, int i);

    public native void setMapMatchJumpPointConfig(long j, DMKMapMatchABConfig dMKMapMatchABConfig);

    public native synchronized void setMatchConfig(long j, DMKMapMatchConfig dMKMapMatchConfig);

    public native void setMockConfig(long j, DMKMockConfig dMKMockConfig);

    public native synchronized void setRoutePoints(long j, List<DMKMapPoint> list);

    static {
        try {
            System.loadLibrary("MapGlobalNavBase");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
