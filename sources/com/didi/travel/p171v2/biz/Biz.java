package com.didi.travel.p171v2.biz;

import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.rpc.IRpcDynamicHostCallback;
import com.didi.travel.p171v2.biz.rpc.RpcCommonParamListener;
import com.didi.travel.p171v2.util.LogUtils;
import java.lang.reflect.Proxy;

/* renamed from: com.didi.travel.v2.biz.Biz */
public final class Biz<T extends IBiz> {

    /* renamed from: a */
    private static final String f44280a = Biz.class.getSimpleName();

    /* renamed from: b */
    private final Class<T> f44281b;

    /* renamed from: c */
    private final IIBiz f44282c;

    /* renamed from: d */
    private final T f44283d;

    /* renamed from: e */
    private final BizProxy<T> f44284e = new BizProxy<>(this);

    /* renamed from: f */
    private IRpcDynamicHostCallback f44285f;

    public Biz(Class<T> cls) {
        this.f44281b = cls;
        this.f44282c = (IIBiz) cls.getAnnotation(IIBiz.class);
        this.f44283d = (IBiz) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this.f44284e);
    }

    public String getKey() {
        return this.f44282c.key();
    }

    public Class<T> getBizClass() {
        return this.f44281b;
    }

    public T getIBiz() {
        return this.f44283d;
    }

    public BizProxy<T> getBizProxy() {
        return this.f44284e;
    }

    public IRpcDynamicHostCallback getBizRpcDynamicHostCallback() {
        IRpcDynamicHostCallback iRpcDynamicHostCallback = this.f44285f;
        if (iRpcDynamicHostCallback != null) {
            return iRpcDynamicHostCallback;
        }
        Class<? extends IRpcDynamicHostCallback> rpcDynamicHostImp = this.f44282c.rpcDynamicHostImp();
        try {
            this.f44285f = (IRpcDynamicHostCallback) rpcDynamicHostImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f44280a;
            LogUtils.m31492e(str, "getBizRpcDynamicHostImp:clz = " + rpcDynamicHostImp + ", e = " + e);
            e.printStackTrace();
        }
        return this.f44285f;
    }

    public void addRpcInvokeBeforeListener(RpcCommonParamListener rpcCommonParamListener) {
        this.f44284e.addRpcInvokeCommonParamListener(rpcCommonParamListener);
    }

    public void removeRpcInvokeCommonParamListener(RpcCommonParamListener rpcCommonParamListener) {
        this.f44284e.removeRpcInvokeCommonParamListener(rpcCommonParamListener);
    }

    public String toString() {
        return "Biz{key=" + getKey() + ", mClass=" + this.f44281b + '}';
    }
}
