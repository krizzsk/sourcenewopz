package com.sdk.poibase;

import com.didi.common.map.model.LatLng;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.google.gson.reflect.TypeToken;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.poi.PoiInfoParam;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.util.BizUtil;
import java.io.IOException;

class PoiBaseApiImpl$1 implements HttpRpc.Callback {
    final /* synthetic */ C20512a this$0;
    final /* synthetic */ IHttpListener val$listener;
    final /* synthetic */ PoiInfoParam val$param;

    PoiBaseApiImpl$1(C20512a aVar, PoiInfoParam poiInfoParam, IHttpListener iHttpListener) {
        this.this$0 = aVar;
        this.val$param = poiInfoParam;
        this.val$listener = iHttpListener;
    }

    public void onSuccess(HttpRpcResponse httpRpcResponse) {
        HttpEntity entity = httpRpcResponse.getEntity();
        if (entity == null) {
            onFailure((HttpRpcRequest) null, new IOException("entity null"));
            return;
        }
        try {
            final ReverseStationsInfo reverseStationsInfo = (ReverseStationsInfo) new GsonDeserializer(new TypeToken<ReverseStationsInfo>() {
            }.getType()).deserialize(entity.getContent());
            if (reverseStationsInfo != null) {
                BizUtil.insertCountryInfoToPoi(reverseStationsInfo.countryId, reverseStationsInfo.countryCode, reverseStationsInfo.result, reverseStationsInfo.recStartPoints, reverseStationsInfo.recDestination);
            }
            String callFrom = CallFrom.GLOBAL_HOMEPAGE_STATION.toString();
            if (!(this.val$param == null || this.val$param.callFrom == null)) {
                callFrom = this.val$param.callFrom.toString();
            }
            AlarmOmegaUtil.checkPoiResponseIsValid(reverseStationsInfo, callFrom);
            if (!(this.val$param == null || reverseStationsInfo == null)) {
                AlarmOmegaUtil.poiInfoAlarmOmega(new LatLng(this.val$param.user_loc_lat, this.val$param.user_loc_lng), new LatLng(this.val$param.select_lat, this.val$param.select_lng), callFrom, reverseStationsInfo.errno, reverseStationsInfo.searchId);
            }
            if (this.val$listener != null) {
                C20512a.f55995b.post(new Runnable() {
                    public void run() {
                        PoiBaseApiImpl$1.this.val$listener.onSuccess(reverseStationsInfo);
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
                    PoiBaseApiImpl$1.this.val$listener.onFail(iOException);
                }
            });
        }
    }
}
