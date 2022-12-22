package com.didi.travel.p171v2.biz.bff;

import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.DataLevel;
import com.didi.travel.p171v2.biz.api.IApiInvokeCallback;
import com.didi.travel.p171v2.biz.api.IBffResponseListenerContainer;
import com.didi.travel.p171v2.util.LogUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.travel.v2.biz.bff.BffV2InvokeCallback */
public class BffV2InvokeCallback<T> extends BffResponseListener<T> implements IApiInvokeCallback, IBffResponseListenerContainer<T> {
    protected final String TAG = BffV2InvokeCallback.class.getSimpleName();
    protected final Api mApi;
    protected Set<BffResponseListener<T>> mBffResponseListenerSet = new HashSet();
    protected final Object[] mInvokeArgs;
    protected final BffResponseListener<T> mOriginListener;

    public BffV2InvokeCallback(Api api, Object[] objArr, BffResponseListener<T> bffResponseListener) {
        this.mApi = api;
        this.mInvokeArgs = objArr;
        this.mOriginListener = bffResponseListener;
    }

    public void beforeInvoke(Api api, Object[] objArr) {
        String str = this.TAG;
        LogUtils.m31493i(str, "beforeInvoke:api = " + api + ", requestMap = " + objArr[0]);
    }

    public void afterInvoke(Api api, Object[] objArr) {
        String str = this.TAG;
        LogUtils.m31493i(str, "afterInvoke:api = " + api + ", requestMap = " + objArr[0]);
    }

    public void onSuccess(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onSuccess:t = " + t);
        super.onSuccess(t);
        store(DataLevel.AVAILABLE, t);
        BffResponseListener<T> bffResponseListener = this.mOriginListener;
        if (bffResponseListener != null) {
            bffResponseListener.onSuccess(t);
        }
        invokeSuccess(t);
    }

    public void onFail(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onFail:t = " + t);
        super.onFail(t);
        store(DataLevel.SUCCESS, t);
        BffResponseListener<T> bffResponseListener = this.mOriginListener;
        if (bffResponseListener != null) {
            bffResponseListener.onFail(t);
        }
        invokeFail(t);
    }

    public void onError(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onError:t = " + t);
        super.onError(t);
        store(DataLevel.ALL, t);
        BffResponseListener<T> bffResponseListener = this.mOriginListener;
        if (bffResponseListener != null) {
            bffResponseListener.onError(t);
        }
        invokeError(t);
    }

    public void onFinish(T t) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onFinish:t = " + t);
        super.onFinish(t);
        BffResponseListener<T> bffResponseListener = this.mOriginListener;
        if (bffResponseListener != null) {
            bffResponseListener.onFinish(t);
        }
        invokeFinish(t);
    }

    /* access modifiers changed from: protected */
    public void store(DataLevel dataLevel, T t) {
        TravelSDKV2.handleStore(this.mApi, dataLevel, this.mInvokeArgs, t);
    }

    public void addBffResponseListener(BffResponseListener<T> bffResponseListener) {
        if (bffResponseListener != null) {
            this.mBffResponseListenerSet.add(bffResponseListener);
        }
    }

    public void removeBffResponseListener(BffResponseListener<T> bffResponseListener) {
        if (bffResponseListener != null) {
            this.mBffResponseListenerSet.remove(bffResponseListener);
        }
    }

    /* access modifiers changed from: protected */
    public void invokeSuccess(T t) {
        for (BffResponseListener next : this.mBffResponseListenerSet) {
            if (next != null) {
                next.onSuccess(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeFail(T t) {
        for (BffResponseListener next : this.mBffResponseListenerSet) {
            if (next != null) {
                next.onFail(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeError(T t) {
        for (BffResponseListener next : this.mBffResponseListenerSet) {
            if (next != null) {
                next.onError(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeFinish(T t) {
        for (BffResponseListener next : this.mBffResponseListenerSet) {
            if (next != null) {
                next.onFinish(t);
            }
        }
    }
}
