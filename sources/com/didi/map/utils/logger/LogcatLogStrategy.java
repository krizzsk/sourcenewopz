package com.didi.map.utils.logger;

import com.didi.sdk.apm.SystemUtils;

public class LogcatLogStrategy implements LogStrategy {

    /* renamed from: a */
    static final String f29044a = "NO_TAG";

    public void log(int i, String str, String str2) {
        C10238b.m20477b(str2);
        if (str == null) {
            str = f29044a;
        }
        SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.map.utils.logger.LogcatLogStrategy", 25);
    }
}
