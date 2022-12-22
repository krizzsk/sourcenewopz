package com.didi.travel.psnger.biz.waitornot;

import android.content.Context;
import com.didi.travel.psnger.HostConstants;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.UpdateOrderInfoModel;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public class NearbyWaitRequest extends BaseRequest {

    /* renamed from: a */
    private static NearbyWaitRequest f44027a;

    /* renamed from: b */
    private INearbyWaitRpcService f44028b;

    /* renamed from: c */
    private Context f44029c;

    public static NearbyWaitRequest getInstance(Context context) {
        if (f44027a == null) {
            synchronized (NearbyWaitRequest.class) {
                if (f44027a == null) {
                    f44027a = new NearbyWaitRequest(context.getApplicationContext());
                }
            }
        }
        return f44027a;
    }

    private NearbyWaitRequest(Context context) {
        this.f44029c = context;
        this.f44028b = (INearbyWaitRpcService) new RpcServiceFactory(context).newRpcService(INearbyWaitRpcService.class, HostConstants.getHostApi());
    }

    public void confirmNearbyWait(Context context, Map<String, Object> map, ResponseListener<NearbyWaitPerception> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44028b.confirmNearbyWait(createBaseParams, getRpcCallback(responseListener, new NearbyWaitPerception()));
    }

    public void updateCompanyOrderInfo(Map<String, Object> map, ResponseListener<UpdateOrderInfoModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44029c);
        createBaseParams.putAll(map);
        this.f44028b.updateCompanyOrderInfo(createBaseParams, getRpcCallback(responseListener, new UpdateOrderInfoModel()));
    }
}
