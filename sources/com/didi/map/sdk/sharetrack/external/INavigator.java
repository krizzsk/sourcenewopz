package com.didi.map.sdk.sharetrack.external;

import android.app.Activity;
import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.sharetrack.callback.IBusinessEventCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.StreetViewInfo;
import com.didi.map.sdk.sharetrack.external.view.INavSkin;
import com.didichuxing.routesearchsdk.CallFrom;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;

public abstract class INavigator {

    @Deprecated
    public interface OnNavStatusChangedListener {
        void onNavStatusChanged(int i, boolean z);
    }

    public abstract void changeNightMode(boolean z);

    public abstract void destroy();

    public abstract void followMyLocation(boolean z);

    public abstract Marker getCarMarker();

    public int getCurrentNaviStatus() {
        return 0;
    }

    public abstract Map getDiDiMap();

    public abstract MultiLine getLine();

    public abstract RouteGuidanceGPSPoint getMatchedPoint();

    public abstract INavSkin getNavSkin();

    public abstract int getNearbyStatus();

    public abstract RouteGuidanceGPSPoint getOriginMatchPoint();

    public abstract int getParkingStatus();

    public abstract List<OrderPoint> getPassPoints();

    public abstract int getRemainMeters(int i);

    public abstract int getRemainMinutes(int i);

    public abstract int getRemainStraightDistance();

    public abstract StreetViewInfo getStreetViewInfo();

    public abstract void initWithVendor(Context context, MapVendor mapVendor, boolean z);

    @Deprecated
    public abstract boolean isArriveDest();

    public abstract boolean isLightNavSctxPaused();

    public abstract boolean isSctxStarted();

    public abstract void modifyRoutes(LatLng latLng, List<OrderPoint> list, long j);

    public abstract void onLocationChanged(GpsLocation gpsLocation, List<GpsLocation> list);

    public abstract void onNewMargin(int i, int i2, int i3, int i4);

    public abstract void pause4Navigation();

    public abstract void pauseRequestOra();

    public abstract void playOpenningVoice();

    public abstract void resumeAfterNavigation();

    public abstract void resumeRequestOra();

    public void setActivity(Activity activity) {
    }

    public abstract void setAudioGuidanceEnabled(boolean z);

    @Deprecated
    public void setAutoArriveThreshold(int i, int i2) {
    }

    public abstract void setBusinessEventCallback(IBusinessEventCallback iBusinessEventCallback);

    public void setCaller(CallFrom callFrom) {
    }

    public abstract void setCameraMode(CameraMode cameraMode);

    public abstract void setCarHeadMaxMapLevel(double d);

    public abstract void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor);

    public abstract void setCarMarkerEnabled(boolean z);

    public abstract void setCarMarkerZindex(float f);

    public abstract void setDestination(LatLng latLng);

    public abstract void setDiDiMap(Map map);

    public abstract void setGuideRouteLineOpt(LineOptions lineOptions);

    public abstract void setIsPassNavi(boolean z);

    public abstract void setLineOptions(LineOptions lineOptions, LineOptions lineOptions2);

    public abstract void setMainRouteBubbleVisible(boolean z);

    public abstract void setMultiSctxGroup(String str);

    public abstract void setNavEndName(String str);

    public abstract void setNaviCallback(INavigationCallback iNavigationCallback);

    @Deprecated
    public void setOnNavStatusChangedListener(OnNavStatusChangedListener onNavStatusChangedListener) {
    }

    public abstract void setOrderInfo(OrderInfo orderInfo);

    public abstract void setOrderPoints(List<OrderPoint> list);

    public abstract void setOrderPointsTimeStamp(long j);

    public abstract void setOutSideRoute(List<LatLng> list, int i, int i2, long j, GpsLocation gpsLocation);

    @Deprecated
    public void setPlaceId(String str) {
    }

    public abstract void setRetryCount(int i);

    public abstract void setRouteLineVisible(boolean z);

    public abstract void setSearchOffRouteCallback(ISearchOffRouteCallback iSearchOffRouteCallback);

    public abstract void setSearchRouteCallbck(ISearchRouteCallback iSearchRouteCallback);

    @Deprecated
    public void setShouldAvoidHighway(boolean z) {
    }

    @Deprecated
    public void setSimulatorEnabled(boolean z) {
    }

    public abstract void start();

    public abstract void startNav();

    public abstract void stop();

    public abstract void zoomToLeftRoute(List<IMapElement> list, int i, int i2, int i3, int i4, int i5);

    public abstract void zoomToNav();
}
