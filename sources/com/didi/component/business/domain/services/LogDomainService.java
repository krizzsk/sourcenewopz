package com.didi.component.business.domain.services;

import android.os.Bundle;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.LoggerConfig;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import java.lang.reflect.Field;

@ServiceProvider(alias = "logapi", value = {IDomainService.class})
public class LogDomainService implements IDomainService {
    public void onNotifyDomainSwitchEvent(int i, Bundle bundle) {
    }

    public void onNotifyDomainChanged(String str) {
        ELog.log("onNotifyDomainChanged() logging-api domainservice receive domain changed with: " + str);
        String domainSuffix = DomainServiceManager.getInstance().getDomainSuffix(DIDIApplication.getAppContext());
        LoggerConfig config = LoggerFactory.getConfig();
        try {
            Field declaredField = Class.forName(LoggerConfig.class.getName()).getDeclaredField("serverHost");
            declaredField.setAccessible(true);
            declaredField.set(config, DomainUtil.rebuildHost(config.getServerHost(), domainSuffix));
            ELog.log("   ┗Logging-api after reset serverhost: " + LoggerFactory.getConfig().getServerHost());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            ELog.log("   ┗Logging-api reset serverhost failed : " + e.getMessage());
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            ELog.log("   ┗Logging-api reset serverhost failed2 : " + e2.getMessage());
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            ELog.log("   ┗Logging-api reset serverhost failed3 : " + e3.getMessage());
        } catch (ClassCastException e4) {
            e4.printStackTrace();
            ELog.log("   ┗Logging-api reset serverhost failed4 : " + e4.getMessage());
        }
    }
}
