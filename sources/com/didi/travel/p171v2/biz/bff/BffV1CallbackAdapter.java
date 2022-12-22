package com.didi.travel.p171v2.biz.bff;

import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.IRemoteCallbackContainer;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.GsonUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.travel.v2.biz.bff.BffV1CallbackAdapter */
public class BffV1CallbackAdapter<T> implements IRemoteCallbackContainer<T>, RpcService.Callback<JsonObject> {
    protected final String TAG = getClass().getSimpleName();

    /* renamed from: a */
    private Api f44303a;

    /* renamed from: b */
    private final Class<T> f44304b;

    /* renamed from: c */
    private final RemoteCallback<T> f44305c;

    /* renamed from: d */
    private final Object[] f44306d;

    /* renamed from: e */
    private final Set<RemoteCallback<T>> f44307e = new HashSet();

    public BffV1CallbackAdapter(Api api, Class<T> cls, RemoteCallback<T> remoteCallback, Object[] objArr) {
        this.f44303a = api;
        this.f44304b = cls;
        this.f44305c = remoteCallback;
        this.f44306d = objArr;
    }

    public void onSuccess(JsonObject jsonObject) {
        String str = this.TAG;
        LogUtils.m31493i(str, ".onSuccess : value = " + jsonObject);
        if (BaseObject.class.isAssignableFrom(this.f44304b)) {
            Object newInstance = newInstance();
            if (newInstance != null) {
                ((BaseObject) newInstance).parse(jsonObject.toString());
            }
            if (!((BaseObject) newInstance).isAvailable()) {
                RemoteCallback<T> remoteCallback = this.f44305c;
                if (remoteCallback != null) {
                    remoteCallback.onBizFail(newInstance);
                    invokeBizFail(newInstance);
                    this.f44305c.onFinish(newInstance);
                    invokeFinish(newInstance);
                    return;
                }
                return;
            }
            RemoteCallback<T> remoteCallback2 = this.f44305c;
            if (remoteCallback2 != null) {
                remoteCallback2.onBizSuccess(newInstance);
                invokeBizSuccess(newInstance);
                this.f44305c.onFinish(newInstance);
                invokeFinish(newInstance);
                return;
            }
            return;
        }
        T objectFromJson = GsonUtil.objectFromJson(jsonObject.toString(), this.f44304b);
        RemoteCallback<T> remoteCallback3 = this.f44305c;
        if (remoteCallback3 != null) {
            remoteCallback3.onBizSuccess(objectFromJson);
            invokeBizSuccess(objectFromJson);
            this.f44305c.onFinish(objectFromJson);
            invokeFinish(objectFromJson);
        }
    }

    public void onFailure(IOException iOException) {
        String str = this.TAG;
        LogUtils.m31493i(str, ".onFailure : exception = " + iOException);
        Object newInstance = newInstance();
        RemoteCallback<T> remoteCallback = this.f44305c;
        if (remoteCallback != null) {
            remoteCallback.onNetError(newInstance);
            invokeNetError(newInstance);
            this.f44305c.onFinish(newInstance);
            invokeFinish(newInstance);
        }
    }

    /* access modifiers changed from: protected */
    public T newInstance() {
        Class<T> cls = this.f44304b;
        if (cls == null) {
            return null;
        }
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = this.TAG;
            LogUtils.m31492e(str, "newInstance:invalid data clz, mDataClz = " + this.f44304b);
            e.printStackTrace();
            return null;
        }
    }

    public void addRemoteCallback(RemoteCallback<T> remoteCallback) {
        if (remoteCallback != null) {
            this.f44307e.add(remoteCallback);
        }
    }

    public void removeRemoteCallback(RemoteCallback<T> remoteCallback) {
        if (remoteCallback != null) {
            this.f44307e.remove(remoteCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void invokeBizSuccess(T t) {
        for (RemoteCallback next : this.f44307e) {
            if (next != null) {
                next.onBizSuccess(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeBizFail(T t) {
        for (RemoteCallback next : this.f44307e) {
            if (next != null) {
                next.onBizFail(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeNetError(T t) {
        for (RemoteCallback next : this.f44307e) {
            if (next != null) {
                next.onNetError(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeFinish(T t) {
        for (RemoteCallback next : this.f44307e) {
            if (next != null) {
                next.onFinish(t);
            }
        }
    }
}
