package com.didi.component.business.util;

import android.content.Context;
import com.didi.unifylogin.api.OneLoginFacade;

public class LoginUtils {
    public static boolean checkLogin(Context context) {
        if (NationComponentDataUtil.isLoginNow()) {
            return true;
        }
        OneLoginFacade.getAction().go2Login(context);
        return false;
    }
}
