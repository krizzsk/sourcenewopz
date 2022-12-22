package com.didi.foundation.sdk.service;

import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({DeviceServiceProvider.class})
public class DeviceServiceImpl implements DeviceServiceProvider {
    public String getDeviceId() {
        return SystemUtil.getIMEI();
    }

    public String getUuid() {
        return SecurityUtil.getUUID();
    }
}
