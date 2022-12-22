package com.didiglobal.domainservice;

import android.os.Bundle;

public interface IDomainService {
    void onNotifyDomainChanged(String str);

    void onNotifyDomainSwitchEvent(int i, Bundle bundle);
}
