package com.didi.component.business.domain;

import com.didi.sdk.app.DIDIApplication;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.publicservice.network.INonRpcInterceptor;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import java.net.MalformedURLException;
import java.net.URL;

@ServiceProvider({INonRpcInterceptor.class})
public class PubSvrNetInterceptor implements INonRpcInterceptor {
    public URL intercept(URL url) {
        ELog.log("publicService doomainservice URL intercept ");
        if (!DomainUtil.isSupportDomainSwitch(DIDIApplication.getAppContext()) || url == null || DomainUtil.isInIpFormat(url.getHost())) {
            return url;
        }
        String rebuildUrl = DomainUtil.rebuildUrl(url.toString(), DomainServiceManager.getInstance().getDomainSuffix(DIDIApplication.getAppContext()));
        ELog.log("    publicservice after rebuild return newUrl: " + rebuildUrl);
        try {
            return new URL(rebuildUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return url;
        }
    }
}
