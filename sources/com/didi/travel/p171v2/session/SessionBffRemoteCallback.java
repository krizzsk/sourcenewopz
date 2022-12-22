package com.didi.travel.p171v2.session;

import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.RemoteCallback;

/* renamed from: com.didi.travel.v2.session.SessionBffRemoteCallback */
public class SessionBffRemoteCallback<T> extends RemoteCallback<T> {

    /* renamed from: a */
    private final Session f44331a;

    /* renamed from: b */
    private final Api f44332b;

    /* renamed from: c */
    private final Object[] f44333c;

    /* renamed from: d */
    private final RemoteCallback<T> f44334d;

    public SessionBffRemoteCallback(Session session, Api api, Object[] objArr, RemoteCallback<T> remoteCallback) {
        this.f44331a = session;
        this.f44332b = api;
        this.f44333c = objArr;
        this.f44334d = remoteCallback;
    }

    public void onBizSuccess(T t) {
        super.onBizSuccess(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44331a, this.f44332b, this.f44333c, t);
        RemoteCallback<T> remoteCallback = this.f44334d;
        if (remoteCallback != null) {
            remoteCallback.onBizSuccess(t);
        }
    }

    public void onBizFail(T t) {
        super.onBizFail(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44331a, this.f44332b, this.f44333c, t);
        RemoteCallback<T> remoteCallback = this.f44334d;
        if (remoteCallback != null) {
            remoteCallback.onBizFail(t);
        }
    }

    public void onNetError(T t) {
        super.onNetError(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44331a, this.f44332b, this.f44333c, t);
        RemoteCallback<T> remoteCallback = this.f44334d;
        if (remoteCallback != null) {
            remoteCallback.onNetError(t);
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        RemoteCallback<T> remoteCallback = this.f44334d;
        if (remoteCallback != null) {
            remoteCallback.onFinish(t);
        }
    }
}
