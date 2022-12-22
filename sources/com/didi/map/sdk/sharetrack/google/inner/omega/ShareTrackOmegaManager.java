package com.didi.map.sdk.sharetrack.google.inner.omega;

import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.global.component.driveromega.GlobalDriverOmega;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.google.gson.Gson;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShareTrackOmegaManager {

    /* renamed from: a */
    private final String f28870a = ShareTrackOmegaManager.class.getSimpleName();

    /* renamed from: b */
    private final int f28871b = 60000;

    /* renamed from: c */
    private ScheduledExecutorService f28872c;

    /* renamed from: d */
    private List<LightNavOmegaInfo> f28873d;

    /* renamed from: e */
    private GoogleSctxDriver f28874e;

    /* renamed from: f */
    private boolean f28875f;

    /* renamed from: g */
    private long f28876g = -1;

    /* renamed from: h */
    private LatLng f28877h;

    /* renamed from: i */
    private Runnable f28878i = new Runnable() {
        public final void run() {
            ShareTrackOmegaManager.this.m20349b();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m20349b() {
        if (this.f28876g < 0) {
            this.f28876g = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f28876g >= 60000) {
            this.f28876g = currentTimeMillis;
            flushAllNavData();
        }
        m20348a();
    }

    public ShareTrackOmegaManager(GoogleSctxDriver googleSctxDriver) {
        this.f28874e = googleSctxDriver;
        this.f28873d = new ArrayList();
        this.f28872c = Executors.newSingleThreadScheduledExecutor();
    }

    public void startLoopCarInfo() {
        if (!this.f28875f) {
            this.f28875f = true;
            try {
                this.f28872c.scheduleAtFixedRate(this.f28878i, 1000, 1000, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                this.f28875f = false;
            }
        }
    }

    public void destroy() {
        flushAllNavData();
        ScheduledExecutorService scheduledExecutorService = this.f28872c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        this.f28875f = false;
        this.f28877h = null;
    }

    /* renamed from: a */
    private void m20348a() {
        double d;
        if (this.f28874e == null) {
            DLog.m20357d(this.f28870a, "driver is null, cannot continue", new Object[0]);
            return;
        }
        LightNavOmegaInfo lightNavOmegaInfo = new LightNavOmegaInfo();
        GpsLocation originGpsLocation = this.f28874e.getOriginGpsLocation();
        RouteGuidanceGPSPoint originMatchPoint = this.f28874e.getOriginMatchPoint();
        IMyLocationDelegate myLocationEngine = this.f28874e.getMyLocationEngine();
        if (originGpsLocation != null) {
            lightNavOmegaInfo.gpsTime = originGpsLocation.time;
            lightNavOmegaInfo.originLat = originGpsLocation.latitude;
            lightNavOmegaInfo.originLng = originGpsLocation.longitude;
        }
        if (originMatchPoint != null) {
            int i = -1;
            double d2 = -1.0d;
            if (originMatchPoint.point != null) {
                double latitudeE6 = ((double) originMatchPoint.point.getLatitudeE6()) / 1000000.0d;
                double longitudeE6 = ((double) originMatchPoint.point.getLongitudeE6()) / 1000000.0d;
                i = this.f28874e.getEda(new LatLng(latitudeE6, longitudeE6), originMatchPoint.segmentIndex, originMatchPoint.shapeOffSet);
                d = longitudeE6;
                d2 = latitudeE6;
            } else {
                d = -1.0d;
            }
            lightNavOmegaInfo.curEDA = i;
            lightNavOmegaInfo.matchedLat = d2;
            lightNavOmegaInfo.matchedLng = d;
        }
        lightNavOmegaInfo.sysTime = System.currentTimeMillis();
        if (TimeServiceManager.getInstance().isNTPEnabled() && TimeServiceManager.getInstance().isNTPAvailable()) {
            lightNavOmegaInfo.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
        }
        if (!(myLocationEngine == null || myLocationEngine.getCarMarker() == null || myLocationEngine.getCarMarker().getPosition() == null)) {
            LatLng position = myLocationEngine.getCarMarker().getPosition();
            lightNavOmegaInfo.carAnimLat = position.latitude;
            lightNavOmegaInfo.carAnimLng = position.longitude;
            AnimateNode currentAnimNode = myLocationEngine.getCurrentAnimNode();
            if (currentAnimNode != null) {
                lightNavOmegaInfo.carAnimEDA = ((int) DDSphericalUtil.computeDistanceBetween(position, currentAnimNode.latLng)) + this.f28874e.getEda(currentAnimNode.latLng, currentAnimNode.index, 0);
            }
            if (this.f28877h == null) {
                this.f28877h = new LatLng(position.latitude, position.longitude);
            }
            lightNavOmegaInfo.distanceBetweenLastNode = (int) DDSphericalUtil.computeDistanceBetween(position, this.f28877h);
            this.f28877h = position;
        }
        List<LightNavOmegaInfo> list = this.f28873d;
        if (list != null) {
            list.add(lightNavOmegaInfo);
        }
    }

    public void flushAllNavData() {
        List<LightNavOmegaInfo> list = this.f28873d;
        if (list != null && !list.isEmpty()) {
            try {
                String json = new Gson().toJson((Object) this.f28873d);
                HashMap hashMap = new HashMap();
                hashMap.put(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId()));
                String str = "";
                if (!(this.f28874e == null || this.f28874e.getOrderInfo() == null)) {
                    str = this.f28874e.getOrderInfo().getOrderId();
                }
                hashMap.put("order_id", str);
                hashMap.put("list", json);
                GlobalDriverOmega.trackEvent("map_gps_anim_location_driv", hashMap);
                String str2 = this.f28870a;
                DLog.m20357d(str2, "flushAllNavData success, size is: " + this.f28873d.size(), new Object[0]);
                this.f28873d.clear();
            } catch (Exception e) {
                DLog.m20357d(this.f28870a, e.getMessage(), new Object[0]);
            }
        }
    }
}
