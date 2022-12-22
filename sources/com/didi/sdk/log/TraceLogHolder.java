package com.didi.sdk.log;

public class TraceLogHolder {

    /* renamed from: a */
    private TraceLogListener f36446a;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final TraceLogHolder INSTANCE = new TraceLogHolder();

        private SingletonHolder() {
        }
    }

    private TraceLogHolder() {
    }

    public static final TraceLogHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public TraceLogListener getLogListener() {
        return this.f36446a;
    }

    public void setLogListener(TraceLogListener traceLogListener) {
        this.f36446a = traceLogListener;
    }
}
