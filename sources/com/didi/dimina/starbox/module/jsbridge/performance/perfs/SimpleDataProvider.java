package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p107ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.ForegroundChecker;

public abstract class SimpleDataProvider<T> implements IPerformance<T>, ForegroundChecker.OnForegroundChange, Runnable {
    private IDataProvider<T> dataProvider;

    /* access modifiers changed from: protected */
    public abstract T onDataProvide();

    public void registerProvider(IDataProvider<T> iDataProvider) {
        this.dataProvider = iDataProvider;
        GlobalDispatcher.post(this);
    }

    public void run() {
        this.dataProvider.onProvide(onDataProvide());
        GlobalDispatcher.postDelay(this, 1000);
    }

    public void onChange(boolean z) {
        GlobalDispatcher.removeCallbacks(this);
        if (z) {
            GlobalDispatcher.post(this);
        }
    }
}
