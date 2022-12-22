package com.didi.unifylogin.utils;

import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.api.LoginBaseFacade;

public class LoginLog {
    public static void write(String str) {
        if (!TextUtil.isEmpty(str)) {
            LoginBaseFacade.getInstance().writeLog(str);
        }
    }

    public static void write(String str, String str2) {
        if (!TextUtil.isEmpty(str2)) {
            LoginBaseFacade instance = LoginBaseFacade.getInstance();
            instance.writeLog(str + str2);
        }
    }
}
