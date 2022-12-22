package com.didichuxing.foundation.net.rpc.http;

import android.content.Context;
import com.didichuxing.foundation.net.rpc.http.OkHttpRpcClient;
import com.didichuxing.foundation.util.Converter;
import didihttp.DidiHttpClient;

public class HttpClientConverter extends Converter<DidiHttpClient, OkHttpRpcClient> {
    public OkHttpRpcClient convert(DidiHttpClient didiHttpClient, Object... objArr) {
        OkHttpRpcClient.Builder builder = new OkHttpRpcClient.Builder(didiHttpClient);
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Context)) {
            builder.setContext(objArr[0]);
        }
        return builder.build();
    }
}
