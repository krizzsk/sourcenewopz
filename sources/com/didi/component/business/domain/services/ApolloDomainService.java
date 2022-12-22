package com.didi.component.business.domain.services;

import android.os.Bundle;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider(alias = "apolloapi", value = {IDomainService.class})
public class ApolloDomainService implements IDomainService {
    public void onNotifyDomainSwitchEvent(int i, Bundle bundle) {
    }

    public void onNotifyDomainChanged(String str) {
        ELog.log("onNotifyDomainChanged() apollo-api domainservice receive domainchange suffix = " + str);
        String rebuildHost = DomainUtil.rebuildHost(Apollo.getServerHost(), str);
        ELog.log("    ┗appollo sdk rebuild newHost:" + rebuildHost);
        Apollo.setServerHost(rebuildHost);
    }
}
