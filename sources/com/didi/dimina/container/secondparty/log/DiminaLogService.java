package com.didi.dimina.container.secondparty.log;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.service.LogService;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class DiminaLogService implements LogService {

    /* renamed from: a */
    private static final String f17306a = "Dimina";

    /* renamed from: b */
    private static final Logger f17307b = LoggerFactory.getLogger(f17306a, f17306a);

    /* renamed from: a */
    private static boolean m12848a() {
        return Dimina.getConfig() == null || Dimina.getConfig().isDebug();
    }

    /* renamed from: i */
    public void mo55824i(String str) {
        if (m12848a()) {
            SystemUtils.log(4, f17306a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 24);
        }
    }

    /* renamed from: i */
    public void mo55825i(String str, String str2) {
        if (m12848a()) {
            SystemUtils.log(4, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 30);
        }
    }

    /* renamed from: d */
    public void mo55818d(String str) {
        if (m12848a()) {
            SystemUtils.log(3, f17306a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 36);
        }
    }

    /* renamed from: d */
    public void mo55819d(String str, String str2) {
        if (m12848a()) {
            SystemUtils.log(3, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 42);
        }
    }

    /* renamed from: e */
    public void mo55821e(String str) {
        if (m12848a()) {
            SystemUtils.log(6, f17306a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 48);
        }
    }

    /* renamed from: e */
    public void mo55822e(String str, String str2) {
        if (m12848a()) {
            SystemUtils.log(6, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 54);
        }
    }

    /* renamed from: w */
    public void mo55827w(String str) {
        if (m12848a()) {
            SystemUtils.log(5, f17306a, str, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 60);
        }
    }

    /* renamed from: w */
    public void mo55828w(String str, String str2) {
        if (m12848a()) {
            SystemUtils.log(5, "Dimina [" + str + Const.jaRight, str2, (Throwable) null, "com.didi.dimina.container.secondparty.log.DiminaLogService", 66);
        }
    }

    public void iRelease(String str, String str2) {
        f17307b.info("[%s] %s", str, str2);
    }

    public void dRelease(String str, String str2) {
        f17307b.debug("[%s] %s", str, str2);
    }

    public void eRelease(String str, String str2) {
        f17307b.error("[%s] %s", str, str2);
    }

    public void wRelease(String str, String str2) {
        f17307b.warn("[%s] %s", str, str2);
    }
}
