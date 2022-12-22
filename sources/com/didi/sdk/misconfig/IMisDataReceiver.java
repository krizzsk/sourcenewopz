package com.didi.sdk.misconfig;

import com.didi.sdk.app.BusinessContext;

public interface IMisDataReceiver {
    void addContext(String str, BusinessContext businessContext);

    void destory();

    void init();
}
