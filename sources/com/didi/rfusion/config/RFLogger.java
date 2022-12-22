package com.didi.rfusion.config;

import com.didi.rfusion.RFusion;
import com.didi.rfusion.config.RFusionConfig;

public class RFLogger implements RFusionConfig.IRFusionLogger {
    public static final String RF_LOG_TAG = "RFusion";

    /* renamed from: a */
    private RFusionConfig.IRFusionLogger f33191a;

    private RFLogger() {
        this.f33191a = RFusion.getLogger();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static RFLogger INSTANCE = new RFLogger();

        private SingletonHolder() {
        }
    }

    public static RFLogger getLogger() {
        return SingletonHolder.INSTANCE;
    }

    public void debug(String str) {
        debug(RF_LOG_TAG, str);
    }

    public void info(String str) {
        info(RF_LOG_TAG, str);
    }

    public void debug(String str, String str2) {
        RFusionConfig.IRFusionLogger iRFusionLogger = this.f33191a;
        if (iRFusionLogger != null) {
            iRFusionLogger.debug(str, str2);
            return;
        }
        System.out.println(String.format("%s - debug：%s", new Object[]{str, str2}));
    }

    public void info(String str, String str2) {
        RFusionConfig.IRFusionLogger iRFusionLogger = this.f33191a;
        if (iRFusionLogger != null) {
            iRFusionLogger.info(str, str2);
            return;
        }
        System.out.println(String.format("%s - info：%s", new Object[]{str, str2}));
    }
}
