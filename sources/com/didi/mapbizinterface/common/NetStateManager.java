package com.didi.mapbizinterface.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.didi.mapbizinterface.utils.ReflectUtils;
import com.didi.sdk.apm.SystemUtils;
import com.sdu.didi.protobuf.NetworkState;

public class NetStateManager {

    /* renamed from: a */
    private ConnectivityManager f29070a;

    /* renamed from: b */
    private WifiManager f29071b;

    /* renamed from: c */
    private TelephonyManager f29072c;

    /* renamed from: d */
    private SimStateListener f29073d;

    private NetStateManager() {
    }

    private static class SingletonHolder {
        static NetStateManager INSTANCE = new NetStateManager();

        private SingletonHolder() {
        }
    }

    public static NetStateManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f29070a = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            this.f29071b = (WifiManager) applicationContext.getSystemService("wifi");
            this.f29072c = (TelephonyManager) applicationContext.getSystemService("phone");
            SimStateListener simStateListener = new SimStateListener();
            this.f29073d = simStateListener;
            this.f29072c.listen(simStateListener, 321);
        }
    }

    private class SimStateListener extends PhoneStateListener {
        private static final int DEFAULT_LEVEL_COUNT = 5;
        private int mSimSignalLevel;
        private int mSimSignalLevelCount = 5;

        public void onDataConnectionStateChanged(int i) {
        }

        SimStateListener() {
            try {
                this.mSimSignalLevelCount = ReflectUtils.getIntField(SignalStrength.class, (Object) null, "NUM_SIGNAL_STRENGTH_BINS", 5);
            } catch (Exception unused) {
            }
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            try {
                this.mSimSignalLevel = ReflectUtils.invokeMethodReturnInt(SignalStrength.class, signalStrength, "getLevel", 0, new Object[0]);
            } catch (Exception unused) {
            }
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            int state = serviceState.getState();
            if (state == 1 || state == 3) {
                this.mSimSignalLevel = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int getSimSignalLevelPercent() {
            int i;
            int i2 = this.mSimSignalLevelCount;
            if (i2 <= 0 || (i = this.mSimSignalLevel) < 0) {
                return -1;
            }
            if (i < i2) {
                return ((i + 1) * 100) / i2;
            }
            return 100;
        }
    }

    /* renamed from: a */
    private boolean m20487a() {
        ConnectivityManager connectivityManager = this.f29070a;
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    private int m20488b() {
        WifiManager wifiManager = this.f29071b;
        if (wifiManager == null) {
            return -1;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                return WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 101);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: c */
    private int m20489c() {
        SimStateListener simStateListener = this.f29073d;
        if (simStateListener != null) {
            return simStateListener.getSimSignalLevelPercent();
        }
        return -1;
    }

    public int getSignalLevel() {
        if (m20487a()) {
            return m20488b();
        }
        return m20489c();
    }

    public NetworkState getNetworkState() {
        ConnectivityManager connectivityManager = this.f29070a;
        if (!(connectivityManager == null || this.f29072c == null)) {
            try {
                NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    return NetworkState.NET_WIFI;
                }
                switch (this.f29072c.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return NetworkState.NET_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return NetworkState.NET_3G;
                    case 13:
                        return NetworkState.NET_4G;
                }
            } catch (Exception unused) {
            }
        }
        return NetworkState.NET_UNKNOWN;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isNetAvailable() {
        /*
            r2 = this;
            android.net.ConnectivityManager r0 = r2.f29070a
            if (r0 == 0) goto L_0x0018
            android.net.NetworkInfo r0 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r0)
            if (r0 == 0) goto L_0x0018
            boolean r1 = r0.isAvailable()
            if (r1 == 0) goto L_0x0018
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.mapbizinterface.common.NetStateManager.isNetAvailable():boolean");
    }
}
