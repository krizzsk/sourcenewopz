package com.didi.foundation.sdk.swarm;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.swarm.toolkit.LogService;

/* renamed from: com.didi.foundation.sdk.swarm.e */
/* compiled from: LogServiceImpl */
class C8397e implements LogService {
    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isVerboseEnabled() {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    C8397e() {
    }

    public void verbose(String str, String str2) {
        if (isVerboseEnabled()) {
            SystemUtils.log(2, str, str2, (Throwable) null, "com.didi.foundation.sdk.swarm.LogServiceImpl", 43);
        }
    }

    public void verbose(String str, String str2, Throwable th) {
        if (isVerboseEnabled()) {
            SystemUtils.log(2, str, str2, th, "com.didi.foundation.sdk.swarm.LogServiceImpl", 50);
        }
    }

    public void debug(String str, String str2) {
        if (isDebugEnabled()) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.foundation.sdk.swarm.LogServiceImpl", 57);
        }
    }

    public void debug(String str, String str2, Throwable th) {
        if (isDebugEnabled()) {
            SystemUtils.log(3, str, str2, th, "com.didi.foundation.sdk.swarm.LogServiceImpl", 64);
        }
    }

    public void info(String str, String str2) {
        if (isInfoEnabled()) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.foundation.sdk.swarm.LogServiceImpl", 71);
        }
    }

    public void info(String str, String str2, Throwable th) {
        if (isInfoEnabled()) {
            SystemUtils.log(4, str, str2, th, "com.didi.foundation.sdk.swarm.LogServiceImpl", 78);
        }
    }

    public void warn(String str, String str2) {
        if (isWarnEnabled()) {
            SystemUtils.log(5, str, str2, (Throwable) null, "com.didi.foundation.sdk.swarm.LogServiceImpl", 85);
        }
    }

    public void warn(String str, String str2, Throwable th) {
        if (isWarnEnabled()) {
            SystemUtils.log(5, str, str2, th, "com.didi.foundation.sdk.swarm.LogServiceImpl", 92);
        }
    }

    public void error(String str, String str2) {
        if (isErrorEnabled()) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.foundation.sdk.swarm.LogServiceImpl", 99);
        }
    }

    public void error(String str, String str2, Throwable th) {
        if (isErrorEnabled()) {
            SystemUtils.log(6, str, str2, th, "com.didi.foundation.sdk.swarm.LogServiceImpl", 106);
        }
    }
}
