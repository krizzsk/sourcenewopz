package com.didi.map.global.rpc.callback;

public abstract class MapRequestCallback<T> {

    /* renamed from: a */
    private int f27350a = 0;

    @Deprecated
    public void onCancelled(T t) {
    }

    public void onError(T t) {
    }

    public void onFailure(T t) {
    }

    public void onFinish(T t) {
    }

    @Deprecated
    public void onProgress(String str, long j, long j2, boolean z) {
    }

    public void onStart() {
    }

    public abstract void onSuccess(T t);

    public MapRequestCallback() {
    }

    public MapRequestCallback(int i) {
        this.f27350a = i;
    }

    public int getRequestIndex() {
        return this.f27350a;
    }
}
