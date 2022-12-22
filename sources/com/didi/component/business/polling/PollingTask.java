package com.didi.component.business.polling;

public abstract class PollingTask {
    /* access modifiers changed from: protected */
    public abstract long loopInterval();

    /* access modifiers changed from: protected */
    public boolean matchPollCondication() {
        return false;
    }

    public abstract void run();
}
