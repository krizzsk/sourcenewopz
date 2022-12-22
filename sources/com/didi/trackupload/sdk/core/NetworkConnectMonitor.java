package com.didi.trackupload.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.trackupload.sdk.utils.TrackLog;

public class NetworkConnectMonitor {

    /* renamed from: a */
    private static final String f37006a = "TrackNetMonitor";

    /* renamed from: b */
    private NetworkReceiver f37007b = new NetworkReceiver();

    /* renamed from: c */
    private Context f37008c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Boolean f37009d;

    /* renamed from: e */
    private long f37010e = 0;

    private static class SingletonHolder {
        static NetworkConnectMonitor INSTANCE = new NetworkConnectMonitor();

        private SingletonHolder() {
        }
    }

    public static NetworkConnectMonitor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        this.f37008c = context.getApplicationContext();
    }

    public void start() {
        if (this.f37008c != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
                try {
                    this.f37008c.registerReceiver(this.f37007b, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void stop() {
        Context context = this.f37008c;
        if (context != null) {
            try {
                try {
                    context.unregisterReceiver(this.f37007b);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26217a() {
        TrackLog.m31343d(f37006a, "onNetworkReconnected");
        if (SystemClock.elapsedRealtime() - this.f37010e > 40000) {
            TrackLog.m31343d(f37006a, "onNetworkReconnected run UploadCacheTask");
            CoreThread.post(new UploadCacheTask());
        }
        this.f37010e = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r2 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m26218a(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 == 0) goto L_0x001e
            android.net.NetworkInfo r2 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r2)
            if (r2 == 0) goto L_0x001e
            boolean r0 = r2.isAvailable()
            if (r0 == 0) goto L_0x001e
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x001e
            r2 = 1
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.NetworkConnectMonitor.m26218a(android.content.Context):boolean");
    }

    private class NetworkReceiver extends BroadcastReceiver {
        private NetworkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION.equals(intent.getAction())) {
                boolean a = NetworkConnectMonitor.this.m26218a(context);
                if (NetworkConnectMonitor.this.f37009d != null && !NetworkConnectMonitor.this.f37009d.booleanValue() && a) {
                    NetworkConnectMonitor.this.m26217a();
                }
                Boolean unused = NetworkConnectMonitor.this.f37009d = Boolean.valueOf(a);
            }
        }
    }
}
