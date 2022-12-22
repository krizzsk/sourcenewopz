package com.didi.foundation.sdk.location;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class LocationConfigService implements LocationConfigServiceProvider {

    /* renamed from: a */
    private final LocationConfigServiceProvider f21206a;

    private LocationConfigService() {
        this.f21206a = (LocationConfigServiceProvider) ServiceLoader.load(LocationConfigServiceProvider.class).get();
    }

    public static final LocationConfigService getInstance() {
        return Singleton.INSTANCE;
    }

    public final String getCountyId() {
        LocationConfigServiceProvider locationConfigServiceProvider = this.f21206a;
        if (locationConfigServiceProvider != null) {
            return locationConfigServiceProvider.getCountyId();
        }
        return null;
    }

    private static final class Singleton {
        static final LocationConfigService INSTANCE = new LocationConfigService();

        private Singleton() {
        }
    }
}
