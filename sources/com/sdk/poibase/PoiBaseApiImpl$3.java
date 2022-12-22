package com.sdk.poibase;

import com.didichuxing.foundation.rpc.RpcService;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.recsug.RpcRecSug;
import java.io.IOException;

class PoiBaseApiImpl$3 implements RpcService.Callback<RpcRecSug> {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ IHttpListener val$listener;

    PoiBaseApiImpl$3(C20512a aVar, IHttpListener iHttpListener) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
    }

    public void onSuccess(RpcRecSug rpcRecSug) {
        IHttpListener iHttpListener = this.val$listener;
        if (iHttpListener != null) {
            iHttpListener.onSuccess(rpcRecSug);
        }
    }

    public void onFailure(IOException iOException) {
        IHttpListener iHttpListener = this.val$listener;
        if (iHttpListener != null) {
            iHttpListener.onFail(iOException);
        }
    }
}
