package com.didi.map.global.task.engine;

import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalTaskEngine {

    /* renamed from: a */
    private static final String f27774a = "GlobalTaskEngine";

    /* renamed from: b */
    private ExecutorService f27775b = new ThreadPoolManage().newSingleThreadExecutor();

    /* renamed from: c */
    private Handler f27776c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f27777d;

    /* renamed from: e */
    private Runnable f27778e;

    /* renamed from: f */
    private AtomicBoolean f27779f;

    /* renamed from: g */
    private AtomicBoolean f27780g;

    /* renamed from: h */
    private Runnable f27781h = new Runnable() {
        public void run() {
            GlobalTaskEngine.this.m19895a().postDelayed(this, (long) GlobalTaskEngine.this.f27777d);
            GlobalTaskEngine.this.m19898c();
        }
    };

    public GlobalTaskEngine(int i, Runnable runnable) {
        this.f27777d = i;
        this.f27778e = runnable;
        this.f27779f = new AtomicBoolean(false);
        this.f27780g = new AtomicBoolean(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Handler m19895a() {
        Handler handler;
        synchronized (GlobalTaskEngine.class) {
            if (this.f27776c == null) {
                this.f27776c = new Handler(Looper.getMainLooper());
            }
            handler = this.f27776c;
        }
        return handler;
    }

    public void setLoopTimeMillis(int i) {
        this.f27777d = i;
    }

    public boolean isRunning() {
        return this.f27779f.get();
    }

    public boolean isPaused() {
        return this.f27780g.get();
    }

    /* renamed from: b */
    private void m19897b() {
        ExecutorService executorService = this.f27775b;
        if (executorService != null && !executorService.isShutdown() && isRunning() && !isPaused()) {
            m19895a().removeCallbacksAndMessages((Object) null);
            m19895a().post(this.f27781h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19898c() {
        ExecutorService executorService = this.f27775b;
        if (executorService != null && !executorService.isShutdown() && isRunning() && !isPaused()) {
            SystemUtils.log(3, f27774a, "Task Loop", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 68);
            this.f27775b.execute(this.f27778e);
        }
    }

    public void start() {
        if (this.f27778e == null) {
            SystemUtils.log(3, f27774a, "mLoopTask is null", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 75);
        } else if (isRunning()) {
            SystemUtils.log(3, f27774a, "mLoopTask is running", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 80);
        } else {
            SystemUtils.log(3, f27774a, "start()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 84);
            this.f27779f.set(true);
            this.f27780g.set(false);
            m19897b();
        }
    }

    public void resume() {
        if (isRunning() && isPaused()) {
            SystemUtils.log(3, f27774a, "resume()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 92);
            this.f27780g.set(false);
            m19897b();
        }
    }

    public void pause() {
        if (isRunning() && !isPaused()) {
            SystemUtils.log(3, f27774a, "pause()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 100);
            this.f27780g.set(true);
        }
    }

    public void stop() {
        SystemUtils.log(3, f27774a, "stop()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 106);
        this.f27779f.set(false);
        this.f27780g.set(true);
        Handler handler = this.f27776c;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f27776c = null;
        }
        ExecutorService executorService = this.f27775b;
        if (executorService != null && !executorService.isShutdown()) {
            this.f27775b.shutdownNow();
            this.f27775b = null;
        }
    }
}
