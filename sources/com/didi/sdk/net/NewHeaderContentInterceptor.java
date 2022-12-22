package com.didi.sdk.net;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.gson.Gson;
import java.io.IOException;

@ServiceProvider({RpcInterceptor.class})
public class NewHeaderContentInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcClient rpcClient = request.getRpcClient();
        HttpRpcRequest.Builder newBuilder = request.newBuilder();
        HeaderContent headerContent = new HeaderContent();
        headerContent.setLang(MultiLocaleStore.getInstance().getLocaleCode());
        String currency = NationTypeUtil.getNationComponentData().getCurrency();
        if (request.getUrl().contains("external/wallet/all_entries/query") && !TextUtils.isEmpty(currency)) {
            headerContent.setCurrency(currency);
        }
        headerContent.setAppTimeout(rpcClient.getReadTimeout() + rpcClient.getWriteTimeout());
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        Uri parse = Uri.parse(request.getUrl());
        if (parse != null) {
            headerContent.setUtc_offset(nationComponentData.getTimeZoneUtcOffset());
            headerContent.setLang(nationComponentData.getLocaleCode());
            DIDILocation didiLocation = nationComponentData.getDidiLocation();
            if (didiLocation != null) {
                headerContent.setLng(didiLocation.getLongitude());
                headerContent.setLat(didiLocation.getLatitude());
            }
            if (parse.getQueryParameterNames().contains("trip_country")) {
                headerContent.setTrip_country(parse.getQueryParameter("trip_country"));
            }
            if (parse.getQueryParameterNames().contains("trip_cityid")) {
                headerContent.setTripCity(parse.getQueryParameter("trip_cityid"));
            }
            if (parse.getQueryParameterNames().contains("product_id")) {
                headerContent.setProductId(parse.getQueryParameter("product_id"));
            }
            headerContent.setLocation_country(nationComponentData.getLocCountry());
            headerContent.setLocation_cityid(nationComponentData.getCityId());
            headerContent.setLocaleCode(MultiLocaleUtil.getLanguageModel().getLocale());
        }
        try {
            newBuilder.addHeader("didi-header-hint-content", new Gson().toJson((Object) headerContent));
        } catch (IncompatibleClassChangeError e) {
            e.printStackTrace();
        }
        String str = NationTypeUtil.getNationComponentData().getLocCountry() + "";
        if (parse != null && parse.getQueryParameterNames().contains(ServerParam.PARAM_TRIPCOUNTRY)) {
            str = parse.getQueryParameter(ServerParam.PARAM_TRIPCOUNTRY);
        }
        newBuilder.addHeader(ServerParam.PARAM_TRIPCOUNTRY, str + "");
        return rpcChain.proceed(newBuilder.build());
    }
}
