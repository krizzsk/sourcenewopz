package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class AccountService implements AccountServiceProvider {

    /* renamed from: a */
    private final AccountServiceProvider f21294a;

    private AccountService() {
        this.f21294a = (AccountServiceProvider) ServiceLoader.load(AccountServiceProvider.class).get();
    }

    public static final AccountService getInstance() {
        return Singleton.INSTANCE;
    }

    public final String getPhone() {
        AccountServiceProvider accountServiceProvider = this.f21294a;
        if (accountServiceProvider != null) {
            return accountServiceProvider.getPhone();
        }
        return null;
    }

    public final String getToken() {
        AccountServiceProvider accountServiceProvider = this.f21294a;
        if (accountServiceProvider != null) {
            return accountServiceProvider.getToken();
        }
        return null;
    }

    public final String getUid() {
        AccountServiceProvider accountServiceProvider = this.f21294a;
        if (accountServiceProvider != null) {
            return accountServiceProvider.getUid();
        }
        return null;
    }

    public final String getCityId() {
        AccountServiceProvider accountServiceProvider = this.f21294a;
        if (accountServiceProvider != null) {
            return accountServiceProvider.getCityId();
        }
        return null;
    }

    public final boolean isAuthenticated() {
        AccountServiceProvider accountServiceProvider = this.f21294a;
        return accountServiceProvider != null && accountServiceProvider.isAuthenticated();
    }

    public final String getCountryCode() {
        AccountServiceProvider accountServiceProvider = this.f21294a;
        if (accountServiceProvider != null) {
            return accountServiceProvider.getCountryCode();
        }
        return null;
    }

    private static final class Singleton {
        static final AccountService INSTANCE = new AccountService();

        private Singleton() {
        }
    }
}
