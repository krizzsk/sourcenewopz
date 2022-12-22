package com.didi.sdk.envsetbase;

import com.didi.sdk.apm.SystemUtils;

public class EnvLog {
    public static void log(String str, String str2) {
        SystemUtils.log(4, "EnvConifg", str + " - " + str2, (Throwable) null, "com.didi.sdk.envsetbase.EnvLog", 11);
    }
}
