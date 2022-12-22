package com.didi.greatwall.util.log;

import android.os.Bundle;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class GLogger {

    /* renamed from: a */
    private static final String f22970a = "GreatWall";

    /* renamed from: b */
    private String f22971b = "";

    /* renamed from: c */
    private Logger f22972c = LoggerFactory.getLogger(f22970a);

    public static final GLogger getLogger(String str) {
        return new GLogger(str);
    }

    public static final GLogger getLogger() {
        return new GLogger("");
    }

    public GLogger(String str) {
        this.f22971b = str;
    }

    public void debug(String str) {
        if (this.f22971b.length() > 0) {
            Logger logger = this.f22972c;
            logger.debug(this.f22971b + "-->" + str, new Object[0]);
            return;
        }
        this.f22972c.debug(str, new Object[0]);
    }

    public void info(String str) {
        if (this.f22971b.length() > 0) {
            Logger logger = this.f22972c;
            logger.info(this.f22971b + "-->" + str, new Object[0]);
            return;
        }
        this.f22972c.info(str, new Object[0]);
    }

    public void warn(String str) {
        if (this.f22971b.length() > 0) {
            Logger logger = this.f22972c;
            logger.warn(this.f22971b + "-->" + str, new Object[0]);
            return;
        }
        this.f22972c.warn(str, new Object[0]);
    }

    public void warn(String str, Throwable th) {
        if (this.f22971b.length() > 0) {
            Logger logger = this.f22972c;
            logger.warn(this.f22971b + "-->" + str, th);
            return;
        }
        this.f22972c.warn(str, th);
    }

    public void error(String str) {
        if (this.f22971b.length() > 0) {
            Logger logger = this.f22972c;
            logger.error(this.f22971b + "-->" + str, new Object[0]);
            return;
        }
        this.f22972c.error(str, new Object[0]);
    }

    public void error(String str, Throwable th) {
        if (this.f22971b.length() > 0) {
            Logger logger = this.f22972c;
            logger.error(this.f22971b + "-->" + str, th);
            return;
        }
        this.f22972c.error(str, th);
    }

    public static String bundleToString(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb.append(str);
            sb.append(" = ");
            sb.append(bundle.get(str));
        }
        return sb.toString();
    }
}
