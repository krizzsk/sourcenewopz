package com.didi.safetoolkit.net;

import com.didi.safetoolkit.model.SfBaseObject;

public class SfResponseListener<T extends SfBaseObject> {
    public void onError(T t) {
    }

    public void onFail(int i, String str) {
    }

    @Deprecated
    public void onFinish(T t) {
    }

    public void onSuccess(T t) {
    }
}
