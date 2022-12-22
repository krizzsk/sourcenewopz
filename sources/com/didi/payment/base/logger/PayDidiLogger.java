package com.didi.payment.base.logger;

import android.text.TextUtils;
import com.didi.payment.base.utils.PayLogUtils;
import com.didi.sdk.logging.HeaderType;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

class PayDidiLogger implements IPayLogger {

    /* renamed from: a */
    private static final String f29910a = "PayDidiLogger";

    /* renamed from: b */
    private static final String f29911b = "PayLog";

    /* renamed from: c */
    private Logger f29912c;

    public static class LogType {
        public static final int LONG = 2;
        public static final int SHORT = 1;
    }

    public PayDidiLogger() {
        Logger logger = LoggerFactory.getLogger(f29911b);
        this.f29912c = logger;
        logger.setHeaderType(HeaderType.SHORT);
    }

    public void traceEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f29912c.traceEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void debugEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f29912c.debugEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void infoEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f29912c.infoEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void warnEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f29912c.warnEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void errorEvent(String str, HashMap<String, Object> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            this.f29912c.errorEvent(str, (Map<?, ?>) hashMap);
        }
    }

    public void setLogType(int i) {
        PayLogUtils.m21013d(f29910a, "setLogType type " + i);
        if (i == 1) {
            this.f29912c.setHeaderType(HeaderType.SHORT);
        } else if (i == 2) {
            this.f29912c.setHeaderType(HeaderType.LONG);
        }
    }
}
