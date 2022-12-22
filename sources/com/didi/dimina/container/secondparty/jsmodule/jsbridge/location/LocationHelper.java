package com.didi.dimina.container.secondparty.jsmodule.jsbridge.location;

import android.content.Context;
import android.location.Criteria;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.LogUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public class LocationHelper {
    public static final String LOCATION_TYPE_BD09 = "bd09";
    public static final String LOCATION_TYPE_GCJ02 = "gcj02";
    public static final String LOCATION_TYPE_WGS84 = "wgs84";

    /* renamed from: a */
    private final DIDILocationManager f17194a;

    /* renamed from: b */
    private DIDILocationListener f17195b;

    public LocationHelper(Context context) {
        this.f17194a = DIDILocationManager.getInstance(context.getApplicationContext());
    }

    public boolean startLocationUpdate(String str, boolean z, long j, float f, final IDMCommonAction<DIDILocation> iDMCommonAction) {
        if (this.f17194a == null) {
            return false;
        }
        if (this.f17195b == null) {
            this.f17195b = new DIDILocationListener() {
                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    LogUtil.m13411i("onLocationChanged, new location=" + dIDILocation);
                    iDMCommonAction.callback(dIDILocation);
                }

                public void onLocationError(int i, ErrInfo errInfo) {
                    iDMCommonAction.callback(null);
                }
            };
        }
        Criteria criteria = new Criteria();
        criteria.setAltitudeRequired(false);
        criteria.setAccuracy(z ? 1 : 2);
        criteria.setPowerRequirement(3);
        try {
            DIDILocationUpdateOption dIDILocationUpdateOption = new DIDILocationUpdateOption();
            dIDILocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.MORE_BATTERY_SAVE);
            this.f17194a.requestLocationUpdates(this.f17195b, dIDILocationUpdateOption);
            LogUtil.m13411i("requestLocationUpdates, minTime:" + j);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void stopLocationUpdate() {
        DIDILocationListener dIDILocationListener;
        LogUtil.m13411i("removeLocationUpdates");
        DIDILocationManager dIDILocationManager = this.f17194a;
        if (!(dIDILocationManager == null || (dIDILocationListener = this.f17195b) == null)) {
            dIDILocationManager.removeLocationUpdates(dIDILocationListener);
        }
        this.f17195b = null;
    }

    public void getOnceLocation(String str, long j, final IDMCommonAction<DIDILocation> iDMCommonAction) {
        if (this.f17194a == null) {
            iDMCommonAction.callback(null);
        }
        this.f17194a.requestLocationUpdateOnce(new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                iDMCommonAction.callback(dIDILocation);
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                iDMCommonAction.callback(null);
            }
        }, "dimina_location");
    }

    public DIDILocation getLastLocation(String str) {
        return this.f17194a.getLastKnownLocation();
    }
}
