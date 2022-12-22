package com.didi.entrega.customer.foundation.rpc.entity;

import com.didi.entrega.customer.foundation.util.LoginUtil;

public class LoginModel {

    /* renamed from: a */
    private boolean f20012a = false;

    /* renamed from: b */
    private boolean f20013b = true;

    /* renamed from: c */
    private String f20014c;

    public static LoginModel newInstance() {
        LoginModel loginModel = new LoginModel();
        loginModel.setLogin(LoginUtil.isLogin());
        loginModel.setToken(LoginUtil.getToken());
        loginModel.setNeedPopToRoot(true);
        return loginModel;
    }

    public boolean ismNeedPopToRoot() {
        return this.f20013b;
    }

    public void setNeedPopToRoot(boolean z) {
        this.f20013b = z;
    }

    public String getToken() {
        return this.f20014c;
    }

    public void setToken(String str) {
        this.f20014c = str;
    }

    public boolean isLogin() {
        return this.f20012a;
    }

    public void setLogin(boolean z) {
        this.f20012a = z;
    }
}
