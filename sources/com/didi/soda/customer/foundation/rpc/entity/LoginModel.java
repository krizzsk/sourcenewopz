package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.util.LoginUtil;

public class LoginModel {

    /* renamed from: a */
    private boolean f41038a = false;

    /* renamed from: b */
    private boolean f41039b = true;

    /* renamed from: c */
    private String f41040c;

    public static LoginModel newInstance() {
        LoginModel loginModel = new LoginModel();
        loginModel.setLogin(LoginUtil.isLogin());
        loginModel.setToken(LoginUtil.getToken());
        loginModel.setNeedPopToRoot(true);
        return loginModel;
    }

    public boolean ismNeedPopToRoot() {
        return this.f41039b;
    }

    public void setNeedPopToRoot(boolean z) {
        this.f41039b = z;
    }

    public String getToken() {
        return this.f41040c;
    }

    public void setToken(String str) {
        this.f41040c = str;
    }

    public boolean isLogin() {
        return this.f41038a;
    }

    public void setLogin(boolean z) {
        this.f41038a = z;
    }
}
