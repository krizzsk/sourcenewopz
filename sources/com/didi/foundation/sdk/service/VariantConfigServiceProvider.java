package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import java.util.ArrayList;

@ServiceProviderInterface
public interface VariantConfigServiceProvider {
    String apolloName();

    ArrayList<String> getHttpDnsCache();

    String getHttpDnsUrl();

    String getTransApolloName();

    String omegaUploadHost();

    String securityKey();
}
