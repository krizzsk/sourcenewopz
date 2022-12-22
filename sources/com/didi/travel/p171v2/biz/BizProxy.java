package com.didi.travel.p171v2.biz;

import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.ApiInvokePolicy;
import com.didi.travel.p171v2.biz.api.ApiProxy;
import com.didi.travel.p171v2.biz.api.IIApi;
import com.didi.travel.p171v2.biz.bff.BffProxy;
import com.didi.travel.p171v2.biz.bff.IIBff;
import com.didi.travel.p171v2.biz.common.CommonProxy;
import com.didi.travel.p171v2.biz.rpc.IIRpc;
import com.didi.travel.p171v2.biz.rpc.IRpcDynamicHostCallback;
import com.didi.travel.p171v2.biz.rpc.RpcCommonParamListener;
import com.didi.travel.p171v2.biz.rpc.RpcProxy;
import com.didi.travel.p171v2.util.LogUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.travel.v2.biz.BizProxy */
public final class BizProxy<T extends IBiz> implements InvocationHandler {

    /* renamed from: a */
    private static final String f44286a = BizProxy.class.getSimpleName();

    /* renamed from: b */
    private final Biz<T> f44287b;

    /* renamed from: c */
    private final Class<T> f44288c;

    /* renamed from: d */
    private CommonProxy<T> f44289d;

    /* renamed from: e */
    private BffProxy<T> f44290e;

    /* renamed from: f */
    private HashMap<String, RpcProxy<T>> f44291f = new HashMap<>();

    /* renamed from: g */
    private HashMap<Method, ApiProxy<T>> f44292g = new HashMap<>();

    /* renamed from: h */
    private HashMap<Method, Api> f44293h = new HashMap<>();

    /* renamed from: i */
    private HashMap<String, Method> f44294i = new HashMap<>();

    /* renamed from: j */
    private Set<RpcCommonParamListener> f44295j = new HashSet();

    public BizProxy(Biz<T> biz) {
        this.f44287b = biz;
        this.f44288c = biz.getBizClass();
        long uptimeMillis = SystemClock.uptimeMillis();
        m31479a((Class) this.f44288c);
        long uptimeMillis2 = SystemClock.uptimeMillis();
        String str = f44286a;
        LogUtils.m31493i(str, "loadInterface spend time = " + (uptimeMillis2 - uptimeMillis) + ", startTime = " + uptimeMillis + ", endTime = " + uptimeMillis2);
    }

    public Method getMethod(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f44294i.get(str);
    }

    public Api getApi(Method method) {
        if (method == null) {
            return null;
        }
        return this.f44293h.get(method);
    }

    public void addRpcInvokeCommonParamListener(RpcCommonParamListener rpcCommonParamListener) {
        if (rpcCommonParamListener != null) {
            this.f44295j.add(rpcCommonParamListener);
        }
    }

    public void removeRpcInvokeCommonParamListener(RpcCommonParamListener rpcCommonParamListener) {
        if (rpcCommonParamListener != null) {
            this.f44295j.remove(rpcCommonParamListener);
        }
    }

    public Set<RpcCommonParamListener> getRpcInvokeCommonParamListenerList() {
        return new HashSet(this.f44295j);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, objArr);
        }
        if (TravelSDKV2.isDebug()) {
            String str = f44286a;
            LogUtils.m31491d(str, "invoke:proxy = " + obj + ", method = " + method + ", args = " + objArr);
        }
        Api api = this.f44293h.get(method);
        if (api != null) {
            ApiProxy apiProxy = this.f44292g.get(method);
            if (apiProxy != null) {
                return apiProxy.invoke(api, obj, method, objArr);
            }
            throw new IllegalArgumentException(f44286a + ".invoke : apiProxy is null, method = " + method);
        }
        throw new IllegalStateException(f44286a + ".invoke : api is null, method = " + method);
    }

    /* renamed from: a */
    private void m31479a(Class cls) {
        LogUtils.m31494v(f44286a, "loadInterface:clz = " + cls);
        if (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (declaredMethods != null && declaredMethods.length > 0) {
                for (Method a : declaredMethods) {
                    m31480a(a);
                }
            }
            if (!IBiz.class.equals(cls)) {
                Class[] interfaces = cls.getInterfaces();
                if (interfaces.length > 0) {
                    for (Class cls2 : interfaces) {
                        LogUtils.m31494v(f44286a, "loadInterface.superInterface:item = " + cls2);
                        m31479a(cls2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m31480a(Method method) {
        String str = f44286a;
        LogUtils.m31494v(str, "loadMethod:method = " + method);
        if (method != null && !Object.class.equals(method.getDeclaringClass())) {
            TravelSDKV2.checkMethod(method, f44286a);
            IIApi iIApi = (IIApi) method.getAnnotation(IIApi.class);
            ApiInvokePolicy apiInvokePolicy = iIApi.apiInvokePolicy();
            if (apiInvokePolicy == ApiInvokePolicy.INNER) {
                m31478a(iIApi, method);
            } else if (apiInvokePolicy == ApiInvokePolicy.BFF) {
                m31476a(iIApi, (IIBff) method.getAnnotation(IIBff.class), method);
            } else if (apiInvokePolicy == ApiInvokePolicy.RPC) {
                m31477a(iIApi, (IIRpc) method.getAnnotation(IIRpc.class), method);
            } else {
                throw new IllegalArgumentException(f44286a + ".loadMethod : unknown apiInvokePolicy = " + apiInvokePolicy + ", iiApi = " + iIApi + ", method = " + method);
            }
        }
    }

    /* renamed from: a */
    private void m31478a(IIApi iIApi, Method method) {
        if (this.f44289d == null) {
            this.f44289d = new CommonProxy<>(this.f44287b);
        }
        Api api = new Api(this.f44287b, iIApi);
        this.f44292g.put(method, this.f44289d);
        this.f44293h.put(method, api);
        this.f44294i.put(api.getKey(), method);
    }

    /* renamed from: a */
    private void m31476a(IIApi iIApi, IIBff iIBff, Method method) {
        if (this.f44290e == null) {
            this.f44290e = new BffProxy<>(this.f44287b);
        }
        Api api = new Api(this.f44287b, iIApi);
        api.setIIBff(iIBff);
        this.f44292g.put(method, this.f44290e);
        this.f44293h.put(method, api);
        this.f44294i.put(api.getKey(), method);
    }

    /* renamed from: a */
    private void m31477a(IIApi iIApi, IIRpc iIRpc, Method method) {
        Api api = new Api(this.f44287b, iIApi);
        api.setIIRpc(iIRpc);
        String a = m31475a(api, iIRpc);
        RpcProxy rpcProxy = this.f44291f.get(a);
        if (rpcProxy == null) {
            rpcProxy = new RpcProxy(this.f44287b, a);
            this.f44291f.put(a, rpcProxy);
        }
        this.f44292g.put(method, rpcProxy);
        this.f44293h.put(method, api);
        this.f44294i.put(api.getKey(), method);
    }

    /* renamed from: a */
    private String m31475a(Api api, IIRpc iIRpc) {
        if (api == null || iIRpc == null) {
            return "";
        }
        String hostKey = iIRpc.hostKey();
        String host = iIRpc.host();
        String sharePath = iIRpc.sharePath();
        IRpcDynamicHostCallback rpcDynamicHostCallback = api.getRpcDynamicHostCallback();
        if (rpcDynamicHostCallback == null) {
            rpcDynamicHostCallback = this.f44287b.getBizRpcDynamicHostCallback();
        }
        if (rpcDynamicHostCallback != null) {
            host = rpcDynamicHostCallback.getHost(api, hostKey, host);
            sharePath = rpcDynamicHostCallback.getSharePath(api, hostKey, sharePath);
        }
        return host + sharePath;
    }
}
