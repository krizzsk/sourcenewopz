package com.didi.travel.psnger.p170v2.api;

import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.biz.rpc.RpcInvokeCallback;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.service.CoreHttpRequest;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;

/* renamed from: com.didi.travel.psnger.v2.api.GetOrderDetailRpcInvokeCallback */
public class GetOrderDetailRpcInvokeCallback extends RpcInvokeCallback<DTSDKOrderDetail> {
    public GetOrderDetailRpcInvokeCallback(RemoteCallback<DTSDKOrderDetail> remoteCallback) {
        super(remoteCallback);
    }

    public void onBizSuccess(DTSDKOrderDetail dTSDKOrderDetail) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onBizSuccess:data = " + dTSDKOrderDetail + ", mOriginListener = " + this.mOriginListener);
        if (this.mOriginListener instanceof ITravelOrderListener) {
            CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) this.mOriginListener);
            return;
        }
        CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) null);
        super.onBizSuccess(dTSDKOrderDetail);
    }

    public void onBizFail(DTSDKOrderDetail dTSDKOrderDetail) {
        LogUtils.m31493i(this.TAG, "onBizFail:data = " + dTSDKOrderDetail + ", mOriginListener = " + this.mOriginListener);
        if (this.mOriginListener == null || !(this.mOriginListener instanceof ITravelOrderListener)) {
            super.onBizFail(dTSDKOrderDetail);
        } else {
            String str = dTSDKOrderDetail.errmsg;
            if (dTSDKOrderDetail.getThrowable() != null) {
                str = str + " throwable=" + dTSDKOrderDetail.getThrowable().getMessage();
            }
            ((ITravelOrderListener) this.mOriginListener).onFail(dTSDKOrderDetail.errno, str);
        }
        OmegaUtils.trackEvent("gp_confirm_orderDetail_request_result", Constants.ERROR_CODE, dTSDKOrderDetail.errno + "");
    }

    public void onNetError(DTSDKOrderDetail dTSDKOrderDetail) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onNetError:data = " + dTSDKOrderDetail + ", mOriginListener = " + this.mOriginListener);
        if (this.mOriginListener == null || !(this.mOriginListener instanceof ITravelOrderListener)) {
            super.onNetError(dTSDKOrderDetail);
        } else {
            ((ITravelOrderListener) this.mOriginListener).onFail(dTSDKOrderDetail.errno, dTSDKOrderDetail.errmsg);
        }
        OmegaUtils.trackEvent("gp_confirm_orderDetail_request_result", Constants.ERROR_CODE, dTSDKOrderDetail.errno + "");
    }

    public void onFinish(DTSDKOrderDetail dTSDKOrderDetail) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onFinish:data = " + dTSDKOrderDetail);
        if (this.mOriginListener == null || !(this.mOriginListener instanceof ITravelOrderListener)) {
            super.onFinish(dTSDKOrderDetail);
        }
    }
}
