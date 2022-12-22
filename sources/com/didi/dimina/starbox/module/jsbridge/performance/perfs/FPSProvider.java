package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import android.view.Choreographer;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p107ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.ForegroundChecker;

public class FPSProvider implements Choreographer.FrameCallback, IPerformance<Integer>, ForegroundChecker.OnForegroundChange {

    /* renamed from: c */
    private static final int f18082c = 1000000000;

    /* renamed from: a */
    long f18083a = -1;

    /* renamed from: b */
    int f18084b = -1;

    /* renamed from: d */
    private Choreographer f18085d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDataProvider<Integer> f18086e;

    public void registerProvider(IDataProvider<Integer> iDataProvider) {
        this.f18086e = iDataProvider;
        Choreographer instance = Choreographer.getInstance();
        this.f18085d = instance;
        instance.postFrameCallback(this);
    }

    public void doFrame(long j) {
        final int i;
        long j2 = this.f18083a;
        if (j2 > 0 && this.f18084b != (i = (int) (((1.0f / ((float) (j - j2))) * 1.0E9f) + 0.5f))) {
            this.f18084b = i;
            if (i > 60) {
                i = 60;
            }
            if (this.f18086e != null) {
                GlobalDispatcher.post(new Runnable() {
                    public void run() {
                        FPSProvider.this.f18086e.onProvide(Integer.valueOf(i));
                    }
                });
            }
        }
        this.f18083a = j;
        this.f18085d.postFrameCallback(this);
    }

    public void onChange(boolean z) {
        Choreographer choreographer = this.f18085d;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this);
            if (z) {
                this.f18085d.postFrameCallback(this);
            }
        }
    }
}
