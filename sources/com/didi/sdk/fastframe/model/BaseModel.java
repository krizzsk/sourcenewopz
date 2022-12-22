package com.didi.sdk.fastframe.model;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.lang.reflect.Proxy;

public class BaseModel implements IModel {
    protected RpcServiceFactory factory = null;

    public BaseModel(Context context) {
        if (context != null) {
            this.factory = new RpcServiceFactory(context);
            return;
        }
        throw new IllegalArgumentException("baseModel:context空");
    }

    public <T extends RpcService> T getService(Class<T> cls, String str) {
        T newRpcService = this.factory.newRpcService(cls, str);
        return (RpcService) Proxy.newProxyInstance(newRpcService.getClass().getClassLoader(), newRpcService.getClass().getInterfaces(), new ProxyLogService(newRpcService));
    }

    public <T extends RpcClient<? extends RpcRequest, ? extends RpcResponse>> T getRpcClient(String str) {
        RpcServiceFactory rpcServiceFactory;
        if (TextUtils.isEmpty(str) || (rpcServiceFactory = this.factory) == null) {
            return null;
        }
        return rpcServiceFactory.getRpcClient(str);
    }

    public Context getContext() {
        RpcServiceFactory rpcServiceFactory = this.factory;
        if (rpcServiceFactory == null) {
            return null;
        }
        return rpcServiceFactory.getContext();
    }
}
