package com.didi.sdk.map;

import android.content.Context;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LocationPerformer {
    public static final int STATUS_DENIED = 2;
    public static final int STATUS_DISABLED = 0;
    public static final int STATUS_ENABLED = 1;
    public static final int STATUS_UNKNOWN = -1;

    /* renamed from: a */
    private static volatile LocationPerformer f36742a;

    /* renamed from: b */
    private Logger f36743b = LoggerFactory.getLogger("LocationPerformer");

    /* renamed from: c */
    private ArrayList<ILocation.ILocationChangedListener> f36744c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<ILocation.ILocateStatusListener> f36745d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<ILocation.ILocationErrorListener> f36746e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f36747f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DIDILocation f36748g;

    /* renamed from: h */
    private DIDILocation f36749h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f36750i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f36751j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f36752k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f36753l = 0;

    /* renamed from: m */
    private DIDILocationListener f36754m = new DIDILocationListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            DIDILocation unused = LocationPerformer.this.f36748g = dIDILocation;
            LocationPerformer.this.m26010a(dIDILocation);
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            LocationPerformer.this.m26006a(i, errInfo);
            if (errInfo != null) {
                int unused = LocationPerformer.this.f36750i = errInfo.getErrNo();
            }
        }

        public void onStatusUpdate(String str, int i, String str2) {
            if ("cell".equals(str)) {
                int unused = LocationPerformer.this.f36751j = i;
            } else if ("wifi".equals(str)) {
                int unused2 = LocationPerformer.this.f36752k = i;
            } else if ("gps".equals(str)) {
                int unused3 = LocationPerformer.this.f36753l = i;
            }
            if (i == 2) {
                boolean unused4 = LocationPerformer.this.f36747f = true;
            } else {
                boolean unused5 = LocationPerformer.this.f36747f = false;
            }
            LocationPerformer locationPerformer = LocationPerformer.this;
            locationPerformer.m26011a(str, locationPerformer.m26004a(str, i), str2);
        }
    };

    private LocationPerformer() {
    }

    public static LocationPerformer getInstance() {
        if (f36742a == null) {
            synchronized (LocationPerformer.class) {
                if (f36742a == null) {
                    f36742a = new LocationPerformer();
                }
            }
        }
        return f36742a;
    }

    public boolean isLocatable() {
        int i;
        if (this.f36752k == 0 || this.f36751j == 0 || (i = this.f36753l) == 768 || i == 0) {
            return true;
        }
        return false;
    }

    public void start(Context context) {
        m26007a(context);
    }

    public void stop(Context context) {
        m26014b(context);
    }

    public DIDILocation getLastKnownLocation(Context context) {
        return DIDILocationManager.getInstance(context).getLastKnownLocation();
    }

    public boolean isPermDenied() {
        return this.f36747f;
    }

    public DIDILocation getLastLocation() {
        return this.f36748g;
    }

    public int getLastErrNo() {
        return this.f36750i;
    }

    public void addLocationListener(ILocation.ILocationChangedListener iLocationChangedListener) {
        if (iLocationChangedListener != null) {
            synchronized (this.f36744c) {
                this.f36744c.add(iLocationChangedListener);
            }
            if (this.f36744c.size() == 1) {
                start(DIDIApplicationDelegate.getAppContext());
            }
        }
    }

    public void removeLocationListener(ILocation.ILocationChangedListener iLocationChangedListener) {
        synchronized (this.f36744c) {
            this.f36744c.remove(iLocationChangedListener);
        }
        if (this.f36744c.size() == 0) {
            stop(DIDIApplicationDelegate.getAppContext());
        }
    }

    public void addLocateStatusListener(ILocation.ILocateStatusListener iLocateStatusListener) {
        if (iLocateStatusListener != null) {
            synchronized (this.f36745d) {
                this.f36745d.add(iLocateStatusListener);
            }
        }
    }

    public void removeLocateStatusListener(ILocation.ILocateStatusListener iLocateStatusListener) {
        if (iLocateStatusListener != null) {
            synchronized (this.f36745d) {
                this.f36745d.remove(iLocateStatusListener);
            }
        }
    }

    public void addLocationErrorListener(ILocation.ILocationErrorListener iLocationErrorListener) {
        if (iLocationErrorListener != null) {
            synchronized (this.f36746e) {
                this.f36746e.add(iLocationErrorListener);
            }
        }
    }

    public void removeLocationErrorListener(ILocation.ILocationErrorListener iLocationErrorListener) {
        if (iLocationErrorListener != null) {
            synchronized (this.f36746e) {
                this.f36746e.remove(iLocationErrorListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26010a(DIDILocation dIDILocation) {
        ArrayList arrayList;
        synchronized (this.f36744c) {
            arrayList = new ArrayList();
            arrayList.addAll(this.f36744c);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ILocation.ILocationChangedListener) it.next()).onLocationChanged(dIDILocation);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26006a(int i, ErrInfo errInfo) {
        ArrayList arrayList;
        synchronized (this.f36744c) {
            arrayList = new ArrayList();
            arrayList.addAll(this.f36746e);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ILocation.ILocationErrorListener) it.next()).onLocationError(i, errInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26011a(String str, int i, String str2) {
        ArrayList arrayList;
        synchronized (this.f36745d) {
            arrayList = new ArrayList();
            arrayList.addAll(this.f36745d);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ILocation.ILocateStatusListener) it.next()).onStatusUpdate(str, i, str2);
        }
    }

    /* renamed from: a */
    private synchronized void m26007a(Context context) {
        this.f36743b.debug("startDidiLoc", new Object[0]);
        DIDILocationManager.getInstance(context).setAppid("grnp");
        DIDILocationManager.getInstance(context).setAppVersionName(SystemUtil.getVersionName(context));
        DIDILocationManager.getInstance(context).setApolloToggleName("ckck_locsdk_dd_v5");
        DIDILocationUpdateOption defaultLocationUpdateOption = DIDILocationManager.getInstance(context).getDefaultLocationUpdateOption();
        defaultLocationUpdateOption.setModuleKey("LocationPerformer");
        DIDILocationManager.getInstance(context).requestLocationUpdates(this.f36754m, defaultLocationUpdateOption);
    }

    /* renamed from: b */
    private synchronized void m26014b(final Context context) {
        this.f36743b.debug("stopDidiLoc", new Object[0]);
        DIDILocationManager.getInstance(context).removeLocationUpdates(this.f36754m);
        UiThreadHandler.post(new Runnable() {
            public void run() {
                if (DIDILocationManager.getInstance(context).isRunning()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("listener_info", DIDILocationManager.getInstance(context).getListenersInfo());
                    OmegaSDKAdapter.trackEvent("app_background_loc_unstop", (Map<String, Object>) hashMap);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0068 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m26004a(java.lang.String r7, int r8) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 102570(0x190aa, float:1.43731E-40)
            r2 = -1
            r3 = 0
            r4 = 2
            r5 = 1
            if (r0 == r1) goto L_0x002c
            r1 = 3049826(0x2e8962, float:4.273716E-39)
            if (r0 == r1) goto L_0x0022
            r1 = 3649301(0x37af15, float:5.11376E-39)
            if (r0 == r1) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r0 = "wifi"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0036
            r7 = 1
            goto L_0x0037
        L_0x0022:
            java.lang.String r0 = "cell"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0036
            r7 = 0
            goto L_0x0037
        L_0x002c:
            java.lang.String r0 = "gps"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0036
            r7 = 2
            goto L_0x0037
        L_0x0036:
            r7 = -1
        L_0x0037:
            if (r7 == 0) goto L_0x0062
            if (r7 == r5) goto L_0x0050
            if (r7 == r4) goto L_0x003e
            goto L_0x0068
        L_0x003e:
            if (r8 == 0) goto L_0x004f
            r7 = 256(0x100, float:3.59E-43)
            if (r8 == r7) goto L_0x004e
            r7 = 768(0x300, float:1.076E-42)
            if (r8 == r7) goto L_0x004f
            r7 = 1024(0x400, float:1.435E-42)
            if (r8 == r7) goto L_0x004d
            goto L_0x0068
        L_0x004d:
            return r4
        L_0x004e:
            return r3
        L_0x004f:
            return r5
        L_0x0050:
            if (r8 == 0) goto L_0x0061
            r7 = 16
            if (r8 == r7) goto L_0x0060
            r7 = 32
            if (r8 == r7) goto L_0x005f
            r7 = 64
            if (r8 == r7) goto L_0x0060
            goto L_0x0068
        L_0x005f:
            return r4
        L_0x0060:
            return r3
        L_0x0061:
            return r5
        L_0x0062:
            if (r8 == 0) goto L_0x006b
            if (r8 == r5) goto L_0x006a
            if (r8 == r4) goto L_0x0069
        L_0x0068:
            return r2
        L_0x0069:
            return r4
        L_0x006a:
            return r3
        L_0x006b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.map.LocationPerformer.m26004a(java.lang.String, int):int");
    }
}
