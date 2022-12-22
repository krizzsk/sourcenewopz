package com.didi.travel.p171v2.biz.common;

import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.IApiInvokeCallback;
import com.didi.travel.p171v2.util.LogUtils;

/* renamed from: com.didi.travel.v2.biz.common.CommonInvokeCallback */
public class CommonInvokeCallback implements IApiInvokeCallback {
    protected final String TAG = CommonInvokeCallback.class.getSimpleName();

    public void beforeInvoke(Api api, Object[] objArr) {
        String str = this.TAG;
        LogUtils.m31493i(str, "beforeInvoke : api = " + api);
    }

    public void afterInvoke(Api api, Object[] objArr) {
        String str = this.TAG;
        LogUtils.m31493i(str, "afterInvoke : api = " + api);
    }
}
