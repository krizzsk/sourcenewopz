package com.didi.soda.customer.foundation.location;

import com.didi.foundation.sdk.location.LocationConfigServiceProvider;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({LocationConfigServiceProvider.class})
public class LocationConfigService implements LocationConfigServiceProvider {
    public String getCountyId() {
        return String.valueOf(LocationUtil.getCountyId());
    }
}
