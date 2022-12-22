package com.didi.map.global.flow.toolkit.sctx;

import android.content.Context;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import java.util.ArrayList;
import java.util.List;

public class DriverSctx extends AbsComponent<DriverSctxParam> {

    /* renamed from: a */
    private static final String f27218a = "DriverSctx";

    /* renamed from: b */
    private Context f27219b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f27220c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DIDILocationListener f27221d;

    /* renamed from: e */
    private DriverSctxService f27222e;

    /* renamed from: f */
    private boolean f27223f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f27224g;

    /* renamed from: h */
    private DIDILocationListener f27225h = new DIDILocationListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            if (!DriverSctx.this.f27224g && dIDILocation != null) {
                DLog.m7384d(DriverSctx.f27218a, "onLocationChanged %s", dIDILocation.toString());
                DIDILocation unused = DriverSctx.this.f27220c = dIDILocation;
                DriverSctx.this.onLocationChanged(dIDILocation, DIDILocBusinessHelper.getInstance().getRecentLocations(20));
                if (DriverSctx.this.f27221d != null) {
                    DriverSctx.this.f27221d.onLocationChanged(dIDILocation);
                }
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            if (!DriverSctx.this.f27224g && DriverSctx.this.f27221d != null) {
                DriverSctx.this.f27221d.onLocationError(i, errInfo);
            }
        }

        public void onStatusUpdate(String str, int i, String str2) {
            if (!DriverSctx.this.f27224g && DriverSctx.this.f27221d != null) {
                DriverSctx.this.f27221d.onStatusUpdate(str, i, str2);
            }
        }
    };

    public DriverSctx(DriverSctxParam driverSctxParam) {
        DLog.m7384d(f27218a, "new: %s", driverSctxParam.toString());
        this.f27219b = driverSctxParam.getApplicationContext();
        this.f27221d = driverSctxParam.locationListener;
        Context context = this.f27219b;
        if (context != null) {
            this.f27222e = new DriverSctxService(context, driverSctxParam);
        }
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f27219b);
        this.f27220c = lastKnownLocation;
        if (lastKnownLocation != null) {
            onLocationChanged(lastKnownLocation, DIDILocBusinessHelper.getInstance().getRecentLocations(20));
        }
        LocationHelper.registerListener(this.f27219b, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f27225h);
    }

    public void update(DriverSctxParam driverSctxParam) {
        super.update(driverSctxParam);
        DLog.m7384d(f27218a, "update: %s", driverSctxParam.toString());
        this.f27221d = driverSctxParam.locationListener;
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.update(driverSctxParam);
        }
        this.f27223f = false;
        this.f27224g = false;
    }

    public void setBestViewMapElements(List<IMapElement> list) {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.setBestViewMapElements(list);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.onNewMargin(i, i2, i3, i4);
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.setCameraMode(cameraMode);
        }
    }

    public void followMyLocation(boolean z) {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.followMyLocation(z);
        }
    }

    public void zoomToNav() {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.zoomToNav();
        }
    }

    public void onLocationChanged(DIDILocation dIDILocation, List<DIDILocation> list) {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService == null) {
            return;
        }
        if (!this.f27223f) {
            DLog.m7384d(f27218a, "start", new Object[0]);
            this.f27222e.start(LocationHelper.DIDILocation2GpsLocation(dIDILocation));
            this.f27223f = true;
            return;
        }
        driverSctxService.onLocationChanged(dIDILocation, list);
    }

    public Marker getCarMarker() {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            return driverSctxService.getCarMarker();
        }
        return null;
    }

    public List<IMapElement> getLine() {
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            return driverSctxService.getLine();
        }
        return new ArrayList();
    }

    public void onMapVisible(boolean z) {
        DLog.m7384d(f27218a, "onMapVisible: %d", Boolean.valueOf(z));
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.onMapVisible(z);
        }
    }

    public void stop() {
        DLog.m7384d(f27218a, "stop", new Object[0]);
        this.f27224g = true;
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.stop();
        }
    }

    public void destroy() {
        DLog.m7384d(f27218a, "destroy", new Object[0]);
        LocationHelper.unRegisterListener(this.f27219b, this.f27225h);
        this.f27221d = null;
        this.f27224g = true;
        DriverSctxService driverSctxService = this.f27222e;
        if (driverSctxService != null) {
            driverSctxService.stop();
            this.f27222e.destroy();
        }
    }
}
