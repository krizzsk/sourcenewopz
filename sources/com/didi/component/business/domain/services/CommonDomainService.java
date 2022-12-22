package com.didi.component.business.domain.services;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider(alias = "common_func", value = {IDomainService.class})
public class CommonDomainService implements IDomainService {
    public void onNotifyDomainSwitchEvent(int i, Bundle bundle) {
    }

    public void onNotifyDomainChanged(String str) {
        ELog.log("onNotifyDomainChanged() mapapi refresh api request");
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_REFRESH_MAPAPI_DATA);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.DOMAIN_SWITCH_FINISH);
    }
}
