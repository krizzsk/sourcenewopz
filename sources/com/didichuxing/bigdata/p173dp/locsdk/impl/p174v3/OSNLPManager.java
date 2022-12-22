package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.OSNLPManager */
public class OSNLPManager {

    /* renamed from: a */
    private static final String f45892a = "OSNLPManager";

    /* renamed from: h */
    private static final long f45893h = 15000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f45894b;

    /* renamed from: c */
    private LocationManager f45895c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile OSLocationWrapper f45896d;

    /* renamed from: e */
    private volatile boolean f45897e;

    /* renamed from: f */
    private boolean f45898f;

    /* renamed from: g */
    private long f45899g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f45900i;

    /* renamed from: j */
    private LocationListener f45901j;

    /* renamed from: a */
    static /* synthetic */ int m32934a(OSNLPManager oSNLPManager) {
        int i = oSNLPManager.f45900i;
        oSNLPManager.f45900i = i + 1;
        return i;
    }

    private OSNLPManager() {
        this.f45896d = null;
        this.f45897e = false;
        this.f45898f = false;
        this.f45900i = 0;
        this.f45901j = new LocationListener() {
            public void onLocationChanged(Location location) {
                OSNLPManager.m32934a(OSNLPManager.this);
                if (OSNLPManager.this.f45900i == 10) {
                    int unused = OSNLPManager.this.f45900i = 0;
                    DLog.m32737d("OSNLPManager location arrived: os nlp");
                }
                if (Utils.locCorrect(location)) {
                    if (ApolloProxy.getInstance().getIsCheckMockViaSystem()) {
                        boolean isMockLocation = Utils.isMockLocation(location);
                        Utils.setIsGpsMocked(isMockLocation);
                        if (isMockLocation && !DIDILocationManager.enableMockLocation) {
                            DLog.m32737d("on osnlp callback, mock loc and disable mock!");
                        }
                    }
                    if (!DIDILocationManager.enableMockLocation) {
                        boolean z = true;
                        if (!Utils.isMockSettingsON(OSNLPManager.this.f45894b) && !Utils.isGpsMocked()) {
                            z = Utils.isMockLocation(location);
                        }
                        if (z) {
                            return;
                        }
                    }
                    if (!(location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) && location.getAccuracy() > 0.0f) {
                        LocNTPHelper.adjustSystemLocationTimestamp(location);
                        OSLocationWrapper unused2 = OSNLPManager.this.f45896d = new OSLocationWrapper(location, System.currentTimeMillis());
                        return;
                    }
                    DLog.m32737d("zero nlp location: " + String.valueOf(location));
                }
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
                DLog.m32737d(" status = " + i);
            }

            public void onProviderEnabled(String str) {
                DLog.m32737d(" osNLP onProviderEnabled: " + str);
            }

            public void onProviderDisabled(String str) {
                DLog.m32737d("osNLP onProviderDisabled: " + str);
            }
        };
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.OSNLPManager$SigletonHolder */
    private static class SigletonHolder {
        static OSNLPManager sInstance = new OSNLPManager();

        private SigletonHolder() {
        }
    }

    public static OSNLPManager getInstance() {
        return SigletonHolder.sInstance;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114515a(Context context) {
        this.f45894b = context;
        this.f45895c = (LocationManager) context.getSystemService("location");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo114514a() {
        m32937a(false);
    }

    /* renamed from: a */
    private synchronized void m32937a(boolean z) {
        if (!this.f45897e || z) {
            this.f45897e = true;
            try {
                this.f45895c.requestLocationUpdates("network", 1000, 0.0f, this.f45901j, ThreadDispatcher.getWorkThread().getLooper());
                this.f45898f = false;
            } catch (SecurityException e) {
                this.f45898f = true;
                DLog.m32737d("OSNLPManager#start: exception:" + e.getMessage());
            } catch (Exception e2) {
                this.f45898f = false;
                DLog.m32737d("OSNLPManager#start: exception:" + e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo114516b() {
        if (this.f45897e) {
            try {
                this.f45895c.removeUpdates(this.f45901j);
            } catch (SecurityException e) {
                DLog.m32737d("OSNLPManager#stop: exception:" + e.getMessage());
            } catch (Exception e2) {
                DLog.m32737d("OSNLPManager#stop: exception:" + e2.getMessage());
            }
            this.f45897e = false;
        }
    }

    /* renamed from: c */
    private synchronized void m32940c() {
        if (this.f45897e && this.f45898f && this.f45895c != null && this.f45894b != null && SystemClock.elapsedRealtime() - this.f45899g > 15000) {
            this.f45899g = SystemClock.elapsedRealtime();
            if (Utils.isLocationPermissionGranted(this.f45894b)) {
                m32937a(true);
            }
        }
    }

    public DIDILocation getNLPLocation(int i) {
        DIDILocation dIDILocation = null;
        if (this.f45896d != null && Utils.locCorrect(this.f45896d.getLocation())) {
            if (System.currentTimeMillis() - this.f45896d.getLocalTime() > 20000) {
                this.f45896d = null;
            } else {
                dIDILocation = DIDILocation.loadFromGps(this.f45896d, true, i);
            }
        }
        if (this.f45896d == null) {
            m32940c();
        }
        return dIDILocation;
    }

    public OSLocationWrapper getOriginNLPLocation() {
        OSLocationWrapper oSLocationWrapper = null;
        if (this.f45896d != null && Utils.locCorrect(this.f45896d.getLocation())) {
            if (System.currentTimeMillis() - this.f45896d.getLocalTime() > 20000) {
                this.f45896d = null;
            } else {
                oSLocationWrapper = this.f45896d;
            }
        }
        if (this.f45896d == null) {
            m32940c();
        }
        return oSLocationWrapper;
    }
}
