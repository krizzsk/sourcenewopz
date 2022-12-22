package com.android.didi.bfflib.business;

import com.android.didi.bfflib.BffExtra;

public abstract class BffResponseListenerV2<T> {
    public void onFail(T t, BffExtra bffExtra) {
    }

    public void onSuccess(T t, BffExtra bffExtra) {
    }
}
