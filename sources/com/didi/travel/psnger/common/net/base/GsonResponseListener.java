package com.didi.travel.psnger.common.net.base;

public abstract class GsonResponseListener<T> {
    public abstract void onError(int i);

    public void onFinish() {
    }

    public abstract void onSuccess(T t);
}
