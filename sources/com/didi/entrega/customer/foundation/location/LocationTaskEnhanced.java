package com.didi.entrega.customer.foundation.location;

import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.foundation.sdk.location.BaseLocationListener;
import com.didi.foundation.sdk.location.LocationService;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public class LocationTaskEnhanced {

    /* renamed from: a */
    private static final String f19924a = "LocationTaskEnhanced";

    /* renamed from: b */
    private LocationUtil.LocationCallback f19925b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f19926c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ErrInfo f19927d;

    /* renamed from: e */
    private DIDILocationListener f19928e = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (LocationTaskEnhanced.this.f19926c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f19926c = dIDILocation;
                LocationTaskEnhanced.this.m14752a();
                StringBuilder sb = new StringBuilder();
                sb.append("OnceListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m14765i(LocationTaskEnhanced.f19924a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            ErrInfo unused = LocationTaskEnhanced.this.f19927d = errInfo;
            LocationTaskEnhanced.this.m14755c();
            StringBuilder sb = new StringBuilder();
            sb.append("OnceListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m14765i(LocationTaskEnhanced.f19924a, sb.toString() != null ? errInfo.toString() : "");
        }
    };

    /* renamed from: f */
    private BaseLocationListener f19929f = new BaseLocationListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            super.onLocationChanged(dIDILocation);
            if (LocationTaskEnhanced.this.f19926c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f19926c = dIDILocation;
                LocationTaskEnhanced.this.m14752a();
                StringBuilder sb = new StringBuilder();
                sb.append("UpdateListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m14765i(LocationTaskEnhanced.f19924a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            super.onLocationError(i, errInfo);
            ErrInfo unused = LocationTaskEnhanced.this.f19927d = errInfo;
            StringBuilder sb = new StringBuilder();
            sb.append("UpdateListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m14765i(LocationTaskEnhanced.f19924a, sb.toString() != null ? errInfo.toString() : "");
        }

        public void onStatusUpdate(String str, int i, String str2) {
            super.onStatusUpdate(str, i, str2);
        }
    };

    /* renamed from: g */
    private Runnable f19930g = new Runnable() {
        public void run() {
            if (LocationTaskEnhanced.this.f19926c == null) {
                if (LocationTaskEnhanced.this.f19927d == null) {
                    ErrInfo unused = LocationTaskEnhanced.this.f19927d = new ErrInfo(-1);
                }
                LocationTaskEnhanced.this.m14753b();
                LogUtil.m14765i(LocationTaskEnhanced.f19924a, "TimeOutRunnable onTimeout");
            }
        }
    };

    /* renamed from: h */
    private int f19931h;

    /* renamed from: i */
    private LocationOmegaHelper f19932i = new LocationOmegaHelper();

    public LocationTaskEnhanced(LocationUtil.LocationCallback locationCallback, int i) {
        this.f19925b = locationCallback;
        this.f19931h = i;
    }

    public void startLocation() {
        this.f19932i.traceLocStart();
        LocationService.getInstance().requestOnceLocation(this.f19928e);
        LocationService.getInstance().registerLocationListener(this.f19929f);
        UiHandlerUtil.postDelayed(this.f19930g, (long) this.f19931h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14752a() {
        this.f19932i.traceLocEnd(this.f19926c);
        m14758d();
        LatLng latLng = new LatLng(this.f19926c.getLatitude(), this.f19926c.getLongitude());
        LocationUtil.LocationCallback locationCallback = this.f19925b;
        if (locationCallback != null) {
            locationCallback.onLocationSuccess(latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14753b() {
        m14758d();
        LocationUtil.LocationCallback locationCallback = this.f19925b;
        if (locationCallback != null) {
            locationCallback.onLocationError();
        }
        this.f19932i.traceLocError(this.f19927d);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14755c() {
        if (!CustomerSystemUtil.isGpsEnabled(GlobalContext.getContext())) {
            m14753b();
        }
    }

    /* renamed from: d */
    private void m14758d() {
        LocationService.getInstance().unRegisterLocationListener(this.f19929f);
        UiHandlerUtil.removeCallbacks(this.f19930g);
    }
}
