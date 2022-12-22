package com.didi.travel.p171v2.biz.rpc;

import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.IApiInvokeCallback;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.util.LogUtils;

/* renamed from: com.didi.travel.v2.biz.rpc.RpcInvokeCallback */
public class RpcInvokeCallback<T> extends RemoteCallback<T> implements IApiInvokeCallback {
    protected final String TAG = getClass().getSimpleName();
    protected RemoteCallback<T> mOriginListener;

    public RpcInvokeCallback(RemoteCallback<T> remoteCallback) {
        this.mOriginListener = remoteCallback;
    }

    public void beforeInvoke(Api api, Object[] objArr) {
        String str = this.TAG;
        LogUtils.m31493i(str, "beforeInvoke:api = " + api);
    }

    public void afterInvoke(Api api, Object[] objArr) {
        String str = this.TAG;
        LogUtils.m31493i(str, "afterInvoke:api = " + api);
    }

    public void onBizSuccess(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onBizSuccess:data = " + t);
        RemoteCallback<T> remoteCallback = this.mOriginListener;
        if (remoteCallback != null) {
            remoteCallback.onBizSuccess(t);
        }
    }

    public void onBizFail(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onBizFail:data = " + t);
        RemoteCallback<T> remoteCallback = this.mOriginListener;
        if (remoteCallback != null) {
            remoteCallback.onBizFail(t);
        }
    }

    public void onNetError(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onNetError:data = " + t);
        RemoteCallback<T> remoteCallback = this.mOriginListener;
        if (remoteCallback != null) {
            remoteCallback.onNetError(t);
        }
    }

    public void onFinish(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onFinish:data = " + t);
        RemoteCallback<T> remoteCallback = this.mOriginListener;
        if (remoteCallback != null) {
            remoteCallback.onFinish(t);
        }
    }
}
