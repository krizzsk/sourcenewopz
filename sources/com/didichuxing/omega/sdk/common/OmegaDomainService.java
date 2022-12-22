package com.didichuxing.omega.sdk.common;

import android.os.Bundle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.omega.sdk.common.backend.BackendThread;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider(alias = "omega_api", value = {IDomainService.class})
public class OmegaDomainService implements IDomainService {
    public void onNotifyDomainChanged(String str) {
        ELog.log("onNotifyDomainChanged domainSuffix = " + str);
        OmegaConfig.setUploadHost(DomainUtil.rebuildHost(OmegaConfig.getUploadHost(), str));
        ELog.log("onNotifyDomainChanged UPLOAD_HOST = " + OmegaConfig.getUploadHost());
    }

    public void onNotifyDomainSwitchEvent(int i, Bundle bundle) {
        if (i == 0) {
            ELog.log("onNotifyDomainSwitchEvent  before");
            BackendThread.getInstance().wakeup();
        } else if (i == 1) {
            ELog.log("onNotifyDomainSwitchEvent  after");
        }
    }
}
