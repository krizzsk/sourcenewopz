package com.didi.entrega.customer.foundation.rpc.header;

import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;

public abstract class AbsHttpHeaderContentProvider {

    /* renamed from: a */
    private HttpRpcRequest f20015a;

    /* renamed from: b */
    private HttpRpcClient f20016b;

    public abstract String getParamContent();

    public abstract String getParamKey();

    public AbsHttpHeaderContentProvider(HttpRpcRequest httpRpcRequest, HttpRpcClient httpRpcClient) {
        this.f20015a = httpRpcRequest;
        this.f20016b = httpRpcClient;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpRpcClient mo60716a() {
        return this.f20016b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public HttpRpcRequest mo60717b() {
        return this.f20015a;
    }
}
