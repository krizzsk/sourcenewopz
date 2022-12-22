package com.didiglobal.privacy.domainmonitor.interceptor;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import com.didiglobal.privacy.domainmonitor.model.OmegaReportParams;

@ServiceProviderInterface
public interface IUrlInterceptor {
    void intercept(OmegaReportParams omegaReportParams);
}
