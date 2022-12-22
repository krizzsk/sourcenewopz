package com.didichuxing.bigdata.p173dp.locsdk.once;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.IWifiManagerWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.Reflect;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.OmegaUtils;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper */
public class WifiManagerWrapper implements IWifiManagerWrapper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WifiManager f46129a;

    /* renamed from: b */
    private Context f46130b;

    /* renamed from: c */
    private boolean f46131c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile long f46132d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f46133e;

    /* renamed from: f */
    private long f46134f;

    /* renamed from: g */
    private long f46135g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f46136h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f46137i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f46138j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Runnable f46139k;

    /* renamed from: l */
    private BroadcastReceiver f46140l;

    /* renamed from: m */
    private BroadcastReceiver f46141m;

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void destroy() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r0 = r4.f46130b     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0044
            android.content.BroadcastReceiver r0 = r4.f46140l     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0044
            boolean r0 = r4.f46131c     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x000e
            goto L_0x0044
        L_0x000e:
            r4.m33141e()     // Catch:{ all -> 0x0046 }
            r0 = 0
            android.content.Context r1 = r4.f46130b     // Catch:{ Exception -> 0x0025 }
            android.content.BroadcastReceiver r2 = r4.f46140l     // Catch:{ Exception -> 0x0025 }
            r1.unregisterReceiver(r2)     // Catch:{ Exception -> 0x001a }
            goto L_0x0022
        L_0x001a:
            r1 = move-exception
            java.lang.String r2 = "Context"
            java.lang.String r3 = "unregisterReceiver"
            android.util.Log.d(r2, r3, r1)     // Catch:{ Exception -> 0x0025 }
        L_0x0022:
            r4.f46140l = r0     // Catch:{ Exception -> 0x0025 }
            goto L_0x002d
        L_0x0025:
            r1 = move-exception
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0046 }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)     // Catch:{ all -> 0x0046 }
        L_0x002d:
            com.didichuxing.bigdata.dp.locsdk.once.ThreadDispatcher$IThreadDispatcher r1 = com.didichuxing.bigdata.p173dp.locsdk.once.ThreadDispatcher.getWorkThread()     // Catch:{ all -> 0x0046 }
            java.lang.Runnable r2 = r4.f46139k     // Catch:{ all -> 0x0046 }
            r1.removeCallbacks((java.lang.Runnable) r2)     // Catch:{ all -> 0x0046 }
            r1 = 0
            r4.f46138j = r1     // Catch:{ all -> 0x0046 }
            r4.m33132a()     // Catch:{ all -> 0x0046 }
            r4.f46129a = r0     // Catch:{ all -> 0x0046 }
            r4.f46130b = r0     // Catch:{ all -> 0x0046 }
            r4.f46131c = r1     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return
        L_0x0044:
            monitor-exit(r4)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.destroy():void");
    }

    /* renamed from: a */
    private void m33132a() {
        this.f46133e = 15000;
        this.f46134f = 0;
        this.f46135g = 120000;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper$SingletonHolder */
    private static class SingletonHolder {
        static final WifiManagerWrapper sInstance = new WifiManagerWrapper();

        private SingletonHolder() {
        }
    }

    public static WifiManagerWrapper getInstance() {
        return SingletonHolder.sInstance;
    }

    private WifiManagerWrapper() {
        this.f46131c = false;
        this.f46132d = 0;
        this.f46133e = 15000;
        this.f46134f = 0;
        this.f46135g = 120000;
        this.f46136h = 120000;
        this.f46137i = 0;
        this.f46138j = false;
        this.f46139k = new Runnable() {
            public void run() {
                if (WifiManagerWrapper.this.f46129a != null && ThreadDispatcher.getWorkThread().isAlive()) {
                    long currentTimeMillis = System.currentTimeMillis() - WifiManagerWrapper.this.f46137i;
                    if ((currentTimeMillis >= WifiManagerWrapper.this.f46133e && currentTimeMillis <= WifiManagerWrapper.this.f46136h) || WifiManagerWrapper.this.f46137i == 0) {
                        try {
                            WifiManagerWrapper.this.m33136b();
                        } catch (SecurityException e) {
                            DLog.m32737d("scanWifiLoop exception, " + e.getMessage());
                            StatusBroadcastManager.getInstance().broadcastStatus("wifi", 32);
                        }
                    }
                    if (WifiManagerWrapper.this.f46138j && ThreadDispatcher.getWorkThread().isAlive()) {
                        ThreadDispatcher.getWorkThread().postDelayed(WifiManagerWrapper.this.f46139k, WifiManagerWrapper.this.f46133e / 2);
                    }
                }
            }
        };
    }

    public synchronized void init(Context context) {
        if (!this.f46131c) {
            this.f46130b = context;
            this.f46129a = (WifiManager) Utils.getServ(context, "wifi");
            m33138c();
            enableWifiAlwaysScan(true);
            try {
                m33136b();
                this.f46132d = System.currentTimeMillis();
            } catch (SecurityException e) {
                DLog.m32737d("initWifiManager exception, " + e.getMessage());
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            intentFilter.addAction("android.location.GPS_FIX_CHANGE");
            intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
            try {
                WifiReceiver wifiReceiver = new WifiReceiver();
                this.f46140l = wifiReceiver;
                this.f46130b.registerReceiver(wifiReceiver, intentFilter, (String) null, ThreadDispatcher.getWorkThread().getHandler());
            } catch (SecurityException e2) {
                DLog.m32737d("initWifiManager exception, " + e2.getMessage());
            }
            m33140d();
            if (ThreadDispatcher.getWorkThread().isAlive()) {
                ThreadDispatcher.getWorkThread().post(this.f46139k);
                this.f46138j = true;
            }
            this.f46131c = true;
        }
    }

    public List<ScanResult> getScanResults() {
        WifiManager wifiManager = this.f46129a;
        if (wifiManager == null) {
            return null;
        }
        try {
            return wifiManager.getScanResults();
        } catch (Exception unused) {
            return null;
        }
    }

    public WifiInfo getConnectionInfo() {
        WifiManager wifiManager = this.f46129a;
        if (wifiManager == null) {
            return null;
        }
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public int getWifiState() {
        WifiManager wifiManager = this.f46129a;
        if (wifiManager == null) {
            return 4;
        }
        try {
            return wifiManager.getWifiState();
        } catch (Exception unused) {
            return 4;
        }
    }

    public boolean startScan() {
        WifiManager wifiManager = this.f46129a;
        if (wifiManager == null) {
            return false;
        }
        try {
            return wifiManager.startScan();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean startScanActive() {
        if (Build.VERSION.SDK_INT <= 17) {
            try {
                return String.valueOf(Reflect.invokeMethod(this.f46129a, "startScanActive", new Object[0])).equals("true");
            } catch (Exception e) {
                OmegaUtils.trackReflectError(e, "startScanActive");
            }
        }
        return false;
    }

    public boolean wifiAccess(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.f46129a;
        if (wifiManager == null || !wifiEnabled()) {
            return false;
        }
        try {
            if (Utils.getNetT(SystemUtils.getActiveNetworkInfo(connectivityManager)) != 1 || !m33133a(wifiManager.getConnectionInfo())) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean wifiEnabled() {
        WifiManager wifiManager = this.f46129a;
        boolean z = false;
        if (wifiManager == null) {
            return false;
        }
        try {
            z = wifiManager.isWifiEnabled();
        } catch (Exception unused) {
        }
        if (z || Utils.getSdk() <= 17) {
            return z;
        }
        try {
            return wifiManager.isScanAlwaysAvailable();
        } catch (Exception e) {
            OmegaUtils.trackReflectError(e, "wifiEnabled");
            DLog.m32737d(e.toString());
            return z;
        }
    }

    public void enableWifiAlwaysScan(boolean z) {
        Context context = this.f46130b;
        if (this.f46129a != null && context != null && z && Build.VERSION.SDK_INT > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                int i = Settings.Global.getInt(contentResolver, "wifi_scan_always_enabled");
                if (i == 0) {
                    Settings.Global.putInt(contentResolver, "wifi_scan_always_enabled", 1);
                }
                DLog.m32737d("wifi| always scan :" + i);
            } catch (Exception e) {
                DLog.m32737d("wifi| always scan Exception :" + e.toString());
            }
        }
    }

    /* renamed from: a */
    private boolean m33133a(WifiInfo wifiInfo) {
        if (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getBSSID()) || wifiInfo.getSSID() == null || wifiInfo.getBSSID().equals("00:00:00:00:00:00") || wifiInfo.getBSSID().contains(" :") || TextUtils.isEmpty(wifiInfo.getSSID())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33136b() {
        if (wifiEnabled()) {
            boolean z = false;
            try {
                z = startScanActive();
                if (z) {
                    DLog.m32737d("start wifi active scan success");
                }
            } catch (Exception unused) {
                DLog.m32737d("start wifi active scan failed");
            }
            if (!z) {
                try {
                    startScan();
                } catch (Exception unused2) {
                    DLog.m32737d("start wifi scan failed");
                }
            }
        }
    }

    /* renamed from: c */
    private void m33138c() {
        long[] requestRefreshWifiParams = ApolloProxy.requestRefreshWifiParams();
        if (requestRefreshWifiParams != null) {
            this.f46133e = requestRefreshWifiParams[0];
            this.f46135g = requestRefreshWifiParams[1];
            this.f46134f = requestRefreshWifiParams[2];
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper$WifiReceiver */
    private class WifiReceiver extends BroadcastReceiver {
        private WifiReceiver() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                if (r5 == 0) goto L_0x0022
                java.lang.String r0 = r5.getAction()
                java.lang.String r1 = "android.net.wifi.SCAN_RESULTS"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0022
                com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper r4 = com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.this
                long r0 = java.lang.System.currentTimeMillis()
                long unused = r4.f46137i = r0
                com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper r4 = com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.this
                long r0 = java.lang.System.currentTimeMillis()
                long unused = r4.f46132d = r0
                goto L_0x00e0
            L_0x0022:
                r0 = 0
                if (r5 == 0) goto L_0x0079
                java.lang.String r1 = r5.getAction()
                java.lang.String r2 = "android.net.wifi.WIFI_STATE_CHANGED"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0079
                com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper r4 = com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.this
                android.net.wifi.WifiManager r4 = r4.f46129a
                if (r4 == 0) goto L_0x00e0
                com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper r4 = com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.this     // Catch:{ SecurityException -> 0x0048 }
                android.net.wifi.WifiManager r4 = r4.f46129a     // Catch:{ SecurityException -> 0x0048 }
                int r4 = r4.getWifiState()     // Catch:{ SecurityException -> 0x0048 }
                r5 = 3
                if (r4 != r5) goto L_0x0048
                r4 = 1
                goto L_0x0049
            L_0x0048:
                r4 = 0
            L_0x0049:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r1 = "wifi enable state change: "
                r5.append(r1)
                r5.append(r4)
                java.lang.String r5 = r5.toString()
                com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r5)
                java.lang.String r5 = "wifi"
                if (r4 == 0) goto L_0x006f
                com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper r4 = com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.this
                r4.m33136b()
                com.didichuxing.bigdata.dp.locsdk.once.StatusBroadcastManager r4 = com.didichuxing.bigdata.p173dp.locsdk.once.StatusBroadcastManager.getInstance()
                r4.broadcastStatus(r5, r0)
                goto L_0x00e0
            L_0x006f:
                com.didichuxing.bigdata.dp.locsdk.once.StatusBroadcastManager r4 = com.didichuxing.bigdata.p173dp.locsdk.once.StatusBroadcastManager.getInstance()
                r0 = 16
                r4.broadcastStatus(r5, r0)
                goto L_0x00e0
            L_0x0079:
                if (r5 == 0) goto L_0x00a5
                java.lang.String r1 = r5.getAction()
                java.lang.String r2 = "android.location.PROVIDERS_CHANGED"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x00a5
                com.didichuxing.bigdata.dp.locsdk.SensorMonitor r4 = com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor.getInstance(r4)
                boolean r4 = r4.isGpsEnabled()
                java.lang.String r5 = "gps"
                if (r4 == 0) goto L_0x009b
                com.didichuxing.bigdata.dp.locsdk.once.StatusBroadcastManager r4 = com.didichuxing.bigdata.p173dp.locsdk.once.StatusBroadcastManager.getInstance()
                r4.broadcastStatus(r5, r0)
                goto L_0x00e0
            L_0x009b:
                com.didichuxing.bigdata.dp.locsdk.once.StatusBroadcastManager r4 = com.didichuxing.bigdata.p173dp.locsdk.once.StatusBroadcastManager.getInstance()
                r0 = 256(0x100, float:3.59E-43)
                r4.broadcastStatus(r5, r0)
                goto L_0x00e0
            L_0x00a5:
                if (r5 == 0) goto L_0x00b9
                java.lang.String r4 = r5.getAction()
                java.lang.String r0 = "android.intent.action.AIRPLANE_MODE"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x00b9
                java.lang.String r4 = "AIRPLANE_MODE change"
                com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r4)
                goto L_0x00e0
            L_0x00b9:
                if (r5 == 0) goto L_0x00cd
                java.lang.String r4 = r5.getAction()
                java.lang.String r0 = "android.location.GPS_FIX_CHANGE"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x00cd
                java.lang.String r4 = "GPS_FIX_CHANGE"
                com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r4)
                goto L_0x00e0
            L_0x00cd:
                if (r5 == 0) goto L_0x00e0
                java.lang.String r4 = r5.getAction()
                java.lang.String r5 = "android.net.conn.CONNECTIVITY_CHANGE"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x00e0
                java.lang.String r4 = "connectivity changed"
                com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r4)
            L_0x00e0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.WifiReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper$SystemEventReceiver */
    private class SystemEventReceiver extends BroadcastReceiver {
        private SystemEventReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                DLog.m32737d("screen on");
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                DLog.m32737d("screen off");
            }
        }
    }

    /* renamed from: d */
    private void m33140d() {
        if (this.f46130b != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            try {
                SystemEventReceiver systemEventReceiver = new SystemEventReceiver();
                this.f46141m = systemEventReceiver;
                try {
                    this.f46130b.registerReceiver(systemEventReceiver, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            } catch (Exception e2) {
                DLog.m32737d("registerSystemEventListener exception, " + e2.getMessage());
            }
        }
    }

    /* renamed from: e */
    private void m33141e() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f46130b;
        if (context != null && (broadcastReceiver = this.f46141m) != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (Exception e2) {
                    DLog.m32737d(e2.toString());
                    return;
                }
            }
            this.f46141m = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
        if (r6.matches("0+") != false) goto L_0x002b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didichuxing.bigdata.p173dp.locsdk.once.LocDataDef.LocWifiInfo> mo114730a(boolean r19) {
        /*
            r18 = this;
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.wifi.WifiInfo r2 = r18.getConnectionInfo()
            java.lang.String r3 = "0+"
            java.lang.String r4 = ":"
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x002b
            java.lang.String r6 = r2.getBSSID()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x002b
            java.lang.String r6 = r6.replace(r4, r5)
            java.lang.String r6 = r6.toLowerCase()
            boolean r7 = r6.matches(r3)
            if (r7 == 0) goto L_0x002c
        L_0x002b:
            r6 = r5
        L_0x002c:
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = r0.f46132d
            long r7 = r7 - r9
            long r9 = r0.f46135g
            r11 = 0
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 > 0) goto L_0x003f
            java.util.List r7 = r18.getScanResults()
            goto L_0x0040
        L_0x003f:
            r7 = r11
        L_0x0040:
            if (r7 == 0) goto L_0x00d5
            int r8 = r7.size()
            if (r8 <= 0) goto L_0x00d5
            java.util.Iterator r7 = r7.iterator()
        L_0x004c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00d5
            java.lang.Object r8 = r7.next()
            android.net.wifi.ScanResult r8 = (android.net.wifi.ScanResult) r8
            if (r8 != 0) goto L_0x005b
            goto L_0x004c
        L_0x005b:
            java.lang.String r9 = r8.BSSID
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x0064
            goto L_0x004c
        L_0x0064:
            com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocWifiInfo r9 = new com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocWifiInfo
            r9.<init>()
            java.lang.String r10 = r8.BSSID
            java.lang.String r10 = r10.replace(r4, r5)
            java.lang.String r10 = r10.toLowerCase()
            r9.mac = r10
            int r10 = r8.level
            long r12 = (long) r10
            r9.level = r12
            java.lang.String r10 = r9.mac
            java.lang.String r10 = r10.toLowerCase()
            boolean r10 = r10.equals(r6)
            r9.connect = r10
            if (r19 == 0) goto L_0x008b
            java.lang.String r10 = r8.SSID
            goto L_0x008c
        L_0x008b:
            r10 = r11
        L_0x008c:
            r9.ssid = r10
            java.lang.String r10 = r9.mac
            boolean r10 = r10.matches(r3)
            if (r10 == 0) goto L_0x0097
            goto L_0x004c
        L_0x0097:
            r1.add(r9)
            int r10 = android.os.Build.VERSION.SDK_INT
            r12 = 17
            if (r10 < r12) goto L_0x00cd
            long r12 = com.didichuxing.bigdata.p173dp.locsdk.once.Utils.getTimeBoot()
            long r14 = r8.timestamp
            r16 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 / r16
            long r12 = r12 - r14
            r9.time_diff = r12
            long r12 = r9.time_diff
            r14 = 0
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x00b8
            long r12 = r9.time_diff
            goto L_0x00ba
        L_0x00b8:
            r12 = -1
        L_0x00ba:
            r9.time_diff = r12
            long r12 = r0.f46134f
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x00cd
            long r12 = r9.time_diff
            long r14 = r0.f46134f
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x00cd
            r1.remove(r9)
        L_0x00cd:
            int r8 = r1.size()
            r9 = 30
            if (r8 < r9) goto L_0x004c
        L_0x00d5:
            int r3 = r1.size()
            if (r3 != 0) goto L_0x010d
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            if (r3 != 0) goto L_0x010d
            if (r2 == 0) goto L_0x010d
            boolean r3 = com.didichuxing.bigdata.p173dp.locsdk.once.Utils.needCheckAppPermissionStrategy()
            if (r3 == 0) goto L_0x00f1
            android.content.Context r3 = r0.f46130b
            boolean r3 = com.didichuxing.bigdata.p173dp.locsdk.once.Utils.isLocatePermissionGrantedForWifiScan(r3)
            if (r3 == 0) goto L_0x010d
        L_0x00f1:
            com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocWifiInfo r3 = new com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocWifiInfo
            r3.<init>()
            r3.mac = r6
            int r4 = r2.getRssi()
            long r4 = (long) r4
            r3.level = r4
            r4 = 1
            r3.connect = r4
            if (r19 == 0) goto L_0x0108
            java.lang.String r11 = r2.getSSID()
        L_0x0108:
            r3.ssid = r11
            r1.add(r3)
        L_0x010d:
            com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper$2 r2 = new com.didichuxing.bigdata.dp.locsdk.once.WifiManagerWrapper$2
            r2.<init>()
            java.util.Collections.sort(r1, r2)
            android.net.wifi.WifiManager r2 = r0.f46129a
            if (r2 == 0) goto L_0x0124
            android.content.Context r3 = r0.f46130b
            if (r3 == 0) goto L_0x0124
            int r2 = r2.getWifiState()
            com.didichuxing.bigdata.p173dp.locsdk.once.util.OmegaUtils.trackWifiInfos(r3, r2)
        L_0x0124:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.once.WifiManagerWrapper.mo114730a(boolean):java.util.List");
    }

    public void updateWifiScanInterval(long j) {
        if (Apollo.getToggle(Const.APOLLO_REDUCE_INNER_FREQUECY).allow() && j > 15000) {
            this.f46133e = j;
            this.f46136h = j + 60000;
        }
    }
}
