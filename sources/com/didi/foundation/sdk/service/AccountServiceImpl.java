package com.didi.foundation.sdk.service;

import com.didi.foundation.sdk.login.LoginService;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({AccountServiceProvider.class})
public class AccountServiceImpl implements AccountServiceProvider {
    public String getCityId() {
        return null;
    }

    public String getPhone() {
        return OneLoginFacade.getStore().getPhone();
    }

    public String getToken() {
        return LoginService.getInstance().getToken();
    }

    public String getUid() {
        return LoginService.getInstance().getUid();
    }

    public boolean isAuthenticated() {
        return LoginService.getInstance().isLogin();
    }

    public String getCountryCode() {
        return LoginService.getInstance().getCountryCode();
    }
}
