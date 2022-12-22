package com.didi.travel.p171v2.biz.api;

/* renamed from: com.didi.travel.v2.biz.api.IApiInvokeCallback */
public interface IApiInvokeCallback {
    void afterInvoke(Api api, Object[] objArr);

    void beforeInvoke(Api api, Object[] objArr);
}
