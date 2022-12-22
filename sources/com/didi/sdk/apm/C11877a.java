package com.didi.sdk.apm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.view.View;
import com.didi.sdk.apm.utils.BackgroundThread;

/* renamed from: com.didi.sdk.apm.a */
/* compiled from: AppAutoCloser */
class C11877a implements Runnable {

    /* renamed from: a */
    private static final String f34965a = "AppAutoCloser";

    /* renamed from: b */
    private static final String f34966b = "close_delay";

    /* renamed from: c */
    private static final String f34967c = "close_type";

    /* renamed from: d */
    private static C11877a f34968d = null;

    /* renamed from: i */
    private static final int f34969i = 0;

    /* renamed from: j */
    private static final int f34970j = 1;

    /* renamed from: e */
    private Context f34971e;

    /* renamed from: f */
    private boolean f34972f;

    /* renamed from: g */
    private Handler f34973g = BackgroundThread.getHandler();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f34974h = 0;

    private C11877a() {
    }

    /* renamed from: a */
    public static synchronized C11877a m24714a() {
        C11877a aVar;
        synchronized (C11877a.class) {
            if (f34968d == null) {
                f34968d = new C11877a();
            }
            aVar = f34968d;
        }
        return aVar;
    }

    /* renamed from: a */
    public synchronized C11877a mo90303a(Context context) {
        if (this.f34972f) {
            return this;
        }
        this.f34972f = true;
        Context applicationContext = context.getApplicationContext();
        this.f34971e = applicationContext;
        if (applicationContext == null) {
            this.f34971e = context;
        }
        return f34968d;
    }

    /* renamed from: b */
    public void mo90304b() {
        AppStateMonitor.getInstance().registerStateListener(new AppAutoCloser$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m24715a(long j) {
        Log.i(f34965a, "scheduleClose: delay=" + j);
        this.f34973g.removeCallbacks(this);
        this.f34973g.postDelayed(this, j);
    }

    public void run() {
        if (this.f34974h == 0) {
            m24721e();
        }
        if (this.f34974h == 1) {
            m24722f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m24719c() {
        this.f34973g.post(new AppAutoCloser$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m24720d() {
        Log.i(f34965a, "removeSchedule ");
        this.f34973g.removeCallbacks(this);
    }

    /* renamed from: e */
    private void m24721e() {
        Log.i(f34965a, "closeNow ");
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    /* renamed from: f */
    private void m24722f() {
        Log.i(f34965a, "restartNow");
        try {
            Intent launchIntentForPackage = this.f34971e.getPackageManager().getLaunchIntentForPackage(this.f34971e.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(View.STATUS_BAR_TRANSIENT);
                launchIntentForPackage.addFlags(268435456);
                this.f34971e.startActivity(launchIntentForPackage);
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th) {
            Log.e(f34965a, "restartNow error: ", th);
        }
    }
}
