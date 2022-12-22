package com.didichuxing.mas.sdk.quality.report.utils;

import android.os.Bundle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.BackendThread;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider(alias = "omega_api", value = {IDomainService.class})
public class OmegaDomainService implements IDomainService {
    public void onNotifyDomainChanged(String str) {
        ELog.log("onNotifyDomainChanged domainSuffix = " + str);
        MASConfig.UPLOAD_HOST = DomainUtil.rebuildHost(MASConfig.UPLOAD_HOST, str);
        ELog.log("onNotifyDomainChanged UPLOAD_HOST = " + MASConfig.UPLOAD_HOST);
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
