package com.didi.travel.p171v2.biz.api;

import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p171v2.IKey;
import com.didi.travel.p171v2.biz.Biz;
import com.didi.travel.p171v2.biz.bff.BffV1InvokeCallback;
import com.didi.travel.p171v2.biz.bff.BffV2InvokeCallback;
import com.didi.travel.p171v2.biz.bff.IIBff;
import com.didi.travel.p171v2.biz.rpc.IIRpc;
import com.didi.travel.p171v2.biz.rpc.IRpcDynamicHostCallback;
import com.didi.travel.p171v2.biz.rpc.RpcInvokeCallback;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.didi.travel.p171v2.util.LogUtils;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.didi.travel.v2.biz.api.Api */
public final class Api implements IKey {

    /* renamed from: a */
    private static final String f44296a = Api.class.getSimpleName();

    /* renamed from: b */
    private final Biz f44297b;

    /* renamed from: c */
    private final IIApi f44298c;

    /* renamed from: d */
    private IIRpc f44299d;

    /* renamed from: e */
    private IIBff f44300e;

    /* renamed from: f */
    private IRpcDynamicHostCallback f44301f;

    /* renamed from: g */
    private IStoreCallback f44302g;

    public Api(Biz biz, IIApi iIApi) {
        if (biz != null) {
            this.f44297b = biz;
            this.f44298c = iIApi;
            return;
        }
        throw new NullPointerException(f44296a + ".new:biz is null");
    }

    public String getBizKey() {
        return this.f44297b.getKey();
    }

    public ApiInvokePolicy getApiInvokePolicy() {
        return this.f44298c.apiInvokePolicy();
    }

    public DataLevel getStoreDataLevel() {
        return this.f44298c.storeDataLevel();
    }

    public IIRpc getIIRpc() {
        return this.f44299d;
    }

    public void setIIRpc(IIRpc iIRpc) {
        if (this.f44298c.apiInvokePolicy() == ApiInvokePolicy.RPC) {
            this.f44299d = iIRpc;
            return;
        }
        String str = f44296a;
        LogUtils.m31492e(str, "setIIRpc:invalid invoke, api = " + this);
        throw new IllegalStateException(f44296a + ".setIIRpc:api = " + this);
    }

    public IIBff getIIBff() {
        return this.f44300e;
    }

    public void setIIBff(IIBff iIBff) {
        if (this.f44298c.apiInvokePolicy() == ApiInvokePolicy.BFF) {
            this.f44300e = iIBff;
            return;
        }
        String str = f44296a;
        LogUtils.m31492e(str, "setIIBff:invalid invoke, api = " + this);
        throw new IllegalStateException(f44296a + ".setIIBff:api = " + this);
    }

    public IRpcDynamicHostCallback getRpcDynamicHostCallback() {
        IRpcDynamicHostCallback iRpcDynamicHostCallback = this.f44301f;
        if (iRpcDynamicHostCallback != null) {
            return iRpcDynamicHostCallback;
        }
        IIRpc iIRpc = this.f44299d;
        if (iIRpc == null) {
            return null;
        }
        Class<? extends IRpcDynamicHostCallback> dynamicHostImp = iIRpc.dynamicHostImp();
        if (IRpcDynamicHostCallback.class.equals(dynamicHostImp)) {
            return null;
        }
        try {
            this.f44301f = (IRpcDynamicHostCallback) dynamicHostImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f44296a;
            LogUtils.m31492e(str, "getRpcDynamicHostCallback:api = " + this + ", clz = " + dynamicHostImp + ", e = " + e);
            e.printStackTrace();
        }
        return this.f44301f;
    }

    public IApiInvokeCallback instanceApiInvokeCallback() {
        Class<? extends IApiInvokeCallback> apiInvokeCallbackImp = this.f44298c.apiInvokeCallbackImp();
        try {
            return (IApiInvokeCallback) apiInvokeCallbackImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f44296a;
            LogUtils.m31492e(str, "instanceApiInvokeCallback:invalid class, api = " + this + ", clz = " + apiInvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public RpcInvokeCallback instanceRpcInvokeCallback(RemoteCallback remoteCallback) {
        IIRpc iIRpc = this.f44299d;
        if (iIRpc == null) {
            LogUtils.m31492e(f44296a, "instanceRpcInvokeCallback:mIIRpc is null");
            return null;
        }
        Class<? extends RpcInvokeCallback> rpcInvokeCallbackImp = iIRpc.rpcInvokeCallbackImp();
        try {
            return (RpcInvokeCallback) rpcInvokeCallbackImp.getConstructor(new Class[]{RemoteCallback.class}).newInstance(new Object[]{remoteCallback});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = f44296a;
            LogUtils.m31492e(str, "instanceRpcInvokeCallback:invalid class, api = " + this + ", clz = " + rpcInvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public BffV1InvokeCallback instanceBffV1InvokeCallback(Api api, Object[] objArr, RemoteCallback remoteCallback) {
        IIBff iIBff = this.f44300e;
        if (iIBff == null) {
            LogUtils.m31492e(f44296a, "instanceBffV1InvokeCallback:mIIBff is null");
            return null;
        }
        Class<? extends BffV1InvokeCallback> bffV1InvokeCallbackImp = iIBff.bffV1InvokeCallbackImp();
        try {
            return (BffV1InvokeCallback) bffV1InvokeCallbackImp.getConstructor(new Class[]{Api.class, Object[].class, RemoteCallback.class}).newInstance(new Object[]{api, objArr, remoteCallback});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = f44296a;
            LogUtils.m31492e(str, "instanceBffV1InvokeCallback:invalid class, api = " + this + ", clz = " + bffV1InvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public BffV2InvokeCallback instanceBffV2ApiInvokeCallback(Api api, Object[] objArr, BffResponseListener bffResponseListener) {
        IIBff iIBff = this.f44300e;
        if (iIBff == null) {
            LogUtils.m31492e(f44296a, "instanceBffV2ApiInvokeCallback:mIIBff is null");
            return null;
        }
        Class<? extends BffV2InvokeCallback> bffV2InvokeCallbackImp = iIBff.bffV2InvokeCallbackImp();
        try {
            return (BffV2InvokeCallback) bffV2InvokeCallbackImp.getConstructor(new Class[]{Api.class, Object[].class, BffResponseListener.class}).newInstance(new Object[]{api, objArr, bffResponseListener});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = f44296a;
            LogUtils.m31492e(str, "instanceBffV2ApiInvokeCallback:invalid class, api = " + this + ", clz = " + bffV2InvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public IStoreCallback getApiStoreCallback() {
        IStoreCallback iStoreCallback = this.f44302g;
        if (iStoreCallback != null) {
            return iStoreCallback;
        }
        Class<? extends IStoreCallback> apiStoreCallbackImp = this.f44298c.apiStoreCallbackImp();
        if (IStoreCallback.class.equals(apiStoreCallbackImp)) {
            return null;
        }
        try {
            this.f44302g = (IStoreCallback) apiStoreCallbackImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f44296a;
            LogUtils.m31492e(str, "getApiStoreCallback:invalid class, api = " + this + ", clz = " + apiStoreCallbackImp + ", exception = " + e);
            e.printStackTrace();
        }
        return this.f44302g;
    }

    public String getKey() {
        return this.f44298c.key();
    }

    public String toString() {
        return "Api{mBizKey='" + getBizKey() + '\'' + ", mApiKey='" + this.f44298c.key() + '\'' + '}';
    }
}
