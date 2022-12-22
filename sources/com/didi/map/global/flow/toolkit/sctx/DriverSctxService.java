package com.didi.map.global.flow.toolkit.sctx;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.sharetrack.callback.INavigationCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.DiDiRouteSegment;
import com.didi.map.sdk.sharetrack.entity.DiDiTimeAndDistance;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.external.CommonNavigator;
import com.didi.map.sdk.sharetrack.external.INavigator;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.ArrayList;
import java.util.List;

public class DriverSctxService {

    /* renamed from: a */
    private static final String f27226a = "DriverSctxService";

    /* renamed from: b */
    private Context f27227b;

    /* renamed from: c */
    private MapView f27228c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DriverSctxParam f27229d;

    /* renamed from: e */
    private LatLng f27230e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public INavigator f27231f;

    /* renamed from: g */
    private CameraMode f27232g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f27233h;

    /* renamed from: i */
    private List<IMapElement> f27234i;

    /* renamed from: j */
    private int f27235j;

    /* renamed from: k */
    private int f27236k;

    /* renamed from: l */
    private int f27237l;

    /* renamed from: m */
    private int f27238m;

    /* renamed from: n */
    private final INavigationCallback f27239n = new INavigationCallback() {
        public void onApproaching(int i) {
        }

        public void onCameraModeChanged(CameraMode cameraMode) {
        }

        public void onDriveAway() {
        }

        public void onNaviVoice(String str, int i) {
        }

        public void onNavigationCodeUpdate(int i) {
        }

        public void onOffRoute() {
        }

        public void onResetView() {
        }

        public void onRoadSnappedLocationChanged(GpsLocation gpsLocation) {
        }

        public void onSctxSetRouteToLightNav_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location) {
        }

        public void onSctxUploadAllData_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location, boolean z) {
        }

        public void onStartNavSuccess() {
        }

        public void startLightNavSctx_Google() {
        }

        public void onArriveDestination() {
            if (DriverSctxService.this.f27229d.navigationCallback != null) {
                DriverSctxService.this.f27229d.navigationCallback.onArriveDestination();
            }
        }

        public void onRemainingTimeOrDistanceChanged() {
            if (DriverSctxService.this.f27231f != null) {
                int remainMeters = DriverSctxService.this.f27231f.getRemainMeters(-1);
                int remainMinutes = DriverSctxService.this.f27231f.getRemainMinutes(-1);
                int i = 0;
                int i2 = 1;
                DLog.m7384d(DriverSctxService.f27226a, "navigationCallback onRemainingTimeOrDistanceChanged distance:%d, time:%d", Integer.valueOf(remainMeters), Integer.valueOf(remainMinutes));
                if (DriverSctxService.this.f27229d.etaEdaCallback != null) {
                    if (!DriverSctxService.this.f27233h) {
                        DriverSctxService.this.f27229d.etaEdaCallback.onEtaEdaChanged(new EtaEda(0, 0));
                        return;
                    }
                    if (remainMeters < 0) {
                        remainMeters = 0;
                    }
                    if (remainMinutes < 0) {
                        remainMinutes = 0;
                    }
                    if (remainMeters == 0 || remainMinutes == 0) {
                        DriverSctxService.this.f27229d.etaEdaCallback.onEtaEdaChanged(new EtaEda(1, 1));
                    } else {
                        if (remainMinutes != Integer.MAX_VALUE) {
                            i = remainMinutes;
                        }
                        if (remainMeters != Integer.MAX_VALUE) {
                            i2 = remainMeters;
                        }
                        DriverSctxService.this.f27229d.etaEdaCallback.onEtaEdaChanged(new EtaEda(i, i2));
                    }
                }
            }
            if (DriverSctxService.this.f27229d.navigationCallback != null) {
                DriverSctxService.this.f27229d.navigationCallback.onRemainingTimeOrDistanceChanged();
            }
        }

        public void onViaPointExpired(List<LatLng> list, long j) {
            if (DriverSctxService.this.f27229d.navigationCallback != null) {
                DriverSctxService.this.f27229d.navigationCallback.onViaPointExpired(list, j);
            }
        }
    };

    /* renamed from: o */
    private final ISearchOffRouteCallback f27240o = new ISearchOffRouteCallback() {
        public void onOffRoute() {
            if (DriverSctxService.this.f27229d.searchOffRouteCallback != null) {
                DriverSctxService.this.f27229d.searchOffRouteCallback.onOffRoute();
            }
        }

        public void onSuccess(ArrayList<NaviRoute> arrayList) {
            if (DriverSctxService.this.f27229d.searchOffRouteCallback != null) {
                DriverSctxService.this.f27229d.searchOffRouteCallback.onSuccess(arrayList);
            }
        }

        public void onRetryFail() {
            if (DriverSctxService.this.f27229d.searchOffRouteCallback != null) {
                DriverSctxService.this.f27229d.searchOffRouteCallback.onRetryFail();
            }
        }
    };

    /* renamed from: p */
    private final ISearchRouteCallback f27241p = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            if (DriverSctxService.this.f27229d.searchRouteCallback != null) {
                DriverSctxService.this.f27229d.searchRouteCallback.onBeginToSearch();
            }
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            if (DriverSctxService.this.f27229d.searchRouteCallback != null) {
                DriverSctxService.this.f27229d.searchRouteCallback.onFinishToSearch(arrayList, str);
            }
        }
    };

    public DriverSctxService(Context context, DriverSctxParam driverSctxParam) {
        this.f27227b = context;
        m19262a(driverSctxParam);
        CommonNavigator commonNavigator = new CommonNavigator();
        this.f27231f = commonNavigator;
        commonNavigator.initWithVendor(context, MapVendor.GOOGLE, false);
    }

    /* renamed from: a */
    private void m19262a(DriverSctxParam driverSctxParam) {
        this.f27228c = driverSctxParam.mapView;
        this.f27234i = new ArrayList();
        this.f27229d = driverSctxParam;
        this.f27230e = (driverSctxParam.orderInfo.getOrderStage() == 4 ? driverSctxParam.orderEndPoint : driverSctxParam.orderStartPoint).latLng;
        this.f27232g = CameraMode.NORTH_UP;
        this.f27233h = true;
    }

    public void update(DriverSctxParam driverSctxParam) {
        m19262a(driverSctxParam);
        if (!TextUtils.equals(this.f27229d.orderInfo.getOrderId(), driverSctxParam.orderInfo.getOrderId())) {
            CommonNavigator commonNavigator = new CommonNavigator();
            this.f27231f = commonNavigator;
            commonNavigator.initWithVendor(this.f27227b, MapVendor.GOOGLE, false);
        }
    }

    public void setBestViewMapElements(List<IMapElement> list) {
        this.f27234i.clear();
        if (list != null) {
            this.f27234i.addAll(list);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        this.f27235j = i;
        this.f27236k = i2;
        this.f27237l = i3;
        this.f27238m = i4;
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            iNavigator.onNewMargin(i, i2, i3, i4);
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        this.f27232g = cameraMode;
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            iNavigator.setCameraMode(cameraMode);
            followMyLocation(cameraMode == CameraMode.CAR_HEAD_UP);
        }
    }

    public void followMyLocation(boolean z) {
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            iNavigator.followMyLocation(z);
        }
    }

    public Marker getCarMarker() {
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            return iNavigator.getCarMarker();
        }
        return null;
    }

    public List<IMapElement> getLine() {
        MultiLine line;
        ArrayList arrayList = new ArrayList();
        INavigator iNavigator = this.f27231f;
        if (!(iNavigator == null || (line = iNavigator.getLine()) == null)) {
            if (line.mFirstLine != null) {
                arrayList.add(line.mFirstLine);
            }
            if (line.mFirstLine_Ex != null) {
                arrayList.add(line.mFirstLine_Ex);
            }
            if (line.mSecondLine != null) {
                arrayList.add(line.mSecondLine);
            }
        }
        return arrayList;
    }

    public void start(GpsLocation gpsLocation) {
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            iNavigator.setCameraMode(this.f27232g);
            this.f27231f.followMyLocation(this.f27232g == CameraMode.CAR_HEAD_UP);
            this.f27231f.setDiDiMap(this.f27229d.mapView.getMap());
            this.f27231f.setOrderInfo(this.f27229d.orderInfo);
            this.f27231f.setRouteLineVisible(this.f27233h);
            this.f27231f.setCarMarkerEnabled(true);
            this.f27231f.setCarMarkerZindex((float) this.f27229d.carZIndex);
            this.f27231f.setCarMarkerBitmap(BitmapDescriptorFactory.fromBitmap(ImageUtil.Drawable2Bitmap(this.f27227b.getResources().getDrawable(this.f27229d.carBitmapRes))));
            this.f27231f.setCarMarkerEnabled(true);
            this.f27231f.setNaviCallback(this.f27239n);
            this.f27231f.setSearchOffRouteCallback(this.f27240o);
            this.f27231f.setSearchRouteCallbck(this.f27241p);
            this.f27231f.setLineOptions(m19260a(false), m19260a(true));
            this.f27231f.onLocationChanged(gpsLocation, LocationHelper.DIDILocations2GpsLocations(DIDILocBusinessHelper.getInstance().getRecentLocations(20)));
            this.f27231f.setDestination(this.f27230e);
            this.f27231f.start();
        }
    }

    public void zoomToNav() {
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            iNavigator.zoomToNav();
        }
    }

    public void onLocationChanged(DIDILocation dIDILocation, List<DIDILocation> list) {
        if (this.f27231f != null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(LocationHelper.DIDILocation2GpsLocation(list.get(i)));
                }
            }
            this.f27231f.onLocationChanged(LocationHelper.DIDILocation2GpsLocation(dIDILocation), arrayList);
        }
    }

    public void onMapVisible(boolean z) {
        INavigator iNavigator = this.f27231f;
        if (iNavigator == null) {
            return;
        }
        if (z) {
            iNavigator.resumeAfterNavigation();
        } else {
            iNavigator.pause4Navigation();
        }
    }

    /* renamed from: a */
    private LineOptions m19260a(boolean z) {
        int i;
        int i2;
        int i3;
        LineOptions lineOptions = new LineOptions();
        Context context = this.f27227b;
        if (context != null) {
            lineOptions.width((double) DisplayUtils.dp2px(context, 5.0f));
        }
        if (z) {
            i = 162;
            i3 = 174;
            i2 = 187;
        } else {
            i = 74;
            i3 = 76;
            i2 = 91;
        }
        lineOptions.color(Color.rgb(i, i3, i2));
        lineOptions.zIndex(this.f27229d.lineZIndex);
        return lineOptions;
    }

    public void stop() {
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            iNavigator.stop();
            this.f27231f.setCarMarkerEnabled(false);
        }
    }

    public void destroy() {
        INavigator iNavigator = this.f27231f;
        if (iNavigator != null) {
            iNavigator.destroy();
        }
    }
}
