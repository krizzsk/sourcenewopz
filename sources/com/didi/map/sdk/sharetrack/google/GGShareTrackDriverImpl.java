package com.didi.map.sdk.sharetrack.google;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.sharetrack.callback.IBusinessEventCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationInnerCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.StreetViewInfo;
import com.didi.map.sdk.sharetrack.external.INavDelegate;
import com.didi.map.sdk.sharetrack.external.view.INavSkin;
import com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver;
import com.didi.map.sdk.sharetrack.google.inner.omega.ShareTrackOmegaManager;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.routesearchsdk.CallFrom;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;

public class GGShareTrackDriverImpl extends INavDelegate {
    private static final String TAG = "GGShareTrackDriverImpl";
    private Context mContext;
    private Map mDiDiMap;
    private ShareTrackOmegaManager mShareTrackOmegaManager;
    private GoogleSctxDriver sctxRouteDriver;

    public void changeNightMode(boolean z) {
    }

    public INavSkin getNavSkin() {
        return null;
    }

    public boolean isArriveDest() {
        return false;
    }

    public void playOpenningVoice() {
    }

    public void setMainRouteBubbleVisible(boolean z) {
    }

    public void setNavEndName(String str) {
    }

    public GGShareTrackDriverImpl(Context context) {
        this.sctxRouteDriver = new GoogleSctxDriver(context);
        this.mContext = context;
    }

    public void setDiDiMap(Map map) {
        this.mDiDiMap = map;
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setDiDiMap(map);
        }
    }

    public Map getDiDiMap() {
        return this.mDiDiMap;
    }

    public int getRemainMinutes(int i) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver == null) {
            return 0;
        }
        return googleSctxDriver.getRemainTime(i);
    }

    public int getRemainMeters(int i) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver == null) {
            return 0;
        }
        return googleSctxDriver.getRemainDistance(i);
    }

    public void zoomToLeftRoute(List<IMapElement> list, int i, int i2, int i3, int i4, int i5) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.zoomToLeftRoute(list, i, i2, i3, i4, i5);
        }
    }

    public List<OrderPoint> getPassPoints() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver == null) {
            return null;
        }
        return googleSctxDriver.getPassPoints();
    }

    public void setIsPassNavi(boolean z) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setIsPassNavi(z);
        }
    }

    public void setRouteLineVisible(boolean z) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setRouteLineVisible(z);
        }
    }

    public void setLineOptions(LineOptions lineOptions, LineOptions lineOptions2) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setLineOptions(lineOptions, lineOptions2);
        }
    }

    public void setGuideRouteLineOpt(LineOptions lineOptions) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setGuideRouteLineOpt(lineOptions);
        }
    }

    public MultiLine getLine() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.getLine();
        }
        return null;
    }

    public void setCameraMode(CameraMode cameraMode) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setCameraMode(cameraMode);
        }
    }

    public void followMyLocation(boolean z) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.followMyLocation(z);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.onNewMargin(i, i2, i3, i4);
        }
    }

    public void zoomToNav() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.zoomToNav();
        }
    }

    public void pauseRequestOra() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.pauseRequestOra();
        }
    }

    public void resumeRequestOra() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.resumeRequestOra();
        }
    }

    public boolean isLightNavSctxPaused() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.isLightNavSctxPaused();
        }
        return false;
    }

    public void setOutSideRoute(List<LatLng> list, int i, int i2, long j, GpsLocation gpsLocation) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setOutSideRoute(list, i, i2, j, gpsLocation);
        }
    }

    public void setOrderPointsTimeStamp(long j) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setOrderPointsTimeStamp(j);
        }
    }

    public void setMultiSctxGroup(String str) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setMultiSctxGroup(str);
        }
    }

    public void setCarHeadMaxMapLevel(double d) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setCarHeadMaxMapLevel(d);
        }
    }

    public int getRemainStraightDistance() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.getRemainStraightDistance();
        }
        return 0;
    }

    public void modifyRoutes(LatLng latLng, List<OrderPoint> list, long j) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null && latLng != null) {
            googleSctxDriver.setDestination(latLng);
            this.sctxRouteDriver.setOrderPoints(list);
            this.sctxRouteDriver.setOrderPointsTimeStamp(j);
            if (list == null || list.isEmpty()) {
                this.sctxRouteDriver.setIsPassNavi(false);
            } else {
                this.sctxRouteDriver.setIsPassNavi(true);
            }
            this.sctxRouteDriver.stopNav();
            this.sctxRouteDriver.start();
        }
    }

    public void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setCarMarkerBitmap(bitmapDescriptor);
        }
    }

    public void setSearchRouteCallbck(ISearchRouteCallback iSearchRouteCallback) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setSearchRouteCallbck(iSearchRouteCallback);
        }
    }

    public void setSearchOffRouteCallback(ISearchOffRouteCallback iSearchOffRouteCallback) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setSearchOffRouteCallback(iSearchOffRouteCallback);
        }
    }

    public void setNavDelegateCallback(INavigationInnerCallback iNavigationInnerCallback) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setNaviCallback(iNavigationInnerCallback);
        }
    }

    public void setBusinessEventCallback(IBusinessEventCallback iBusinessEventCallback) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setBusinessEventCallback(iBusinessEventCallback);
        }
    }

    public void setDestination(LatLng latLng) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setDestination(latLng);
        }
    }

    public boolean isSctxStarted() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        return googleSctxDriver != null && googleSctxDriver.isSctxStarted();
    }

    public void start() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.start();
            if (shouldLoopCarInfo()) {
                startLoopCarInfo();
            }
        }
    }

    public void startNav() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setIsSctx(false);
            this.sctxRouteDriver.start();
        }
    }

    public void stop() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.stop();
        }
    }

    public void pause4Navigation() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.pause4Navigation();
        }
    }

    public void resumeAfterNavigation() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.resumeAfterNavigation();
        }
    }

    public void setRetryCount(int i) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setRetryCount(i);
        }
    }

    public void destroy() {
        ShareTrackOmegaManager shareTrackOmegaManager = this.mShareTrackOmegaManager;
        if (shareTrackOmegaManager != null) {
            shareTrackOmegaManager.destroy();
            this.mShareTrackOmegaManager = null;
        }
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.destroy();
            this.sctxRouteDriver = null;
        }
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setOrderInfo(orderInfo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setOrderInfo:");
        sb.append(orderInfo == null ? "null" : orderInfo.toString());
        DLog.m20357d(TAG, sb.toString(), new Object[0]);
    }

    public Marker getCarMarker() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.getCarMarker();
        }
        return null;
    }

    public void setCarMarkerZindex(float f) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setCarMarkerZindex(f);
        }
    }

    public void setCarMarkerEnabled(boolean z) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setCarMarkerEnabled(z);
        }
    }

    public void onLocationChanged(GpsLocation gpsLocation, List<GpsLocation> list) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.onLocationChanged(gpsLocation, list);
        }
    }

    public void setOrderPoints(List<OrderPoint> list) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setOrderPoints(list);
        }
    }

    private boolean shouldLoopCarInfo() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver == null || googleSctxDriver.getOrderInfo() == null || this.sctxRouteDriver.getOrderInfo().getOrderStage() != 1) {
            return false;
        }
        return true;
    }

    private void startLoopCarInfo() {
        if (this.mShareTrackOmegaManager == null) {
            this.mShareTrackOmegaManager = new ShareTrackOmegaManager(this.sctxRouteDriver);
        }
        this.mShareTrackOmegaManager.startLoopCarInfo();
    }

    public RouteGuidanceGPSPoint getOriginMatchPoint() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.getOriginMatchPoint();
        }
        return null;
    }

    public RouteGuidanceGPSPoint getMatchedPoint() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.getMatchedPoint();
        }
        return null;
    }

    public StreetViewInfo getStreetViewInfo() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.getStreetViewInfo();
        }
        return null;
    }

    public LatLng getRouteEndPoint() {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            return googleSctxDriver.getRouteEndPoint();
        }
        return null;
    }

    public void setArriveStatus(int i) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setArriveStatus(i);
        }
    }

    public void setCaller(CallFrom callFrom) {
        GoogleSctxDriver googleSctxDriver = this.sctxRouteDriver;
        if (googleSctxDriver != null) {
            googleSctxDriver.setCaller(callFrom);
        }
    }
}
