package com.didiglobal.privacy.domainmonitor.interceptor;

import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacy.domainmonitor.model.OmegaReportParams;
import com.didiglobal.privacy.domainmonitor.utils.OmegaUtil;

@ServiceProvider({IUrlInterceptor.class})
public class DomainUrlInterceptor implements IUrlInterceptor {
    public void intercept(OmegaReportParams omegaReportParams) {
        if (m36324a(omegaReportParams.getUrl())) {
            OmegaUtil.tech_driver_http_url_monitor(omegaReportParams.getHost(), omegaReportParams.getUrl(), omegaReportParams.getSource(), omegaReportParams.getTraceId(), omegaReportParams.getBffName(), omegaReportParams.getNetSource(), omegaReportParams.getAlarmTag());
        }
    }

    /* renamed from: a */
    private boolean m36324a(String str) {
        for (String contains : DomainMonitor.getFilterList()) {
            if (str.contains(contains)) {
                return false;
            }
        }
        return true;
    }
}
