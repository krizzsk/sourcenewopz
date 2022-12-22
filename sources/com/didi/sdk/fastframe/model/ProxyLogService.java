package com.didi.sdk.fastframe.model;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyLogService implements InvocationHandler {

    /* renamed from: a */
    private Object f35888a;

    public ProxyLogService(Object obj) {
        this.f35888a = obj;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        return method.invoke(this.f35888a, objArr);
    }

    /* renamed from: a */
    private void m25414a(Method method, Object[] objArr) {
        String name = method == null ? "" : method.getName();
        int size = CollectionUtil.size(objArr);
        if (size > 0) {
            Gson gson = new Gson();
            for (int i = 0; i < size; i++) {
                Object obj = objArr[i];
                if (obj != null && !(obj instanceof RpcService.Callback)) {
                    SystemUtils.log(3, "ProxyLogService", "request:" + name + "--" + gson.toJson(obj), (Throwable) null, "com.didi.sdk.fastframe.model.ProxyLogService", 50);
                }
            }
        }
    }
}
