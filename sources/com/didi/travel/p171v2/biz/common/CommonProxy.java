package com.didi.travel.p171v2.biz.common;

import com.didi.travel.p171v2.biz.Biz;
import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.ApiProxy;
import com.didi.travel.p171v2.biz.api.IApiInvokeCallback;
import java.lang.reflect.Method;

/* renamed from: com.didi.travel.v2.biz.common.CommonProxy */
public class CommonProxy<T extends IBiz> extends ApiProxy<T> {
    public CommonProxy(Biz<T> biz) {
        super(biz);
    }

    public Object invoke(Api api, Object obj, Method method, Object[] objArr) {
        IApiInvokeCallback instanceApiInvokeCallback = api.instanceApiInvokeCallback();
        doInvokeBefore(api, instanceApiInvokeCallback, objArr);
        String key = api.getKey();
        if (((key.hashCode() == -97285837 && key.equals(IBiz.API_KEY_BIZ_KEY)) ? (char) 0 : 65535) == 0) {
            String key2 = this.mBiz.getKey();
            doInvokeAfter(api, instanceApiInvokeCallback, objArr);
            return key2;
        }
        throw new IllegalArgumentException(this.TAG + "invalid invoke:api = " + api);
    }

    /* access modifiers changed from: protected */
    public void doInvokeBefore(Api api, IApiInvokeCallback iApiInvokeCallback, Object[] objArr) {
        iApiInvokeCallback.beforeInvoke(api, objArr);
    }

    /* access modifiers changed from: protected */
    public void doInvokeAfter(Api api, IApiInvokeCallback iApiInvokeCallback, Object[] objArr) {
        iApiInvokeCallback.afterInvoke(api, objArr);
    }
}
