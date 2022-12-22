package com.didi.sdk.webview;

import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.BusinessParamsUtil;
import com.didi.sdk.webview.tool.IWebProductIdService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IWebProductIdService.class})
public class WebProductIdService implements IWebProductIdService {
    public int getProductId() {
        return BusinessParamsUtil.getProductId(ConfProxy.getInstance().getSelectedType());
    }
}
