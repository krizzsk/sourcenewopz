package com.didi.sdk.spi;

import com.didi.sdk.app.ProductPrefix;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({ProductPrefix.class})
public class AppProductPrefix implements ProductPrefix {
    public String getProductPrefix() {
        return NationTypeUtil.getNationComponentData().getProductPreFix();
    }
}
