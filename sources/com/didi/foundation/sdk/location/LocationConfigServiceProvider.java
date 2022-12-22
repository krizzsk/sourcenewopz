package com.didi.foundation.sdk.location;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface LocationConfigServiceProvider {
    String getCountyId();
}
