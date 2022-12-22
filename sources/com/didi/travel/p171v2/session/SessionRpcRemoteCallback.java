package com.didi.travel.p171v2.session;

import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.RemoteCallback;

/* renamed from: com.didi.travel.v2.session.SessionRpcRemoteCallback */
public class SessionRpcRemoteCallback<T> extends RemoteCallback<T> {

    /* renamed from: a */
    private final Session f44339a;

    /* renamed from: b */
    private final Api f44340b;

    /* renamed from: c */
    private final Object[] f44341c;

    /* renamed from: d */
    private final RemoteCallback<T> f44342d;

    public SessionRpcRemoteCallback(Session session, Api api, Object[] objArr, RemoteCallback<T> remoteCallback) {
        this.f44339a = session;
        this.f44340b = api;
        this.f44341c = objArr;
        this.f44342d = remoteCallback;
    }

    public void onBizSuccess(T t) {
        super.onBizSuccess(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44339a, this.f44340b, this.f44341c, t);
        RemoteCallback<T> remoteCallback = this.f44342d;
        if (remoteCallback != null) {
            remoteCallback.onBizSuccess(t);
        }
    }

    public void onBizFail(T t) {
        super.onBizFail(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44339a, this.f44340b, this.f44341c, t);
        RemoteCallback<T> remoteCallback = this.f44342d;
        if (remoteCallback != null) {
            remoteCallback.onBizFail(t);
        }
    }

    public void onNetError(T t) {
        super.onNetError(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44339a, this.f44340b, this.f44341c, t);
        RemoteCallback<T> remoteCallback = this.f44342d;
        if (remoteCallback != null) {
            remoteCallback.onNetError(t);
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        RemoteCallback<T> remoteCallback = this.f44342d;
        if (remoteCallback != null) {
            remoteCallback.onFinish(t);
        }
    }
}
