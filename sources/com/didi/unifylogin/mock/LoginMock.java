package com.didi.unifylogin.mock;

import com.didi.unifylogin.base.net.LoginNet;

public class LoginMock {
    public static boolean IS_MOCK = false;

    /* renamed from: a */
    private static LoginNet f44822a;

    public static LoginNet getNetBiz() {
        return f44822a;
    }

    public static void setNetBiz(LoginNet loginNet) {
        f44822a = loginNet;
    }
}
