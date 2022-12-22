package com.didi.sdk.global.enterprise.bridger;

import com.didi.sdk.global.enterprise.model.data.EnterpriseInfo;

@Deprecated
public interface IEnterpriseBridge {
    EnterpriseInfo getEnterpriseInfo();

    void setEnterpriseInfo(EnterpriseInfo enterpriseInfo);
}
