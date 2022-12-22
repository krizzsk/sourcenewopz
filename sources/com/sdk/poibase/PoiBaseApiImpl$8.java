package com.sdk.poibase;

import com.didichuxing.foundation.rpc.RpcService;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.recoperation.RpcRecOperation;
import java.io.IOException;

class PoiBaseApiImpl$8 implements RpcService.Callback<RpcRecOperation> {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ IHttpListener val$listener;

    PoiBaseApiImpl$8(C20512a aVar, IHttpListener iHttpListener) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
    }

    public void onSuccess(RpcRecOperation rpcRecOperation) {
        IHttpListener iHttpListener = this.val$listener;
        if (iHttpListener != null) {
            iHttpListener.onSuccess(rpcRecOperation);
        }
    }

    public void onFailure(IOException iOException) {
        IHttpListener iHttpListener = this.val$listener;
        if (iHttpListener != null) {
            iHttpListener.onFail(iOException);
        }
    }
}
