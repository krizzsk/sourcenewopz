package com.didi.map.global.component.departure.canoe.reverse;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.canoe.reverse.ReverseTaskParam;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Utils;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.yanzhenjie.permission.runtime.Permission;

public class DepartureReverseManager implements ReverseTaskCallback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24961a;

    /* renamed from: b */
    private final int f24962b = 1;

    /* renamed from: c */
    private int f24963c;

    /* renamed from: d */
    private ReverseTask f24964d;

    /* renamed from: e */
    private ReverseTaskParam f24965e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DepartureLocationInfo f24966f;

    /* renamed from: g */
    private IReverseCallback f24967g;

    /* renamed from: h */
    private DepartureAddress f24968h;

    /* renamed from: i */
    private ReverseStationsInfo f24969i;

    /* renamed from: j */
    private boolean f24970j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f24971k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LatLng f24972l;

    /* renamed from: m */
    private final int f24973m = 30;

    /* renamed from: n */
    private DIDILocationListener f24974n = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (dIDILocation != null && !DepartureReverseManager.this.f24971k) {
                if (DepartureReverseManager.this.f24961a == null || (DepartureReverseManager.isLocationPermissionGranted(DepartureReverseManager.this.f24961a) && !DepartureReverseManager.isSystemLocationOff(DepartureReverseManager.this.f24961a))) {
                    LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (LatLngUtils.locateCorrect(latLng)) {
                        if (DepartureReverseManager.this.f24966f == null) {
                            DepartureLocationInfo unused = DepartureReverseManager.this.f24966f = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
                        }
                        if (DepartureReverseManager.this.f24972l == null || DepartureReverseManager.this.m17835a(latLng)) {
                            DepartureReverseManager.this.f24966f.latLng = latLng;
                            DepartureReverseManager.this.m17834a();
                        }
                        LatLng unused2 = DepartureReverseManager.this.f24972l = latLng;
                    }
                }
            }
        }
    };

    public DepartureReverseManager(Context context, IReverseCallback iReverseCallback) {
        this.f24961a = context;
        this.f24967g = iReverseCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m17835a(LatLng latLng) {
        return ((int) DDSphericalUtil.computeDistanceBetween(this.f24972l, latLng)) > 30;
    }

    public void reverseForce() {
        LatLng latLng;
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f24961a).getLastKnownLocation();
        if (lastKnownLocation != null) {
            latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            if (!LatLngUtils.locateCorrect(latLng)) {
                IReverseCallback iReverseCallback = this.f24967g;
                if (iReverseCallback != null) {
                    iReverseCallback.onReverseFailed();
                    return;
                }
                return;
            }
        } else {
            latLng = null;
        }
        if (this.f24966f == null) {
            this.f24966f = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
        }
        this.f24966f.latLng = latLng;
        m17834a();
    }

    public void reverse() {
        if (!this.f24970j) {
            LocationHelper.registerListener(this.f24961a, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f24974n);
            this.f24970j = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m17834a() {
        m17842c();
        int i = this.f24963c + 1;
        this.f24963c = i;
        ReverseTaskParam build = new ReverseTaskParam.Builder(i, this).mapType("gmap").locationInfo(this.f24966f).reqCallerId(CallFrom.HOME_PAGE_DRAG).build();
        this.f24965e = build;
        ReverseTask reverseTask = new ReverseTask(this.f24961a, build);
        this.f24964d = reverseTask;
        reverseTask.start();
    }

    public void onDataStart() {
        IReverseCallback iReverseCallback;
        if (this.f24964d.getId() == this.f24963c && (iReverseCallback = this.f24967g) != null) {
            iReverseCallback.onLoading();
        }
    }

    public void onDataFailed(int i) {
        IReverseCallback iReverseCallback;
        if (this.f24964d.getId() == this.f24963c && (iReverseCallback = this.f24967g) != null) {
            iReverseCallback.onReverseFailed();
        }
    }

    public void onDataSuccess(ReverseStationsInfo reverseStationsInfo) {
        if (this.f24964d.getId() == this.f24963c && this.f24967g != null) {
            this.f24969i = reverseStationsInfo;
            DepartureAddress b = m17840b();
            this.f24968h = b;
            if (b == null) {
                this.f24967g.onReverseFailed();
                return;
            }
            DLog.m32737d("address = " + this.f24968h);
            this.f24967g.onReverseSuccess(this.f24968h);
        }
    }

    /* renamed from: b */
    private DepartureAddress m17840b() {
        if (this.f24969i == null) {
            return null;
        }
        DepartureAddress departureAddress = new DepartureAddress();
        RpcPoi departureAddress2 = this.f24969i.getDepartureAddress();
        boolean z = false;
        departureAddress.setRecommendPoi(false);
        if (departureAddress2 != null) {
            departureAddress.setAddress(DepartureUtils.getAddressByRpcPoi(departureAddress2, false, this.f24969i.language, 1));
            if (departureAddress2.base_info != null) {
                departureAddress.setIsAirPortPickUpPoint(departureAddress2.base_info.isAirPortPickUpPoint);
                departureAddress.setCountryId(departureAddress2.base_info.countryId);
                departureAddress.setCountryCode(departureAddress2.base_info.countryCode);
            }
            if (departureAddress2.extend_info != null) {
                departureAddress.setPickIconUrl(departureAddress2.extend_info.pickIconUrl);
                departureAddress.setEta(departureAddress2.extend_info.eta);
                departureAddress.setStartParkingProperty(departureAddress2.extend_info.startParkingProperty);
                if (departureAddress2.extend_info.pictureStyle != 1) {
                    z = true;
                }
                departureAddress.setShowRealPicInXpanel(z);
            }
        }
        return departureAddress;
    }

    /* renamed from: c */
    private void m17842c() {
        ReverseTask reverseTask = this.f24964d;
        if (reverseTask != null) {
            reverseTask.stop();
        }
    }

    public void destroy() {
        LocationHelper.unRegisterListener(this.f24961a, this.f24974n);
        this.f24974n = null;
        this.f24970j = false;
        this.f24971k = true;
        ReverseTask reverseTask = this.f24964d;
        if (reverseTask != null) {
            reverseTask.destroy();
        }
        this.f24964d = null;
        this.f24963c = 0;
        this.f24969i = null;
        this.f24961a = null;
    }

    public static boolean isLocationPermissionGranted(Context context) {
        return Utils.checkSystemPermission(context, Permission.ACCESS_FINE_LOCATION) == 0 || Utils.checkSystemPermission(context, Permission.ACCESS_COARSE_LOCATION) == 0;
    }

    public static boolean isSystemLocationOff(Context context) {
        return DIDILocationManager.getInstance(context).isLocationSwitchOff();
    }
}
