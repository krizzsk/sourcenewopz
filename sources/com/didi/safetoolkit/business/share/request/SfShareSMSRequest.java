package com.didi.safetoolkit.business.share.request;

import com.didi.safetoolkit.net.ISfNetService;
import com.didi.safetoolkit.net.ISfRpcRequest;
import com.didi.safetoolkit.net.SfRpcParam;
import com.didi.safetoolkit.net.SfUrls;

public class SfShareSMSRequest implements ISfRpcRequest<ISfNetService> {
    @SfRpcParam("contacts")
    public String contacts;
    @SfRpcParam("oid")
    public String orderId;
    @SfRpcParam("product_id")
    public int productId;

    public String getPathParameter() {
        return null;
    }

    public String getServiceName() {
        return "shareSMS";
    }

    public String getBaseUrl() {
        return SfUrls.getBaseUrl();
    }
}
