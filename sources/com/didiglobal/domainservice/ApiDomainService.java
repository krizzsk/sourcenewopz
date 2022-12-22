package com.didiglobal.domainservice;

import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider(alias = "globalapi", value = {IDomainService.class})
public class ApiDomainService implements IDomainService {
    public void onNotifyDomainChanged(String str) {
        ELog.log("ApiDomainService receive doman changed() domainSuffix = " + str);
    }

    public void onNotifyDomainSwitchEvent(int i, Bundle bundle) {
        SystemUtils.log(3, "hgl_tag", "receive domain event notify in APIDomainService", (Throwable) null, "com.didiglobal.domainservice.ApiDomainService", 19);
    }
}
