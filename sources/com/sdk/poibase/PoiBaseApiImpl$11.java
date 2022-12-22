package com.sdk.poibase;

import com.didi.common.map.model.LatLng;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.google.gson.reflect.TypeToken;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.io.IOException;

class PoiBaseApiImpl$11 implements HttpRpc.Callback {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ IHttpListener val$listener;
    final /* synthetic */ ReverseGeoParam val$param;

    PoiBaseApiImpl$11(C20512a aVar, IHttpListener iHttpListener, ReverseGeoParam reverseGeoParam) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
        this.val$param = reverseGeoParam;
    }

    public void onSuccess(HttpRpcResponse httpRpcResponse) {
        GsonDeserializer gsonDeserializer = new GsonDeserializer(new TypeToken<ReverseGeoResult>() {
        }.getType());
        HttpEntity entity = httpRpcResponse.getEntity();
        if (entity == null) {
            onFailure((HttpRpcRequest) null, new IOException("entity null"));
            return;
        }
        try {
            final ReverseGeoResult reverseGeoResult = (ReverseGeoResult) gsonDeserializer.deserialize(entity.getContent());
            if (this.val$listener != null) {
                C20512a.f55995b.post(new Runnable() {
                    public void run() {
                        PoiBaseApiImpl$11.this.val$listener.onSuccess(reverseGeoResult);
                    }
                });
            }
            if (this.val$param != null && reverseGeoResult != null) {
                AlarmOmegaUtil.reverseGeoAlarmOmega(new LatLng(this.val$param.user_loc_lat, this.val$param.user_loc_lng), reverseGeoResult.result, reverseGeoResult.errno, reverseGeoResult.searchId);
            }
        } catch (IOException e) {
            onFailure((HttpRpcRequest) null, e);
        }
    }

    public void onFailure(HttpRpcRequest httpRpcRequest, final IOException iOException) {
        if (this.val$listener != null) {
            C20512a.f55995b.post(new Runnable() {
                public void run() {
                    PoiBaseApiImpl$11.this.val$listener.onFail(iOException);
                }
            });
        }
    }
}
