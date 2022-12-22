package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface ApplicationServiceProvider {
    String getChannelId();

    int getVersionCode();

    String getVersionName();

    boolean isDebuggable();
}
