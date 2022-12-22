package com.didi.travel.psnger.common.net.base;

import android.content.Context;
import android.text.TextUtils;
import com.didi.travel.psnger.TEBridge;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashSet;
import java.util.Map;

public class RPCServiceWrapper implements InvocationHandler {

    /* renamed from: a */
    private static final String f44050a = "wsgsig";

    /* renamed from: b */
    private static final String f44051b = "a3_token";

    /* renamed from: c */
    private static final String f44052c = "getDeviceInfo";

    /* renamed from: d */
    private Context f44053d;

    /* renamed from: e */
    private Object f44054e;

    /* access modifiers changed from: protected */
    public void addSpecificParams(Object obj, Method method, Map<String, Object> map) {
    }

    protected RPCServiceWrapper(Context context, Object obj) {
        this.f44053d = context.getApplicationContext();
        this.f44054e = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (objArr == null || objArr.length == 0 || !(objArr[0] instanceof Map)) {
            return method.invoke(this.f44054e, objArr);
        }
        Map map = objArr[0];
        addNormalParams(obj, method, map);
        addSpecificParams(obj, method, map);
        return method.invoke(this.f44054e, objArr);
    }

    /* access modifiers changed from: protected */
    public void addNormalParams(Object obj, Method method, Map<String, Object> map) {
        if (!TextUtils.equals(method.getName(), f44052c)) {
            String a3Token = TEBridge.clientConfig().a3Token();
            if (!TextUtils.isEmpty(a3Token)) {
                map.put("a3_token", a3Token);
            }
        }
    }

    public static <T> T wrap(Context context, T t) {
        return Proxy.newProxyInstance(t.getClass().getClassLoader(), collectInterfaces(t.getClass()), new RPCServiceWrapper(context, t));
    }

    protected static Class[] collectInterfaces(Class cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        do {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces != null ? interfaces.length : 0;
            for (int i = 0; i < length; i++) {
                linkedHashSet.add(interfaces[i]);
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return (Class[]) linkedHashSet.toArray(new Class[linkedHashSet.size()]);
    }
}
