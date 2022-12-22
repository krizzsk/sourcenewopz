package com.didi.travel.p171v2.biz.rpc;

import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.DataLevel;
import com.didi.travel.p171v2.biz.api.IRemoteCallbackContainer;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.travel.v2.biz.rpc.RemoteCallbackBridge */
public class RemoteCallbackBridge<T extends BaseObject> extends RemoteCallback<T> implements IRemoteCallbackContainer<T>, RpcService.Callback<String> {

    /* renamed from: a */
    private static final String f44310a = RemoteCallbackBridge.class.getSimpleName();

    /* renamed from: b */
    private final Api f44311b;

    /* renamed from: c */
    private final Class<T> f44312c;

    /* renamed from: d */
    private final RemoteCallback<T> f44313d;

    /* renamed from: e */
    private final Object[] f44314e;
    protected Set<RemoteCallback<T>> mRemoteCallbackSet = new HashSet();

    public void onBizFail(T t) {
    }

    public void onBizSuccess(T t) {
    }

    public void onFinish(T t) {
    }

    public void onNetError(T t) {
    }

    public RemoteCallbackBridge(Api api, Class<T> cls, RemoteCallback<T> remoteCallback, Object[] objArr) {
        this.f44311b = api;
        this.f44312c = cls;
        this.f44313d = remoteCallback;
        this.f44314e = objArr;
    }

    public void onSuccess(String str) {
        String str2 = f44310a;
        LogUtils.m31493i(str2, "onSuccess : data = " + str);
        BaseObject a = m31481a();
        if (a != null) {
            a.parse(str);
        }
        if (!a.isAvailable()) {
            store(DataLevel.SUCCESS, a);
            RemoteCallback<T> remoteCallback = this.f44313d;
            if (remoteCallback != null) {
                remoteCallback.onBizFail(a);
                invokeBizFail(a);
                this.f44313d.onFinish(a);
                invokeFinish(a);
                return;
            }
            return;
        }
        store(DataLevel.AVAILABLE, a);
        RemoteCallback<T> remoteCallback2 = this.f44313d;
        if (remoteCallback2 != null) {
            remoteCallback2.onBizSuccess(a);
            invokeBizSuccess(a);
            this.f44313d.onFinish(a);
            invokeFinish(a);
        }
    }

    public void onFailure(IOException iOException) {
        String str = f44310a;
        LogUtils.m31493i(str, "onFailure : exception = " + iOException);
        BaseObject a = m31481a();
        store(DataLevel.ALL, a);
        RemoteCallback<T> remoteCallback = this.f44313d;
        if (remoteCallback != null) {
            remoteCallback.onNetError(a);
            invokeNetError(a);
            this.f44313d.onFinish(a);
            invokeFinish(a);
        }
    }

    /* renamed from: a */
    private T m31481a() {
        Class<T> cls = this.f44312c;
        if (cls == null) {
            return null;
        }
        try {
            return (BaseObject) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = f44310a;
            LogUtils.m31492e(str, "newInstance:invalid class, mDataClz = " + this.f44312c);
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void store(DataLevel dataLevel, T t) {
        TravelSDKV2.handleStore(this.f44311b, dataLevel, this.f44314e, t);
    }

    /* access modifiers changed from: protected */
    public void invokeBizSuccess(T t) {
        for (RemoteCallback next : this.mRemoteCallbackSet) {
            if (next != null) {
                next.onBizSuccess(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeBizFail(T t) {
        for (RemoteCallback next : this.mRemoteCallbackSet) {
            if (next != null) {
                next.onBizFail(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeNetError(T t) {
        for (RemoteCallback next : this.mRemoteCallbackSet) {
            if (next != null) {
                next.onNetError(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeFinish(T t) {
        for (RemoteCallback next : this.mRemoteCallbackSet) {
            if (next != null) {
                next.onFinish(t);
            }
        }
    }

    public void addRemoteCallback(RemoteCallback<T> remoteCallback) {
        if (remoteCallback != null) {
            this.mRemoteCallbackSet.add(remoteCallback);
        }
    }

    public void removeRemoteCallback(RemoteCallback<T> remoteCallback) {
        if (remoteCallback != null) {
            this.mRemoteCallbackSet.remove(remoteCallback);
        }
    }
}
