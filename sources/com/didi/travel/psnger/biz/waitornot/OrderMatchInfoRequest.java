package com.didi.travel.psnger.biz.waitornot;

import android.content.Context;
import com.didi.travel.psnger.HostConstants;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public class OrderMatchInfoRequest extends BaseRequest {

    /* renamed from: a */
    private IOrderInfoRpcService f44030a;

    public OrderMatchInfoRequest(Context context) {
        this.f44030a = (IOrderInfoRpcService) new RpcServiceFactory(context).newRpcService(IOrderInfoRpcService.class, HostConstants.getHostApi());
    }

    public void getOrderMatchInfo(Context context, Map<String, Object> map, ResponseListener<OrderMatchInfoPerception> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44030a.getOrderMatchInfo(createBaseParams, getRpcCallback(responseListener, new OrderMatchInfoPerception()));
    }
}
