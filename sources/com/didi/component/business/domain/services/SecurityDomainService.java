package com.didi.component.business.domain.services;

import android.app.Application;
import android.os.Bundle;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.sdk.app.DIDIApplication;
import com.didi.security.wireless.SecurityManager;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider(alias = "apisecurity", value = {IDomainService.class})
public class SecurityDomainService implements IDomainService {
    public void onNotifyDomainSwitchEvent(int i, Bundle bundle) {
    }

    public void onNotifyDomainChanged(String str) {
        ELog.log("onNotifyDomainChanged() apisec receive domain changed with " + str);
        SecurityManager.setHost(mo46197a(SecurityManager.getHost()));
        OmegaSDK.setUploadHost(mo46197a(OmegaSDK.getUploadHost()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo46197a(String str) {
        Application appContext = DIDIApplication.getAppContext();
        return DomainUtil.rebuildHost(str, DomainServiceManager.getInstance().getDomainSuffix(appContext), GlobalApolloUtil.getWhiteListDomain(appContext));
    }
}
