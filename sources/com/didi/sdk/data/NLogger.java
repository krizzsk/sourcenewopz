package com.didi.sdk.data;

import android.text.TextUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class NLogger {
    public static final String TAG = "NLogger";

    /* renamed from: a */
    private static Logger f35776a = LoggerFactory.getLogger("NLogger");

    /* renamed from: b */
    private String f35777b;

    private NLogger() {
    }

    public static NLogger getNLogger(String str) {
        NLogger nLogger = new NLogger();
        nLogger.f35777b = str;
        return nLogger;
    }

    public static NLogger getNLogger() {
        return new NLogger();
    }

    public void debug(String str) {
        if (TextUtils.isEmpty(this.f35777b)) {
            f35776a.debug(str, new Object[0]);
            return;
        }
        Logger logger = f35776a;
        logger.debug("===" + this.f35777b + "=== " + str, new Object[0]);
    }

    public void info(String str) {
        if (TextUtils.isEmpty(this.f35777b)) {
            f35776a.info(str, new Object[0]);
            return;
        }
        Logger logger = f35776a;
        logger.info("===" + this.f35777b + "=== " + str, new Object[0]);
    }

    public void warn(String str) {
        if (TextUtils.isEmpty(this.f35777b)) {
            f35776a.warn(str, new Object[0]);
            return;
        }
        Logger logger = f35776a;
        logger.warn("===" + this.f35777b + "=== " + str, new Object[0]);
    }

    public void error(String str) {
        if (TextUtils.isEmpty(this.f35777b)) {
            f35776a.error(str, new Object[0]);
            return;
        }
        Logger logger = f35776a;
        logger.error("===" + this.f35777b + "=== " + str, new Object[0]);
    }
}
