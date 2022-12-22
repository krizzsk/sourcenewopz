package com.didi.sdk.global.enterprise.util;

import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.sdk.global.enterprise.bridger.IEnterpriseBridge;
import com.didi.sdk.global.enterprise.model.data.EnterpriseInfo;

public class EnterpriseUtil {
    public static EnterpriseInfo getEnterpriseInfo() {
        IEnterpriseBridge iEnterpriseBridge = (IEnterpriseBridge) ServiceProviderManager.getInstance().getComponent(IEnterpriseBridge.class);
        if (iEnterpriseBridge == null) {
            return null;
        }
        return iEnterpriseBridge.getEnterpriseInfo();
    }

    public static void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
        IEnterpriseBridge iEnterpriseBridge = (IEnterpriseBridge) ServiceProviderManager.getInstance().getComponent(IEnterpriseBridge.class);
        if (iEnterpriseBridge != null) {
            iEnterpriseBridge.setEnterpriseInfo(enterpriseInfo);
        }
    }

    public static boolean isEnterpriseSigned() {
        EnterpriseInfo enterpriseInfo = getEnterpriseInfo();
        return enterpriseInfo != null && enterpriseInfo.isSigned();
    }
}
