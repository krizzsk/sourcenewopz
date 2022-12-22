package com.didi.travel.p171v2.biz.api;

import com.didi.travel.p171v2.biz.Biz;
import com.didi.travel.p171v2.biz.IBiz;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.didi.travel.v2.biz.api.ApiProxy */
public abstract class ApiProxy<T extends IBiz> {
    protected final String TAG = getClass().getSimpleName();
    protected final Biz<T> mBiz;

    public abstract Object invoke(Api api, Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    public ApiProxy(Biz<T> biz) {
        if (biz != null) {
            this.mBiz = biz;
            return;
        }
        throw new IllegalArgumentException(this.TAG + ".new:biz is null");
    }

    public Biz<T> getBiz() {
        return this.mBiz;
    }
}
