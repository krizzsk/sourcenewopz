package com.didi.soda.customer.foundation.rpc.header;

import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;

public abstract class AbsHttpHeaderContentProvider {

    /* renamed from: a */
    private HttpRpcRequest f41051a;

    /* renamed from: b */
    private HttpRpcClient f41052b;

    public abstract String getParamContent();

    public abstract String getParamKey();

    public AbsHttpHeaderContentProvider(HttpRpcRequest httpRpcRequest, HttpRpcClient httpRpcClient) {
        this.f41051a = httpRpcRequest;
        this.f41052b = httpRpcClient;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpRpcClient mo104801a() {
        return this.f41052b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public HttpRpcRequest mo104802b() {
        return this.f41051a;
    }
}
