package com.sdk.poibase;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.google.gson.reflect.TypeToken;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.destpoi.DestPoiReverseInfo;
import java.io.IOException;

class PoiBaseApiImpl$16 implements HttpRpc.Callback {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ IHttpListener val$listener;

    PoiBaseApiImpl$16(C20512a aVar, IHttpListener iHttpListener) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
    }

    public void onSuccess(HttpRpcResponse httpRpcResponse) {
        HttpEntity entity = httpRpcResponse.getEntity();
        if (entity == null) {
            onFailure((HttpRpcRequest) null, new IOException("entity null"));
            return;
        }
        try {
            SystemUtils.log(4, "PoiBaseApiImpl", "onSuccess: result: " + String.valueOf(entity.getContent()), (Throwable) null, "com.sdk.poibase.PoiBaseApiImpl$16", 1018);
            final DestPoiReverseInfo destPoiReverseInfo = (DestPoiReverseInfo) new GsonDeserializer(new TypeToken<DestPoiReverseInfo>() {
            }.getType()).deserialize(entity.getContent());
            if (this.val$listener != null) {
                C20512a.f55995b.post(new Runnable() {
                    public void run() {
                        PoiBaseApiImpl$16.this.val$listener.onSuccess(destPoiReverseInfo);
                    }
                });
            }
        } catch (IOException e) {
            onFailure((HttpRpcRequest) null, e);
        }
    }

    public void onFailure(HttpRpcRequest httpRpcRequest, final IOException iOException) {
        if (this.val$listener != null) {
            C20512a.f55995b.post(new Runnable() {
                public void run() {
                    PoiBaseApiImpl$16.this.val$listener.onFail(iOException);
                }
            });
        }
    }
}
