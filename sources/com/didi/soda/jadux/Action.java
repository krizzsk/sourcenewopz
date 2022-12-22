package com.didi.soda.jadux;

import com.didi.soda.jadux.utils.ActionTypes;

public class Action<T> implements AbsAction {

    /* renamed from: a */
    private String f43350a = ActionTypes.UNKNOW;

    /* renamed from: b */
    private T f43351b;

    public Action(String str, T t) {
        this.f43350a = str;
        this.f43351b = t;
    }

    public T getPayload() {
        return this.f43351b;
    }

    public String getType() {
        return this.f43350a;
    }
}
