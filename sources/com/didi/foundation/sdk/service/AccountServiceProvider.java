package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface AccountServiceProvider {
    String getCityId();

    String getCountryCode();

    String getPhone();

    String getToken();

    String getUid();

    boolean isAuthenticated();
}
