package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;

public final class VariantConfigService implements VariantConfigServiceProvider {

    /* renamed from: a */
    private final VariantConfigServiceProvider f21319a;

    private VariantConfigService() {
        this.f21319a = (VariantConfigServiceProvider) ServiceLoader.load(VariantConfigServiceProvider.class).get();
    }

    public static final VariantConfigService getInstance() {
        return Singleton.INSTANCE;
    }

    public final ArrayList<String> getHttpDnsCache() {
        VariantConfigServiceProvider variantConfigServiceProvider = this.f21319a;
        if (variantConfigServiceProvider != null) {
            return variantConfigServiceProvider.getHttpDnsCache();
        }
        return null;
    }

    public final String omegaUploadHost() {
        VariantConfigServiceProvider variantConfigServiceProvider = this.f21319a;
        if (variantConfigServiceProvider != null) {
            return variantConfigServiceProvider.omegaUploadHost();
        }
        return null;
    }

    public final String securityKey() {
        VariantConfigServiceProvider variantConfigServiceProvider = this.f21319a;
        if (variantConfigServiceProvider != null) {
            return variantConfigServiceProvider.securityKey();
        }
        return null;
    }

    public final String apolloName() {
        VariantConfigServiceProvider variantConfigServiceProvider = this.f21319a;
        if (variantConfigServiceProvider != null) {
            return variantConfigServiceProvider.apolloName();
        }
        return null;
    }

    public final String getHttpDnsUrl() {
        VariantConfigServiceProvider variantConfigServiceProvider = this.f21319a;
        if (variantConfigServiceProvider != null) {
            return variantConfigServiceProvider.getHttpDnsUrl();
        }
        return null;
    }

    public final String getTransApolloName() {
        VariantConfigServiceProvider variantConfigServiceProvider = this.f21319a;
        if (variantConfigServiceProvider != null) {
            return variantConfigServiceProvider.getTransApolloName();
        }
        return null;
    }

    private static final class Singleton {
        static final VariantConfigService INSTANCE = new VariantConfigService();

        private Singleton() {
        }
    }
}
