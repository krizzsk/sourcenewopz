package com.didi.sdk.net;

import com.didi.sdk.log.Logger;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import didihttp.HttpUrl;
import java.io.IOException;

@ServiceProvider({RpcInterceptor.class})
public class GlobalCommonParamsInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcRequest.Builder newBuilder = request.newBuilder();
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        newBuilder.setUrl(HttpUrl.parse(request.getUrl()).newBuilder().addEncodedQueryParameter("utc_offset", String.valueOf(nationComponentData.getTimeZoneUtcOffset())).addEncodedQueryParameter("origin_id", nationComponentData.getOriginID()).addEncodedQueryParameter("biz_type", nationComponentData.getBiz_type()).addEncodedQueryParameter("terminal_id", nationComponentData.getTerminal_id()).addEncodedQueryParameter("platform_type", nationComponentData.getPlatform_type()).addEncodedQueryParameter("trip_type", nationComponentData.getLocCountry()).addEncodedQueryParameter("location_country", nationComponentData.getLocCountry()).addEncodedQueryParameter("location_cityid", nationComponentData.getCityId()).build().toString());
        HttpRpcResponse proceed = rpcChain.proceed(newBuilder.build());
        String name = RpcInterceptor.class.getName();
        Logger.m25808d(name, "URL:" + request.getUrl());
        return proceed;
    }
}
