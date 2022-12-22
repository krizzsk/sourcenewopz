package com.didi.component.common.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class FastDoubleClickTest {

    /* renamed from: a */
    private static final Logger f11752a = LoggerFactory.getLogger((Class<?>) FastDoubleClickTest.class);

    /* renamed from: b */
    private static long f11753b;

    /* renamed from: c */
    private static long f11754c = 400;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        Logger logger = f11752a;
        logger.debug("FastDoubleClickTest 开始: currentTime: " + currentTimeMillis, new Object[0]);
        long j = currentTimeMillis - f11753b;
        if (0 >= j || j >= f11754c) {
            Logger logger2 = f11752a;
            logger2.debug("FastDoubleClickTest 结束 timeD: " + j + "false ; lastClickTime: " + currentTimeMillis, new Object[0]);
            f11753b = currentTimeMillis;
            return false;
        }
        Logger logger3 = f11752a;
        logger3.debug("FastDoubleClickTest 结束 timeD: " + j + "true, time = " + currentTimeMillis, new Object[0]);
        return true;
    }
}
