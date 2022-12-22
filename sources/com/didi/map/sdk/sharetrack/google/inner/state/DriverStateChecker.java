package com.didi.map.sdk.sharetrack.google.inner.state;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.sharetrack.logger.DLog;

public class DriverStateChecker {
    public static final String ACTION_DRIVER_SCTX_ERR = "action_driver_sctx_err";
    public static final String ACTION_LINK_STATE_OFFLINE = "action_link_state_offline";
    public static final String ACTION_LINK_STATE_ONLINE = "action_link_state_online";

    /* renamed from: a */
    private static final String f28879a = "DriverStateChecker";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f28880b;

    /* renamed from: c */
    private LatLng f28881c;

    /* renamed from: d */
    private final int f28882d = 180;

    /* renamed from: e */
    private Handler f28883e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private boolean f28884f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f28885g = false;

    /* renamed from: h */
    private final BroadcastReceiver f28886h = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent == null ? null : intent.getAction();
            if (action != null) {
                char c = 65535;
                int hashCode = action.hashCode();
                if (hashCode != 753754141) {
                    if (hashCode == 1657052505 && action.equals(DriverStateChecker.ACTION_LINK_STATE_OFFLINE)) {
                        c = 0;
                    }
                } else if (action.equals(DriverStateChecker.ACTION_LINK_STATE_ONLINE)) {
                    c = 1;
                }
                if (c == 0) {
                    PlatInfo.getInstance().setPushConnect(false);
                } else if (c == 1) {
                    PlatInfo.getInstance().setPushConnect(true);
                }
                DLog.m20357d(DriverStateChecker.f28879a, " || receive push connect action = " + action, new Object[0]);
            }
        }
    };

    /* renamed from: i */
    private Runnable f28887i = new Runnable() {
        public void run() {
            if (DriverStateChecker.this.f28880b != null && !DriverStateChecker.this.f28885g) {
                boolean unused = DriverStateChecker.this.f28885g = true;
                LocalBroadcastManager.getInstance(DriverStateChecker.this.f28880b).sendBroadcast(new Intent(DriverStateChecker.ACTION_DRIVER_SCTX_ERR));
                DLog.m20357d(DriverStateChecker.f28879a, " || broad ACTION_DRIVER_SCTX_ERR", new Object[0]);
            }
        }
    };

    public DriverStateChecker(Context context) {
        this.f28880b = context;
    }

    public void create() {
        if (this.f28880b != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_LINK_STATE_OFFLINE);
            intentFilter.addAction(ACTION_LINK_STATE_ONLINE);
            LocalBroadcastManager.getInstance(this.f28880b).registerReceiver(this.f28886h, intentFilter);
            m20351a();
        }
    }

    public void destroy() {
        Context context = this.f28880b;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f28886h);
            this.f28880b = null;
            m20353b();
            this.f28883e = null;
        }
    }

    public void onMatched(LatLng latLng, int i) {
        if (latLng != null) {
            LatLng latLng2 = this.f28881c;
            if (latLng2 != null && !latLng2.equals(latLng) && i >= 0 && PlatInfo.getInstance().isPushConnect()) {
                m20353b();
                m20351a();
            }
            this.f28881c = latLng;
        }
    }

    /* renamed from: a */
    private void m20351a() {
        Handler handler = this.f28883e;
        if (handler != null && !this.f28884f && !this.f28885g) {
            handler.postDelayed(this.f28887i, 180000);
            this.f28884f = true;
        }
    }

    /* renamed from: b */
    private void m20353b() {
        Handler handler = this.f28883e;
        if (handler != null) {
            handler.removeCallbacks(this.f28887i);
            this.f28884f = false;
        }
    }
}
