package com.didi.component.common.net;

import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.common.util.AddressUtil;
import com.didi.component.common.util.GLog;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import didihttp.HttpUrl;
import java.io.IOException;

public class EasternGlobalCommonParamsIntercedptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f11650a = "EasternGlobalCommonParamsIntercedptor";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        HttpRpcRequest.Builder newBuilder = request.newBuilder();
        newBuilder.setUrl(HttpUrl.parse(request.getUrl()).newBuilder().addEncodedQueryParameter("product_id", BusinessDataUtil.getProductId()).addEncodedQueryParameter("trip_country", AddressUtil.getTripCountry(nationComponentData)).addEncodedQueryParameter("trip_cityid", AddressUtil.getTripCityId(nationComponentData)).build().toString());
        HttpRpcRequest build = newBuilder.build();
        HttpRpcResponse proceed = rpcChain.proceed(build);
        GLog.m7965d(f11650a, "URL:" + build.getUrl());
        return proceed;
    }
}
