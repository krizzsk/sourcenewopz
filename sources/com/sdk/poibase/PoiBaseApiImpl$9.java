package com.sdk.poibase;

import com.didichuxing.foundation.rpc.RpcService;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.IHttpListener;
import java.io.IOException;

class PoiBaseApiImpl$9 implements RpcService.Callback<HttpResultBase> {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ IHttpListener val$listener;

    PoiBaseApiImpl$9(C20512a aVar, IHttpListener iHttpListener) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
    }

    public void onSuccess(HttpResultBase httpResultBase) {
        IHttpListener iHttpListener = this.val$listener;
        if (iHttpListener != null) {
            iHttpListener.onSuccess(httpResultBase);
        }
    }

    public void onFailure(IOException iOException) {
        IHttpListener iHttpListener = this.val$listener;
        if (iHttpListener != null) {
            iHttpListener.onFail(iOException);
        }
    }
}
