package com.didi.unifylogin.base.api;

import com.didi.unifylogin.base.log.LogListener;
import com.didi.unifylogin.base.net.LoginNetModeListener;
import com.didi.unifylogin.base.net.LoginNetParamListener;

public class BaseListenerContainer {

    /* renamed from: a */
    private static LoginNetParamListener f44672a;

    /* renamed from: b */
    private static LogListener f44673b;

    /* renamed from: c */
    private static LoginNetModeListener f44674c;

    public static LoginNetParamListener getNetParamListener() {
        return f44672a;
    }

    public static void setNetParamListener(LoginNetParamListener loginNetParamListener) {
        f44672a = loginNetParamListener;
    }

    public static LogListener getLogListener() {
        return f44673b;
    }

    public static void setLogListener(LogListener logListener) {
        f44673b = logListener;
    }

    public static LoginNetModeListener getNetModeListener() {
        return f44674c;
    }

    public static void setNetModeListener(LoginNetModeListener loginNetModeListener) {
        f44674c = loginNetModeListener;
    }
}
