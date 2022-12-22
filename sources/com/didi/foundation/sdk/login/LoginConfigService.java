package com.didi.foundation.sdk.login;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class LoginConfigService implements LoginConfigServiceProvider {

    /* renamed from: a */
    private final LoginConfigServiceProvider f21236a;

    private LoginConfigService() {
        this.f21236a = (LoginConfigServiceProvider) ServiceLoader.load(LoginConfigServiceProvider.class).get();
    }

    public static final LoginConfigService getInstance() {
        return Singleton.INSTANCE;
    }

    public final LoginParams getLoginParams() {
        LoginConfigServiceProvider loginConfigServiceProvider = this.f21236a;
        if (loginConfigServiceProvider != null) {
            return loginConfigServiceProvider.getLoginParams();
        }
        return null;
    }

    public final LoginConfig getLoginConfiguration() {
        LoginConfigServiceProvider loginConfigServiceProvider = this.f21236a;
        if (loginConfigServiceProvider != null) {
            return loginConfigServiceProvider.getLoginConfiguration();
        }
        return null;
    }

    public final ThirdLoginClientIds getThirdLoginClientIds() {
        LoginConfigServiceProvider loginConfigServiceProvider = this.f21236a;
        if (loginConfigServiceProvider != null) {
            return loginConfigServiceProvider.getThirdLoginClientIds();
        }
        return null;
    }

    private static final class Singleton {
        static final LoginConfigService INSTANCE = new LoginConfigService();

        private Singleton() {
        }
    }
}
