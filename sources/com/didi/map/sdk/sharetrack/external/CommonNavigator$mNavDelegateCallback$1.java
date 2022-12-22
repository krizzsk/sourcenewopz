package com.didi.map.sdk.sharetrack.external;

import android.location.Location;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.sharetrack.callback.INavigationCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationInnerCallback;
import com.didi.map.sdk.sharetrack.common.ShareTrackApolloHelper;
import com.didi.map.sdk.sharetrack.entity.DiDiRouteSegment;
import com.didi.map.sdk.sharetrack.entity.DiDiTimeAndDistance;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.sdk.sharetrack.net.DataFetcherManager;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J2\u0010\u001e\u001a\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J:\u0010&\u001a\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J \u0010(\u001a\u00020\u00032\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010 2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016¨\u0006."}, mo175978d2 = {"com/didi/map/sdk/sharetrack/external/CommonNavigator$mNavDelegateCallback$1", "Lcom/didi/map/sdk/sharetrack/callback/INavigationInnerCallback;", "onApproaching", "", "eda", "", "onArriveDestination", "onCameraModeChanged", "mode", "Lcom/didi/map/sdk/nav/car/CameraMode;", "onDriveAway", "onNaviVoice", "voiceTts", "", "prefix", "onNavigationCodeUpdate", "code", "onOffRoute", "onReceiveETA", "eta", "onRemainingTimeOrDistanceChanged", "onResetView", "onRoadSnappedLocationChanged", "gpsLocation", "Lcom/didi/common/map/model/GpsLocation;", "onRouteUpdate", "newRoute", "Lcom/didi/map/sdk/sharetrack/entity/NaviRoute;", "isOffRoute", "", "onSctxSetRouteToLightNav_Google", "routeSegmentList", "", "Lcom/didi/map/sdk/sharetrack/entity/DiDiRouteSegment;", "timeAndDistanceList", "Lcom/didi/map/sdk/sharetrack/entity/DiDiTimeAndDistance;", "driverLoc", "Landroid/location/Location;", "onSctxUploadAllData_Google", "onStartNavSuccess", "onViaPointExpired", "latLngs", "Lcom/didi/common/map/model/LatLng;", "timestamp", "", "startLightNavSctx_Google", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonNavigator.kt */
public final class CommonNavigator$mNavDelegateCallback$1 implements INavigationInnerCallback {
    final /* synthetic */ CommonNavigator this$0;

    CommonNavigator$mNavDelegateCallback$1(CommonNavigator commonNavigator) {
        this.this$0 = commonNavigator;
    }

    public void onRouteUpdate(NaviRoute naviRoute, boolean z) {
        BaseRoundStrategy access$getMStrategy$p;
        if (!this.this$0.m20219d()) {
            INavDelegate access$getMNavDelegate$p = this.this$0.f28656b;
            if (access$getMNavDelegate$p != null) {
                access$getMNavDelegate$p.setRouteLineVisible(true);
            }
            DLog.m20357d(BaseRoundStrategy.TAG, "don't use round loop strategy, change line visible", new Object[0]);
        } else if (ShareTrackApolloHelper.INSTANCE.isV3Enable() == 0) {
            DLog.m20357d(BaseRoundStrategy.TAG, "don't use any strategy, apollo banned", new Object[0]);
            INavDelegate access$getMNavDelegate$p2 = this.this$0.f28656b;
            if (access$getMNavDelegate$p2 != null) {
                access$getMNavDelegate$p2.setRouteLineVisible(true);
            }
        } else {
            this.this$0.m20218c();
            if (naviRoute != null) {
                BaseRoundStrategy access$getMStrategy$p2 = this.this$0.f28659e;
                if (access$getMStrategy$p2 != null) {
                    access$getMStrategy$p2.updateRouteId(naviRoute.getRouteId());
                }
                BaseRoundStrategy access$getMStrategy$p3 = this.this$0.f28659e;
                if (access$getMStrategy$p3 != null) {
                    access$getMStrategy$p3.updateETA(naviRoute.getTime());
                }
                DataFetcherManager access$getMDataFetcherManager$p = this.this$0.f28661g;
                if (access$getMDataFetcherManager$p != null) {
                    access$getMDataFetcherManager$p.updateRouteId(naviRoute.getRouteId());
                }
                if (z && (access$getMStrategy$p = this.this$0.f28659e) != null) {
                    access$getMStrategy$p.tryTrackWhenRouteInvisible();
                }
                this.this$0.f28667m = naviRoute.getRouteId();
                this.this$0.f28668n = naviRoute.getTime();
            }
            if (!this.this$0.f28665k && !z) {
                this.this$0.m20216b();
            }
        }
    }

    public void onReceiveETA(int i) {
        this.this$0.f28668n = i;
        BaseRoundStrategy access$getMStrategy$p = this.this$0.f28659e;
        if (access$getMStrategy$p != null) {
            access$getMStrategy$p.updateETA(i);
        }
    }

    public void onDriveAway() {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onDriveAway();
        }
    }

    public void onResetView() {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onResetView();
        }
    }

    public void onSctxSetRouteToLightNav_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location) {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onSctxSetRouteToLightNav_Google(list, list2, location);
        }
    }

    public void onViaPointExpired(List<LatLng> list, long j) {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onViaPointExpired(list, j);
        }
    }

    public void onStartNavSuccess() {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onStartNavSuccess();
        }
    }

    public void onOffRoute() {
        BaseRoundStrategy access$getMStrategy$p;
        if (this.this$0.m20219d() && (access$getMStrategy$p = this.this$0.f28659e) != null) {
            access$getMStrategy$p.offRoute();
        }
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onOffRoute();
        }
    }

    public void onApproaching(int i) {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onApproaching(i);
        }
    }

    public void onNaviVoice(String str, int i) {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onNaviVoice(str, i);
        }
    }

    public void onRemainingTimeOrDistanceChanged() {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onRemainingTimeOrDistanceChanged();
        }
        if (this.this$0.m20219d()) {
            INavDelegate access$getMNavDelegate$p = this.this$0.f28656b;
            if (access$getMNavDelegate$p != null) {
                int remainMeters = access$getMNavDelegate$p.getRemainMeters(-1);
                this.this$0.f28664j = remainMeters;
                BaseRoundStrategy access$getMStrategy$p = this.this$0.f28659e;
                if (access$getMStrategy$p != null) {
                    access$getMStrategy$p.updateEDA(remainMeters);
                }
            }
            BaseRoundStrategy access$getMStrategy$p2 = this.this$0.f28659e;
            if (access$getMStrategy$p2 != null) {
                INavDelegate access$getMNavDelegate$p2 = this.this$0.f28656b;
                access$getMStrategy$p2.setEndPoint(access$getMNavDelegate$p2 != null ? access$getMNavDelegate$p2.getRouteEndPoint() : null);
            }
        }
    }

    public void onRoadSnappedLocationChanged(GpsLocation gpsLocation) {
        BaseRoundStrategy access$getMStrategy$p;
        if (this.this$0.m20219d() && (access$getMStrategy$p = this.this$0.f28659e) != null) {
            access$getMStrategy$p.updateMatchLocation(gpsLocation);
        }
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onRoadSnappedLocationChanged(gpsLocation);
        }
    }

    public void onCameraModeChanged(CameraMode cameraMode) {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onCameraModeChanged(cameraMode);
        }
    }

    public void onArriveDestination() {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onArriveDestination();
        }
    }

    public void onNavigationCodeUpdate(int i) {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onNavigationCodeUpdate(i);
        }
    }

    public void startLightNavSctx_Google() {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.startLightNavSctx_Google();
        }
    }

    public void onSctxUploadAllData_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location, boolean z) {
        INavigationCallback access$getMNavCallbackOut$p = this.this$0.f28658d;
        if (access$getMNavCallbackOut$p != null) {
            access$getMNavCallbackOut$p.onSctxUploadAllData_Google(list, list2, location, z);
        }
    }
}
