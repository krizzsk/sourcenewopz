package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface LocaleConfigServiceProvider {
    LocaleConfig getLocaleConfig();
}
