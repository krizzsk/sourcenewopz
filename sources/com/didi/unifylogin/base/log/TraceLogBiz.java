package com.didi.unifylogin.base.log;

import com.didi.unifylogin.base.api.BaseListenerContainer;

public final class TraceLogBiz {
    private TraceLogBiz() {
    }

    private static class TraceLogBizHolder {
        /* access modifiers changed from: private */
        public static final TraceLogBiz singleton = new TraceLogBiz();

        private TraceLogBizHolder() {
        }
    }

    public static TraceLogBiz getInstance() {
        return TraceLogBizHolder.singleton;
    }

    public synchronized void addLogWithTab(String str) {
        LogListener logListener = BaseListenerContainer.getLogListener();
        if (logListener != null) {
            logListener.addLogWithTab("[ LoginSDK ] " + str);
        }
    }
}
