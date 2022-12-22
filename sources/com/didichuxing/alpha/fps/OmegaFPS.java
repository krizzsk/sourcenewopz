package com.didichuxing.alpha.fps;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.WindowManager;
import com.didichuxing.alpha.lag.OmegaLag;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeListener;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeReceiver;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class OmegaFPS {
    private static boolean FPS_STARTED = false;
    private static OmegaFPS instance = null;
    /* access modifiers changed from: private */
    public static Map<Long, Integer> latestFPSMap = null;
    /* access modifiers changed from: private */
    public static float systemRefreshRate = 60.0f;
    private AppStateMonitor.AppStateListener appStateListener;
    /* access modifiers changed from: private */
    public boolean backed = false;
    private Timer fpsTraceForAnrTime = new Timer(true);
    /* access modifiers changed from: private */
    public int framTotalCountForAnrTrace = 0;
    /* access modifiers changed from: private */
    public long frameTotalCount = 0;
    /* access modifiers changed from: private */
    public boolean pauseFlag = true;
    private ScreenChangeListener screenChangeListener;
    private Timer timer = new Timer(true);

    private OmegaFPS() {
        latestFPSMap = new LinkedHashMap<Long, Integer>() {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
                return size() > OmegaConfig.FPS_LATEST_CACHE_NUM;
            }
        };
    }

    private void registListeners() {
        this.appStateListener = new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
                OmegaFPS.this.resume();
            }

            public void onInBackground() {
                OmegaFPS.this.pause();
                boolean unused = OmegaFPS.this.backed = true;
            }
        };
        this.screenChangeListener = new ScreenChangeListener() {
            public void screenOn() {
            }

            public void screenOff() {
                OmegaFPS.this.pause();
                boolean unused = OmegaFPS.this.backed = true;
            }
        };
        AppStateMonitor.getInstance().registerAppStateListener(this.appStateListener);
        ScreenChangeReceiver.addScreenChangeListener(this.screenChangeListener);
    }

    private void unregistListeners() {
        if (this.appStateListener != null) {
            AppStateMonitor.getInstance().unregisterAppStateListener(this.appStateListener);
            this.appStateListener = null;
        }
        ScreenChangeListener screenChangeListener2 = this.screenChangeListener;
        if (screenChangeListener2 != null) {
            ScreenChangeReceiver.removeScreenChangeListener(screenChangeListener2);
            this.screenChangeListener = null;
        }
    }

    public static synchronized OmegaFPS getInstance() {
        OmegaFPS omegaFPS;
        synchronized (OmegaFPS.class) {
            if (instance == null) {
                instance = new OmegaFPS();
            }
            omegaFPS = instance;
        }
        return omegaFPS;
    }

    public void start(Context context, final long j, long j2) {
        if (!FPS_STARTED) {
            FPS_STARTED = true;
            registListeners();
            try {
                systemRefreshRate = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
            } catch (Exception e) {
                OLog.m34763e("system refresh rate err:" + e.toString());
                Tracker.trackEvent("omg_system_rr", (String) null, new HashMap<String, Object>() {
                    {
                        put("rate", Float.valueOf(OmegaFPS.systemRefreshRate));
                    }
                });
            }
            postDoFrame();
            this.timer.schedule(new TimerTask() {
                public void run() {
                    if (!OmegaFPS.this.pauseFlag) {
                        if (!OmegaFPS.this.backed) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("fps", Float.valueOf((((float) (OmegaFPS.this.frameTotalCount / (j / 1000))) / OmegaFPS.systemRefreshRate) * 60.0f));
                            hashMap.put("lag", Integer.valueOf(OmegaLag.getInstance().isLagChecking() ? 1 : 0));
                            hashMap.put("interval", Long.valueOf(j));
                            hashMap.put("refreshRate", Float.valueOf(OmegaFPS.systemRefreshRate));
                            Tracker.trackEvent("omg_fps", (String) null, hashMap);
                        } else {
                            boolean unused = OmegaFPS.this.backed = false;
                        }
                    }
                    long unused2 = OmegaFPS.this.frameTotalCount = 0;
                }
            }, j, j);
            this.fpsTraceForAnrTime.schedule(new TimerTask() {
                public void run() {
                    if (!OmegaFPS.this.pauseFlag) {
                        synchronized (OmegaFPS.latestFPSMap) {
                            OmegaFPS.latestFPSMap.put(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(OmegaFPS.this.framTotalCountForAnrTrace));
                        }
                    }
                    int unused = OmegaFPS.this.framTotalCountForAnrTrace = 0;
                }
            }, j2, j2);
        }
    }

    private void postDoFrame() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 16) {
                    try {
                        Choreographer.getInstance().postFrameCallback(new FPSFrameCallback());
                        boolean unused = OmegaFPS.this.pauseFlag = false;
                    } catch (Throwable th) {
                        OLog.m34763e("init fps fail! " + th.toString());
                    }
                }
            }
        });
    }

    public void stop() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
            this.pauseFlag = true;
            unregistListeners();
        }
    }

    public void pause() {
        if (this.timer != null) {
            this.pauseFlag = true;
        }
    }

    public void resume() {
        if (this.timer != null) {
            this.pauseFlag = false;
            postDoFrame();
        }
    }

    public boolean isPause() {
        return this.pauseFlag;
    }

    public void addFrame() {
        this.frameTotalCount++;
        this.framTotalCountForAnrTrace++;
    }

    public String getLatestFPS() {
        if (!FPS_STARTED) {
            return "";
        }
        HashMap hashMap = new HashMap();
        synchronized (latestFPSMap) {
            for (Long next : latestFPSMap.keySet()) {
                hashMap.put(String.valueOf(next), latestFPSMap.get(next));
            }
        }
        return JsonUtil.map2Json(hashMap);
    }

    public float getSystemRefreshRate() {
        return systemRefreshRate;
    }

    public void setBacked(boolean z) {
        this.backed = z;
    }
}
