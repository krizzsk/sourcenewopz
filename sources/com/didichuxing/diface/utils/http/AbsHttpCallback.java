package com.didichuxing.diface.utils.http;

import com.didichuxing.diface.utils.http.BaseResult;

public abstract class AbsHttpCallback<T extends BaseResult> {
    public abstract void onFailed(int i, String str);

    public abstract void onSuccess(T t);
}
