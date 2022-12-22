package com.didichuxing.bigdata.p173dp.locsdk.ntp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.ITimeServiceScheduler;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager */
public class TimeServiceManager {

    /* renamed from: a */
    private static final String f46024a = "TimeServiceManager ";

    /* renamed from: f */
    private static final int f46025f = 4;

    /* renamed from: b */
    private InnerTimeServiceImpl f46026b;

    /* renamed from: c */
    private InnerTimeServiceImpl f46027c;

    /* renamed from: d */
    private TimeServiceScheduler f46028d;

    /* renamed from: e */
    private SyncNTPReceiver f46029e;

    /* renamed from: g */
    private int f46030g;

    /* renamed from: h */
    private int f46031h;

    /* renamed from: i */
    private ITimeServiceScheduler.OnTimeScheduleListener f46032i;

    private TimeServiceManager() {
        this.f46030g = 1;
        this.f46031h = 0;
        this.f46032i = new ITimeServiceScheduler.OnTimeScheduleListener() {
            public void onTimeTick(Context context) {
                DLog.m32737d("TimeServiceManager onTimeTick called");
                if (TimeServiceManager.this.m33046c()) {
                    TimeServiceManager.this.m33039a(context, "time_tick_retry");
                }
            }
        };
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager$SingletonHolder */
    private static class SingletonHolder {
        static final TimeServiceManager INSTANCE = new TimeServiceManager();

        private SingletonHolder() {
        }
    }

    public static TimeServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start(Context context, boolean z) {
        boolean isNTPEnabled = ApolloProxy.getInstance().isNTPEnabled();
        int nTPStatLocPercent = ApolloProxy.getInstance().getNTPStatLocPercent();
        DLog.m32737d("TimeServiceManager start context=" + context + " apolloEnabled=" + isNTPEnabled + " ntpLocStatPercent=" + nTPStatLocPercent);
        if (context != null && isNTPEnabled) {
            if (this.f46028d == null) {
                TimeServiceScheduler timeServiceScheduler = new TimeServiceScheduler(context);
                this.f46028d = timeServiceScheduler;
                timeServiceScheduler.setOnTimeScheduleListener(this.f46032i);
                this.f46028d.start();
                DLog.m32737d("TimeServiceManager TimeTicker started");
            }
            if (this.f46026b == null) {
                this.f46026b = new InnerTimeServiceImpl(context, z);
            }
            InnerTimeServiceImpl innerTimeServiceImpl = this.f46026b;
            if (innerTimeServiceImpl != null) {
                this.f46030g = 1;
                this.f46031h = 0;
                innerTimeServiceImpl.mo114606a();
                m33040a(this.f46026b);
                m33039a(context, "start_service");
                m33038a(context);
            }
        }
    }

    public void stop(Context context) {
        DLog.m32737d("TimeServiceManager stop context=" + context);
        if (context != null) {
            m33044b(context);
            m33040a((InnerTimeServiceImpl) null);
        }
        TimeServiceScheduler timeServiceScheduler = this.f46028d;
        if (timeServiceScheduler != null) {
            timeServiceScheduler.stop();
        }
    }

    public boolean isNTPEnabled() {
        return m33037a() != null;
    }

    public boolean isNTPAvailable() {
        InnerTimeServiceImpl a = m33037a();
        return a != null && a.isAvailable();
    }

    public long getNTPCurrenTimeMillis() {
        return System.currentTimeMillis() + getNTPTimeDiffMillis();
    }

    public long getNTPTimeDiffMillis() {
        InnerTimeServiceImpl a = m33037a();
        if (a != null) {
            return a.mo114610c();
        }
        return 0;
    }

    public void updateStandardTimeRef(TimeSource timeSource, long j) {
        InnerTimeServiceImpl a = m33037a();
        if (a != null) {
            a.mo114607a(timeSource, j);
        }
    }

    /* renamed from: a */
    private synchronized InnerTimeServiceImpl m33037a() {
        return this.f46027c;
    }

    /* renamed from: a */
    private synchronized void m33040a(InnerTimeServiceImpl innerTimeServiceImpl) {
        this.f46027c = innerTimeServiceImpl;
    }

    /* renamed from: a */
    private void m33038a(Context context) {
        if (this.f46029e == null) {
            this.f46029e = new SyncNTPReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
            try {
                try {
                    context.registerReceiver(this.f46029e, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            } catch (Exception e2) {
                DLog.m32737d("TimeServiceManager registerReceiver error=" + e2.getMessage());
            }
        }
    }

    /* renamed from: b */
    private void m33044b(Context context) {
        SyncNTPReceiver syncNTPReceiver = this.f46029e;
        if (syncNTPReceiver != null) {
            try {
                context.unregisterReceiver(syncNTPReceiver);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (Exception e2) {
                    DLog.m32737d("TimeServiceManager unregisterReceiver error=" + e2.getMessage());
                }
            }
            this.f46029e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33043b() {
        InnerTimeServiceImpl a = m33037a();
        if (a != null) {
            a.mo114611d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33039a(Context context, String str) {
        if (context == null) {
            DLog.m32737d("TimeServiceManager syncNTPNetworkTime context is null");
            return;
        }
        boolean c = m33047c(context);
        InnerTimeServiceImpl a = m33037a();
        StringBuilder sb = new StringBuilder();
        sb.append("TimeServiceManager syncNTPNetworkTime scene=");
        sb.append(str);
        sb.append(" netAvailable=");
        sb.append(c);
        sb.append(" serviceAvailable=");
        sb.append(a != null);
        DLog.m32737d(sb.toString());
        if (c && a != null) {
            a.mo114608a(str);
        }
    }

    /* renamed from: c */
    private boolean m33047c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m33046c() {
        if (isNTPAvailable()) {
            return false;
        }
        int i = this.f46031h + 1;
        this.f46031h = i;
        int i2 = this.f46030g;
        if (i % i2 != 0) {
            return false;
        }
        if (i2 < 4) {
            this.f46030g = i2 << 1;
        }
        return true;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager$SyncNTPReceiver */
    private class SyncNTPReceiver extends BroadcastReceiver {
        private SyncNTPReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            DLog.m32737d("TimeServiceManager SyncNTPReceiver onReceive action=" + action);
            if (action != null) {
                char c = 65535;
                int hashCode = action.hashCode();
                if (hashCode != -1172645946) {
                    if (hashCode != 502473491) {
                        if (hashCode == 505380757 && action.equals("android.intent.action.TIME_SET")) {
                            c = 0;
                        }
                    } else if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                        c = 1;
                    }
                } else if (action.equals(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION)) {
                    c = 2;
                }
                if (c == 0 || c == 1) {
                    TimeServiceManager.this.m33043b();
                    TimeServiceManager.this.m33039a(context, "time_changed");
                } else if (c == 2) {
                    TimeServiceManager.this.m33039a(context, "net_changed");
                }
            }
        }
    }
}
