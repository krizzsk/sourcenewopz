package com.sdk.poibase;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.google.gson.reflect.TypeToken;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.util.BizUtil;
import java.io.IOException;

class PoiBaseApiImpl$7 implements HttpRpc.Callback {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ RpcPoi val$address;
    final /* synthetic */ IHttpListener val$listener;

    PoiBaseApiImpl$7(C20512a aVar, IHttpListener iHttpListener, RpcPoi rpcPoi) {
        this.this$0 = aVar;
        this.val$listener = iHttpListener;
        this.val$address = rpcPoi;
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
            if (this.val$listener != null) {
                C20512a.f55995b.post(new Runnable() {
                    public void run() {
                        PoiBaseApiImpl$7.this.val$listener.onSuccess(rpcRecSug);
                    }
                });
            }
            if (this.val$address == null || this.val$address.base_info == null) {
                AlarmOmegaUtil.geoCodeAlarmOmega("", "", rpcRecSug.result, rpcRecSug.errno, rpcRecSug.search_id);
            } else {
                AlarmOmegaUtil.geoCodeAlarmOmega(this.val$address.base_info.poi_id, this.val$address.base_info.displayname, rpcRecSug != null ? rpcRecSug.result : null, rpcRecSug.errno, rpcRecSug.search_id);
            }
        } catch (IOException e) {
            onFailure((HttpRpcRequest) null, e);
        }
    }

    public void onFailure(HttpRpcRequest httpRpcRequest, final IOException iOException) {
        if (this.val$listener != null) {
            C20512a.f55995b.post(new Runnable() {
                public void run() {
                    PoiBaseApiImpl$7.this.val$listener.onFail(iOException);
                }
            });
        }
    }
}
