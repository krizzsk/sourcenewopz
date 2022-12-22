package com.didi.component.business.domain.services;

import android.os.Bundle;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider(alias = "dpush", value = {IDomainService.class})
public class DPushDomainService implements IDomainService {
    public void onNotifyDomainSwitchEvent(int i, Bundle bundle) {
    }

    public void onNotifyDomainChanged(String str) {
        ELog.log("onNotifyDomainChanged() dpush receive domainchanged() suffix = " + str);
        NationTypeUtil.refreshPushConfig();
    }
}
