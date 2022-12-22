package com.didi.zxing.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;

public final class InactivityTimer {

    /* renamed from: a */
    private static final String f45478a = "InactivityTimer";

    /* renamed from: b */
    private static final long f45479b = 300000;

    /* renamed from: c */
    private final Context f45480c;

    /* renamed from: d */
    private final BroadcastReceiver f45481d;

    /* renamed from: e */
    private boolean f45482e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f45483f;

    /* renamed from: g */
    private Runnable f45484g;

    /* renamed from: h */
    private boolean f45485h;

    public InactivityTimer(Context context, Runnable runnable) {
        this.f45480c = context;
        this.f45484g = runnable;
        this.f45481d = new PowerStatusReceiver();
        this.f45483f = new Handler();
    }

    public void activity() {
        m32620c();
        if (this.f45485h) {
            this.f45483f.postDelayed(this.f45484g, 300000);
        }
    }

    public void start() {
        m32619b();
        activity();
    }

    public void cancel() {
        m32620c();
        m32616a();
    }

    /* renamed from: a */
    private void m32616a() {
        if (this.f45482e) {
            try {
                this.f45480c.unregisterReceiver(this.f45481d);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f45482e = false;
        }
    }

    /* renamed from: b */
    private void m32619b() {
        if (!this.f45482e) {
            try {
                this.f45480c.registerReceiver(this.f45481d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            this.f45482e = true;
        }
    }

    /* renamed from: c */
    private void m32620c() {
        this.f45483f.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32618a(boolean z) {
        this.f45485h = z;
        if (this.f45482e) {
            activity();
        }
    }

    private final class PowerStatusReceiver extends BroadcastReceiver {
        private PowerStatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z = intent.getIntExtra("plugged", -1) <= 0;
                InactivityTimer.this.f45483f.post(new Runnable() {
                    public void run() {
                        InactivityTimer.this.m32618a(z);
                    }
                });
            }
        }
    }
}
