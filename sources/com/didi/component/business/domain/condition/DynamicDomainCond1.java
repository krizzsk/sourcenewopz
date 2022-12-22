package com.didi.component.business.domain.condition;

import android.content.Context;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.IDomainSwitchCondition;

@ServiceProvider(alias = "ab_toggle", value = {IDomainSwitchCondition.class})
public class DynamicDomainCond1 implements IDomainSwitchCondition {
    public boolean isAllowDomainSwitch(Context context) {
        return true;
    }
}
