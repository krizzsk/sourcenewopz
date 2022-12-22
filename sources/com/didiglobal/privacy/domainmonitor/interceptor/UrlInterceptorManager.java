package com.didiglobal.privacy.domainmonitor.interceptor;

import android.text.TextUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacy.domainmonitor.model.OmegaReportParams;
import java.util.Iterator;

public class UrlInterceptorManager {

    /* renamed from: a */
    private static final String f50521a = "0";

    /* renamed from: b */
    private static final String f50522b = "1";

    /* renamed from: c */
    private static final String f50523c = "2";

    /* renamed from: d */
    private static final String f50524d = "1000";

    /* renamed from: e */
    private static ServiceLoader<IUrlInterceptor> f50525e = ServiceLoader.load(IUrlInterceptor.class);

    public static void dispatchUrl(OmegaReportParams omegaReportParams) {
        ServiceLoader<IUrlInterceptor> serviceLoader;
        if (!TextUtils.isEmpty(omegaReportParams.getUrl()) && (serviceLoader = f50525e) != null && serviceLoader.get() != null) {
            omegaReportParams.setAlarmTag(m36325a(omegaReportParams.getUrl(), omegaReportParams.getHost()));
            Iterator<IUrlInterceptor> it = f50525e.iterator();
            while (it.hasNext()) {
                IUrlInterceptor next = it.next();
                if (next != null) {
                    next.intercept(omegaReportParams);
                }
            }
        }
    }

    /* renamed from: a */
    private static String m36325a(String str, String str2) {
        if (!DomainMonitor.isAlarm()) {
            return "1000";
        }
        if (DomainMonitor.getWhiteList().containsKey(str2)) {
            return "0";
        }
        for (String contains : DomainMonitor.getBlackList()) {
            if (str.contains(contains)) {
                return "1";
            }
        }
        return "2";
    }
}
