package com.didi.component.safetoolkit.api.requests;

import android.content.Context;
import com.didi.component.business.constant.HostConstants;
import com.didi.component.safetoolkit.api.SafeToolkitRequestService;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public class SafeToolkitRequest extends BaseRequest {

    /* renamed from: a */
    private SafeToolkitRequestService f15356a;

    /* renamed from: b */
    private Context f15357b;

    public void reportUserState() {
    }

    public SafeToolkitRequest(Context context) {
        this.f15357b = context;
        this.f15356a = (SafeToolkitRequestService) new RpcServiceFactory(context).newRpcService(SafeToolkitRequestService.class, HostConstants.getHostApi());
    }

    public void querySafeToolkitStatus(Map<String, Object> map, RpcService.Callback callback) {
        Map<String, Object> createBaseParams = createBaseParams(this.f15357b);
        if (map != null) {
            createBaseParams.putAll(map);
        }
        this.f15356a.queryStatus(createBaseParams, callback);
    }
}
