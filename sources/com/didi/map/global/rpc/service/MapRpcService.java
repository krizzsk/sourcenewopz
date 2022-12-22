package com.didi.map.global.rpc.service;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.ArrayList;
import java.util.List;

public abstract class MapRpcService {

    /* renamed from: a */
    private List<RpcInterceptor> f27354a;
    protected Context mContext;
    protected RpcServiceFactory mFactory;

    public MapRpcService(Context context) {
        this.mFactory = null;
        this.mFactory = new RpcServiceFactory(context);
        this.mContext = context;
    }

    public MapRpcService(Context context, List<RpcInterceptor> list) {
        this(context);
        this.f27354a = list;
    }

    public void setInterceptorList(List<RpcInterceptor> list) {
        this.f27354a = list;
    }

    public void addInterceptor(RpcInterceptor rpcInterceptor) {
        if (rpcInterceptor != null) {
            if (this.f27354a == null) {
                this.f27354a = new ArrayList();
            }
            this.f27354a.add(rpcInterceptor);
        }
    }

    public Context getContext() {
        RpcServiceFactory rpcServiceFactory = this.mFactory;
        if (rpcServiceFactory == null) {
            return null;
        }
        return rpcServiceFactory.getContext();
    }

    /* access modifiers changed from: protected */
    public <T extends RpcService> T getService(Class<T> cls, String str) {
        return this.mFactory.newRpcService(cls, str);
    }

    public <T extends RpcClient<? extends RpcRequest, ? extends RpcResponse>> T getRpcClient(String str) {
        RpcServiceFactory rpcServiceFactory;
        if (TextUtils.isEmpty(str) || (rpcServiceFactory = this.mFactory) == null) {
            return null;
        }
        return rpcServiceFactory.getRpcClient(str);
    }
}
