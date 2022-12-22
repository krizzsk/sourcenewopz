package com.didi.travel.p171v2.biz.bff;

import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.DataLevel;
import com.didi.travel.p171v2.biz.api.IApiInvokeCallback;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.util.LogUtils;

/* renamed from: com.didi.travel.v2.biz.bff.BffV1InvokeCallback */
public class BffV1InvokeCallback<T> extends RemoteCallback<T> implements IApiInvokeCallback {
    protected final String TAG = BffV1InvokeCallback.class.getSimpleName();
    protected final Api mApi;
    protected final Object[] mInvokeArgs;
    protected final RemoteCallback<T> mOriginListener;

    public BffV1InvokeCallback(Api api, Object[] objArr, RemoteCallback<T> remoteCallback) {
        this.mApi = api;
        this.mInvokeArgs = objArr;
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
        store(DataLevel.AVAILABLE, t);
        RemoteCallback<T> remoteCallback = this.mOriginListener;
        if (remoteCallback != null) {
            remoteCallback.onBizSuccess(t);
        }
    }

    public void onBizFail(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onBizFail:data = " + t);
        store(DataLevel.SUCCESS, t);
        RemoteCallback<T> remoteCallback = this.mOriginListener;
        if (remoteCallback != null) {
            remoteCallback.onBizFail(t);
        }
    }

    public void onNetError(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onNetError:data = " + t);
        store(DataLevel.ALL, t);
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

    /* access modifiers changed from: protected */
    public void store(DataLevel dataLevel, T t) {
        TravelSDKV2.handleStore(this.mApi, dataLevel, this.mInvokeArgs, t);
    }
}
