package com.didi.component.business.domain.filter;

import android.text.TextUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.IDomainFilter;

@ServiceProvider(alias = "internalhostfilter", value = {IDomainFilter.class})
public class InternalDomainFilter implements IDomainFilter {
    public boolean filterDomain(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf(".didiglobal") <= 0) {
            return true;
        }
        return false;
    }
}
