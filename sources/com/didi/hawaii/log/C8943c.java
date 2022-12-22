package com.didi.hawaii.log;

import android.text.TextUtils;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.didi.hawaii.log.c */
/* compiled from: LoggerHelper */
final class C8943c {

    /* renamed from: a */
    private static final HWLogger2 f23486a = new HWLogger2("{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt");

    /* renamed from: b */
    private static Logger f23487b = null;

    C8943c() {
    }

    /* renamed from: a */
    static void m16778a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f23486a.setPhoneNumber(str);
        }
    }

    /* renamed from: b */
    static void m16782b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f23486a.setPath(str);
        }
    }

    /* renamed from: c */
    static void m16783c(String str) {
        if (ApolloHawaii.useNewLogSDK()) {
            Logger a = m16777a();
            if (a != null) {
                a.println(Const.jaLeft + m16781b() + "] " + str);
                return;
            }
            return;
        }
        f23486a.log(str);
    }

    /* renamed from: a */
    static void m16779a(String str, String str2) {
        if (ApolloHawaii.useNewLogSDK()) {
            Logger a = m16777a();
            if (a != null) {
                a.error(str + " " + str2, new Object[0]);
                return;
            }
            return;
        }
        f23486a.log(str, str2);
    }

    /* renamed from: a */
    static void m16780a(boolean z) {
        f23486a.setDebug(z);
    }

    /* renamed from: a */
    private static synchronized Logger m16777a() {
        synchronized (C8943c.class) {
            if (f23487b != null) {
                Logger logger = f23487b;
                return logger;
            }
            Logger logger2 = LoggerFactory.getLogger("", HWLog.BUFFER_ID);
            f23487b = logger2;
            return logger2;
        }
    }

    /* renamed from: b */
    private static String m16781b() {
        return Thread.currentThread().getName();
    }
}
