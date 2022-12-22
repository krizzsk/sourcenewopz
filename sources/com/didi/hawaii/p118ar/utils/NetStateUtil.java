package com.didi.hawaii.p118ar.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.didi.hawaii.p118ar.jni.DARCNetworkStatus;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.hawaii.ar.utils.NetStateUtil */
public class NetStateUtil {
    public static final int NETWORK_MOBILE = 2;
    public static final int NETWORK_NONE = 0;
    public static final int NETWORK_WIFI = 1;

    /* renamed from: a */
    private static boolean f23325a = false;
    public static Context mContext = null;
    public static NetStateChangeListener mListener = null;
    public static final NetWorkStateReceiver netWorkStateReceiver = new NetWorkStateReceiver();

    /* renamed from: com.didi.hawaii.ar.utils.NetStateUtil$NetStateChangeListener */
    public interface NetStateChangeListener {
        void onStateChange(int i);
    }

    public static void init(Context context) {
        if (mContext == null && context != null) {
            mContext = context.getApplicationContext();
        }
    }

    public static int getNetworkState() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            i = 1;
            if (type == 1 || type == 9) {
                return i;
            }
            return 2;
        }
        return i;
    }

    public static DARCNetworkStatus convertNetworkeStateJava2AR(int i) {
        if (i == 0) {
            return DARCNetworkStatus.DARCNetworkStatus_NotReachable;
        }
        if (i == 1) {
            return DARCNetworkStatus.DARCNetworkStatus_ReachableViaWiFi;
        }
        if (i != 2) {
            return null;
        }
        return DARCNetworkStatus.DARCNetworkStatus_ReachableViaWWAN;
    }

    public static void startListenNetWorkerState(NetStateChangeListener netStateChangeListener) {
        mListener = netStateChangeListener;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.didi.dimina.container.bridge.network.NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        try {
            mContext.registerReceiver(netWorkStateReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        f23325a = true;
    }

    public static void stopListenNetWorkerState() {
        if (f23325a) {
            try {
                mContext.unregisterReceiver(netWorkStateReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            f23325a = false;
        }
        mListener = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNetConnected(android.content.Context r1) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            if (r1 == 0) goto L_0x0020
            android.net.NetworkInfo r1 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r1)
            if (r1 == 0) goto L_0x0020
            boolean r0 = r1.isConnected()
            if (r0 == 0) goto L_0x0020
            android.net.NetworkInfo$State r1 = r1.getState()
            android.net.NetworkInfo$State r0 = android.net.NetworkInfo.State.CONNECTED
            if (r1 != r0) goto L_0x0020
            r1 = 1
            return r1
        L_0x0020:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.NetStateUtil.isNetConnected(android.content.Context):boolean");
    }

    public static synchronized boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        int type;
        synchronized (NetStateUtil.class) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null || ((type = activeNetworkInfo.getType()) != 1 && type != 9)) {
                return false;
            }
            boolean isConnected = activeNetworkInfo.isConnected();
            return isConnected;
        }
    }

    /* renamed from: com.didi.hawaii.ar.utils.NetStateUtil$NetWorkStateReceiver */
    static class NetWorkStateReceiver extends BroadcastReceiver {
        NetWorkStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            NetStateUtil.mListener.onStateChange(NetStateUtil.getNetworkState());
        }
    }
}
