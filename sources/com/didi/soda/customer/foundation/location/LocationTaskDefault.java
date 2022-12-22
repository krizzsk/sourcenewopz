package com.didi.soda.customer.foundation.location;

import com.didi.common.map.model.LatLng;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public class LocationTaskDefault {

    /* renamed from: a */
    private static final String f40928a = "LocationTaskDefault";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LocationUtil.LocationCallback f40929b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LocationOmegaHelper f40930c = new LocationOmegaHelper();

    public LocationTaskDefault(LocationUtil.LocationCallback locationCallback) {
        this.f40929b = locationCallback;
    }

    public void startLocation() {
        this.f40930c.traceLocStart();
        LocationService.getInstance().requestOnceLocation(new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                LocationUtil.setErrorInfo((ErrInfo) null);
                LocationTaskDefault.this.f40930c.traceLocEnd(dIDILocation);
                LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                if (LocationTaskDefault.this.f40929b != null) {
                    LocationTaskDefault.this.f40929b.onLocationSuccess(latLng);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("OnceListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m29104i(LocationTaskDefault.f40928a, sb.toString() != null ? dIDILocation.toString() : "");
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (LocationTaskDefault.this.f40929b != null) {
                    LocationTaskDefault.this.f40929b.onLocationError();
                }
                LocationUtil.setErrorInfo(errInfo);
                LocationTaskDefault.this.f40930c.traceLocError(errInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("UpdateListener onLocationError: ");
                sb.append(errInfo);
                LogUtil.m29104i(LocationTaskDefault.f40928a, sb.toString() != null ? errInfo.toString() : "");
            }
        });
    }
}
