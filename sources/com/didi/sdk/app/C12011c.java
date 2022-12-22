package com.didi.sdk.app;

import com.didi.sdk.security.SecurityUtil;
import com.didichuxing.swarm.toolkit.DeviceService;

/* renamed from: com.didi.sdk.app.c */
/* compiled from: DeviceServiceImpl */
class C12011c implements DeviceService {
    C12011c() {
    }

    public String getDeviceId() {
        return SecurityUtil.getDeviceId();
    }
}
