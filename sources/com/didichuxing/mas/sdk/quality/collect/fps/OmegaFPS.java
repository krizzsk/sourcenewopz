package com.didichuxing.mas.sdk.quality.collect.fps;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.WindowManager;
import com.didichuxing.mas.sdk.quality.collect.lag.OmegaLag;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeListener;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class OmegaFPS {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static Map<Long, Integer> f48087f = null;

    /* renamed from: g */
    private static boolean f48088g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static float f48089h = 60.0f;

    /* renamed from: j */
    private static OmegaFPS f48090j;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f48091a = 0;

    /* renamed from: b */
    private Timer f48092b = new Timer(true);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f48093c = 0;

    /* renamed from: d */
    private Timer f48094d = new Timer(true);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f48095e = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f48096i = false;

    /* renamed from: k */
    private AppStateMonitor.AppStateListener f48097k;

    /* renamed from: l */
    private ScreenChangeListener f48098l;

    private OmegaFPS() {
        f48087f = new LinkedHashMap<Long, Integer>() {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
                return size() > MASConfig.FPS_LATEST_CACHE_NUM;
            }
        };
    }

    /* renamed from: c */
    private void m34301c() {
        this.f48097k = new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
                OmegaFPS.this.resume();
            }

            public void onInBackground() {
                OmegaFPS.this.pause();
                boolean unused = OmegaFPS.this.f48096i = true;
            }
        };
        this.f48098l = new ScreenChangeListener() {
            public void screenOn() {
            }

            public void screenOff() {
                OmegaFPS.this.pause();
                boolean unused = OmegaFPS.this.f48096i = true;
            }
        };
        AppStateMonitor.getInstance().registerAppStateListener(this.f48097k);
        ScreenChangeReceiver.addScreenChangeListener(this.f48098l);
    }

    /* renamed from: d */
    private void m34303d() {
        if (this.f48097k != null) {
            AppStateMonitor.getInstance().unregisterAppStateListener(this.f48097k);
            this.f48097k = null;
        }
        ScreenChangeListener screenChangeListener = this.f48098l;
        if (screenChangeListener != null) {
            ScreenChangeReceiver.removeScreenChangeListener(screenChangeListener);
            this.f48098l = null;
        }
    }

    public static synchronized OmegaFPS getInstance() {
        OmegaFPS omegaFPS;
        synchronized (OmegaFPS.class) {
            if (f48090j == null) {
                f48090j = new OmegaFPS();
            }
            omegaFPS = f48090j;
        }
        return omegaFPS;
    }

    public void start(Context context, final long j, long j2) {
        if (!f48088g) {
            f48088g = true;
            m34301c();
            try {
                f48089h = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
            } catch (Exception e) {
                OLog.m34418e("system refresh rate err:" + e.toString());
                OmegaSDKAdapter.trackMasEvent("omg_system_rr", (String) null, new HashMap<String, Object>() {
                    {
                        put("rate", Float.valueOf(OmegaFPS.f48089h));
                    }
                });
            }
            m34304e();
            this.f48092b.schedule(new TimerTask() {
                public void run() {
                    if (!OmegaFPS.this.f48095e) {
                        if (!OmegaFPS.this.f48096i) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("fps", Float.valueOf((((float) (OmegaFPS.this.f48091a / (j / 1000))) / OmegaFPS.f48089h) * 60.0f));
                            hashMap.put("lag", Integer.valueOf(OmegaLag.getInstance().isLagChecking() ? 1 : 0));
                            hashMap.put("interval", Long.valueOf(j));
                            hashMap.put("refreshRate", Float.valueOf(OmegaFPS.f48089h));
                            OmegaSDKAdapter.trackMasEvent("omg_fps", (String) null, hashMap);
                        } else {
                            boolean unused = OmegaFPS.this.f48096i = false;
                        }
                    }
                    long unused2 = OmegaFPS.this.f48091a = 0;
                }
            }, j, j);
            this.f48094d.schedule(new TimerTask() {
                public void run() {
                    if (!OmegaFPS.this.f48095e) {
                        synchronized (OmegaFPS.f48087f) {
                            OmegaFPS.f48087f.put(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(OmegaFPS.this.f48093c));
                        }
                    }
                    int unused = OmegaFPS.this.f48093c = 0;
                }
            }, j2, j2);
        }
    }

    /* renamed from: e */
    private void m34304e() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 16) {
                    try {
                        Choreographer.getInstance().postFrameCallback(new FPSFrameCallback());
                        boolean unused = OmegaFPS.this.f48095e = false;
                    } catch (Throwable th) {
                        OLog.m34418e("init fps fail! " + th.toString());
                    }
                }
            }
        });
    }

    public void stop() {
        Timer timer = this.f48092b;
        if (timer != null) {
            timer.cancel();
            this.f48092b = null;
            this.f48095e = true;
            m34303d();
        }
    }

    public void pause() {
        if (this.f48092b != null) {
            this.f48095e = true;
        }
    }

    public void resume() {
        if (this.f48092b != null) {
            this.f48095e = false;
            m34304e();
        }
    }

    public boolean isPause() {
        return this.f48095e;
    }

    public void addFrame() {
        this.f48091a++;
        this.f48093c++;
    }

    public String getLatestFPS() {
        if (!f48088g) {
            return "";
        }
        HashMap hashMap = new HashMap();
        synchronized (f48087f) {
            for (Long next : f48087f.keySet()) {
                hashMap.put(String.valueOf(next), f48087f.get(next));
            }
        }
        return JsonUtil.map2Json(hashMap);
    }

    public float getSystemRefreshRate() {
        return f48089h;
    }

    public void setBacked(boolean z) {
        this.f48096i = z;
    }
}
