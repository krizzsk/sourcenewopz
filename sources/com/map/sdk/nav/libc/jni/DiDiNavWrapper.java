package com.map.sdk.nav.libc.jni;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_ng_handle;
import com.map.sdk.nav.hawaii.ApolloUtils;
import com.map.sdk.nav.hawaii.HawaiiMatchResult;
import com.map.sdk.nav.hawaii.HawaiiMatcher;
import com.map.sdk.nav.libc.common.ApolloUtil;
import com.map.sdk.nav.libc.common.Convertor;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.DMKGPSPoint;
import com.map.sdk.nav.libc.common.DMKMapMatchConfig;
import com.map.sdk.nav.libc.common.DMKMapPoint;
import com.map.sdk.nav.libc.common.DMKMatchResult;
import com.map.sdk.nav.libc.common.DMKMockConfig;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.MapMatchType;
import com.map.sdk.nav.libc.common.MercatorUtil;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import com.map.sdk.nav.trace.NavBaseTrace;
import java.util.ArrayList;
import java.util.List;

public class DiDiNavWrapper implements JniWrapperInterface {
    public static String TAG = "DiDiNavWrapper";
    private HawaiiMatchResult hawaiiMatchResult;
    private DMKGPSPoint mCurGps;
    private boolean mCurrentRouteHasYaw = false;
    private String mCurrentRouteId = "ddNavWrapper";
    private LatLng mEndPoint;
    private LatLng mFirstPoint;
    private long mHandle;
    private boolean mHasSetRouteHawaii;
    private SWIGTYPE_p_ng_handle mHawaiiMatcher;
    private DiDiNavJni mJni;
    private MapMatchType mMapMatchType = MapMatchType.UNKNOWN;
    private RouteGuidanceGPSPoint mMatchResult;
    private int mNextRouteLength;
    private List<DMKMapPoint> mRoutePoints;

    public DiDiNavWrapper() {
        DiDiNavJni diDiNavJni = new DiDiNavJni();
        this.mJni = diDiNavJni;
        this.mHandle = diDiNavJni.create();
        if (isHawaiiApolloEnabled()) {
            this.mHawaiiMatcher = HawaiiMatcher.initHawaiiMatcher();
        }
        DMKMapMatchConfig dMKMapMatchConfig = new DMKMapMatchConfig();
        dMKMapMatchConfig.filterAccuracy = ApolloUtil.getFilterAccuracy();
        dMKMapMatchConfig.m_Min_offsetRadius = ApolloUtil.getMinSnapOffsetRadius();
        dMKMapMatchConfig.m_Max_offsetRadius = ApolloUtil.getMaxSnapOffsetRadius();
        dMKMapMatchConfig.yaw_Min_offsetRadius = ApolloUtil.getMinOffsetRadius();
        dMKMapMatchConfig.yaw_Max_offsetRadius = ApolloUtil.getMaxOffsetRadius();
        dMKMapMatchConfig.m_valid_angleDiff = ApolloUtil.getValidAngleDiff();
        dMKMapMatchConfig.yaw_valid_angleDiff = ApolloUtil.getYawValidAngleDiff();
        dMKMapMatchConfig.yaw_direct_speed = ApolloUtil.getYawDirectSpeed();
        dMKMapMatchConfig.yaw_outWay_credit = ApolloUtil.getYawOutWayCredit();
        dMKMapMatchConfig.yaw_accuracy_offset = ApolloUtil.getYawAccuracyOffset();
        dMKMapMatchConfig.corner_yaw_strategy = ApolloUtil.getCornerYawStrategy();
        dMKMapMatchConfig.corner_yaw_distance_ratio = ApolloUtil.getCornerYawDistanceRadio();
        setMatchConfig(dMKMapMatchConfig);
        setMapMatchJumpPointConfig();
        this.mJni.setMapMatchEngineType(this.mHandle, 1);
    }

    public void setRoutePoints(GeoPoint[] geoPointArr) {
        SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle;
        this.mCurrentRouteHasYaw = false;
        if (!isHawaiiApolloEnabled() || (sWIGTYPE_p_ng_handle = this.mHawaiiMatcher) == null || geoPointArr == null || geoPointArr.length <= 4) {
            this.mHasSetRouteHawaii = false;
        } else {
            HawaiiMatcher.setHawaiiRoutePoints(sWIGTYPE_p_ng_handle, geoPointArr);
            this.mHasSetRouteHawaii = true;
        }
        if (this.mHandle != 0 && this.mJni != null) {
            List<DMKMapPoint> convertFromGeoPoints = Convertor.convertFromGeoPoints(geoPointArr);
            this.mRoutePoints = convertFromGeoPoints;
            if (convertFromGeoPoints != null) {
                this.mEndPoint = MercatorUtil.mercator2LatLng(convertFromGeoPoints.get(convertFromGeoPoints.size() - 1));
                this.mJni.setRoutePoints(this.mHandle, this.mRoutePoints);
                return;
            }
            this.mEndPoint = null;
        }
    }

    public void setNextRoutePoints(List<LatLng> list) {
        if (list == null || list.size() <= 0) {
            this.mNextRouteLength = 0;
        } else {
            this.mNextRouteLength = (int) DDSphericalUtil.computeLength(list);
        }
    }

    private void setMatchConfig(DMKMapMatchConfig dMKMapMatchConfig) {
        DiDiNavJni diDiNavJni;
        long j = this.mHandle;
        if (j != 0 && (diDiNavJni = this.mJni) != null && dMKMapMatchConfig != null) {
            diDiNavJni.setMatchConfig(j, dMKMapMatchConfig);
        }
    }

    private void setMapMatchJumpPointConfig() {
        DiDiNavJni diDiNavJni;
        long j = this.mHandle;
        if (j != 0 && (diDiNavJni = this.mJni) != null) {
            diDiNavJni.setMapMatchJumpPointConfig(j, ApolloUtil.getDMKMapMatchABConfig());
        }
    }

    public boolean isOutWay() {
        DiDiNavJni diDiNavJni;
        if (!ApolloUtils.INSTANCE.isNeedUseHawaiiMatcher() || this.hawaiiMatchResult == null || !this.mHasSetRouteHawaii) {
            long j = this.mHandle;
            if (j == 0 || (diDiNavJni = this.mJni) == null) {
                return false;
            }
            boolean isOutWay = diDiNavJni.isOutWay(j);
            String str = TAG;
            DLog.m7384d(str, "isOutWay: " + isOutWay, new Object[0]);
            if (isOutWay && !this.mCurrentRouteHasYaw) {
                DMKGPSPoint dMKGPSPoint = this.mCurGps;
                NavBaseTrace.traceYawPointDistance(dMKGPSPoint, findClosetPointToRoute(dMKGPSPoint, false), 0, this.mCurrentRouteId);
                this.mCurrentRouteHasYaw = true;
            }
            return isOutWay;
        }
        String str2 = TAG;
        DLog.m7384d(str2, "hawaii isOutWay: " + this.hawaiiMatchResult.isYaw, new Object[0]);
        if (this.hawaiiMatchResult.isYaw && !this.mCurrentRouteHasYaw) {
            DMKGPSPoint dMKGPSPoint2 = this.mCurGps;
            NavBaseTrace.traceYawPointDistance(dMKGPSPoint2, findClosetPointToRoute(dMKGPSPoint2, false), 1, this.mCurrentRouteId);
            this.mCurrentRouteHasYaw = true;
        }
        return this.hawaiiMatchResult.isYaw;
    }

    public RouteGuidanceGPSPoint matchResult(RouteGuidanceGPSPoint routeGuidanceGPSPoint, DMKMatchResult dMKMatchResult) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint2;
        HawaiiMatchResult hawaiiMatchResult2;
        SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle;
        if (isHawaiiApolloEnabled() && (sWIGTYPE_p_ng_handle = this.mHawaiiMatcher) != null && this.mHasSetRouteHawaii) {
            this.hawaiiMatchResult = HawaiiMatcher.hawaiiMatch(sWIGTYPE_p_ng_handle, routeGuidanceGPSPoint);
        }
        if (this.mHandle == 0 || this.mJni == null || routeGuidanceGPSPoint == null) {
            this.mMatchResult = null;
            return routeGuidanceGPSPoint;
        }
        DMKGPSPoint convert2DMKGPSPoint = Convertor.convert2DMKGPSPoint(routeGuidanceGPSPoint);
        this.mCurGps = convert2DMKGPSPoint;
        if (convert2DMKGPSPoint == null || convert2DMKGPSPoint.mapPoint == null) {
            this.mMatchResult = null;
            return null;
        }
        if (this.mFirstPoint == null) {
            this.mFirstPoint = MercatorUtil.mercator2LatLng(this.mCurGps.mapPoint);
            String str = TAG;
            DLog.m7384d(str, "mFirstPoint:" + this.mFirstPoint.toString(), new Object[0]);
        }
        DLog.m7384d(TAG, "[before match] resGpsFrequency:%.2f", Float.valueOf(dMKMatchResult.resGpsFrequency));
        this.mJni.matchResult(this.mHandle, this.mCurGps, dMKMatchResult);
        DLog.m7384d(TAG, "[matchResult][start] gps  = ", routeGuidanceGPSPoint.toString());
        if (dMKMatchResult != null) {
            if (!isHawaiiApolloEnabled() || (hawaiiMatchResult2 = this.hawaiiMatchResult) == null || !this.mHasSetRouteHawaii) {
                routeGuidanceGPSPoint2 = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint);
                this.mMapMatchType = MapMatchType.NG_VP_MATCH;
            } else {
                routeGuidanceGPSPoint2 = hawaiiMatchResult2.routeGuidanceGPSPoint;
                dMKMatchResult.resMatchPoint = Convertor.convert2DMKGPSPoint(routeGuidanceGPSPoint2);
                dMKMatchResult.resOriginMatchPoint = Convertor.convert2DMKGPSPoint(routeGuidanceGPSPoint2);
                DLog.m7384d(TAG, "[matchResult] hawaiiMatchResult = ", routeGuidanceGPSPoint2.toString());
                RouteGuidanceGPSPoint convertFromDMKGPSPoint = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint);
                DLog.m7384d(TAG, "[matchResult] iOS MatchResult = ", convertFromDMKGPSPoint.toString());
                this.mMapMatchType = MapMatchType.HAWAII_MATCH;
            }
            DMKEventPoint dMKEventPoint = dMKMatchResult.resEventPoint;
            if (dMKEventPoint != null && dMKEventPoint.geoIndex >= 0 && dMKEventPoint.geoIndex < this.mRoutePoints.size()) {
                RouteGuidanceGPSPoint routeGuidanceGPSPoint3 = new RouteGuidanceGPSPoint();
                routeGuidanceGPSPoint3.shapeOffSet = 0;
                routeGuidanceGPSPoint3.segmentIndex = dMKEventPoint.geoIndex;
                routeGuidanceGPSPoint3.point = Convertor.convertToGeoPoints(this.mRoutePoints.get(dMKEventPoint.geoIndex));
            }
            if (routeGuidanceGPSPoint2 == null) {
                this.mMatchResult = null;
                return null;
            }
            routeGuidanceGPSPoint2.originMatchPoint = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resOriginMatchPoint);
            this.mMatchResult = routeGuidanceGPSPoint2;
            String str2 = TAG;
            DLog.m7384d(str2, "[matchResult] ios and Hawaii Matched:" + routeGuidanceGPSPoint2.toString(), new Object[0]);
            DLog.m7384d(TAG, "[matchResult][end] gps  = ", routeGuidanceGPSPoint.toString());
            return routeGuidanceGPSPoint2;
        }
        this.mMatchResult = null;
        return null;
    }

    public int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        DiDiNavJni diDiNavJni;
        long j = this.mHandle;
        if (j == 0 || (diDiNavJni = this.mJni) == null || routeGuidanceGPSPoint == null) {
            return -1;
        }
        return diDiNavJni.distanceLeft(j, Convertor.convert2DMKGPSPoint(routeGuidanceGPSPoint)) + this.mNextRouteLength;
    }

    public int distanceLeft2() {
        DiDiNavJni diDiNavJni;
        long j = this.mHandle;
        if (j == 0 || (diDiNavJni = this.mJni) == null) {
            return -1;
        }
        return diDiNavJni.distanceLeft2(j) + this.mNextRouteLength;
    }

    public void setMockConfig(DMKMockConfig dMKMockConfig) {
        DiDiNavJni diDiNavJni;
        long j = this.mHandle;
        if (j != 0 && (diDiNavJni = this.mJni) != null && dMKMockConfig != null) {
            diDiNavJni.setMockConfig(j, dMKMockConfig);
        }
    }

    public RouteGuidanceGPSPoint findClosetPointToRoute(DMKGPSPoint dMKGPSPoint, boolean z) {
        if (this.mHandle == 0 || this.mJni == null || dMKGPSPoint == null) {
            return null;
        }
        DMKGPSPoint dMKGPSPoint2 = new DMKGPSPoint();
        this.mJni.findClosetPointToRoute(this.mHandle, dMKGPSPoint, dMKGPSPoint2, z);
        return Convertor.convertFromDMKGPSPoint(dMKGPSPoint2);
    }

    public int getEventPointSize() {
        DiDiNavJni diDiNavJni;
        long j = this.mHandle;
        if (j == 0 || (diDiNavJni = this.mJni) == null) {
            return 0;
        }
        return (int) diDiNavJni.getEventPointSize(j);
    }

    public void getEventPointList(ArrayList<DMKEventPoint> arrayList) {
        if (this.mHandle != 0 && this.mJni != null && arrayList != null) {
            int eventPointSize = getEventPointSize();
            for (int i = 0; i < eventPointSize; i++) {
                arrayList.add(new DMKEventPoint());
            }
            this.mJni.getEventPointList(this.mHandle, arrayList);
        }
    }

    public void setRouteId(String str) {
        this.mCurrentRouteId = str;
    }

    public MapMatchType getMapMatchType() {
        String str = TAG;
        DLog.m7384d(str, "getMapMatchType : " + this.mMapMatchType, new Object[0]);
        return this.mMapMatchType;
    }

    public void clear() {
        DiDiNavJni diDiNavJni;
        long j = this.mHandle;
        if (j != 0 && (diDiNavJni = this.mJni) != null) {
            diDiNavJni.clear(j);
            this.mMatchResult = null;
        }
    }

    public void destroy() {
        DiDiNavJni diDiNavJni;
        SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle;
        if (isHawaiiApolloEnabled() && (sWIGTYPE_p_ng_handle = this.mHawaiiMatcher) != null) {
            HawaiiMatcher.destroyHawaiiMatcher(sWIGTYPE_p_ng_handle);
            this.mHawaiiMatcher = null;
        }
        long j = this.mHandle;
        if (j != 0 && (diDiNavJni = this.mJni) != null) {
            diDiNavJni.destroy(j);
            this.mJni = null;
            this.mHandle = 0;
            this.mMatchResult = null;
            this.mRoutePoints = null;
            this.mFirstPoint = null;
            this.mCurGps = null;
        }
    }

    private boolean isHawaiiApolloEnabled() {
        return ApolloUtils.INSTANCE.isNeedUseHawaiiMatcher() || ApolloUtils.INSTANCE.isPasNeedUseHawaiiMatcher();
    }
}
