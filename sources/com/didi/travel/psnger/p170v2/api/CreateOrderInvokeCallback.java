package com.didi.travel.psnger.p170v2.api;

import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.biz.rpc.RpcInvokeCallback;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarOrder;

/* renamed from: com.didi.travel.psnger.v2.api.CreateOrderInvokeCallback */
public class CreateOrderInvokeCallback extends RpcInvokeCallback<CarOrder> {
    public CreateOrderInvokeCallback(RemoteCallback<CarOrder> remoteCallback) {
        super(remoteCallback);
    }

    public void onBizSuccess(CarOrder carOrder) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onBizSuccess:data = " + carOrder);
        super.onBizSuccess(carOrder);
    }

    public void onBizFail(CarOrder carOrder) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onBizFail:data = " + carOrder);
        super.onBizFail(carOrder);
    }

    public void onFinish(CarOrder carOrder) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onFinish:data = " + carOrder);
        super.onFinish(carOrder);
    }

    public void onNetError(CarOrder carOrder) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onNetError:data = " + carOrder);
        super.onNetError(carOrder);
    }
}
