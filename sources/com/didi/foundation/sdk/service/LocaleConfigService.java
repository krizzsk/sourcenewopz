package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class LocaleConfigService implements LocaleConfigServiceProvider {

    /* renamed from: a */
    private final LocaleConfigServiceProvider f21304a;

    private LocaleConfigService() {
        this.f21304a = (LocaleConfigServiceProvider) ServiceLoader.load(LocaleConfigServiceProvider.class).get();
    }

    public static final LocaleConfigService getInstance() {
        return Singleton.INSTANCE;
    }

    public final LocaleConfig getLocaleConfig() {
        LocaleConfigServiceProvider localeConfigServiceProvider = this.f21304a;
        if (localeConfigServiceProvider != null) {
            return localeConfigServiceProvider.getLocaleConfig();
        }
        return null;
    }

    private static final class Singleton {
        static final LocaleConfigService INSTANCE = new LocaleConfigService();

        private Singleton() {
        }
    }
}
