package com.didi.unifylogin.base.model;

import android.content.Context;
import com.didi.unifylogin.base.api.LoginFlutterNetBiz;
import com.didi.unifylogin.base.api.LoginNetBiz;
import com.didi.unifylogin.base.net.LoginNet;
import com.didi.unifylogin.mock.LoginMock;

public class LoginModel implements ILoginBaseModel {
    public static LoginNet getNet(Context context) {
        if (LoginMock.IS_MOCK) {
            return LoginMock.getNetBiz();
        }
        return new LoginNetBiz(context);
    }

    public static LoginNet getFlutterNet(Context context) {
        return new LoginFlutterNetBiz(context);
    }
}
