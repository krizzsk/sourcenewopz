package com.didi.safetoolkit.business.emergency.request;

import com.didi.safetoolkit.net.ISfNetService;
import com.didi.safetoolkit.net.ISfRpcRequest;
import com.didi.safetoolkit.net.SfRpcParam;
import com.didi.safetoolkit.net.SfUrls;

public class SfEmergencyStatusRequest implements ISfRpcRequest<ISfNetService> {
    @SfRpcParam("country_code")
    public String countryCode;
    @SfRpcParam("oid")
    public String orderId;
    @SfRpcParam("product_id")
    public int productId;

    public String getPathParameter() {
        return null;
    }

    public String getServiceName() {
        return "emergencyStatus";
    }

    public String getBaseUrl() {
        return SfUrls.getBaseUrl();
    }
}
