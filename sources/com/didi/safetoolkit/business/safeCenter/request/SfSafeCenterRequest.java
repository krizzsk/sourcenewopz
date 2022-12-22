package com.didi.safetoolkit.business.safeCenter.request;

import com.didi.safetoolkit.net.ISfNetService;
import com.didi.safetoolkit.net.ISfRpcRequest;
import com.didi.safetoolkit.net.SfRpcParam;
import com.didi.safetoolkit.net.SfServerParam;
import com.didi.safetoolkit.net.SfUrls;

public class SfSafeCenterRequest implements ISfRpcRequest<ISfNetService> {
    @SfRpcParam("lang")
    public String lang;
    @SfRpcParam("origin_id")
    public String originId;
    @SfRpcParam("token")
    public String token;
    @SfRpcParam("oasisDriver")
    public int vamosDriver;

    public String getPathParameter() {
        return null;
    }

    public String getServiceName() {
        return SfServerParam.SERVICE_SAFETY_CENTER;
    }

    public String getBaseUrl() {
        return SfUrls.getBaseUrl();
    }
}
