package com.didichuxing.mas.sdk.quality.collect.lag;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.a */
/* compiled from: AbstractSampler */
abstract class C15799a {

    /* renamed from: c */
    private static final int f48121c = 300;

    /* renamed from: a */
    protected AtomicBoolean f48122a = new AtomicBoolean(false);

    /* renamed from: b */
    protected long f48123b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f48124d = new AbstractSampler$1(this);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo118406c();

    public C15799a(long j) {
        this.f48123b = 0 == j ? 300 : j;
    }

    /* renamed from: a */
    public void mo118404a() {
        if (!this.f48122a.get()) {
            this.f48122a.set(true);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.f48124d);
            HandlerThreadFactory.getTimerThreadHandler().postDelayed(this.f48124d, BlockCanaryInternals.m34310a().mo118395b());
        }
    }

    /* renamed from: b */
    public void mo118405b() {
        if (this.f48122a.get()) {
            this.f48122a.set(false);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.f48124d);
        }
    }
}
