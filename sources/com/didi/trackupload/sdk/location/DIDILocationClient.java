package com.didi.trackupload.sdk.location;

import android.content.Context;
import com.didi.trackupload.sdk.utils.LocUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import java.util.List;

public class DIDILocationClient implements ILocationClient {

    /* renamed from: a */
    private static final String f43990a = "TRACK_UPLOAD_SDK";

    /* renamed from: b */
    private static final String f43991b = "DIDILocationClient";

    /* renamed from: c */
    private DIDILocationManager f43992c;

    /* renamed from: d */
    private Integer f43993d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TrackLocationListener f43994e;

    /* renamed from: f */
    private DIDILocationListener f43995f = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m31331a(dIDILocationClient.f43994e, dIDILocation);
            DIDILocationClient.this.m31332a((Integer) 0);
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m31330a(dIDILocationClient.f43994e, i, errInfo);
            DIDILocationClient dIDILocationClient2 = DIDILocationClient.this;
            if (errInfo != null) {
                i = errInfo.getErrNo();
            }
            dIDILocationClient2.m31332a(Integer.valueOf(i));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TrackLocationListener f43996g;

    /* renamed from: h */
    private DIDILocationListener f43997h = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m31331a(dIDILocationClient.f43996g, dIDILocation);
            DIDILocationClient.this.m31332a((Integer) 0);
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m31330a(dIDILocationClient.f43996g, i, errInfo);
            DIDILocationClient dIDILocationClient2 = DIDILocationClient.this;
            if (errInfo != null) {
                i = errInfo.getErrNo();
            }
            dIDILocationClient2.m31332a(Integer.valueOf(i));
        }
    };

    public void init(Context context) {
        if (context != null) {
            DIDILocationManager instance = DIDILocationManager.getInstance(context.getApplicationContext());
            this.f43992c = instance;
            instance.requestLocationUpdateOnce(new DIDILocationListener() {
                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    DIDILocationClient.this.m31332a((Integer) 0);
                }

                public void onLocationError(int i, ErrInfo errInfo) {
                    DIDILocationClient dIDILocationClient = DIDILocationClient.this;
                    if (errInfo != null) {
                        i = errInfo.getErrNo();
                    }
                    dIDILocationClient.m31332a(Integer.valueOf(i));
                }
            }, f43990a);
        }
    }

    public boolean isLocationServiceAlive() {
        DIDILocationManager dIDILocationManager = this.f43992c;
        return dIDILocationManager != null && dIDILocationManager.isRunning();
    }

    public void requestNormalLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        DIDILocationUpdateOption a;
        if (this.f43992c != null && trackLocationListener != null && (a = m31325a(j, false)) != null) {
            this.f43994e = trackLocationListener;
            this.f43992c.requestLocationUpdates(this.f43995f, a);
        }
    }

    public void removeNormalLocationUpdates() {
        DIDILocationManager dIDILocationManager = this.f43992c;
        if (dIDILocationManager != null && this.f43994e != null) {
            this.f43994e = null;
            dIDILocationManager.removeLocationUpdates(this.f43995f);
        }
    }

    public void requestDirectNotifyLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        DIDILocationUpdateOption a;
        if (this.f43992c != null && trackLocationListener != null && (a = m31325a(j, true)) != null) {
            this.f43996g = trackLocationListener;
            this.f43992c.requestLocationUpdates(this.f43997h, a);
            TrackLog.m31343d(f43991b, "register direct listener[" + this.f43997h.hashCode() + ":" + j + Const.jaRight);
        }
    }

    public void removeDirectNotifyLocationUpdates() {
        DIDILocationManager dIDILocationManager = this.f43992c;
        if (dIDILocationManager != null && this.f43996g != null) {
            this.f43996g = null;
            dIDILocationManager.removeLocationUpdates(this.f43997h);
        }
    }

    public void requestLocationUpdateOnce(final TrackLocationListener trackLocationListener) {
        DIDILocationManager dIDILocationManager = this.f43992c;
        if (dIDILocationManager != null) {
            dIDILocationManager.requestLocationUpdateOnce(new DIDILocationListener() {
                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    DIDILocationClient.this.m31331a(trackLocationListener, dIDILocation);
                    DIDILocationClient.this.m31332a((Integer) 0);
                }

                public void onLocationError(int i, ErrInfo errInfo) {
                    DIDILocationClient.this.m31330a(trackLocationListener, i, errInfo);
                    DIDILocationClient dIDILocationClient = DIDILocationClient.this;
                    if (errInfo != null) {
                        i = errInfo.getErrNo();
                    }
                    dIDILocationClient.m31332a(Integer.valueOf(i));
                }
            }, f43990a);
        }
    }

    public DIDILocation getLastLocation() {
        DIDILocationManager dIDILocationManager = this.f43992c;
        if (dIDILocationManager != null) {
            return dIDILocationManager.getLastKnownLocation();
        }
        return null;
    }

    public String getLastError() {
        return String.valueOf(m31326a());
    }

    public List<DIDILocation> getRecentLocations(int i) {
        return DIDILocBusinessHelper.getInstance().getRecentEffectiveLocations(5);
    }

    /* renamed from: a */
    private DIDILocationUpdateOption m31325a(long j, boolean z) {
        DIDILocationUpdateOption.IntervalMode a = m31324a(j);
        if (a == null) {
            return null;
        }
        DIDILocationUpdateOption dIDILocationUpdateOption = new DIDILocationUpdateOption();
        dIDILocationUpdateOption.setModuleKey(f43990a);
        dIDILocationUpdateOption.setInterval(a);
        dIDILocationUpdateOption.setDirectNotify(z);
        return dIDILocationUpdateOption;
    }

    /* renamed from: a */
    private DIDILocationUpdateOption.IntervalMode m31324a(long j) {
        for (DIDILocationUpdateOption.IntervalMode intervalMode : DIDILocationUpdateOption.IntervalMode.values()) {
            if (intervalMode.getValue() == j) {
                return intervalMode;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31331a(TrackLocationListener trackLocationListener, DIDILocation dIDILocation) {
        if (trackLocationListener != null) {
            trackLocationListener.onLocationChanged(LocUtils.buildLocationInfo(dIDILocation));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31330a(TrackLocationListener trackLocationListener, int i, ErrInfo errInfo) {
        if (trackLocationListener != null) {
            if (errInfo != null) {
                i = errInfo.getErrNo();
            }
            trackLocationListener.onLocationError(i, errInfo != null ? errInfo.getErrMessage() : "null");
        }
    }

    /* renamed from: a */
    private synchronized Integer m31326a() {
        return this.f43993d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m31332a(Integer num) {
        this.f43993d = num;
    }
}
