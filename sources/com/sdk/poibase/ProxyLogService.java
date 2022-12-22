package com.sdk.poibase;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyLogService implements InvocationHandler {

    /* renamed from: a */
    private Object f55993a;

    public ProxyLogService(Object obj) {
        this.f55993a = obj;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        method.invoke(this.f55993a, objArr);
        return null;
    }

    /* renamed from: a */
    private void m40318a(Method method, Object[] objArr) {
        int i;
        String name = method == null ? "" : method.getName();
        if (objArr == null) {
            i = 0;
        } else {
            i = objArr.length;
        }
        if (i > 0) {
            Gson gson = new Gson();
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj != null && !(obj instanceof RpcService.Callback)) {
                    SystemUtils.log(3, "ProxyLogService", "request:" + name + "--" + gson.toJson(obj), (Throwable) null, "com.sdk.poibase.ProxyLogService", 38);
                }
            }
        }
    }
}
