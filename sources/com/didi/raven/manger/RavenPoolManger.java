package com.didi.raven.manger;

import com.didi.raven.RavenDataManger;
import com.didi.raven.RavenSdk;
import com.didi.raven.utils.RavenLogUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class RavenPoolManger {

    /* renamed from: a */
    private static final String f33103a = "RavenPoolManger";

    /* renamed from: b */
    private final AtomicBoolean f33104b = new AtomicBoolean(false);

    /* renamed from: c */
    private final Runnable f33105c = new Runnable() {
        public final void run() {
            RavenPoolManger.this.m23311c();
        }
    };

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenPoolManger INSTANCE = new RavenPoolManger();

        private SingleTon() {
        }
    }

    public static RavenPoolManger getInstance() {
        return SingleTon.INSTANCE;
    }

    /* renamed from: a */
    private ScheduledExecutorService m23309a() {
        return RavenThreadExecutorManger.getInstance().getService();
    }

    public void start() {
        if (!this.f33104b.get()) {
            RavenLogUtils.m23331i(f33103a, "start: service");
            m23309a().scheduleAtFixedRate(this.f33105c, 0, RavenDataManger.getInstance().getPoolConfig().getDelay(), TimeUnit.MILLISECONDS);
            this.f33104b.set(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23311c() {
        RavenSdk.getInstance().clearPool();
    }

    public void stop() {
        m23309a().shutdown();
    }
}
