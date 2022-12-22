package com.sdk.poibase;

import com.didi.common.map.model.LatLng;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.google.gson.reflect.TypeToken;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.util.BizUtil;
import java.io.IOException;

class PoiBaseApiImpl$6 implements HttpRpc.Callback {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ AddressParam val$addressParam;
    final /* synthetic */ IHttpListener val$listener;

    PoiBaseApiImpl$6(C20512a aVar, IHttpListener iHttpListener, AddressParam addressParam) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
        this.val$addressParam = addressParam;
    }

    public void onSuccess(HttpRpcResponse httpRpcResponse) {
        GsonDeserializer gsonDeserializer = new GsonDeserializer(new TypeToken<RpcRecSug>() {
        }.getType());
        HttpEntity entity = httpRpcResponse.getEntity();
        if (entity == null) {
            onFailure((HttpRpcRequest) null, new IOException("entity null"));
            return;
        }
        try {
            final RpcRecSug rpcRecSug = (RpcRecSug) gsonDeserializer.deserialize(entity.getContent());
            if (rpcRecSug != null) {
                BizUtil.insertCountryInfoToRecSugPoi(rpcRecSug.countryId, rpcRecSug.countryCode, rpcRecSug.rec_poi_list, rpcRecSug.result);
            }
            this.this$0.m40323a(rpcRecSug);
            if (this.val$listener != null) {
                C20512a.f55995b.post(new Runnable() {
                    public void run() {
                        PoiBaseApiImpl$6.this.val$listener.onSuccess(rpcRecSug);
                    }
                });
            }
            if (this.val$addressParam != null && rpcRecSug != null) {
                AlarmOmegaUtil.textSearchAlarmOmega(this.val$addressParam.currentAddress != null ? new LatLng(this.val$addressParam.currentAddress.latitude, this.val$addressParam.currentAddress.longitude) : null, this.val$addressParam.currentAddress != null ? new LatLng(this.val$addressParam.targetAddress.latitude, this.val$addressParam.targetAddress.longitude) : null, this.val$addressParam.query, this.val$addressParam.addressType, rpcRecSug.errno, rpcRecSug.search_id);
            }
        } catch (IOException e) {
            onFailure((HttpRpcRequest) null, e);
        }
    }

    public void onFailure(HttpRpcRequest httpRpcRequest, final IOException iOException) {
        if (this.val$listener != null) {
            C20512a.f55995b.post(new Runnable() {
                public void run() {
                    PoiBaseApiImpl$6.this.val$listener.onFail(iOException);
                }
            });
        }
    }
}
