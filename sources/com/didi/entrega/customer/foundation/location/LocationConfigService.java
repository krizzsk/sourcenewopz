package com.didi.entrega.customer.foundation.location;

import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.foundation.sdk.location.LocationConfigServiceProvider;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({LocationConfigServiceProvider.class})
public class LocationConfigService implements LocationConfigServiceProvider {
    public String getCountyId() {
        return String.valueOf(LocationUtil.getCountyId());
    }
}
