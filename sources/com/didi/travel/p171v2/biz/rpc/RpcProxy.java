package com.didi.travel.p171v2.biz.rpc;

import android.text.TextUtils;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.Biz;
import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.ApiProxy;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/* renamed from: com.didi.travel.v2.biz.rpc.RpcProxy */
public class RpcProxy<T extends IBiz> extends ApiProxy<T> {

    /* renamed from: a */
    private final String f44315a;

    /* renamed from: b */
    private final T f44316b;

    public RpcProxy(Biz<T> biz, String str) {
        super(biz);
        if (!TextUtils.isEmpty(str)) {
            this.f44315a = str;
            this.f44316b = (IBiz) new RpcServiceFactory(TravelSDKV2.getAppContext()).newRpcService(biz.getBizClass(), str);
            return;
        }
        throw new IllegalArgumentException(this.TAG + ".new : rpcKey is empty");
    }

    public Object invoke(Api api, Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        int length = objArr.length - 1;
        RemoteCallback remoteCallback = objArr[objArr.length - 1];
        RpcInvokeCallback instanceRpcInvokeCallback = api.instanceRpcInvokeCallback(remoteCallback);
        Class<? extends BaseObject> dataType = api.getIIRpc().dataType();
        if (instanceRpcInvokeCallback != null) {
            remoteCallback = instanceRpcInvokeCallback;
        }
        objArr[length] = new RemoteCallbackBridge(api, dataType, remoteCallback, objArr);
        doCommonParamsBeforeInvoke(api, objArr);
        instanceRpcInvokeCallback.beforeInvoke(api, objArr);
        Object invoke = method.invoke(this.f44316b, objArr);
        instanceRpcInvokeCallback.afterInvoke(api, objArr);
        return invoke;
    }

    /* access modifiers changed from: protected */
    public void doCommonParamsBeforeInvoke(Api api, Object[] objArr) {
        Set<RpcCommonParamListener> rpcInvokeCommonParamListenerList;
        if (objArr != null && objArr.length != 0) {
            if ((objArr[0] == null || (objArr[0] instanceof Map)) && (rpcInvokeCommonParamListenerList = this.mBiz.getBizProxy().getRpcInvokeCommonParamListenerList()) != null && rpcInvokeCommonParamListenerList.size() != 0) {
                for (RpcCommonParamListener next : rpcInvokeCommonParamListenerList) {
                    if (next != null) {
                        objArr[0] = next.generateRequestParamMap(api, objArr[0]);
                    }
                }
            }
        }
    }
}
