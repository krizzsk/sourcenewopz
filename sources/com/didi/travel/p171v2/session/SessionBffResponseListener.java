package com.didi.travel.p171v2.session;

import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.api.Api;

/* renamed from: com.didi.travel.v2.session.SessionBffResponseListener */
public class SessionBffResponseListener<T> extends BffResponseListener<T> {

    /* renamed from: a */
    private final Session f44335a;

    /* renamed from: b */
    private final Api f44336b;

    /* renamed from: c */
    private final Object[] f44337c;

    /* renamed from: d */
    private final BffResponseListener<T> f44338d;

    public SessionBffResponseListener(Session session, Api api, Object[] objArr, BffResponseListener<T> bffResponseListener) {
        this.f44335a = session;
        this.f44336b = api;
        this.f44337c = objArr;
        this.f44338d = bffResponseListener;
    }

    public void onSuccess(T t) {
        super.onSuccess(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44335a, this.f44336b, this.f44337c, t);
        BffResponseListener<T> bffResponseListener = this.f44338d;
        if (bffResponseListener != null) {
            bffResponseListener.onSuccess(t);
        }
    }

    public void onFail(T t) {
        super.onFail(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44335a, this.f44336b, this.f44337c, t);
        BffResponseListener<T> bffResponseListener = this.f44338d;
        if (bffResponseListener != null) {
            bffResponseListener.onFail(t);
        }
    }

    public void onError(T t) {
        super.onError(t);
        TravelSDKV2.bindStoreLifeCycle(this.f44335a, this.f44336b, this.f44337c, t);
        BffResponseListener<T> bffResponseListener = this.f44338d;
        if (bffResponseListener != null) {
            bffResponseListener.onError(t);
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        BffResponseListener<T> bffResponseListener = this.f44338d;
        if (bffResponseListener != null) {
            bffResponseListener.onFinish(t);
        }
    }
}
