package com.didi.soda.customer.foundation.location;

import com.didi.common.map.model.LatLng;
import com.didi.foundation.sdk.location.BaseLocationListener;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public class LocationTaskEnhanced {

    /* renamed from: a */
    private static final String f40931a = "LocationTaskEnhanced";

    /* renamed from: b */
    private LocationUtil.LocationCallback f40932b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f40933c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ErrInfo f40934d;

    /* renamed from: e */
    private DIDILocationListener f40935e = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (LocationTaskEnhanced.this.f40933c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f40933c = dIDILocation;
                LocationTaskEnhanced.this.m29091a();
                StringBuilder sb = new StringBuilder();
                sb.append("OnceListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m29104i(LocationTaskEnhanced.f40931a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            ErrInfo unused = LocationTaskEnhanced.this.f40934d = errInfo;
            LocationTaskEnhanced.this.m29094c();
            StringBuilder sb = new StringBuilder();
            sb.append("OnceListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m29104i(LocationTaskEnhanced.f40931a, sb.toString() != null ? errInfo.toString() : "");
        }
    };

    /* renamed from: f */
    private BaseLocationListener f40936f = new BaseLocationListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            super.onLocationChanged(dIDILocation);
            if (LocationTaskEnhanced.this.f40933c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f40933c = dIDILocation;
                LocationTaskEnhanced.this.m29091a();
                StringBuilder sb = new StringBuilder();
                sb.append("UpdateListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m29104i(LocationTaskEnhanced.f40931a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            super.onLocationError(i, errInfo);
            ErrInfo unused = LocationTaskEnhanced.this.f40934d = errInfo;
            LocationUtil.setErrorInfo(LocationTaskEnhanced.this.f40934d);
            StringBuilder sb = new StringBuilder();
            sb.append("UpdateListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m29104i(LocationTaskEnhanced.f40931a, sb.toString() != null ? errInfo.toString() : "");
        }

        public void onStatusUpdate(String str, int i, String str2) {
            super.onStatusUpdate(str, i, str2);
        }
    };

    /* renamed from: g */
    private Runnable f40937g = new Runnable() {
        public void run() {
            if (LocationTaskEnhanced.this.f40933c == null) {
                if (LocationTaskEnhanced.this.f40934d == null) {
                    ErrInfo unused = LocationTaskEnhanced.this.f40934d = new ErrInfo(-1);
                }
                LocationTaskEnhanced.this.m29092b();
                LogUtil.m29104i(LocationTaskEnhanced.f40931a, "TimeOutRunnable onTimeout");
            }
        }
    };

    /* renamed from: h */
    private int f40938h;

    /* renamed from: i */
    private LocationOmegaHelper f40939i = new LocationOmegaHelper();

    public LocationTaskEnhanced(LocationUtil.LocationCallback locationCallback, int i) {
        this.f40932b = locationCallback;
        this.f40938h = i;
    }

    public void startLocation() {
        this.f40939i.traceLocStart();
        LocationService.getInstance().requestOnceLocation(this.f40935e);
        LocationService.getInstance().registerLocationListener(this.f40936f);
        UiHandlerUtil.postDelayed(this.f40937g, (long) this.f40938h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29091a() {
        LocationUtil.setErrorInfo((ErrInfo) null);
        this.f40939i.traceLocEnd(this.f40933c);
        m29097d();
        LatLng latLng = new LatLng(this.f40933c.getLatitude(), this.f40933c.getLongitude());
        LocationUtil.LocationCallback locationCallback = this.f40932b;
        if (locationCallback != null) {
            locationCallback.onLocationSuccess(latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29092b() {
        LocationUtil.setErrorInfo(this.f40934d);
        m29097d();
        LocationUtil.LocationCallback locationCallback = this.f40932b;
        if (locationCallback != null) {
            locationCallback.onLocationError();
        }
        this.f40939i.traceLocError(this.f40934d);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29094c() {
        if (!CustomerSystemUtil.isGpsEnabled(GlobalContext.getContext())) {
            m29092b();
        }
    }

    /* renamed from: d */
    private void m29097d() {
        LocationService.getInstance().unRegisterLocationListener(this.f40936f);
        UiHandlerUtil.removeCallbacks(this.f40937g);
    }
}
