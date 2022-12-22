package com.didichuxing.foundation.net.rpc.http;

import android.content.Context;
import com.didichuxing.foundation.net.rpc.http.OkHttpRpc;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.util.Converter;
import didihttp.DidiHttpClient;
import didihttp.Interceptor;

public class InterceptorConverter extends Converter<RpcInterceptor<HttpRpcRequest, HttpRpcResponse>, Interceptor> {
    public Interceptor convert(RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor, Object... objArr) {
        OkHttpRpc.OkHttpRpcInterceptor okHttpRpcInterceptor = new OkHttpRpc.OkHttpRpcInterceptor(rpcInterceptor);
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof DidiHttpClient)) {
            if (objArr.length <= 1 || !(objArr[1] instanceof Context)) {
                okHttpRpcInterceptor.mClient = new OkHttpRpcClient(objArr[0], (Context) null);
            } else {
                okHttpRpcInterceptor.mClient = new OkHttpRpcClient(objArr[0], objArr[1]);
            }
        }
        return okHttpRpcInterceptor;
    }
}
